/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.juphoon.cmcc.app.lemon;

public class MtcD2JNI {
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
  public final static native long Mtc_D2CreateImage();
  public final static native void Mtc_D2DeleteImage(long jarg1);
  public final static native long Mtc_D2ParseImage(String jarg1);
  public final static native String Mtc_D2PrintImage(long jarg1);
  public final static native int Mtc_D2SetImageParms(long jarg1, String jarg2);
  public final static native String Mtc_D2GetImageParms(long jarg1);
  public final static native long Mtc_D2CreateAction();
  public final static native void Mtc_D2DeleteAction(long jarg1);
  public final static native long Mtc_D2ParseAction(String jarg1);
  public final static native String Mtc_D2PrintAction(long jarg1);
  public final static native int Mtc_D2SetActionParms(long jarg1, String jarg2);
  public final static native String Mtc_D2GetActionParms(long jarg1);
  public final static native int Mtc_D2AddActionPosition(long jarg1, float jarg2, float jarg3);
  public final static native int Mtc_D2AddActionPositionX(long jarg1, float jarg2, float jarg3, int jarg4);
  public final static native int Mtc_D2GetActionPositionCount(long jarg1);
  public final static native int Mtc_D2GetActionIntval(long jarg1, int jarg2);
  public final static native float Mtc_D2GetActionPositionX(long jarg1, int jarg2);
  public final static native float Mtc_D2GetActionPositionY(long jarg1, int jarg2);
  public final static native String Mtc_D2GetActionPath(long jarg1);
  public final static native long Mtc_D2CreateSession();
  public final static native void Mtc_D2DeleteSession(long jarg1);
  public final static native int Mtc_D2SessionSetPageCount(long jarg1, int jarg2);
  public final static native int Mtc_D2SessionAddPage(long jarg1);
  public final static native int Mtc_D2SessionGetPageCount(long jarg1);
  public final static native int Mtc_D2SessionSetImage(long jarg1, long jarg2);
  public final static native long Mtc_D2SessionGetImage(long jarg1, int jarg2);
  public final static native int Mtc_D2SessionSetCfAction(long jarg1, String jarg2, long jarg3);
  public final static native long Mtc_D2SessionGetCfAction(long jarg1, String jarg2);
  public final static native int Mtc_D2SessionGetCfActionCount(long jarg1);
  public final static native String Mtc_D2SessionEnumCfActionKey(long jarg1, int jarg2);
  public final static native long Mtc_D2SessionEnumCfAction(long jarg1, int jarg2);
  public final static native int Mtc_D2SessionAddAction(long jarg1, long jarg2);
  public final static native int Mtc_D2SessionGetActionCount(long jarg1, int jarg2);
  public final static native long Mtc_D2SessionEnumAction(long jarg1, int jarg2, int jarg3);
}
