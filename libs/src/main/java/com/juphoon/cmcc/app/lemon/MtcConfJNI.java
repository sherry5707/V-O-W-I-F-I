/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.juphoon.cmcc.app.lemon;

public class MtcConfJNI {
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
  public final static native int Mtc_ConfCreate();
  public final static native int Mtc_ConfSetup(int jarg1, Object jarg2);
  public final static native int Mtc_ConfJoin(int jarg1, Object jarg2, String jarg3, boolean jarg4);
  public final static native int Mtc_ConfAlert(int jarg1, Object jarg2);
  public final static native int Mtc_ConfAcpt(int jarg1, Object jarg2);
  public final static native int Mtc_ConfHold(int jarg1, boolean jarg2);
  public final static native int Mtc_ConfIvtUser(int jarg1, String jarg2);
  public final static native int Mtc_ConfIvtUserLst(int jarg1, Object jarg2, int jarg3, boolean jarg4);
  public final static native int Mtc_ConfKickUser(int jarg1, String jarg2);
  public final static native int Mtc_ConfIvtSess(int jarg1, int jarg2);
  public final static native int Mtc_ConfIvtSessLst(int jarg1, Object jarg2, int jarg3);
  public final static native int Mtc_ConfTerm(int jarg1, int jarg2, boolean jarg3);
  public final static native int Mtc_ConfGetState(int jarg1);
  public final static native int Mtc_ConfVideoSelectUsr(int jarg1, String jarg2);
  public final static native int Mtc_ConfRmvUser(int jarg1, String jarg2);
  public final static native Object Mtc_ConfGetCookie(int jarg1);
  public final static native int Mtc_ConfGetPeerUri(int jarg1, MtcString jarg2, MtcString jarg3);
  public final static native int Mtc_ConfGetConfUri(int jarg1, MtcString jarg2, MtcString jarg3);
  public final static native int Mtc_ConfGetInitiatorUri(int jarg1, MtcString jarg2, MtcString jarg3);
  public final static native int Mtc_ConfGetPartpSize(int jarg1);
  public final static native int Mtc_ConfGetPartpUri(int jarg1, int jarg2, MtcString jarg3, MtcString jarg4);
  public final static native int Mtc_ConfGetPartpStat(int jarg1, int jarg2);
  public final static native boolean Mtc_ConfGetMicMute(int jarg1);
  public final static native int Mtc_ConfSetMicMute(int jarg1, boolean jarg2);
  public final static native boolean Mtc_ConfGetSpkMute(int jarg1);
  public final static native int Mtc_ConfSetSpkMute(int jarg1, boolean jarg2);
  public final static native int Mtc_ConfDtmf(int jarg1, int jarg2);
  public final static native int Mtc_ConfCameraAttach(int jarg1, int jarg2, String jarg3);
  public final static native int Mtc_ConfCameraDetach(int jarg1, int jarg2);
  public final static native String Mtc_ConfGetStrmName(int jarg1, int jarg2);
  public final static native int Mtc_ConfStrmIdFromStrmName(int jarg1, String jarg2);
  public final static native int Mtc_ConfGetVideoStrmCount(int jarg1);
  public final static native int Mtc_ConfGetVideoStrmIdByIndex(int jarg1, int jarg2);
  public final static native String Mtc_ConfGetVideoStat(int jarg1, int jarg2);
  public final static native String Mtc_ConfGetAudioStat(int jarg1);
  public final static native int Mtc_ConfGetMaxImageNum(int jarg1);
  public final static native int Mtc_ConfGetVideoSwithMode(int jarg1);
  public final static native int Mtc_ConfGetMultiPicMode(int jarg1);
  public final static native int Mtc_ConfEnableAdaptiveAspect(int jarg1, boolean jarg2, float jarg3);
  public final static native int Mtc_ConfRecMicStart(String jarg1, short jarg2);
  public final static native int Mtc_ConfRecMicStop();
  public final static native int Mtc_ConfRecPlayoutStart(int jarg1, String jarg2, short jarg3);
  public final static native int Mtc_ConfRecPlayoutStop(int jarg1);
  public final static native int Mtc_ConfSndStartSend(int jarg1, String jarg2, short jarg3, boolean jarg4, boolean jarg5);
  public final static native int Mtc_ConfSndStopSend(int jarg1);
  public final static native int Mtc_ConfFilePlayAsCamera(String jarg1, int jarg2, int jarg3);
  public final static native int Mtc_ConfFilePlayStop(String jarg1);
  public final static native int Mtc_ConfGetStrmId(int jarg1, short jarg2);
  public final static native String Mtc_ConfGetMediaServerIpAddr(int jarg1);
  public final static native short Mtc_ConfGetConfType(int jarg1);
}
