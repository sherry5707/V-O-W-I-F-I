/**
 * @file MtcCpConstants.java
 * @brief MtcCpConstants constants
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
 * @brief MtcCpConstants constants
 */
public interface MtcCpConstants {
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
  public final static int MTC_CP_STAT_ERR_NO = (0xE000+0); /**< @brief no error */
  public final static int MTC_CP_STAT_ERR_TIMEOUT = (0xE000+1); /**< @brief connect timeout */
  public final static int MTC_CP_STAT_ERR_NETWORK = (0xE000+2); /**< @brief network error */
  public final static int MTC_CP_STAT_ERR_FORBIDDEN = (0xE000+3); /**< @brief request forbidden */
  public final static int MTC_CP_STAT_ERR_INTERNAL_ERR = (0xE000+4); /**< @brief server internal error. */
  public final static int MTC_CP_STAT_ERR_INCORRET_XML = (0xE000+5); /**< @brief incorret configuration xml. */
  public final static int MTC_CP_STAT_ERR_DISABLED_TEMP = (0xE000+6); /**< @brief service disabled temporarily. */
  public final static int MTC_CP_STAT_ERR_DISABLED_PERM = (0xE000+7); /**< @brief service disabled permanently. */
  public final static int MTC_CP_STAT_ERR_DECLINE = (0xE000+8); /**< @brief user decline */
  public final static int MTC_CP_STAT_ERR_INVALID_OTP = (0xE000+9); /**< @brief invalid otp */
  public final static int MTC_CP_STAT_ERR_INVALID_TOKEN = (0xE000+10); /**< @brief invalid token */
  public final static int MTC_CP_STAT_ERR_INVALID_NUMBER = (0xE000+11); /**< @brief invalid number */
  public final static int MTC_CP_STAT_ERR_RETRY_AFTER = (0xE000+12); /**< @brief retry after */
  public final static int MTC_CP_STAT_ERR_BOSS_ERROR = (0xE000+13); /**< @brief BOSS error */
  public final static int MTC_CP_STAT_ERR_NO_WHITE_USER = (0xE000+14); /**< @brief no white user */
  public final static int MTC_CP_STAT_ERR_BOSS_TIMEOUT = (0xE000+15); /**< @brief BOSS timeout */
  public final static int MTC_CP_STAT_ERR_PROMPT_TIMEOUT = (0xE000+16); /**< @brief prompt timeout */
  public final static int MTC_CP_STAT_ERR_HAS_BODY = (0xE000+17); /**< @brief first HTTP_RSP_200_OK has body */
  public final static int MTC_CP_STAT_ERR_OTHER = (0xE000+200); /**< @brief other error */
  // EN_MTC_CP_ACT_TYPE 
  public final static int EN_MTC_CP_ACT_ACPT = 0; /**< @brief Client provisioning accept action */
  public final static int EN_MTC_CP_ACT_DECL = EN_MTC_CP_ACT_ACPT + 1; /**< @brief Client provisioning decline action */

  // EN_MTC_CP_NET_TYPE 
  public final static int EN_MTC_CP_NET_UNKNOWN = 0; /**< @brief unknown network */
  public final static int EN_MTC_CP_NET_PS = EN_MTC_CP_NET_UNKNOWN + 1; /**< @brief PS network */
  public final static int EN_MTC_CP_NET_WIFI = EN_MTC_CP_NET_PS + 1; /**< @brief WIFI network */

  // EN_MTC_CP_EXPIRE_TYPE 
  public final static int EN_MTC_CP_EXPIRE_VER = 0; /**< @brief version expire */
  public final static int EN_MTC_CP_EXPIRE_TOKEN = EN_MTC_CP_EXPIRE_VER + 1; /**< @brief token expire */

}
