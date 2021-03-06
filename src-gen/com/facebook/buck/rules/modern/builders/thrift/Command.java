/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.rules.modern.builders.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)")
public class Command implements org.apache.thrift.TBase<Command, Command._Fields>, java.io.Serializable, Cloneable, Comparable<Command> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Command");

  private static final org.apache.thrift.protocol.TField ARGUMENTS_FIELD_DESC = new org.apache.thrift.protocol.TField("arguments", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField ENVIRONMENT_VARIABLES_FIELD_DESC = new org.apache.thrift.protocol.TField("environmentVariables", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CommandStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CommandTupleSchemeFactory();

  public java.util.List<java.lang.String> arguments; // required
  public java.util.List<EnvironmentVariable> environmentVariables; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ARGUMENTS((short)1, "arguments"),
    ENVIRONMENT_VARIABLES((short)2, "environmentVariables");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ARGUMENTS
          return ARGUMENTS;
        case 2: // ENVIRONMENT_VARIABLES
          return ENVIRONMENT_VARIABLES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ARGUMENTS, new org.apache.thrift.meta_data.FieldMetaData("arguments", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.ENVIRONMENT_VARIABLES, new org.apache.thrift.meta_data.FieldMetaData("environmentVariables", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, EnvironmentVariable.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Command.class, metaDataMap);
  }

  public Command() {
  }

  public Command(
    java.util.List<java.lang.String> arguments,
    java.util.List<EnvironmentVariable> environmentVariables)
  {
    this();
    this.arguments = arguments;
    this.environmentVariables = environmentVariables;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Command(Command other) {
    if (other.isSetArguments()) {
      java.util.List<java.lang.String> __this__arguments = new java.util.ArrayList<java.lang.String>(other.arguments);
      this.arguments = __this__arguments;
    }
    if (other.isSetEnvironmentVariables()) {
      java.util.List<EnvironmentVariable> __this__environmentVariables = new java.util.ArrayList<EnvironmentVariable>(other.environmentVariables.size());
      for (EnvironmentVariable other_element : other.environmentVariables) {
        __this__environmentVariables.add(new EnvironmentVariable(other_element));
      }
      this.environmentVariables = __this__environmentVariables;
    }
  }

  public Command deepCopy() {
    return new Command(this);
  }

  @Override
  public void clear() {
    this.arguments = null;
    this.environmentVariables = null;
  }

  public int getArgumentsSize() {
    return (this.arguments == null) ? 0 : this.arguments.size();
  }

  public java.util.Iterator<java.lang.String> getArgumentsIterator() {
    return (this.arguments == null) ? null : this.arguments.iterator();
  }

  public void addToArguments(java.lang.String elem) {
    if (this.arguments == null) {
      this.arguments = new java.util.ArrayList<java.lang.String>();
    }
    this.arguments.add(elem);
  }

  public java.util.List<java.lang.String> getArguments() {
    return this.arguments;
  }

  public Command setArguments(java.util.List<java.lang.String> arguments) {
    this.arguments = arguments;
    return this;
  }

  public void unsetArguments() {
    this.arguments = null;
  }

  /** Returns true if field arguments is set (has been assigned a value) and false otherwise */
  public boolean isSetArguments() {
    return this.arguments != null;
  }

  public void setArgumentsIsSet(boolean value) {
    if (!value) {
      this.arguments = null;
    }
  }

  public int getEnvironmentVariablesSize() {
    return (this.environmentVariables == null) ? 0 : this.environmentVariables.size();
  }

  public java.util.Iterator<EnvironmentVariable> getEnvironmentVariablesIterator() {
    return (this.environmentVariables == null) ? null : this.environmentVariables.iterator();
  }

  public void addToEnvironmentVariables(EnvironmentVariable elem) {
    if (this.environmentVariables == null) {
      this.environmentVariables = new java.util.ArrayList<EnvironmentVariable>();
    }
    this.environmentVariables.add(elem);
  }

  public java.util.List<EnvironmentVariable> getEnvironmentVariables() {
    return this.environmentVariables;
  }

  public Command setEnvironmentVariables(java.util.List<EnvironmentVariable> environmentVariables) {
    this.environmentVariables = environmentVariables;
    return this;
  }

  public void unsetEnvironmentVariables() {
    this.environmentVariables = null;
  }

  /** Returns true if field environmentVariables is set (has been assigned a value) and false otherwise */
  public boolean isSetEnvironmentVariables() {
    return this.environmentVariables != null;
  }

  public void setEnvironmentVariablesIsSet(boolean value) {
    if (!value) {
      this.environmentVariables = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ARGUMENTS:
      if (value == null) {
        unsetArguments();
      } else {
        setArguments((java.util.List<java.lang.String>)value);
      }
      break;

    case ENVIRONMENT_VARIABLES:
      if (value == null) {
        unsetEnvironmentVariables();
      } else {
        setEnvironmentVariables((java.util.List<EnvironmentVariable>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ARGUMENTS:
      return getArguments();

    case ENVIRONMENT_VARIABLES:
      return getEnvironmentVariables();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ARGUMENTS:
      return isSetArguments();
    case ENVIRONMENT_VARIABLES:
      return isSetEnvironmentVariables();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Command)
      return this.equals((Command)that);
    return false;
  }

  public boolean equals(Command that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_arguments = true && this.isSetArguments();
    boolean that_present_arguments = true && that.isSetArguments();
    if (this_present_arguments || that_present_arguments) {
      if (!(this_present_arguments && that_present_arguments))
        return false;
      if (!this.arguments.equals(that.arguments))
        return false;
    }

    boolean this_present_environmentVariables = true && this.isSetEnvironmentVariables();
    boolean that_present_environmentVariables = true && that.isSetEnvironmentVariables();
    if (this_present_environmentVariables || that_present_environmentVariables) {
      if (!(this_present_environmentVariables && that_present_environmentVariables))
        return false;
      if (!this.environmentVariables.equals(that.environmentVariables))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetArguments()) ? 131071 : 524287);
    if (isSetArguments())
      hashCode = hashCode * 8191 + arguments.hashCode();

    hashCode = hashCode * 8191 + ((isSetEnvironmentVariables()) ? 131071 : 524287);
    if (isSetEnvironmentVariables())
      hashCode = hashCode * 8191 + environmentVariables.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Command other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetArguments()).compareTo(other.isSetArguments());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArguments()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.arguments, other.arguments);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetEnvironmentVariables()).compareTo(other.isSetEnvironmentVariables());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnvironmentVariables()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.environmentVariables, other.environmentVariables);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Command(");
    boolean first = true;

    sb.append("arguments:");
    if (this.arguments == null) {
      sb.append("null");
    } else {
      sb.append(this.arguments);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("environmentVariables:");
    if (this.environmentVariables == null) {
      sb.append("null");
    } else {
      sb.append(this.environmentVariables);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CommandStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CommandStandardScheme getScheme() {
      return new CommandStandardScheme();
    }
  }

  private static class CommandStandardScheme extends org.apache.thrift.scheme.StandardScheme<Command> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Command struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ARGUMENTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list48 = iprot.readListBegin();
                struct.arguments = new java.util.ArrayList<java.lang.String>(_list48.size);
                java.lang.String _elem49;
                for (int _i50 = 0; _i50 < _list48.size; ++_i50)
                {
                  _elem49 = iprot.readString();
                  struct.arguments.add(_elem49);
                }
                iprot.readListEnd();
              }
              struct.setArgumentsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ENVIRONMENT_VARIABLES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list51 = iprot.readListBegin();
                struct.environmentVariables = new java.util.ArrayList<EnvironmentVariable>(_list51.size);
                EnvironmentVariable _elem52;
                for (int _i53 = 0; _i53 < _list51.size; ++_i53)
                {
                  _elem52 = new EnvironmentVariable();
                  _elem52.read(iprot);
                  struct.environmentVariables.add(_elem52);
                }
                iprot.readListEnd();
              }
              struct.setEnvironmentVariablesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Command struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.arguments != null) {
        oprot.writeFieldBegin(ARGUMENTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.arguments.size()));
          for (java.lang.String _iter54 : struct.arguments)
          {
            oprot.writeString(_iter54);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.environmentVariables != null) {
        oprot.writeFieldBegin(ENVIRONMENT_VARIABLES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.environmentVariables.size()));
          for (EnvironmentVariable _iter55 : struct.environmentVariables)
          {
            _iter55.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CommandTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CommandTupleScheme getScheme() {
      return new CommandTupleScheme();
    }
  }

  private static class CommandTupleScheme extends org.apache.thrift.scheme.TupleScheme<Command> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Command struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetArguments()) {
        optionals.set(0);
      }
      if (struct.isSetEnvironmentVariables()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetArguments()) {
        {
          oprot.writeI32(struct.arguments.size());
          for (java.lang.String _iter56 : struct.arguments)
          {
            oprot.writeString(_iter56);
          }
        }
      }
      if (struct.isSetEnvironmentVariables()) {
        {
          oprot.writeI32(struct.environmentVariables.size());
          for (EnvironmentVariable _iter57 : struct.environmentVariables)
          {
            _iter57.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Command struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list58 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.arguments = new java.util.ArrayList<java.lang.String>(_list58.size);
          java.lang.String _elem59;
          for (int _i60 = 0; _i60 < _list58.size; ++_i60)
          {
            _elem59 = iprot.readString();
            struct.arguments.add(_elem59);
          }
        }
        struct.setArgumentsIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list61 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.environmentVariables = new java.util.ArrayList<EnvironmentVariable>(_list61.size);
          EnvironmentVariable _elem62;
          for (int _i63 = 0; _i63 < _list61.size; ++_i63)
          {
            _elem62 = new EnvironmentVariable();
            _elem62.read(iprot);
            struct.environmentVariables.add(_elem62);
          }
        }
        struct.setEnvironmentVariablesIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

