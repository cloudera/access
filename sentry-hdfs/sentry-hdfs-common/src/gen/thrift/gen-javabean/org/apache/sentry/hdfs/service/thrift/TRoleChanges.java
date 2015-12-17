/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.sentry.hdfs.service.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TRoleChanges implements org.apache.thrift.TBase<TRoleChanges, TRoleChanges._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TRoleChanges");

  private static final org.apache.thrift.protocol.TField ROLE_FIELD_DESC = new org.apache.thrift.protocol.TField("role", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ADD_GROUPS_FIELD_DESC = new org.apache.thrift.protocol.TField("addGroups", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField DEL_GROUPS_FIELD_DESC = new org.apache.thrift.protocol.TField("delGroups", org.apache.thrift.protocol.TType.LIST, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TRoleChangesStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TRoleChangesTupleSchemeFactory());
  }

  public String role; // required
  public List<String> addGroups; // required
  public List<String> delGroups; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ROLE((short)1, "role"),
    ADD_GROUPS((short)2, "addGroups"),
    DEL_GROUPS((short)3, "delGroups");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ROLE
          return ROLE;
        case 2: // ADD_GROUPS
          return ADD_GROUPS;
        case 3: // DEL_GROUPS
          return DEL_GROUPS;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROLE, new org.apache.thrift.meta_data.FieldMetaData("role", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ADD_GROUPS, new org.apache.thrift.meta_data.FieldMetaData("addGroups", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.DEL_GROUPS, new org.apache.thrift.meta_data.FieldMetaData("delGroups", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TRoleChanges.class, metaDataMap);
  }

  public TRoleChanges() {
  }

  public TRoleChanges(
    String role,
    List<String> addGroups,
    List<String> delGroups)
  {
    this();
    this.role = role;
    this.addGroups = addGroups;
    this.delGroups = delGroups;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TRoleChanges(TRoleChanges other) {
    if (other.isSetRole()) {
      this.role = other.role;
    }
    if (other.isSetAddGroups()) {
      List<String> __this__addGroups = new ArrayList<String>();
      for (String other_element : other.addGroups) {
        __this__addGroups.add(other_element);
      }
      this.addGroups = __this__addGroups;
    }
    if (other.isSetDelGroups()) {
      List<String> __this__delGroups = new ArrayList<String>();
      for (String other_element : other.delGroups) {
        __this__delGroups.add(other_element);
      }
      this.delGroups = __this__delGroups;
    }
  }

  public TRoleChanges deepCopy() {
    return new TRoleChanges(this);
  }

  @Override
  public void clear() {
    this.role = null;
    this.addGroups = null;
    this.delGroups = null;
  }

  public String getRole() {
    return this.role;
  }

  public TRoleChanges setRole(String role) {
    this.role = role;
    return this;
  }

  public void unsetRole() {
    this.role = null;
  }

  /** Returns true if field role is set (has been assigned a value) and false otherwise */
  public boolean isSetRole() {
    return this.role != null;
  }

  public void setRoleIsSet(boolean value) {
    if (!value) {
      this.role = null;
    }
  }

  public int getAddGroupsSize() {
    return (this.addGroups == null) ? 0 : this.addGroups.size();
  }

  public java.util.Iterator<String> getAddGroupsIterator() {
    return (this.addGroups == null) ? null : this.addGroups.iterator();
  }

  public void addToAddGroups(String elem) {
    if (this.addGroups == null) {
      this.addGroups = new ArrayList<String>();
    }
    this.addGroups.add(elem);
  }

  public List<String> getAddGroups() {
    return this.addGroups;
  }

  public TRoleChanges setAddGroups(List<String> addGroups) {
    this.addGroups = addGroups;
    return this;
  }

  public void unsetAddGroups() {
    this.addGroups = null;
  }

  /** Returns true if field addGroups is set (has been assigned a value) and false otherwise */
  public boolean isSetAddGroups() {
    return this.addGroups != null;
  }

  public void setAddGroupsIsSet(boolean value) {
    if (!value) {
      this.addGroups = null;
    }
  }

  public int getDelGroupsSize() {
    return (this.delGroups == null) ? 0 : this.delGroups.size();
  }

  public java.util.Iterator<String> getDelGroupsIterator() {
    return (this.delGroups == null) ? null : this.delGroups.iterator();
  }

  public void addToDelGroups(String elem) {
    if (this.delGroups == null) {
      this.delGroups = new ArrayList<String>();
    }
    this.delGroups.add(elem);
  }

  public List<String> getDelGroups() {
    return this.delGroups;
  }

  public TRoleChanges setDelGroups(List<String> delGroups) {
    this.delGroups = delGroups;
    return this;
  }

  public void unsetDelGroups() {
    this.delGroups = null;
  }

  /** Returns true if field delGroups is set (has been assigned a value) and false otherwise */
  public boolean isSetDelGroups() {
    return this.delGroups != null;
  }

  public void setDelGroupsIsSet(boolean value) {
    if (!value) {
      this.delGroups = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ROLE:
      if (value == null) {
        unsetRole();
      } else {
        setRole((String)value);
      }
      break;

    case ADD_GROUPS:
      if (value == null) {
        unsetAddGroups();
      } else {
        setAddGroups((List<String>)value);
      }
      break;

    case DEL_GROUPS:
      if (value == null) {
        unsetDelGroups();
      } else {
        setDelGroups((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ROLE:
      return getRole();

    case ADD_GROUPS:
      return getAddGroups();

    case DEL_GROUPS:
      return getDelGroups();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ROLE:
      return isSetRole();
    case ADD_GROUPS:
      return isSetAddGroups();
    case DEL_GROUPS:
      return isSetDelGroups();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TRoleChanges)
      return this.equals((TRoleChanges)that);
    return false;
  }

  public boolean equals(TRoleChanges that) {
    if (that == null)
      return false;

    boolean this_present_role = true && this.isSetRole();
    boolean that_present_role = true && that.isSetRole();
    if (this_present_role || that_present_role) {
      if (!(this_present_role && that_present_role))
        return false;
      if (!this.role.equals(that.role))
        return false;
    }

    boolean this_present_addGroups = true && this.isSetAddGroups();
    boolean that_present_addGroups = true && that.isSetAddGroups();
    if (this_present_addGroups || that_present_addGroups) {
      if (!(this_present_addGroups && that_present_addGroups))
        return false;
      if (!this.addGroups.equals(that.addGroups))
        return false;
    }

    boolean this_present_delGroups = true && this.isSetDelGroups();
    boolean that_present_delGroups = true && that.isSetDelGroups();
    if (this_present_delGroups || that_present_delGroups) {
      if (!(this_present_delGroups && that_present_delGroups))
        return false;
      if (!this.delGroups.equals(that.delGroups))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TRoleChanges other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TRoleChanges typedOther = (TRoleChanges)other;

    lastComparison = Boolean.valueOf(isSetRole()).compareTo(typedOther.isSetRole());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRole()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.role, typedOther.role);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAddGroups()).compareTo(typedOther.isSetAddGroups());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAddGroups()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.addGroups, typedOther.addGroups);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDelGroups()).compareTo(typedOther.isSetDelGroups());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDelGroups()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.delGroups, typedOther.delGroups);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TRoleChanges(");
    boolean first = true;

    sb.append("role:");
    if (this.role == null) {
      sb.append("null");
    } else {
      sb.append(this.role);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("addGroups:");
    if (this.addGroups == null) {
      sb.append("null");
    } else {
      sb.append(this.addGroups);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("delGroups:");
    if (this.delGroups == null) {
      sb.append("null");
    } else {
      sb.append(this.delGroups);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (role == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'role' was not present! Struct: " + toString());
    }
    if (addGroups == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'addGroups' was not present! Struct: " + toString());
    }
    if (delGroups == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'delGroups' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TRoleChangesStandardSchemeFactory implements SchemeFactory {
    public TRoleChangesStandardScheme getScheme() {
      return new TRoleChangesStandardScheme();
    }
  }

  private static class TRoleChangesStandardScheme extends StandardScheme<TRoleChanges> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TRoleChanges struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ROLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.role = iprot.readString();
              struct.setRoleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ADD_GROUPS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list86 = iprot.readListBegin();
                struct.addGroups = new ArrayList<String>(_list86.size);
                for (int _i87 = 0; _i87 < _list86.size; ++_i87)
                {
                  String _elem88; // required
                  _elem88 = iprot.readString();
                  struct.addGroups.add(_elem88);
                }
                iprot.readListEnd();
              }
              struct.setAddGroupsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEL_GROUPS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list89 = iprot.readListBegin();
                struct.delGroups = new ArrayList<String>(_list89.size);
                for (int _i90 = 0; _i90 < _list89.size; ++_i90)
                {
                  String _elem91; // required
                  _elem91 = iprot.readString();
                  struct.delGroups.add(_elem91);
                }
                iprot.readListEnd();
              }
              struct.setDelGroupsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TRoleChanges struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.role != null) {
        oprot.writeFieldBegin(ROLE_FIELD_DESC);
        oprot.writeString(struct.role);
        oprot.writeFieldEnd();
      }
      if (struct.addGroups != null) {
        oprot.writeFieldBegin(ADD_GROUPS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.addGroups.size()));
          for (String _iter92 : struct.addGroups)
          {
            oprot.writeString(_iter92);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.delGroups != null) {
        oprot.writeFieldBegin(DEL_GROUPS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.delGroups.size()));
          for (String _iter93 : struct.delGroups)
          {
            oprot.writeString(_iter93);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TRoleChangesTupleSchemeFactory implements SchemeFactory {
    public TRoleChangesTupleScheme getScheme() {
      return new TRoleChangesTupleScheme();
    }
  }

  private static class TRoleChangesTupleScheme extends TupleScheme<TRoleChanges> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TRoleChanges struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.role);
      {
        oprot.writeI32(struct.addGroups.size());
        for (String _iter94 : struct.addGroups)
        {
          oprot.writeString(_iter94);
        }
      }
      {
        oprot.writeI32(struct.delGroups.size());
        for (String _iter95 : struct.delGroups)
        {
          oprot.writeString(_iter95);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TRoleChanges struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.role = iprot.readString();
      struct.setRoleIsSet(true);
      {
        org.apache.thrift.protocol.TList _list96 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.addGroups = new ArrayList<String>(_list96.size);
        for (int _i97 = 0; _i97 < _list96.size; ++_i97)
        {
          String _elem98; // required
          _elem98 = iprot.readString();
          struct.addGroups.add(_elem98);
        }
      }
      struct.setAddGroupsIsSet(true);
      {
        org.apache.thrift.protocol.TList _list99 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.delGroups = new ArrayList<String>(_list99.size);
        for (int _i100 = 0; _i100 < _list99.size; ++_i100)
        {
          String _elem101; // required
          _elem101 = iprot.readString();
          struct.delGroups.add(_elem101);
        }
      }
      struct.setDelGroupsIsSet(true);
    }
  }

}

