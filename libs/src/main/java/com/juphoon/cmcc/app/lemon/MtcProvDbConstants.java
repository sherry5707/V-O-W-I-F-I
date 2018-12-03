/**
 * @file MtcProvDbConstants.java
 * @brief MtcProvDbConstants constants
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
 * @brief MtcProvDbConstants constants
 */
public interface MtcProvDbConstants {
  public final static String MTC_PROV_TMNL_APP = "APP";
  public final static String MTC_PROV_TMNL_PC = "PC";
  public final static String MTC_PROV_TMNL_MAC = "MAC";
  public final static String MTC_PROV_TMNL_PAD = "PAD";
  public final static String MTC_PROV_TMNL_WEB = "WEB";
  public final static String MTC_PROV_TMNL_NATIVE = "NATIVE";
  // EN_MTC_PROV_RCS_VER_TYPE 
  public final static int EN_MTC_PROV_RCS_VER_UNKNOWN = 0; /**< @brief unknown */
  public final static int EN_MTC_PROV_RCS_VER_5_1 = EN_MTC_PROV_RCS_VER_UNKNOWN + 1; /**< @brief rcs5.1_v1.0(5.1) */
  public final static int EN_MTC_PROV_RCS_VER_5_1_B = EN_MTC_PROV_RCS_VER_5_1 + 1; /**< @brief rcs5.1_v2.0(5.1B) */

  // EN_MTC_PROV_RCS_PROF_TYPE 
  public final static int EN_MTC_PROV_RCS_PROF_UNKNOWN = 0; /**< @brief unknown */
  public final static int EN_MTC_PROV_RCS_PROF_JOYN_BLACKBIRD = EN_MTC_PROV_RCS_PROF_UNKNOWN + 1; /**< @brief joyn blackbird */
  public final static int EN_MTC_PROV_RCS_PROF_JOYN_HOTFIXES = EN_MTC_PROV_RCS_PROF_JOYN_BLACKBIRD + 1; /**< @brief joyn hotfixes */

  // EN_MTC_PROV_DEVICE_TYPE 
  public final static int EN_MTC_PROV_DEVICE_TABLET = 0; /**< @brief tablet device type */
  public final static int EN_MTC_PROV_DEVICE_PC = EN_MTC_PROV_DEVICE_TABLET + 1; /**< @brief pc device type */
  public final static int EN_MTC_PROV_DEVICE_OTHER = EN_MTC_PROV_DEVICE_PC + 1; /**< @brief other device type */

  // EN_MTC_PROV_SRV_TMPL_TYPE 
  public final static int EN_MTC_PROV_SRV_TMPL_UNKNOWN = 0; /**< @brief unknown */
  public final static int EN_MTC_PROV_SRV_TMPL_LOCAL = EN_MTC_PROV_SRV_TMPL_UNKNOWN + 1; /**< @brief config.rcs.mncXXX.mccXXX.pub.3gppnetwork.org */
  public final static int EN_MTC_PROV_SRV_TMPL_GLOBAL = EN_MTC_PROV_SRV_TMPL_LOCAL + 1; /**< @brief global.config.rcs.mncXXX.mccXXX.pub.3gppnetwork.org */
  public final static int EN_MTC_PROV_SRV_TMPL_OTHER = EN_MTC_PROV_SRV_TMPL_GLOBAL + 1; /**< @brief other */

}
