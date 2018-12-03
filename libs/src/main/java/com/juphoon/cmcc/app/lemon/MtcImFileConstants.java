/**
 * @file MtcImFileConstants.java
 * @brief MtcImFileConstants constants
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
 * @brief MtcImFileConstants constants
 */
public interface MtcImFileConstants {
  public final static String MTC_IM_FILE_CONT_TXT_PLAIN = "text/plain"; /**< @brief text/plain content */
  public final static String MTC_IM_FILE_CONT_TXT_HTML = "text/html"; /**< @brief text/html content */
  public final static String MTC_IM_FILE_CONT_TXT_VCARD = "text/x-vcard"; /**< @brief text/x-vcard content */
  public final static String MTC_IM_FILE_CONT_IMG_JPEG = "image/jpeg"; /**< @brief image/jpeg content */
  public final static String MTC_IM_FILE_CONT_IMG_GIF = "image/gif"; /**< @brief image/gif content */
  public final static String MTC_IM_FILE_CONT_IMG_PNG = "image/png"; /**< @brief image/png content */
  public final static String MTC_IM_FILE_CONT_IMG_BMP = "image/bmp"; /**< @brief image/bmp content */
  public final static String MTC_IM_FILE_CONT_IMG_MSBMP = "image/x-ms-bmp"; /**< @brief image/x-ms-bmp content */
  public final static String MTC_IM_FILE_CONT_IMG_WBMP = "image/vnd.wap.wbmp"; /**< @brief image/vnd.wap.wbmp content */
  public final static String MTC_IM_FILE_CONT_IMG_WEBP = "image/webp"; /**< @brief image/webp content */
  public final static String MTC_IM_FILE_CONT_AUDIO_MP3 = "audio/mpeg"; /**< @brief audio/mpeg content */
  public final static String MTC_IM_FILE_CONT_AUDIO_M4A = "audio/mp4"; /**< @brief audio/mp4 content */
  public final static String MTC_IM_FILE_CONT_AUDIO_WAV = "audio/x-wav"; /**< @brief audio/x-wav content */
  public final static String MTC_IM_FILE_CONT_AUDIO_AMR = "audio/amr"; /**< @brief audio/amr content */
  public final static String MTC_IM_FILE_CONT_AUDIO_AWB = "audio/amr-wb"; /**< @brief audio/amr-wb content */
  public final static String MTC_IM_FILE_CONT_AUDIO_WMA = "audio/x-ms-wma"; /**< @brief audio/x-ms-wma content */
  public final static String MTC_IM_FILE_CONT_AUDIO_3GP = "audio/3gpp"; /**< @brief audio/3gpp content */
  public final static String MTC_IM_FILE_CONT_AUDIO_OGG = "audio/ogg"; /**< @brief audio/ogg content */
  public final static String MTC_IM_FILE_CONT_AUDIO_AAC = "audio/aac"; /**< @brief audio/aac content */
  public final static String MTC_IM_FILE_CONT_AUDIO_ADTS = "audio/aac-adts"; /**< @brief audio/aac-adts content */
  public final static String MTC_IM_FILE_CONT_AUDIO_MKA = "audio/x-matroska"; /**< @brief audio/x-matroska content */
  public final static String MTC_IM_FILE_CONT_AUDIO_MID = "audio/midi"; /**< @brief audio/midi content */
  public final static String MTC_IM_FILE_CONT_AUDIO_SMF = "audio/sp-midi"; /**< @brief audio/sp-midi content */
  public final static String MTC_IM_FILE_CONT_AUDIO_IMY = "audio/imelody"; /**< @brief audio/imelody content */
  public final static String MTC_IM_FILE_CONT_AUDIO_M3U = "audio/x-mpegurl"; /**< @brief audio/x-mpegurl content */
  public final static String MTC_IM_FILE_CONT_AUDIO_XM3U = "audio/mpegurl"; /**< @brief audio/mpegurl content */
  public final static String MTC_IM_FILE_CONT_AUDIO_PLS = "audio/x-scpls"; /**< @brief audio/x-scpls content */
  public final static String MTC_IM_FILE_CONT_VIDEO_MPG = "video/mpeg"; /**< @brief video/mpeg content */
  public final static String MTC_IM_FILE_CONT_VIDEO_MP4 = "video/mp4"; /**< @brief video/mp4 content */
  public final static String MTC_IM_FILE_CONT_VIDEO_3GP = "video/3gpp"; /**< @brief video/3gpp content */
  public final static String MTC_IM_FILE_CONT_VIDEO_3G2 = "video/3gpp2"; /**< @brief video/3gpp2 content */
  public final static String MTC_IM_FILE_CONT_VIDEO_MKV = "video/x-matroska"; /**< @brief video/x-matroska content */
  public final static String MTC_IM_FILE_CONT_VIDEO_WEBM = "video/webm"; /**< @brief video/webm content */
  public final static String MTC_IM_FILE_CONT_VIDEO_MP2TS = "video/mp2ts"; /**< @brief video/mp2ts content */
  public final static String MTC_IM_FILE_CONT_VIDEO_AVI = "video/avi"; /**< @brief video/avi content */
  public final static String MTC_IM_FILE_CONT_VIDEO_WMV = "video/x-ms-wmv"; /**< @brief video/x-ms-wmv content */
  public final static String MTC_IM_FILE_CONT_VIDEO_ASF = "video/x-ms-asf"; /**< @brief video/x-ms-asf content */
  public final static String MTC_IM_FILE_CONT_VIDEO_MP2PS = "video/mp2p"; /**< @brief video/mp2p content */
  public final static String MTC_IM_FILE_CONT_APP_OSTRM = "application/octet-stream"; /**< @brief application/octet-stream content */
  public final static int MTC_IM_FILE_IMDN_REG = 0x00000000; /**< @brief no notification request, regular file transfer */
  public final static int MTC_IM_FILE_IMDN_UNKNOWN = 0x00000001; /**< @brief unknown imdn type */
  public final static int MTC_IM_FILE_IMDN_DELI_SUCC = 0x00000002; /**< @brief file transfer with delivery succeed notification request */
  public final static int MTC_IM_FILE_IMDN_DELI_FAIL = 0x00000004; /**< @brief file transfer with delivery fail notification request */
  public final static int MTC_IM_FILE_IMDN_DELI_FWD = 0x00000008; /**< @brief file transfer with delivery forward notification request */
  public final static int MTC_IM_FILE_IMDN_DISP = 0x00000010; /**< @brief file transfer with display notification request */
  public final static int MTC_IM_FILE_IMDN_BURN = 0x00000020; /**< @brief file transfer with burn after reading notification request */
  // EN_MTC_FILE_DIRECT_TYPE 
  public final static int EN_MTC_FILE_DIRECT_UNKNOWN = 0; /**< @brief file transfer direct unknown */
  public final static int EN_MTC_FILE_DIRECT_SENDER = EN_MTC_FILE_DIRECT_UNKNOWN + 1; /**< @brief file transfer direct sender */
  public final static int EN_MTC_FILE_DIRECT_RECVER = EN_MTC_FILE_DIRECT_SENDER + 1; /**< @brief file transfer direct receiver */

  // EN_MTC_IM_FILE_REJECT_REASON_TYPE 
  public final static int EN_MTC_IM_FILE_REJECT_REASON_NORMAL = 0; /**< @brief normal */
  public final static int EN_MTC_IM_FILE_REJECT_REASON_FILE_TOO_LARGE = EN_MTC_IM_FILE_REJECT_REASON_NORMAL + 1; /**< @brief file too large */

  // EN_MTC_IM_FILE_SPAM_TYPE 
  public final static int EN_MTC_IM_FILE_SPAM_MIN = 0;
  public final static int EN_MTC_IM_FILE_SPAM_POLITICAL_RUMOR = EN_MTC_IM_FILE_SPAM_MIN + 1; /**< @brief political rumor msg */
  public final static int EN_MTC_IM_FILE_SPAM_JURISPRUDENCE = EN_MTC_IM_FILE_SPAM_POLITICAL_RUMOR + 1; /**< @brief jurisprudence msg */
  public final static int EN_MTC_IM_FILE_SPAM_FRAUD = EN_MTC_IM_FILE_SPAM_JURISPRUDENCE + 1; /**< @brief fraud msg */
  public final static int EN_MTC_IM_FILE_SPAM_MALICIOUS_MARKETING = EN_MTC_IM_FILE_SPAM_FRAUD + 1; /**< @brief malicious marketing msg */
  public final static int EN_MTC_IM_FILE_SPAM_VIOLENCE = EN_MTC_IM_FILE_SPAM_MALICIOUS_MARKETING + 1; /**< @brief violence msg */
  public final static int EN_MTC_IM_FILE_SPAM_OTHER = 9;
  public final static int EN_MTC_IM_FILE_SPAM_MAX = EN_MTC_IM_FILE_SPAM_OTHER + 1;

}