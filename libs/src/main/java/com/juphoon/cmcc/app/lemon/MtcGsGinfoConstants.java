/**
 * @file MtcGsGinfoConstants.java
 * @brief MtcGsGinfoConstants constants
 */
/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.juphoon.cmcc.app.lemon;

/**
 * @brief MtcGsGinfoConstants constants
 */
public interface MtcGsGinfoConstants {
  public final static int MTC_EBASE_CP = 0xE000; /**< @brief CP error base */
  public final static int MTC_EBASE_REG = 0xE100; /**< @brief REG error base */
  public final static int MTC_EBASE_CALL = 0xE200; /**< @brief CALL error base */
  public final static int MTC_EBASE_VSHARE = 0xE300; /**< @brief VSHARE error base */
  public final static int MTC_EBASE_CAP = 0xE400; /**< @brief CAP error base */
  public final static int MTC_EBASE_BUDDY = 0xE500; /**< @brief BUDDY error base */
  public final static int MTC_EBASE_GRP = 0xE600; /**< @brief GRP error base */
  public final static int MTC_EBASE_CONF = 0xE700; /**< @brief CONF error base */
  public final static int MTC_EBASE_GS = 0xE800; /**< @brief GS error base */
  public final static int MTC_EBASE_PRES = 0xE900; /**< @brief PRES error base */
  public final static int MTC_EBASE_IM = 0xEA00; /**< @brief IM error base */
  public final static int MTC_EBASE_LCS = 0xEB00; /**< @brief LCS error base */
  public final static int MTC_EBASE_PA = 0xEC00; /**< @brief PA error base */
  public final static int MTC_EBASE_CPROF = 0xED00; /**< @brief CRPOF error base */
  public final static int MTC_EBASE_GBA = 0xEE00; /**< @brief GBA error base */
  public final static int MTC_GS_ERR_NO = (0xE800+0); /**< @brief no error. */
  public final static int MTC_GS_ERR_FORBIDDEN = (0xE800+1); /**< @brief gs forbidden. */
  public final static int MTC_GS_ERR_NOT_FOUND = (0xE800+2); /**< @brief gs participant not found. */
  public final static int MTC_GS_ERR_NOT_ACPTED = (0xE800+3); /**< @brief gs not accepted. */
  public final static int MTC_GS_ERR_TEMP_UNAVAIL = (0xE800+4); /**< @brief gs participant temp unavailable. */
  public final static int MTC_GS_ERR_REQ_TERMED = (0xE800+5); /**< @brief gs request terminated. */
  public final static int MTC_GS_ERR_INTERNAL_ERR = (0xE800+6); /**< @brief server internal error. */
  public final static int MTC_GS_ERR_SRV_UNAVAIL = (0xE800+7); /**< @brief service unavailable. */
  public final static int MTC_GS_ERR_TIMEOUT = (0xE800+8); /**< @brief request timeout. */
  public final static int MTC_GS_ERR_OFFLINE = (0xE800+9); /**< @brief callee not registered. */
  public final static int MTC_GS_ERR_SURPASS_TRAFFIC = (0xE800+10); /**< @brief surpass traffic */
  public final static int MTC_GS_ERR_EMERGENCY_FORBIDDEN = (0xE800+11); /**< @brief emergency forbidden */
  public final static int MTC_GS_ERR_FILE_EXPIRED = (0xE800+12); /**< @brief file expired */
  public final static int MTC_GS_ERR_SEND_TIMEOUT = (0xE800+13); /**< @brief file expired */
  public final static int MTC_GS_ERR_OTHER = (0xE800+14); /**< @brief other error. */
  public final static int MTC_GS_GINFO_IMDN_NO = 0x00000000; /**< @brief no notification request, regular location */
  public final static int MTC_GS_GINFO_IMDN_UNKNOWN = 0x00000001; /**< @brief unknown imdn type */
  public final static int MTC_GS_GINFO_IMDN_DELI_SUCC = 0x00000002; /**< @brief location with delivery succeed notification request */
  public final static int MTC_GS_GINFO_IMDN_DELI_FAIL = 0x00000004; /**< @brief location with delivery fail notification request */
  public final static int MTC_GS_GINFO_IMDN_DELI_FWD = 0x00000008; /**< @brief location with delivery forward notification request */
  public final static int MTC_GS_GINFO_IMDN_DISP = 0x00000010; /**< @brief location with display notification request */
  // EN_MTC_GS_GINFO_TYPE 
  public final static int EN_MTC_GS_GINFO_UNKNOWN = 0; /**< @brief unknown. */
  public final static int EN_MTC_GS_GINFO_FREE_TEXT = 1; /**< @brief free text. */
  public final static int EN_MTC_GS_GINFO_2D_CIRCLE = 2; /**< @brief 2d circle. */
  public final static int EN_MTC_GS_GINFO_BOTH = 3; /**< @brief both. */

  // EN_MTC_GS_GINFO_SPAM_TYPE 
  public final static int EN_MTC_GS_GINFO_SPAM_MIN = 0;
  public final static int EN_MTC_GS_GINFO_SPAM_POLITICAL_RUMOR = EN_MTC_GS_GINFO_SPAM_MIN + 1; /**< @brief political rumor msg */
  public final static int EN_MTC_GS_GINFO_SPAM_JURISPRUDENCE = EN_MTC_GS_GINFO_SPAM_POLITICAL_RUMOR + 1; /**< @brief jurisprudence msg */
  public final static int EN_MTC_GS_GINFO_SPAM_FRAUD = EN_MTC_GS_GINFO_SPAM_JURISPRUDENCE + 1; /**< @brief fraud msg */
  public final static int EN_MTC_GS_GINFO_SPAM_MALICIOUS_MARKETING = EN_MTC_GS_GINFO_SPAM_FRAUD + 1; /**< @brief malicious marketing msg */
  public final static int EN_MTC_GS_GINFO_SPAM_VIOLENCE = EN_MTC_GS_GINFO_SPAM_MALICIOUS_MARKETING + 1; /**< @brief violence msg */
  public final static int EN_MTC_GS_GINFO_SPAM_OTHER = 9; /**< @brief other msg */
  public final static int EN_MTC_GS_GINFO_SPAM_MAX = EN_MTC_GS_GINFO_SPAM_OTHER + 1;

}
