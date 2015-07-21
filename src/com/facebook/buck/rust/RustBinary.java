/*
 * Copyright 2015-present Facebook, Inc.
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

package com.facebook.buck.rust;

import com.facebook.buck.rules.BuildTargetSourcePath;
import com.facebook.buck.rules.CommandTool;
import com.facebook.buck.rules.Tool;
import com.facebook.buck.model.BuildTargets;
import com.facebook.buck.rules.BinaryBuildRule;
import com.facebook.buck.rules.BuildRuleParams;
import com.facebook.buck.rules.BuildableProperties;
import com.facebook.buck.rules.SourcePath;
import com.facebook.buck.rules.SourcePathResolver;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class RustBinary extends RustLinkable implements BinaryBuildRule {

  public RustBinary(
      BuildRuleParams params,
      SourcePathResolver resolver,
      ImmutableSet<SourcePath> srcs,
      ImmutableSet<String> features,
      ImmutableList<String> rustcFlags,
      Tool compiler) {
    super(
        params,
        resolver,
        srcs,
        ImmutableList.<String>builder()
            .add("--crate-type", "bin")
            .addAll(rustcFlags)
            .build(),
        features,
        BuildTargets.getGenPath(
            params.getBuildTarget(), "%s/" + params.getBuildTarget().getShortName()),
        compiler);
  }

  @Override
  public Tool getExecutableCommand() {
    return new CommandTool.Builder()
        .addArg(new BuildTargetSourcePath(getBuildTarget()))
        .build();
  }

  @Override
  public BuildableProperties getProperties() {
    return new BuildableProperties(BuildableProperties.Kind.PACKAGING);
  }

}
