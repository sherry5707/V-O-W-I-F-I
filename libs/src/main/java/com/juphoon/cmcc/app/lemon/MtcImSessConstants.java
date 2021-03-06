/**
 * @file MtcImSessConstants.java
 * @brief MtcImSessConstants constants
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
 * @brief MtcImSessConstants constants
 */
public interface MtcImSessConstants {
  public final static int MTC_IM_SESS_AT_ALL_MEMBER = (0xFFFFFFFF-1); /**< @brief  Indicate at all member in the group chat */
  public final static int MTC_IM_SESS_IMDN_NO = 0x00000000; /**< @brief no notification request, regular message */
  public final static int MTC_IM_SESS_IMDN_UNKNOWN = 0x00000001; /**< @brief unknown type */
  public final static int MTC_IM_SESS_IMDN_DELI_SUCC = 0x00000002; /**< @brief delivery succeed notification request */
  public final static int MTC_IM_SESS_IMDN_DELI_FAIL = 0x00000004; /**< @brief delivery succeed fail request */
  public final static int MTC_IM_SESS_IMDN_DELI_FWD = 0x00000008; /**< @brief delivery succeed forward request */
  public final static int MTC_IM_SESS_IMDN_DISP = 0x00000010; /**< @brief display notification request */
  // EN_MTC_IM_SESS_AT_TYPE 
  public final static int EN_MTC_IM_SESS_AT_PARTIAL = 0; /**< @brief user @ some members  in the group */
  public final static int EN_MTC_IM_SESS_AT_ALL = EN_MTC_IM_SESS_AT_PARTIAL + 1; /**< @brief user @ all members in the group */
  public final static int EN_MTC_IM_SESS_AT_NONE = EN_MTC_IM_SESS_AT_ALL + 1; /**< @brief user @ no body in the group */

  // EN_MTC_IM_SESS_TYPE 
  public final static int EN_MTC_IM_SESS_ONLINE_CREATE = 0; /**< @brief online create invitation */
  public final static int EN_MTC_IM_SESS_ONLINE_MSG = EN_MTC_IM_SESS_ONLINE_CREATE + 1; /**< @brief online message invitation */
  public final static int EN_MTC_IM_SESS_OFFLINE_CREATE = EN_MTC_IM_SESS_ONLINE_MSG + 1; /**< @brief offline create invitation */
  public final static int EN_MTC_IM_SESS_OFFLINE_MSG = EN_MTC_IM_SESS_OFFLINE_CREATE + 1; /**< @brief offline message invitation */

  // EN_MTC_IM_SESS_STAT_TYPE 
  public final static int EN_MTC_IM_SESS_STAT_UNKNOWN = 0; /**< @brief unknown state*/
  public final static int EN_MTC_IM_SESS_STAT_IDLE = EN_MTC_IM_SESS_STAT_UNKNOWN + 1; /**< @brief idle state*/
  public final static int EN_MTC_IM_SESS_STAT_PENDING = EN_MTC_IM_SESS_STAT_IDLE + 1; /**< @brief pending state */
  public final static int EN_MTC_IM_SESS_STAT_ACTIVE = EN_MTC_IM_SESS_STAT_PENDING + 1; /**< @brief active state */
  public final static int EN_MTC_IM_SESS_STAT_INACTIVE = EN_MTC_IM_SESS_STAT_ACTIVE + 1; /**< @brief inactive state */

  // EN_MTC_IM_SESS_CONT_TYPE 
  public final static int EN_MTC_IM_SESS_CONT_UNKNOWN = 0; /**< @brief unknown content */
  public final static int EN_MTC_IM_SESS_CONT_TXT_PLAIN = EN_MTC_IM_SESS_CONT_UNKNOWN + 1; /**< @brief text/plain content */
  public final static int EN_MTC_IM_SESS_CONT_LOCATION = EN_MTC_IM_SESS_CONT_TXT_PLAIN + 1; /**< @brief application/vnd.gsma.rcspushlocation+xml content */
  public final static int EN_MTC_IM_SESS_CONT_MSG_TXT_PLAIN = EN_MTC_IM_SESS_CONT_LOCATION + 1; /**< @brief content type of "text/plain" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_IMAGE_JPEG = EN_MTC_IM_SESS_CONT_MSG_TXT_PLAIN + 1; /**< @brief content type of "image/jpeg" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_IMAGE_BMP = EN_MTC_IM_SESS_CONT_MSG_IMAGE_JPEG + 1; /**< @brief content type of "image/bmp" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_IMDN = EN_MTC_IM_SESS_CONT_MSG_IMAGE_BMP + 1; /**< @brief content type of "message/imdn+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_FTHTTP = EN_MTC_IM_SESS_CONT_MSG_IMDN + 1; /**< @brief content type of "application/vnd.gsma.rcs-ft-http+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_LOCATION = EN_MTC_IM_SESS_CONT_MSG_FTHTTP + 1; /**< @brief content type of "application/vnd.gsma.rcspushlocation+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_VEMOTICON = EN_MTC_IM_SESS_CONT_MSG_LOCATION + 1; /**< @brief content type of "application/vemoticon+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_CLOUD_FILE = EN_MTC_IM_SESS_CONT_MSG_VEMOTICON + 1; /**< @brief content type of "application/cloudfile+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_CMRED_BAG = EN_MTC_IM_SESS_CONT_MSG_CLOUD_FILE + 1; /**< @brief content type of "application/cmredbag+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_CARD = EN_MTC_IM_SESS_CONT_MSG_CMRED_BAG + 1; /**< @brief content type of "application/card+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_COM_TEMP = EN_MTC_IM_SESS_CONT_MSG_CARD + 1; /**< @brief content type of "application/commontemplate+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_CHRED_BAG = EN_MTC_IM_SESS_CONT_MSG_COM_TEMP + 1; /**< @brief content type of "application/chredbag+xml" wrapt by cpim */
  public final static int EN_MTC_IM_SESS_CONT_MSG_REVOKE = EN_MTC_IM_SESS_CONT_MSG_CHRED_BAG + 1; /**< @brief content type of "application/vnd.gsma.rcsrevoke+xml" wrapt by cpim */

  // EN_MTC_IM_SESS_REJECT_REASON_TYPE 
  public final static int EN_MTC_IM_SESS_REJECT_REASON_BUSY = 0; /**< @brief busy response */
  public final static int EN_MTC_IM_SESS_REJECT_REASON_DECLINE = EN_MTC_IM_SESS_REJECT_REASON_BUSY + 1; /**< @brief decline the session */

  // EN_MTC_IM_SESS_GRP_TYPE 
  public final static int EN_MTC_IM_SESS_GRP_TYPE_ALL = 0; /**< @brief all groups */
  public final static int EN_MTC_IM_SESS_GRP_TYPE_GENERAL = EN_MTC_IM_SESS_GRP_TYPE_ALL + 1; /**< @brief general group */
  public final static int EN_MTC_IM_SESS_GRP_TYPE_ENTERPRISE = EN_MTC_IM_SESS_GRP_TYPE_GENERAL + 1; /**< @brief enterprise group */
  public final static int EN_MTC_IM_SESS_GRP_TYPE_PARTY = EN_MTC_IM_SESS_GRP_TYPE_ENTERPRISE + 1; /**< @brief party group */
  public final static int EN_MTC_IM_SESS_GRP_TYPE_END = EN_MTC_IM_SESS_GRP_TYPE_PARTY + 1;

}
