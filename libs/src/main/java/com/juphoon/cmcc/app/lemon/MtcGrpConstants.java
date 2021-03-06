/**
 * @file MtcGrpConstants.java
 * @brief MtcGrpConstants constants
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
 * @brief MtcGrpConstants constants
 */
public interface MtcGrpConstants {
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
  public final static int MTC_GRP_ERR_NO = (0xE600+0); /**< @brief no error */
  public final static int MTC_GRP_ERR_AUTH_FAILED = (0xE600+1); /**< @brief authentication failed, invalid user or password */
  public final static int MTC_GRP_ERR_CONN_FAILED = (0xE600+2); /**< @brief transport connect failed */
  public final static int MTC_GRP_ERR_SEND_FAILED = (0xE600+3); /**< @brief transport send failed */
  public final static int MTC_GRP_ERR_SERV_DISCED = (0xE600+4); /**< @brief transport disconnected by server */
  public final static int MTC_GRP_ERR_SERV_ERR = (0xE600+5); /**< @brief server internal error */
  public final static int MTC_GRP_ERR_REQ_TIMEOUT = (0xE600+6); /**< @brief request timeout */
  public final static int MTC_GRP_ERR_BAD_XML_MSG = (0xE600+7); /**< @brief bad xml message */
  public final static int MTC_GRP_ERR_REPEATED = (0xE600+8); /**< @brief element repeated */
  public final static int MTC_GRP_ERR_NOT_FOUND = (0xE600+9); /**< @brief not found */
  public final static int MTC_GRP_ERR_OTHER = (0xE600+10); /**< @brief other error */
}
