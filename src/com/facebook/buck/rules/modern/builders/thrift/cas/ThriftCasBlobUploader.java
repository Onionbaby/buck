/*
 * Copyright 2018-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.rules.modern.builders.thrift.cas;

import com.facebook.buck.core.util.log.Logger;
import com.facebook.buck.rules.modern.builders.CasBlobUploader;
import com.facebook.buck.rules.modern.builders.MultiThreadedBlobUploader.UploadData;
import com.facebook.buck.rules.modern.builders.MultiThreadedBlobUploader.UploadResult;
import com.facebook.buck.rules.modern.builders.Protocol;
import com.facebook.buck.rules.modern.builders.thrift.ThriftProtocol;
import com.facebook.buck.rules.modern.builders.thrift.ThriftProtocol.ThriftDigest;
import com.facebook.buck.rules.modern.builders.thrift.ThriftUtil;
import com.facebook.buck.util.MoreThrowables;
import com.facebook.buck.util.exceptions.BuckUncheckedExecutionException;
import com.facebook.remoteexecution.cas.BatchUpdateBlobsRequest;
import com.facebook.remoteexecution.cas.BatchUpdateBlobsResponse;
import com.facebook.remoteexecution.cas.ContentAddressableStorage;
import com.facebook.remoteexecution.cas.ContentAddressableStorageException;
import com.facebook.remoteexecution.cas.Digest;
import com.facebook.remoteexecution.cas.FindMissingBlobsRequest;
import com.facebook.remoteexecution.cas.FindMissingBlobsResponse;
import com.facebook.remoteexecution.cas.UpdateBlobRequest;
import com.facebook.remoteexecution.cas.UpdateBlobResponse;
import com.facebook.thrift.TException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/** A Thrift-based implementation of uploading inputs/outputs to the CAS. */
public class ThriftCasBlobUploader implements CasBlobUploader {

  private static final Logger LOG = Logger.get(ThriftCasBlobUploader.class);

  private final ContentAddressableStorage.Iface client;

  public ThriftCasBlobUploader(ContentAddressableStorage.Iface client) {
    // TODO(shivanker): The direct thrift client is not thread-safe, so we need to keep the requests
    // synchronized.
    this.client = client;
  }

  @Override
  public ImmutableSet<String> getMissingHashes(List<Protocol.Digest> requiredDigests)
      throws IOException {
    List<Digest> digests =
        requiredDigests.stream().map(ThriftProtocol::get).collect(Collectors.toList());

    FindMissingBlobsRequest request = new FindMissingBlobsRequest(digests);
    FindMissingBlobsResponse response;

    try {
      response = client.findMissingBlobs(request);
    } catch (TException | ContentAddressableStorageException e) {
      MoreThrowables.throwIfInitialCauseInstanceOf(e, IOException.class);

      String message =
          String.format(
              "Failed to get missing hashes. Message=[%s] Details=[%s] Request=[%s]",
              e.getMessage(),
              ThriftUtil.getExceptionDetails(e).orElse("NONE"),
              ThriftUtil.thriftToDebugJson(request));
      LOG.error(e, message);
      throw new BuckUncheckedExecutionException(e, message);
    }

    if (response.missing_blob_digests.stream().anyMatch(Objects::isNull)) {
      LOG.error(
          "Found null digest in response. Requested digests were: [%s]",
          ThriftUtil.thriftToDebugJson(response));
    }

    return response
        .missing_blob_digests
        .stream()
        .map(Digest::getHash)
        .collect(ImmutableSet.toImmutableSet());
  }

  @Override
  public ImmutableList<UploadResult> batchUpdateBlobs(ImmutableList<UploadData> blobs)
      throws IOException {

    List<UpdateBlobRequest> individualBlobRequests = new LinkedList<>();

    for (UploadData blob : blobs) {
      try (InputStream dataStream = blob.data.get()) {
        UpdateBlobRequest individualRequest =
            new UpdateBlobRequest(
                ThriftProtocol.get(blob.digest), ByteStreams.toByteArray(dataStream));
        individualBlobRequests.add(individualRequest);
      }
    }

    BatchUpdateBlobsRequest request = new BatchUpdateBlobsRequest(individualBlobRequests);
    BatchUpdateBlobsResponse response;

    try {
      response = client.batchUpdateBlobs(request);
    } catch (TException | ContentAddressableStorageException e) {
      MoreThrowables.throwIfInitialCauseInstanceOf(e, IOException.class);
      String digests =
          request
              .getRequests()
              .stream()
              .map(
                  blobRequest ->
                      String.format(
                          "%s:%d",
                          blobRequest.getContent_digest().getHash(),
                          blobRequest.getContent_digest().getSize_bytes()))
              .reduce("", (digest1, digest2) -> digest1 + ", " + digest2);
      String message =
          String.format(
              "Failed to batch update [%d] blobs for digests [%s]. Details=[%s]",
              request.getRequests().size(),
              digests,
              ThriftUtil.getExceptionDetails(e).orElse("NONE"));
      LOG.error(e, message);
      throw new BuckUncheckedExecutionException(e, message);
    }

    ImmutableList.Builder<UploadResult> resultBuilder = ImmutableList.builder();

    for (UpdateBlobResponse individualResponse : response.getResponses()) {
      resultBuilder.add(
          new UploadResult(
              new ThriftDigest(individualResponse.getBlob_digest()),
              0, // status code; TODO(orr): We don't have that codified in our API yet. TBD
              "OK" // status message; TODO(orr): We don't have that codified in our API yet. TBD
              ));
    }
    return resultBuilder.build();
  }
}
