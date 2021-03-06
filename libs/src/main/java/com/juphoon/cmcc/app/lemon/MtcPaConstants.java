/**
 * @file MtcPaConstants.java
 * @brief MtcPaConstants constants
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
 * @brief MtcPaConstants constants
 */
public interface MtcPaConstants {
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
  public final static int MTC_PA_ERR_NO = (0xEC00+0); /**< @brief no error */
  public final static int MTC_PA_ERR_AUTH_FAILED = (0xEC00+1); /**< @brief authentication failed, invalid user or password */
  public final static int MTC_PA_ERR_CONN_FAILED = (0xEC00+2); /**< @brief transport connect failed */
  public final static int MTC_PA_ERR_SEND_FAILED = (0xEC00+3); /**< @brief transport send failed */
  public final static int MTC_PA_ERR_RECV_FAILED = (0xEC00+4); /**< @brief transport received failed */
  public final static int MTC_PA_ERR_SERV_DISCED = (0xEC00+5); /**< @brief transport disconnected by server */
  public final static int MTC_PA_ERR_SERV_ERR = (0xEC00+6); /**< @brief server internal error */
  public final static int MTC_PA_ERR_REQ_TIMEOUT = (0xEC00+7); /**< @brief request timeout */
  public final static int MTC_PA_ERR_BAD_XML_MSG = (0xEC00+8); /**< @brief bad xml message */
  public final static int MTC_PA_ERR_FORBIDDEN = (0xEC00+9); /**< @brief forbidden */
  public final static int MTC_PA_ERR_RESULT = (0xEC00+10); /**< @brief server result */
  public final static int MTC_PA_ERR_OTHER = (0xEC00+11); /**< @brief other */
  // EN_MTC_PA_MEDIA_TYPE 
  public final static int EN_MTC_PA_MEDIA_UNKNOWN = 0; /**< @brief unknown message */
  public final static int EN_MTC_PA_MEDIA_TXT = EN_MTC_PA_MEDIA_UNKNOWN + 1; /**< @brief text message */
  public final static int EN_MTC_PA_MEDIA_TMPL = EN_MTC_PA_MEDIA_TXT + 1; /**< @brief template message */
  public final static int EN_MTC_PA_MEDIA_VCARD = EN_MTC_PA_MEDIA_TMPL + 1; /**< @brief vCard message */
  public final static int EN_MTC_PA_MEDIA_GEO = EN_MTC_PA_MEDIA_VCARD + 1; /**< @brief geolocation message */
  public final static int EN_MTC_PA_MEDIA_PIC = EN_MTC_PA_MEDIA_GEO + 1; /**< @brief picture message */
  public final static int EN_MTC_PA_MEDIA_VIDEO = EN_MTC_PA_MEDIA_PIC + 1; /**< @brief video message */
  public final static int EN_MTC_PA_MEDIA_AUDIO = EN_MTC_PA_MEDIA_VIDEO + 1; /**< @brief audio message */
  public final static int EN_MTC_PA_MEDIA_SART = EN_MTC_PA_MEDIA_AUDIO + 1; /**< @brief single article message */
  public final static int EN_MTC_PA_MEDIA_MART = EN_MTC_PA_MEDIA_SART + 1; /**< @brief multi-article message */
  public final static int EN_MTC_PA_MEDIA_CARD = EN_MTC_PA_MEDIA_MART + 1; /**< @brief card message */
  public final static int EN_MTC_PA_MEDIA_SMS = EN_MTC_PA_MEDIA_CARD + 1; /**< @brief SMS message */
  public final static int EN_MTC_PA_MEDIA_SUBLST_UPDT = EN_MTC_PA_MEDIA_SMS + 1; /**< @brief subsribe list update message */
  public final static int EN_MTC_PA_MEDIA_DETAIL_UPDT = EN_MTC_PA_MEDIA_SUBLST_UPDT + 1; /**< @brief detail update message */

  // EN_MTC_PA_TYPE 
  public final static int EN_MTC_PA_UNKNOWN = 0; /**< @brief unknown type */
  public final static int EN_MTC_PA_HOT = EN_MTC_PA_UNKNOWN + 1; /**< @brief hot type */
  public final static int EN_MTC_PA_READ = EN_MTC_PA_HOT + 1; /**< @brief read type */
  public final static int EN_MTC_PA_STAR = EN_MTC_PA_READ + 1; /**< @brief star type */
  public final static int EN_MTC_PA_FOOD = EN_MTC_PA_STAR + 1; /**< @brief food type */
  public final static int EN_MTC_PA_CORP = EN_MTC_PA_FOOD + 1; /**< @brief corporation type */
  public final static int EN_MTC_PA_SOCAIL = EN_MTC_PA_CORP + 1; /**< @brief social type */
  public final static int EN_MTC_PA_GAME = EN_MTC_PA_SOCAIL + 1; /**< @brief game type */
  public final static int EN_MTC_PA_MUSIC = EN_MTC_PA_GAME + 1; /**< @brief music type */
  public final static int EN_MTC_PA_EDU = EN_MTC_PA_MUSIC + 1; /**< @brief education type */
  public final static int EN_MTC_PA_OTHER = 99; /**< @brief other type */

  // EN_MTC_PA_RECMD_LV_TYPE 
  public final static int EN_MTC_PA_RECMD_LV_UNKNOWN = 0; /**< @brief level unknown type */
  public final static int EN_MTC_PA_RECMD_LV_ONE = EN_MTC_PA_RECMD_LV_UNKNOWN + 1; /**< @brief level one type */
  public final static int EN_MTC_PA_RECMD_LV_TWO = EN_MTC_PA_RECMD_LV_ONE + 1; /**< @brief level two type */
  public final static int EN_MTC_PA_RECMD_LV_THREE = EN_MTC_PA_RECMD_LV_TWO + 1; /**< @brief level three type */
  public final static int EN_MTC_PA_RECMD_LV_FOUR = EN_MTC_PA_RECMD_LV_THREE + 1; /**< @brief level four type */
  public final static int EN_MTC_PA_RECMD_LV_FIVE = EN_MTC_PA_RECMD_LV_FOUR + 1; /**< @brief level five type */

  // EN_MTC_PA_MENU_CMD_TYPE 
  public final static int EN_MTC_PA_MENU_CMD_SMLT_MSG = 0; /**< @brief simulative message type */
  public final static int EN_MTC_PA_MENU_CMD_LINK = EN_MTC_PA_MENU_CMD_SMLT_MSG + 1; /**< @brief link type */
  public final static int EN_MTC_PA_MENU_CMD_DEV_API = EN_MTC_PA_MENU_CMD_LINK + 1; /**< @brief device API type */
  public final static int EN_MTC_PA_MENU_CMD_APP_API = EN_MTC_PA_MENU_CMD_DEV_API + 1; /**< @brief application API type */

  // EN_MTC_PA_ID_TYPE 
  public final static int EN_MTC_PA_ID_UNKNOWN = 0; /**< @brief unknown type */
  public final static int EN_MTC_PA_ID_COMPANY = EN_MTC_PA_ID_UNKNOWN + 1; /**< @brief company type */
  public final static int EN_MTC_PA_ID_PERSONAL = EN_MTC_PA_ID_COMPANY + 1; /**< @brief personal type */

  // EN_MTC_PA_COLOR_TYPE 
  public final static int EN_MTC_PA_COLOR_UNKNOWN = 0; /**< @brief unknown type */
  public final static int EN_MTC_PA_COLOR_RED = EN_MTC_PA_COLOR_UNKNOWN + 1; /**< @brief RGB(255,0,24) #ff0018 */
  public final static int EN_MTC_PA_COLOR_DARKRED = EN_MTC_PA_COLOR_RED + 1; /**< @brief RGB(152,42,42) #982a2a */
  public final static int EN_MTC_PA_COLOR_ORANGE = EN_MTC_PA_COLOR_DARKRED + 1; /**< @brief RGB(255,120,0) #ff7800 */
  public final static int EN_MTC_PA_COLOR_YELLOW = EN_MTC_PA_COLOR_ORANGE + 1; /**< @brief RGB(255,192,0) #ffc000 */
  public final static int EN_MTC_PA_COLOR_GREEN = EN_MTC_PA_COLOR_YELLOW + 1; /**< @brief RGB(0,213,85) #00d555 */
  public final static int EN_MTC_PA_COLOR_BLUE = EN_MTC_PA_COLOR_GREEN + 1; /**< @brief RGB(0,120,255) #0078ff */
  public final static int EN_MTC_PA_COLOR_DARKBLUE = EN_MTC_PA_COLOR_BLUE + 1; /**< @brief RGB(29,50,155) #1d3273 */
  public final static int EN_MTC_PA_COLOR_PURPLE = EN_MTC_PA_COLOR_DARKBLUE + 1; /**< @brief RGB(154,72,255) #9a48ff */
  public final static int EN_MTC_PA_COLOR_PINK = EN_MTC_PA_COLOR_PURPLE + 1; /**< @brief RGB(253,93,255) #fd5dff */
  public final static int EN_MTC_PA_COLOR_DEEPPINK = EN_MTC_PA_COLOR_PINK + 1; /**< @brief RGB(190,39,128) #be2780 */
  public final static int EN_MTC_PA_COLOR_GRAY = EN_MTC_PA_COLOR_DEEPPINK + 1; /**< @brief RGB(204,204,204) #CCCCCC */
  public final static int EN_MTC_PA_COLOR_DARKGRAY = EN_MTC_PA_COLOR_GRAY + 1; /**< @brief RGB(133,133,133) #858585 */
  public final static int EN_MTC_PA_COLOR_BLACK = EN_MTC_PA_COLOR_DARKGRAY + 1; /**< @brief RGB(0,0,0) #000000 */
  public final static int EN_MTC_PA_COLOR_WHITE = EN_MTC_PA_COLOR_BLACK + 1; /**< @brief RGB(255,255,255) #ffffff */

}
