/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.juphoon.cmcc.app.lemon;

public class MtcProfDbJNI {
  public final static native void MtcNumber_value_set(long jarg1, MtcNumber jarg1_, int jarg2);
  public final static native int MtcNumber_value_get(long jarg1, MtcNumber jarg1_);
  public final static native long new_MtcNumber();
  public final static native void delete_MtcNumber(long jarg1);
  public final static native void MtcByteArray_data_set(long jarg1, MtcByteArray jarg1_, long jarg2);
  public final static native long MtcByteArray_data_get(long jarg1, MtcByteArray jarg1_);
  public final static native void MtcByteArray_size_set(long jarg1, MtcByteArray jarg1_, long jarg2);
  public final static native long MtcByteArray_size_get(long jarg1, MtcByteArray jarg1_);
  public final static native void MtcByteArray_value_set(long jarg1, MtcByteArray jarg1_, byte[] jarg2);
  public final static native byte[] MtcByteArray_value_get(long jarg1, MtcByteArray jarg1_);
  public final static native long new_MtcByteArray();
  public final static native void delete_MtcByteArray(long jarg1);
  public final static native void MtcString_value_set(long jarg1, MtcString jarg1_, String jarg2);
  public final static native String MtcString_value_get(long jarg1, MtcString jarg1_);
  public final static native long new_MtcString();
  public final static native void delete_MtcString(long jarg1);
  public final static native String Mtc_ProfDbGetAppVer();
  public final static native int Mtc_ProfDbSetAppVer(String jarg1);
  public final static native boolean Mtc_ProfDbGetRemPwd();
  public final static native int Mtc_ProfDbSetRemPwd(boolean jarg1);
  public final static native boolean Mtc_ProfDbGetAutoLogin();
  public final static native int Mtc_ProfDbSetAutoLogin(boolean jarg1);
  public final static native String Mtc_ProfDbGetAvatarFile();
  public final static native int Mtc_ProfDbSetAvatarFile(String jarg1);
  public final static native String Mtc_ProfDbGetCountryCode();
  public final static native int Mtc_ProfDbSetCountryCode(String jarg1);
  public final static native String Mtc_ProfDbGetAreaCode();
  public final static native int Mtc_ProfDbSetAreaCode(String jarg1);
  public final static native boolean Mtc_ProfDbGetCpEnable();
  public final static native int Mtc_ProfDbSetCpEnable(boolean jarg1);
  public final static native int Mtc_ProfDbGetExtnParm(String jarg1, MtcString jarg2);
  public final static native int Mtc_ProfDbGetExtnParmBool(String jarg1, MtcNumber jarg2);
  public final static native int Mtc_ProfDbGetExtnParmInt(String jarg1, MtcNumber jarg2);
  public final static native int Mtc_ProfDbGetExtnParmUint(String jarg1, MtcNumber jarg2);
  public final static native String Mtc_ProfDbGetExtnParmX(String jarg1, int jarg2);
  public final static native int Mtc_ProfDbGetExtnParmCount(String jarg1);
  public final static native int Mtc_ProfDbSetExtnParm(String jarg1, String jarg2);
  public final static native int Mtc_ProfDbSetExtnParmBool(String jarg1, boolean jarg2);
  public final static native int Mtc_ProfDbSetExtnParmInt(String jarg1, int jarg2);
  public final static native int Mtc_ProfDbSetExtnParmUint(String jarg1, int jarg2);
  public final static native int Mtc_ProfDbAddExtnParm(String jarg1, String jarg2);
  public final static native int Mtc_ProfDbAddExtnParmN(String jarg1, int jarg2, String jarg3, int jarg4);
}