/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.juphoon.cmcc.app.lemon;

public class MtcPaJNI {
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
  public final static native int Mtc_PaSessAddSubs(String jarg1);
  public final static native int Mtc_PaSessCancelSubs(String jarg1);
  public final static native int Mtc_PaSessQryUsrSubs(int jarg1, int jarg2, int jarg3);
  public final static native int Mtc_PaSessGetPubLst(String jarg1, int jarg2, int jarg3, int jarg4);
  public final static native int Mtc_PaSessGetPubLstRecmd(int jarg1, int jarg2, int jarg3);
  public final static native int Mtc_PaSessGetPubDetail(String jarg1, int jarg2);
  public final static native int Mtc_PaSessGetPubMenu(String jarg1, int jarg2);
  public final static native int Mtc_PaSessGetPrevMsg(String jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
  public final static native int Mtc_PaSessComplainPub(String jarg1, int jarg2, String jarg3, String jarg4, String jarg5);
  public final static native int Mtc_PaSessSetAcptStat(String jarg1, boolean jarg2);
  public final static native String Mtc_PaSessEncodeMsg(String jarg1);
  public final static native int Mtc_PaSessDecodeMsg(String jarg1);
  public final static native void Mtc_PaSessRelease(int jarg1);
  public final static native String Mtc_PaSessGetXmlMsg(int jarg1);
  public final static native int Mtc_PaSessGetPaSize(int jarg1);
  public final static native int Mtc_PaSessGetPaId(int jarg1, int jarg2);
  public final static native int Mtc_PaSessGetMenuSize(int jarg1);
  public final static native int Mtc_PaSessGetMenuId(int jarg1, int jarg2);
  public final static native int Mtc_PaSessGetMsgSize(int jarg1);
  public final static native int Mtc_PaSessGetMsgId(int jarg1, int jarg2);
  public final static native String Mtc_PaSessGetResult(int jarg1);
  public final static native String Mtc_PaSessGetPaUuid(int jarg1);
  public final static native boolean Mtc_PaSessHasData(int jarg1);
  public final static native String Mtc_PaBscGetPaUuid(int jarg1);
  public final static native String Mtc_PaBscGetName(int jarg1);
  public final static native int Mtc_PaBscGetRecmdLv(int jarg1);
  public final static native String Mtc_PaBscGetLogoUrl(int jarg1);
  public final static native String Mtc_PaBscGetIntro(int jarg1);
  public final static native int Mtc_PaBscGetIdType(int jarg1);
  public final static native int Mtc_PaBscGetSubsStat(int jarg1);
  public final static native String Mtc_PaDetailGetPaUuid(int jarg1);
  public final static native String Mtc_PaDetailGetName(int jarg1);
  public final static native String Mtc_PaDetailGetCompany(int jarg1);
  public final static native String Mtc_PaDetailGetIntro(int jarg1);
  public final static native int Mtc_PaDetailGetUpdTime(int jarg1);
  public final static native int Mtc_PaDetailGetMenuTimestamp(int jarg1);
  public final static native String Mtc_PaDetailGetType(int jarg1);
  public final static native int Mtc_PaDetailGetRecmdLv(int jarg1);
  public final static native int Mtc_PaDetailGetIdType(int jarg1);
  public final static native int Mtc_PaDetailGetMenuType(int jarg1);
  public final static native int Mtc_PaDetailGetSubsStat(int jarg1);
  public final static native int Mtc_PaDetailGetAcptStat(int jarg1);
  public final static native int Mtc_PaDetailGetActiveStat(int jarg1);
  public final static native String Mtc_PaDetailGetTel(int jarg1);
  public final static native String Mtc_PaDetailGetEmail(int jarg1);
  public final static native String Mtc_PaDetailGetZip(int jarg1);
  public final static native String Mtc_PaDetailGetAddr(int jarg1);
  public final static native String Mtc_PaDetailGetField(int jarg1);
  public final static native String Mtc_PaDetailGetLogoUrl(int jarg1);
  public final static native String Mtc_PaDetailGetQrCode(int jarg1);
  public final static native String Mtc_PaMenuGetCmdId(int jarg1);
  public final static native int Mtc_PaMenuGetCmdType(int jarg1);
  public final static native String Mtc_PaMenuGetTitle(int jarg1);
  public final static native int Mtc_PaMenuGetPriority(int jarg1);
  public final static native int Mtc_PaMenuGetSubmenuSize(int jarg1);
  public final static native int Mtc_PaMenuGetSubmenuId(int jarg1, int jarg2);
  public final static native int Mtc_PaMsgGetMediaType(int jarg1);
  public final static native String Mtc_PaMsgGetMsgUuid(int jarg1);
  public final static native String Mtc_PaMsgGetPaUuid(int jarg1);
  public final static native String Mtc_PaMsgGetSmsDigest(int jarg1);
  public final static native String Mtc_PaMsgGetText(int jarg1);
  public final static native int Mtc_PaMsgGetCreateTime(int jarg1);
  public final static native int Mtc_PaMsgGetActiveStat(int jarg1);
  public final static native int Mtc_PaMsgGetFwdable(int jarg1);
  public final static native int Mtc_PaMsgGetGInfoId(int jarg1);
  public final static native int Mtc_PaMsgGetArtMsgSize(int jarg1);
  public final static native int Mtc_PaMsgGetArtMsgId(int jarg1, int jarg2);
  public final static native String Mtc_PaArtMsgGetTitle(int jarg1);
  public final static native String Mtc_PaArtMsgGetAuthor(int jarg1);
  public final static native String Mtc_PaArtMsgGetThumbLink(int jarg1);
  public final static native String Mtc_PaArtMsgGetOrigLink(int jarg1);
  public final static native String Mtc_PaArtMsgGetBodyLink(int jarg1);
  public final static native String Mtc_PaArtMsgGetSrcLink(int jarg1);
  public final static native String Mtc_PaArtMsgGetMainText(int jarg1);
  public final static native String Mtc_PaArtMsgGetMediaUuid(int jarg1);
  public final static native String Mtc_PaBscMsgGetTitle(int jarg1);
  public final static native int Mtc_PaBscMsgGetFileSize(int jarg1);
  public final static native String Mtc_PaBscMsgGetFileType(int jarg1);
  public final static native int Mtc_PaBscMsgGetFileDuration(int jarg1);
  public final static native String Mtc_PaBscMsgGetThumbLink(int jarg1);
  public final static native String Mtc_PaBscMsgGetOrigLink(int jarg1);
  public final static native String Mtc_PaBscMsgGetMediaUuid(int jarg1);
  public final static native int Mtc_PaBscMsgGetCreateTime(int jarg1);
  public final static native String Mtc_PaCardMsgGetTitle(int jarg1);
  public final static native String Mtc_PaCardMsgGetAuthor(int jarg1);
  public final static native String Mtc_PaCardMsgGetThumbLink(int jarg1);
  public final static native String Mtc_PaCardMsgGetOrigLink(int jarg1);
  public final static native String Mtc_PaCardMsgGetBodyLink(int jarg1);
  public final static native String Mtc_PaCardMsgGetSrcLink(int jarg1);
  public final static native String Mtc_PaCardMsgGetMainText(int jarg1);
  public final static native String Mtc_PaCardMsgGetMediaUuid(int jarg1);
  public final static native int Mtc_PaTmplMsgGetTopColor(int jarg1);
  public final static native String Mtc_PaTmplMsgGetTitle(int jarg1);
  public final static native String Mtc_PaTmplMsgGetFirstText(int jarg1);
  public final static native int Mtc_PaTmplMsgGetFirstColor(int jarg1);
  public final static native String Mtc_PaTmplMsgGetLastText(int jarg1);
  public final static native int Mtc_PaTmplMsgGetLastColor(int jarg1);
  public final static native String Mtc_PaTmplMsgGetUrl(int jarg1);
  public final static native int Mtc_PaTmplMsgGetKeyNoteSize(int jarg1);
  public final static native int Mtc_PaTmplMsgGetKeyNoteId(int jarg1, int jarg2);
  public final static native String Mtc_PaKeyNoteGetName(int jarg1);
  public final static native String Mtc_PaKeyNoteGetValueText(int jarg1);
  public final static native int Mtc_PaKeyNoteGetValueColor(int jarg1);
}