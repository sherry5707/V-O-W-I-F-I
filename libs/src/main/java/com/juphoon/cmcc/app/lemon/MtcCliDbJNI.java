/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.juphoon.cmcc.app.lemon;

public class MtcCliDbJNI {
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
  public final static native int Mtc_CliDbApplyAll();
  public final static native boolean Mtc_CliDbGetApplyChange();
  public final static native int Mtc_CliDbSetApplyChange(boolean jarg1);
  public final static native String Mtc_CliDbGetLocalIp();
  public final static native int Mtc_CliDbGetLocalIpX();
  public final static native int Mtc_CliDbSetLocalIp(String jarg1);
  public final static native String Mtc_CliDbGetLocalIpv6();
  public final static native int Mtc_CliDbSetLocalIpv6(String jarg1);
  public final static native int Mtc_CliDbSetLoginLogPrint(boolean jarg1);
  public final static native boolean Mtc_CliDbGetLoginLogPrint();
  public final static native int Mtc_CliDbGetLogLevel();
  public final static native int Mtc_CliDbSetLogLevel(int jarg1);
  public final static native int Mtc_CliDbGetLogFileSize();
  public final static native int Mtc_CliDbSetLogFileSize(int jarg1);
  public final static native String Mtc_CliDbGetUserAgent();
  public final static native int Mtc_CliDbSetUserAgent(String jarg1);
  public final static native String Mtc_CliDbGetImpu();
  public final static native int Mtc_CliDbSetImpu(String jarg1);
  public final static native String Mtc_CliDbGetPcImpu();
  public final static native int Mtc_CliDbSetPcImpu(String jarg1);
  public final static native int Mtc_CliDbSetUserState(int jarg1);
  public final static native int Mtc_CliDbGetUserState();
  public final static native String Mtc_CliDbGetUserName();
  public final static native int Mtc_CliDbSetUserName(String jarg1);
  public final static native String Mtc_CliDbGetNickName();
  public final static native int Mtc_CliDbSetNickName(String jarg1);
  public final static native String Mtc_CliDbGetAuthName();
  public final static native String Mtc_CliDbGetAuthRealm();
  public final static native int Mtc_CliDbSetAuthName(String jarg1);
  public final static native int Mtc_CliDbSetAuthRealm(String jarg1);
  public final static native String Mtc_CliDbGetAuthPass();
  public final static native int Mtc_CliDbSetAuthPass(String jarg1);
  public final static native String Mtc_CliDbGetPhoneContext();
  public final static native int Mtc_CliDbSetPhoneContext(String jarg1);
  public final static native int Mtc_CliDbGetAuthType();
  public final static native int Mtc_CliDbSetAuthType(int jarg1);
  public final static native int Mtc_CliDbGetRoamType();
  public final static native int Mtc_CliDbSetRoamType(int jarg1);
  public final static native boolean Mtc_CliDbGetRegNoDigest();
  public final static native int Mtc_CliDbSetRegNoDigest(boolean jarg1);
  public final static native int Mtc_CliDbGetKeepAliveType();
  public final static native int Mtc_CliDbSetKeepAliveType(int jarg1);
  public final static native int Mtc_CliDbGetHeartbeatTmr();
  public final static native int Mtc_CliDbSetHeartbeatTmr(int jarg1);
  public final static native int Mtc_CliDbGetWifiHeartbeatTmr();
  public final static native int Mtc_CliDbSetWifiHeartbeatTmr(int jarg1);
  public final static native boolean Mtc_CliDbGetUserReg();
  public final static native boolean Mtc_CliDbGetProxyEnable();
  public final static native int Mtc_CliDbSetProxyEnable(boolean jarg1);
  public final static native int Mtc_CliDbSetUserReg(boolean jarg1);
  public final static native boolean Mtc_CliDbGetRegTagConverg();
  public final static native int Mtc_CliDbSetRegTagConverg(boolean jarg1);
  public final static native int Mtc_CliDbSetUserRegDetect(boolean jarg1);
  public final static native boolean Mtc_CliDbGetUserRegDetect();
  public final static native String Mtc_CliDbGetSipRegIp();
  public final static native int Mtc_CliDbSetSipRegIp(String jarg1);
  public final static native short Mtc_CliDbGetSipRegTpt();
  public final static native int Mtc_CliDbSetSipRegTpt(short jarg1);
  public final static native int Mtc_CliDbGetSipRegUdpPort();
  public final static native int Mtc_CliDbSetSipRegUdpPort(int jarg1);
  public final static native int Mtc_CliDbGetSipRegTcpPort();
  public final static native int Mtc_CliDbSetSipRegTcpPort(int jarg1);
  public final static native int Mtc_CliDbGetSipRegTlsPort();
  public final static native int Mtc_CliDbSetSipRegTlsPort(int jarg1);
  public final static native int Mtc_CliDbGetSipRegStunPort();
  public final static native int Mtc_CliDbSetSipRegStunPort(int jarg1);
  public final static native String Mtc_CliDbGet2ndSipRegIp();
  public final static native int Mtc_CliDbSet2ndSipRegIp(String jarg1);
  public final static native int Mtc_CliDbGet2ndSipRegUdpPort();
  public final static native int Mtc_CliDbSet2ndSipRegUdpPort(int jarg1);
  public final static native int Mtc_CliDbGet2ndSipRegTcpPort();
  public final static native int Mtc_CliDbSet2ndSipRegTcpPort(int jarg1);
  public final static native int Mtc_CliDbGet2ndSipRegTlsPort();
  public final static native int Mtc_CliDbSet2ndSipRegTlsPort(int jarg1);
  public final static native int Mtc_CliDbGet2ndSipRegStunPort();
  public final static native int Mtc_CliDbSet2ndSipRegStunPort(int jarg1);
  public final static native int Mtc_CliDbGetRegExpire();
  public final static native int Mtc_CliDbSetRegExpire(int jarg1);
  public final static native int Mtc_CliDbGetRegExpireType();
  public final static native int Mtc_CliDbSetRegExpireType(int jarg1);
  public final static native int Mtc_CliDbGetSubsRegExpire();
  public final static native int Mtc_CliDbSetSubsRegExpire(int jarg1);
  public final static native String Mtc_CliDbGetSipRegRealm();
  public final static native int Mtc_CliDbSetSipRegRealm(String jarg1);
  public final static native int Mtc_CliDbGetMsrpKeepAliveType();
  public final static native int Mtc_CliDbSetMsrpKeepAliveType(int jarg1);
  public final static native int Mtc_CliDbGetMsrpKeepAliveIntval();
  public final static native int Mtc_CliDbSetMsrpKeepAliveIntval(int jarg1);
  public final static native int Mtc_CliDbGetMsrpTptTrunkSize();
  public final static native int Mtc_CliDbSetMsrpTptTrunkSize(int jarg1);
  public final static native boolean Mtc_CliDbGetMsrpSendBodiless();
  public final static native int Mtc_CliDbSetMsrpSendBodiless(boolean jarg1);
  public final static native boolean Mtc_CliDbGetMsrpLogMsgPrint();
  public final static native int Mtc_CliDbSetMsrpLogMsgPrint(boolean jarg1);
  public final static native boolean Mtc_CliDbGetMsrpLogFileInfoPrint();
  public final static native int Mtc_CliDbSetMsrpLogFileInfoPrint(boolean jarg1);
  public final static native int Mtc_CliDbGetDnsLclPort();
  public final static native int Mtc_CliDbSetDnsLclPort(int jarg1);
  public final static native int Mtc_CliDbSetDnsEnableCache(boolean jarg1);
  public final static native int Mtc_CliDbGetDnsServIp(boolean jarg1);
  public final static native int Mtc_CliDbSetDnsServIp(boolean jarg1, int jarg2);
  public final static native int Mtc_CliDbGetDnsServPort(boolean jarg1);
  public final static native boolean Mtc_CliDbGetDnsEnableCache();
  public final static native int Mtc_CliDbSetDnsServPort(boolean jarg1, int jarg2);
  public final static native int Mtc_CliDbGetNatTraversalMode();
  public final static native int Mtc_CliDbSetNatTraversalMode(int jarg1);
  public final static native String Mtc_CliDbGetStunServerName();
  public final static native int Mtc_CliDbSetStunServerName(String jarg1);
  public final static native int Mtc_CliDbGetStunServerPort();
  public final static native int Mtc_CliDbSetStunServerPort(int jarg1);
  public final static native String Mtc_CliDbGetMdmServerUri();
  public final static native int Mtc_CliDbSetMdmServerUri(String jarg1);
  public final static native String Mtc_CliDbGetTurnServerName();
  public final static native int Mtc_CliDbSetTurnServerName(String jarg1);
  public final static native int Mtc_CliDbGetTurnServerPort();
  public final static native int Mtc_CliDbSetTurnServerPort(int jarg1);
  public final static native int Mtc_CliDbGetSipLclUdpPort();
  public final static native int Mtc_CliDbSetSipLclUdpPort(int jarg1);
  public final static native int Mtc_CliDbGetSipLclTcpPort();
  public final static native int Mtc_CliDbSetSipLclTcpPort(int jarg1);
  public final static native int Mtc_CliDbGetSipLclTlsPort();
  public final static native int Mtc_CliDbSetSipLclTlsPort(int jarg1);
  public final static native int Mtc_CliDbGetSipTmr1();
  public final static native int Mtc_CliDbSetSipTmr1(int jarg1);
  public final static native int Mtc_CliDbGetSipTmr2();
  public final static native int Mtc_CliDbSetSipTmr2(int jarg1);
  public final static native int Mtc_CliDbGetSipTmr4();
  public final static native int Mtc_CliDbSetSipTmr4(int jarg1);
  public final static native boolean Mtc_CliDbGetUseIpv4();
  public final static native int Mtc_CliDbSetUseIpv4(boolean jarg1);
  public final static native int Mtc_CliDbGetSipDscpValue();
  public final static native int Mtc_CliDbSetSipDscpValue(int jarg1);
  public final static native boolean Mtc_CliDbGetUseTelUri();
  public final static native int Mtc_CliDbSetUseTelUri(boolean jarg1);
  public final static native String Mtc_CliDbGetSipServIp(boolean jarg1);
  public final static native int Mtc_CliDbSetSipServIp(boolean jarg1, String jarg2);
  public final static native int Mtc_CliDbGetSipServPort(boolean jarg1);
  public final static native int Mtc_CliDbSetSipServPort(boolean jarg1, int jarg2);
  public final static native int Mtc_CliDbGetSipServPortX(boolean jarg1, short jarg2);
  public final static native int Mtc_CliDbSetSipServPortX(boolean jarg1, short jarg2, int jarg3);
  public final static native short Mtc_CliDbGetSipServTpt(boolean jarg1);
  public final static native int Mtc_CliDbSetSipServTpt(boolean jarg1, short jarg2);
  public final static native String Mtc_CliDbGetSipServRealm(boolean jarg1);
  public final static native int Mtc_CliDbSetSipServRealm(boolean jarg1, String jarg2);
  public final static native int Mtc_CliDbGetRegRetryCount();
  public final static native int Mtc_CliDbSetRegRetryCount(int jarg1);
  public final static native boolean Mtc_CliDbGetSubsRegEvnt();
  public final static native int Mtc_CliDbSetSubsRegEvnt(boolean jarg1);
  public final static native int Mtc_CliDbGetAccNetType();
  public final static native int Mtc_CliDbSetAccNetType(int jarg1);
  public final static native String Mtc_CliDbGetAccNetInfo();
  public final static native int Mtc_CliDbSetAccNetInfo(String jarg1);
  public final static native String Mtc_CliDbGetXcapRootUri();
  public final static native int Mtc_CliDbSetXcapRootUri(String jarg1);
  public final static native String Mtc_CliDbGetXcapAuthName();
  public final static native int Mtc_CliDbSetXcapAuthName(String jarg1);
  public final static native String Mtc_CliDbGetXcapAuthPass();
  public final static native int Mtc_CliDbSetXcapAuthPass(String jarg1);
  public final static native String Mtc_CliDbGetXcapAuthToken();
  public final static native int Mtc_CliDbSetXcapAuthToken(String jarg1);
  public final static native int Mtc_CliDbGetXcapAuthType();
  public final static native int Mtc_CliDbSetXcapAuthType(int jarg1);
  public final static native String Mtc_CliDbGetXcapHost();
  public final static native int Mtc_CliDbSetXcapHost(String jarg1);
  public final static native int Mtc_CliDbGetXcapHostPort();
  public final static native int Mtc_CliDbSetXcapHostPort(int jarg1);
  public final static native String Mtc_CliDbGetXcapRoot();
  public final static native int Mtc_CliDbSetXcapRoot(String jarg1);
  public final static native String Mtc_CliDbGetXcapUserId();
  public final static native int Mtc_CliDbSetXcapUserId(String jarg1);
  public final static native String Mtc_CliDbGetXcapAgProxyIp();
  public final static native int Mtc_CliDbSetXcapAgProxyIp(String jarg1);
  public final static native int Mtc_CliDbGetXcapAgProxyPort();
  public final static native int Mtc_CliDbSetXcapAgProxyPort(int jarg1);
  public final static native boolean Mtc_CliDbGetXcapUriNsSupt();
  public final static native int Mtc_CliDbSetXcapUriNsSupt(boolean jarg1);
  public final static native String Mtc_CliDbGetXcapPreArgGrpUri();
  public final static native int Mtc_CliDbSetXcapPreArgGrpUri(String jarg1);
  public final static native String Mtc_CliDbGetXcapChatGrpUri();
  public final static native int Mtc_CliDbSetXcapChatGrpUri(String jarg1);
  public final static native String Mtc_CliDbGetXcapRlsSrvUri();
  public final static native int Mtc_CliDbSetXcapRlsSrvUri(String jarg1);
  public final static native int Mtc_CliDbGetXcapcTcpListenPort();
  public final static native int Mtc_CliDbSetXcapcTcpListenPort(int jarg1);
  public final static native int Mtc_CliDbGetRvkTmrLen();
  public final static native boolean Mtc_CliDbGetPnbEnable();
  public final static native int Mtc_CliDbSetPnbEnable(boolean jarg1);
  public final static native boolean Mtc_CliDbGetXdmChgSubsEnable();
  public final static native int Mtc_CliDbSetXdmChgSubsEnable(boolean jarg1);
  public final static native int Mtc_CliDbGetNatUriFmt();
  public final static native int Mtc_CliDbGetIntUriFmt();
  public final static native boolean Mtc_CliDbGetSipInstanceEnable();
  public final static native int Mtc_CliDbSetSipInstanceEnable(boolean jarg1);
  public final static native String Mtc_CliDbGetQValue();
  public final static native short Mtc_CliDbGetRcseSwitchType();
  public final static native String Mtc_CliDbGetRcseOnlyApn();
  public final static native int Mtc_CliDbGetAlwaysUseImsApn();
  public final static native int Mtc_CliDbSetRcseSwitchType(short jarg1);
  public final static native int Mtc_CliDbSetRcseOnlyApn(String jarg1);
  public final static native int Mtc_CliDbSetAlwaysUseImsApn(int jarg1);
  public final static native int Mtc_CliDbGetDataBearerType();
  public final static native int Mtc_CliDbSetDataBearerType(int jarg1);
  public final static native int Mtc_CliDbGetTlsCliMethod();
  public final static native int Mtc_CliDbGetTlsCliVeryType();
  public final static native String Mtc_CliDbGetTlsCliTrustCaPath();
  public final static native String Mtc_CliDbGetTlsCliTrustCaFile();
  public final static native String Mtc_CliDbGetTlsCliCertFile();
  public final static native String Mtc_CliDbGetTlsCliPrvKeyFile();
  public final static native String Mtc_CliDbGetTlsCliPrvKeyPass();
  public final static native int Mtc_CliDbGetTlsServMethod();
  public final static native int Mtc_CliDbGetTlsServVeryType();
  public final static native String Mtc_CliDbGetTlsServTrustCaFile();
  public final static native String Mtc_CliDbGetTlsServCertFile();
  public final static native String Mtc_CliDbGetTlsServPrvKeyFile();
  public final static native String Mtc_CliDbGetTlsServPrvKeyPass();
  public final static native int Mtc_CliDbSetTlsCliMethod(int jarg1);
  public final static native int Mtc_CliDbSetTlsCliVeryType(int jarg1);
  public final static native int Mtc_CliDbSetTlsCliTrustCaPath(String jarg1);
  public final static native int Mtc_CliDbSetTlsCliTrustCaFile(String jarg1);
  public final static native int Mtc_CliDbSetTlsCliCertFile(String jarg1);
  public final static native int Mtc_CliDbSetTlsCliPrvKeyFile(String jarg1);
  public final static native int Mtc_CliDbSetTlsCliPrvKeyPass(String jarg1);
  public final static native int Mtc_CliDbSetTlsServMethod(int jarg1);
  public final static native int Mtc_CliDbSetTlsServVeryType(int jarg1);
  public final static native int Mtc_CliDbSetTlsServTrustCaFile(String jarg1);
  public final static native int Mtc_CliDbSetTlsServCertFile(String jarg1);
  public final static native int Mtc_CliDbSetTlsServPrvKeyFile(String jarg1);
  public final static native int Mtc_CliDbSetTlsServPrvKeyPass(String jarg1);
  public final static native int Mtc_CliDbSetDtlsCaFile(String jarg1);
  public final static native String Mtc_CliDbGetDtlsCaFile();
  public final static native boolean Mtc_CliDbGetUxMessagingUX();
  public final static native int Mtc_CliDbSetUxMessagingUX(boolean jarg1);
  public final static native int Mtc_CliDbSetAcvServAddr(String jarg1);
  public final static native int Mtc_CliDbSetAcvUrl(String jarg1);
  public final static native int Mtc_CliDbSetAcvServPort(int jarg1);
  public final static native String Mtc_CliDbGetPaServAddr();
  public final static native int Mtc_CliDbSetPaServAddr(String jarg1);
  public final static native String Mtc_CliDbGetPaServAddrType();
  public final static native int Mtc_CliDbSetPaServAddrType(String jarg1);
  public final static native String Mtc_CliDbGetPaServRoot();
  public final static native int Mtc_CliDbSetPaServRoot(String jarg1);
  public final static native int Mtc_CliDbGetPaServPort();
  public final static native int Mtc_CliDbSetPaServPort(int jarg1);
  public final static native String Mtc_CliDbGetPaHttpUserId();
  public final static native int Mtc_CliDbSetPaHttpUserId(String jarg1);
  public final static native String Mtc_CliDbGetPaVers();
  public final static native int Mtc_CliDbSetPaVers(String jarg1);
  public final static native String Mtc_CliDbGetPaAuthName();
  public final static native int Mtc_CliDbSetPaAuthName(String jarg1);
  public final static native String Mtc_CliDbGetPaAuthPass();
  public final static native int Mtc_CliDbSetPaAuthPass(String jarg1);
  public final static native String Mtc_CliDbGetPaAuthToken();
  public final static native int Mtc_CliDbSetPaAuthToken(String jarg1);
  public final static native int Mtc_CliDbGetPaAuthType();
  public final static native int Mtc_CliDbSetPaAuthType(int jarg1);
  public final static native int Mtc_CliDbSetPaUserAgent(String jarg1);
  public final static native String Mtc_CliDbGetPaUserAgent();
  public final static native String Mtc_CliDbGetProfileServAddr();
  public final static native int Mtc_CliDbSetProfileServAddr(String jarg1);
  public final static native String Mtc_CliDbGetProfileServAddrType();
  public final static native int Mtc_CliDbSetProfileServAddrType(String jarg1);
  public final static native String Mtc_CliDbGetPcAsServAddr();
  public final static native int Mtc_CliDbSetPcAsServAddr(String jarg1);
  public final static native int Mtc_CliDbGetPcAsServPort();
  public final static native int Mtc_CliDbSetpcAsServPort(int jarg1);
  public final static native String Mtc_CliDbGetPcAsServAddrType();
  public final static native int Mtc_CliDbSetPcAsServAddrType(String jarg1);
  public final static native String Mtc_CliDbGetProfileServRoot();
  public final static native int Mtc_CliDbSetProfileServRoot(String jarg1);
  public final static native int Mtc_CliDbGetProfileServPort();
  public final static native int Mtc_CliDbSetProfileServPort(int jarg1);
  public final static native String Mtc_CliDbGetProfileAuthName();
  public final static native int Mtc_CliDbSetProfileAuthName(String jarg1);
  public final static native String Mtc_CliDbGetProfileAuthPass();
  public final static native int Mtc_CliDbSetProfileAuthPass(String jarg1);
  public final static native String Mtc_CliDbGetProfileAuthToken();
  public final static native int Mtc_CliDbSetProfileAuthToken(String jarg1);
  public final static native int Mtc_CliDbGetProfileAuthType();
  public final static native int Mtc_CliDbSetProfileAuthType(int jarg1);
  public final static native String Mtc_CliDbGetQrcardServAddr();
  public final static native int Mtc_CliDbSetQrcardServAddr(String jarg1);
  public final static native String Mtc_CliDbGetQrcardServAddrType();
  public final static native int Mtc_CliDbSetQrcardServAddrType(String jarg1);
  public final static native String Mtc_CliDbGetQrcardServRoot();
  public final static native int Mtc_CliDbSetQrcardServRoot(String jarg1);
  public final static native int Mtc_CliDbGetQrcardServPort();
  public final static native int Mtc_CliDbSetQrcardServPort(int jarg1);
  public final static native String Mtc_CliDbGetQrcardAuthName();
  public final static native int Mtc_CliDbSetQrcardAuthName(String jarg1);
  public final static native String Mtc_CliDbGetQrcardAuthPass();
  public final static native int Mtc_CliDbSetQrcardAuthPass(String jarg1);
  public final static native String Mtc_CliDbGetQrcardAuthToken();
  public final static native int Mtc_CliDbSetQrcardAuthToken(String jarg1);
  public final static native int Mtc_CliDbGetQrcardAuthType();
  public final static native int Mtc_CliDbSetQrcardAuthType(int jarg1);
  public final static native String Mtc_CliDbGetNabServAddr();
  public final static native int Mtc_CliDbSetNabServAddr(String jarg1);
  public final static native String Mtc_CliDbGetNabServAddrType();
  public final static native int Mtc_CliDbSetNabServAddrType(String jarg1);
  public final static native String Mtc_CliDbGetSsoServAddr();
  public final static native int Mtc_CliDbSetSsoServAddr(String jarg1);
  public final static native String Mtc_CliDbGetSsoServAddrType();
  public final static native int Mtc_CliDbSetSsoServAddrType(String jarg1);
  public final static native String Mtc_CliDbGetEcscmsServAddr();
  public final static native int Mtc_CliDbSetEcscmsServAddr(String jarg1);
  public final static native String Mtc_CliDbGetEcscmsServAddrType();
  public final static native int Mtc_CliDbSetEcscmsServAddrType(String jarg1);
  public final static native String Mtc_CliDbGetEcscmsNumberPrefixes();
  public final static native int Mtc_CliDbSetEcscmsNumberPrefixes(String jarg1);
  public final static native String Mtc_CliDbGetUserMangerServAddr();
  public final static native int Mtc_CliDbSetUserMangerServAddr(String jarg1);
  public final static native String Mtc_CliDbGetUserMangerServAddrType();
  public final static native int Mtc_CliDbSetUserMangerServAddrType(String jarg1);
  public final static native String Mtc_CliDbGetIapServAddr();
  public final static native int Mtc_CliDbSetIapServAddr(String jarg1);
  public final static native String Mtc_CliDbGetIapServAddrType();
  public final static native int Mtc_CliDbSetIapServAddrType(String jarg1);
  public final static native boolean Mtc_CliDbGetProfileAuth();
  public final static native int Mtc_CliDbSetProfileAuth(boolean jarg1);
  public final static native boolean Mtc_CliDbGetNabAuth();
  public final static native int Mtc_CliDbSetNabAuth(boolean jarg1);
  public final static native boolean Mtc_CliDbGetPaAuth();
  public final static native int Mtc_CliDbSetPaAuth(boolean jarg1);
  public final static native boolean Mtc_CliDbGetSsoAuth();
  public final static native int Mtc_CliDbSetSsoAuth(boolean jarg1);
  public final static native boolean Mtc_CliDbGetEcscmsAuth();
  public final static native int Mtc_CliDbSetEcscmsAuth(boolean jarg1);
  public final static native boolean Mtc_CliDbGetUserMangerAuth();
  public final static native int Mtc_CliDbSetUserMangerAuth(boolean jarg1);
  public final static native boolean Mtc_CliDbGetIapAuth();
  public final static native int Mtc_CliDbSetIapAuth(boolean jarg1);
  public final static native int Mtc_CliDbGetStgUseType();
  public final static native int Mtc_CliDbSetStgUseType(int jarg1);
  public final static native int Mtc_CliDbGetStgTunnelType();
  public final static native int Mtc_CliDbSetStgTunnelType(int jarg1);
  public final static native String Mtc_CliDbGetStgTunnelIp();
  public final static native int Mtc_CliDbSetStgTunnelIp(String jarg1);
  public final static native int Mtc_CliDbGetStgTunnelPort();
  public final static native int Mtc_CliDbSetStgTunnelPort(int jarg1);
  public final static native boolean Mtc_CliDbGetStgTunnelProxyEnable();
  public final static native int Mtc_CliDbSetStgTunnelProxyEnable(boolean jarg1);
  public final static native String Mtc_CliDbGetStgTunnelProxySrvAddr();
  public final static native int Mtc_CliDbSetStgTunnelProxySrvAddr(String jarg1);
  public final static native short Mtc_CliDbGetStgTunnelProxySrvPort();
  public final static native int Mtc_CliDbSetStgTunnelProxySrvPort(int jarg1);
  public final static native String Mtc_CliDbGetStgTunnelProxySrvUsername();
  public final static native int Mtc_CliDbSetStgTunnelProxySrvUsername(String jarg1);
  public final static native String Mtc_CliDbGetStgTunnelProxySrvPwd();
  public final static native int Mtc_CliDbSetStgTunnelProxySrvPwd(String jarg1);
  public final static native boolean Mtc_CliDbGetUseBackupServer();
  public final static native int Mtc_CliDbSetUseBackupServer(boolean jarg1);
  public final static native String Mtc_CliDbGetBsfServAddr();
  public final static native int Mtc_CliDbSetBsfServAddr(String jarg1);
  public final static native String Mtc_CliDbGetBsfServAddrType();
  public final static native int Mtc_CliDbSetBsfServAddrType(String jarg1);
  public final static native int Mtc_CliDbGetBsfServPort();
  public final static native int Mtc_CliDbSetBsfServPort(int jarg1);
  public final static native String Mtc_CliDbGetBsfRealm();
  public final static native int Mtc_CliDbSetBsfRealm(String jarg1);
  public final static native String Mtc_CliDbGetDevToken();
  public final static native String Mtc_CliDbGetVoipToken();
  public final static native String Mtc_CliDbGetTokenType();
  public final static native int Mtc_CliDbSetPushToken(String jarg1, String jarg2, String jarg3);
  public final static native boolean Mtc_CliDbGetCalibrateTime();
  public final static native int Mtc_CliDbSetCalibrateTime(boolean jarg1);
  public final static native int Mtc_CliDbSetUserIdPolicy(int jarg1);
  public final static native int Mtc_CliDbSetImpi(String jarg1);
  public final static native String Mtc_CliDbGetImpi();
  public final static native int Mtc_CliDbGetRegAddrType();
  public final static native int Mtc_CliDbSetRegAddrType(int jarg1);
  public final static native int Mtc_CliDbGet2ndRegAddrType();
  public final static native int Mtc_CliDbSet2ndRegAddrType(int jarg1);
  public final static native String Mtc_CliDbGetCnpcHttpServAddr();
  public final static native int Mtc_CliDbSetCnpcHttpServAddr(String jarg1);
  public final static native int Mtc_CliDbGetCnpcHttpServPort();
  public final static native int Mtc_CliDbSetCnpcHttpServPort(int jarg1);
  public final static native String Mtc_CliDbGetCnpcSyncServRoot();
  public final static native int Mtc_CliDbSetCnpcSyncServRoot(String jarg1);
  public final static native String Mtc_CliDbGetCnpcVerifyServRoot();
  public final static native int Mtc_CliDbSetCnpcVerifyServRoot(String jarg1);
  public final static native boolean Mtc_CliDbGetDeactedEnable();
  public final static native int Mtc_CliDbSetDeactedEnable(boolean jarg1);
  public final static native String Mtc_CliDbGetAccNetInfoCountry();
  public final static native int Mtc_CliDbSetAccNetInfoCountry(String jarg1);
  public final static native String Mtc_CliDbGetAccNetInfoCity();
  public final static native int Mtc_CliDbSetAccNetInfoCity(String jarg1);
  public final static native String Mtc_CliDbGetSSOWhiteAddr(int jarg1);
  public final static native int Mtc_CliDbSetSSOWhiteAddr(String jarg1, int jarg2);
  public final static native String Mtc_CliDbGetSSOWhiteAddrType(int jarg1);
  public final static native int Mtc_CliDbSetSSOWhiteAddrType(String jarg1, int jarg2);
  public final static native int Mtc_CliDbGetSSOWhiteAddrLstSize();
  public final static native int Mtc_CliDbSetSSOWhiteAddrLstSize(int jarg1);
  public final static native boolean Mtc_CliDbGetAutoRegEnable();
  public final static native int Mtc_CliDbSetAutoRegEnable(boolean jarg1);
  public final static native String Mtc_CliDbGetIMEI();
  public final static native int Mtc_CliDbSetIMEI(String jarg1);
  public final static native String Mtc_CliDbGetCellId();
  public final static native int Mtc_CliDbSetCellId(String jarg1);
  public final static native String Mtc_CliDbGetCompany();
  public final static native int Mtc_CliDbSetCompany(String jarg1);
  public final static native int Mtc_CliDbGetRegTmr1();
  public final static native int Mtc_CliDbSetRegTmr1(int jarg1);
  public final static native int Mtc_CliDbGetRegTmr2();
  public final static native int Mtc_CliDbSetRegTmr2(int jarg1);
  public final static native boolean Mtc_CliDbGetRegUseLclIp();
  public final static native int Mtc_CliDbSetRegUseLclIp(boolean jarg1);
  public final static native int Mtc_CliDbGetHttpProxyType();
  public final static native int Mtc_CliDbSetHttpProxyType(int jarg1);
  public final static native String Mtc_CliDbGetHttpProxySrvAddr();
  public final static native int Mtc_CliDbSetHttpProxySrvAddr(String jarg1);
  public final static native short Mtc_CliDbGetHttpProxySrvPort();
  public final static native int Mtc_CliDbSetHttpProxySrvPort(int jarg1);
  public final static native String Mtc_CliDbGetGrpHttpServAddr();
  public final static native int Mtc_CliDbSetGrpHttpServAddr(String jarg1);
  public final static native int Mtc_CliDbGetGrpHttpServPort();
  public final static native int Mtc_CliDbSetGrpHttpServPort(int jarg1);
  public final static native String Mtc_CliDbGetGrpHttpAuthName();
  public final static native int Mtc_CliDbSetGrpHttpAuthName(String jarg1);
  public final static native boolean Mtc_CliDbGetUseDmPwd();
  public final static native int Mtc_CliDbSetUseDmPwd(boolean jarg1);
  public final static native int Mtc_CliDbGetMinHeartbeatTime();
  public final static native int Mtc_CliDbSetMinHeartbeatTime(int jarg1);
  public final static native int Mtc_CliDbGetWifiMinHeartbeatTime();
  public final static native int Mtc_CliDbSetWifiMinHeartbeatTime(int jarg1);
  public final static native int Mtc_CliDbGetMaxHeartbeatTime();
  public final static native int Mtc_CliDbSetMaxHeartbeatTime(int jarg1);
  public final static native int Mtc_CliDbGetWifiMaxHeartbeatTime();
  public final static native int Mtc_CliDbSetWifiMaxHeartbeatTime(int jarg1);
  public final static native int Mtc_CliDbGetHeartbeatStepLen();
  public final static native int Mtc_CliDbSetHeartbeatStepLen(int jarg1);
}
