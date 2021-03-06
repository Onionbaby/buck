/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.remoteexecution.executionengine;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facebook.thrift.*;
import com.facebook.thrift.async.*;
import com.facebook.thrift.meta_data.*;
import com.facebook.thrift.server.*;
import com.facebook.thrift.transport.*;
import com.facebook.thrift.protocol.*;

@SuppressWarnings({ "unused", "serial" })
public class Platform implements TBase, java.io.Serializable, Cloneable, Comparable<Platform> {
  private static final TStruct STRUCT_DESC = new TStruct("Platform");
  private static final TField PROPERTIES_FIELD_DESC = new TField("properties", TType.LIST, (short)1);

  public List<Property> properties;
  public static final int PROPERTIES = 1;
  public static boolean DEFAULT_PRETTY_PRINT = true;

  // isset id assignments

  public static final Map<Integer, FieldMetaData> metaDataMap;
  static {
    Map<Integer, FieldMetaData> tmpMetaDataMap = new HashMap<Integer, FieldMetaData>();
    tmpMetaDataMap.put(PROPERTIES, new FieldMetaData("properties", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, Property.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMetaDataMap);
  }

  static {
    FieldMetaData.addStructMetaDataMap(Platform.class, metaDataMap);
  }

  public Platform() {
  }

  public Platform(
    List<Property> properties)
  {
    this();
    this.properties = properties;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Platform(Platform other) {
    if (other.isSetProperties()) {
      this.properties = TBaseHelper.deepCopy(other.properties);
    }
  }

  public Platform deepCopy() {
    return new Platform(this);
  }

  @Deprecated
  public Platform clone() {
    return new Platform(this);
  }

  public List<Property>  getProperties() {
    return this.properties;
  }

  public Platform setProperties(List<Property> properties) {
    this.properties = properties;
    return this;
  }

  public void unsetProperties() {
    this.properties = null;
  }

  // Returns true if field properties is set (has been assigned a value) and false otherwise
  public boolean isSetProperties() {
    return this.properties != null;
  }

  public void setPropertiesIsSet(boolean value) {
    if (!value) {
      this.properties = null;
    }
  }

  @SuppressWarnings("unchecked")
  public void setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
    case PROPERTIES:
      if (value == null) {
        unsetProperties();
      } else {
        setProperties((List<Property>)value);
      }
      break;

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  public Object getFieldValue(int fieldID) {
    switch (fieldID) {
    case PROPERTIES:
      return getProperties();

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  // Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise
  public boolean isSet(int fieldID) {
    switch (fieldID) {
    case PROPERTIES:
      return isSetProperties();
    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Platform)
      return this.equals((Platform)that);
    return false;
  }

  public boolean equals(Platform that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_properties = true && this.isSetProperties();
    boolean that_present_properties = true && that.isSetProperties();
    if (this_present_properties || that_present_properties) {
      if (!(this_present_properties && that_present_properties))
        return false;
      if (!TBaseHelper.equalsNobinary(this.properties, that.properties))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Platform other) {
    if (other == null) {
      // See java.lang.Comparable docs
      throw new NullPointerException();
    }

    if (other == this) {
      return 0;
    }
    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetProperties()).compareTo(other.isSetProperties());
    if (lastComparison != 0) {
      return lastComparison;
    }
    lastComparison = TBaseHelper.compareTo(properties, other.properties);
    if (lastComparison != 0) {
      return lastComparison;
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin(metaDataMap);
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id)
      {
        case PROPERTIES:
          if (field.type == TType.LIST) {
            {
              TList _list0 = iprot.readListBegin();
              this.properties = new ArrayList<Property>(Math.max(0, _list0.size));
              for (int _i1 = 0; 
                   (_list0.size < 0) ? iprot.peekList() : (_i1 < _list0.size); 
                   ++_i1)
              {
                Property _elem2;
                _elem2 = new Property();
                _elem2.read(iprot);
                this.properties.add(_elem2);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
          break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();


    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.properties != null) {
      oprot.writeFieldBegin(PROPERTIES_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.properties.size()));
        for (Property _iter3 : this.properties)        {
          _iter3.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    return toString(DEFAULT_PRETTY_PRINT);
  }

  @Override
  public String toString(boolean prettyPrint) {
    return toString(1, prettyPrint);
  }

  @Override
  public String toString(int indent, boolean prettyPrint) {
    String indentStr = prettyPrint ? TBaseHelper.getIndentedString(indent) : "";
    String newLine = prettyPrint ? "\n" : "";
String space = prettyPrint ? " " : "";
    StringBuilder sb = new StringBuilder("Platform");
    sb.append(space);
    sb.append("(");
    sb.append(newLine);
    boolean first = true;

    sb.append(indentStr);
    sb.append("properties");
    sb.append(space);
    sb.append(":").append(space);
    if (this. getProperties() == null) {
      sb.append("null");
    } else {
      sb.append(TBaseHelper.toString(this. getProperties(), indent + 1, prettyPrint));
    }
    first = false;
    sb.append(newLine + TBaseHelper.reduceIndent(indentStr));
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check that fields of type enum have valid values
  }

}

