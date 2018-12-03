/**
 * @file MtcImLargeConstants.java
 * @brief MtcImLargeConstants constants
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
 * @brief MtcImLargeConstants constants
 */
public interface MtcImLargeConstants {
  public final static int MTC_IM_LMSG_IMDN_NO = 0x00000000; /**< @brief no notification request, regular message */
  public final static int MTC_IM_LMSG_IMDN_UNKNOWN = 0x00000001; /**< @brief unknown imdn type */
  public final static int MTC_IM_LMSG_IMDN_DELI_SUCC = 0x00000002; /**< @brief message with delivery succeed notification request */
  public final static int MTC_IM_LMSG_IMDN_DELI_FAIL = 0x00000004; /**< @brief message with delivery fail notification request */
  public final static int MTC_IM_LMSG_IMDN_DELI_FWD = 0x00000008; /**< @brief message with delivery forward notification request */
  public final static int MTC_IM_LMSG_IMDN_DISP = 0x00000010; /**< @brief message with display notification request */
  public final static int MTC_IM_LMSG_IMDN_BURN = 0x00000020; /**< @brief message with burn after reading notification request */
  // EN_MTC_IM_LMSG_CONT_TYPE 
  public final static int EN_MTC_IM_LMSG_CONT_UNKNOWN = 0; /**< @brief unknown content */
  public final static int EN_MTC_IM_LMSG_CONT_TXT_PLAIN = EN_MTC_IM_LMSG_CONT_UNKNOWN + 1; /**< @brief text/plain content */
  public final static int EN_MTC_IM_LMSG_CONT_XML = EN_MTC_IM_LMSG_CONT_TXT_PLAIN + 1; /**< @brief "message/xml" content */
  public final static int EN_MTC_IM_LMSG_CONT_OMAPUSH = EN_MTC_IM_LMSG_CONT_XML + 1; /**< @brief "application/vnd.oma.push" content */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_TXT_PLAIN = EN_MTC_IM_LMSG_CONT_OMAPUSH + 1; /**< @brief content type of "text/plain" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_IMAGE_JPEG = EN_MTC_IM_LMSG_CONT_MSG_TXT_PLAIN + 1; /**< @brief content type of "image/jpeg" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_IMAGE_BMP = EN_MTC_IM_LMSG_CONT_MSG_IMAGE_JPEG + 1; /**< @brief content type of "image/bmp" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_IMDN = EN_MTC_IM_LMSG_CONT_MSG_IMAGE_BMP + 1; /**< @brief content type of "message/imdn+xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_XML = EN_MTC_IM_LMSG_CONT_MSG_IMDN + 1; /**< @brief content type of "message/xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_VEMOTICON = EN_MTC_IM_LMSG_CONT_MSG_XML + 1; /**< @brief content type of "message/vemoticon+xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_CLOUD_FILE = EN_MTC_IM_LMSG_CONT_MSG_VEMOTICON + 1; /**< @brief content type of "message/cloudfile+xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_CMRED_BAG = EN_MTC_IM_LMSG_CONT_MSG_CLOUD_FILE + 1; /**< @brief content type of "message/cmredbag+xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_CARD = EN_MTC_IM_LMSG_CONT_MSG_CMRED_BAG + 1; /**< @brief content type of "message/card+xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_139MAIL_NEW = EN_MTC_IM_LMSG_CONT_MSG_CARD + 1; /**< @brief content type of "application/commonextension+xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_TXT_SMS = EN_MTC_IM_LMSG_CONT_MSG_139MAIL_NEW + 1; /**< @brief content type of "text/sms" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_COM_TEMP = EN_MTC_IM_LMSG_CONT_MSG_TXT_SMS + 1; /**< @brief content type of "application/commontemplate+xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_CHRED_BAG = EN_MTC_IM_LMSG_CONT_MSG_COM_TEMP + 1; /**< @brief content type of "message/cmredbag+xml" wrapt by cpim */
  public final static int EN_MTC_IM_LMSG_CONT_MSG_REVOKE = EN_MTC_IM_LMSG_CONT_MSG_CHRED_BAG + 1; /**< @brief content type of "application/vnd.gsma.rcsrevoke+xml" wrapt by cpim */

  // EN_MTC_IM_LMSG_SPAM_TYPE 
  public final static int EN_MTC_IM_LMSG_SPAM_MIN = 0;
  public final static int EN_MTC_IM_LMSG_SPAM_POLITICAL_RUMOR = EN_MTC_IM_LMSG_SPAM_MIN + 1; /**< @brief political rumor msg */
  public final static int EN_MTC_IM_LMSG_SPAM_JURISPRUDENCE = EN_MTC_IM_LMSG_SPAM_POLITICAL_RUMOR + 1; /**< @brief jurisprudence msg */
  public final static int EN_MTC_IM_LMSG_SPAM_FRAUD = EN_MTC_IM_LMSG_SPAM_JURISPRUDENCE + 1; /**< @brief fraud msg */
  public final static int EN_MTC_IM_LMSG_SPAM_MALICIOUS_MARKETING = EN_MTC_IM_LMSG_SPAM_FRAUD + 1; /**< @brief malicious marketing msg */
  public final static int EN_MTC_IM_LMSG_SPAM_VIOLENCE = EN_MTC_IM_LMSG_SPAM_MALICIOUS_MARKETING + 1; /**< @brief violence msg */
  public final static int EN_MTC_IM_LMSG_SPAM_OTHER = 9; /**< @brief other msg */
  public final static int EN_MTC_IM_LMSG_SPAM_MAX = EN_MTC_IM_LMSG_SPAM_OTHER + 1;

}
