/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.juphoon.cmcc.app.lemon;

public class MtcCliJNI {
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
  public final static native int Mtc_CliInit(String jarg1);
  public final static native void Mtc_CliDestroy();
  public final static native int Mtc_CliOpen(String jarg1);
  public final static native void Mtc_CliClose();
  public final static native int Mtc_CliStart();
  public final static native void Mtc_CliStop();
  public final static native int Mtc_CliLogin(int jarg1, String jarg2);
  public final static native int Mtc_CliRelogin(int jarg1, String jarg2);
  public final static native int Mtc_CliEnterAkaRsp(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5);
  public final static native int Mtc_CliEnterDgstPwd(int jarg1, String jarg2);
  public final static native int Mtc_CliRefresh();
  public final static native int Mtc_CliKeepAlive();
  public final static native int Mtc_CliLogout();
  public final static native int Mtc_CliInfo(String jarg1, String jarg2);
  public final static native int Mtc_CliGetRegState();
  public final static native int Mtc_CliGetRegServType();
  public final static native int Mtc_CliGetRegDate();
  public final static native boolean Mtc_CliGetDidReg();
  public final static native int Mtc_CliDrive(long jarg1);
  public final static native int Mtc_CliDetLclIp();
  public final static native int Mtc_CliDetLclIpv6(MtcNumber jarg1);
  public final static native int Mtc_CliSetLclIpAddrType();
  public final static native String Mtc_CliGetDevId();
  public final static native String Mtc_CliGetDevIdX(int jarg1);
  public final static native int Mtc_CliDownloadMmp();
  public final static native int Mtc_CliNetUnavailable();
  public final static native int Mtc_CliChkApp();
  public final static native int Mtc_CliRegDisc();
  public final static native int Mtc_CliGetSyncResult();
  public final static native int Mtc_CliCallCbNetChanged(int jarg1);
  public final static native int Mtc_CliGetTimeDiff();
  public final static native int Mtc_CliInitHeartbeatDetect();
}
