/**
 * @file MtcCliCfg.java
 * @brief MtcCliCfg interface
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
 * @brief MtcCliCfg interface
 */
public class MtcCliCfg implements MtcCliCfgConstants {
/**
 * @brief Set log level.
 *
 * @param [in] iLevel Log level, 0 for no log, larger value for more log, 
 *  type see @ref MtcCliCfgConstants::EN_MTC_LOG_LEVEL_DISABLE.
 */
  public static void Mtc_CliCfgSetLogLevel(int iLevel) {
    MtcCliCfgJNI.Mtc_CliCfgSetLogLevel(iLevel);
  }

/**
 * @brief Set log level.
 *
 * @param [in] iLevel Log level, MTC_LOG_LEVEL_NULL for no log, 
 *  larger value (e.g. MTC_LOG_LEVEL_ERROR & MTC_LOG_LEVEL_INFO) for more log, 
 *  type see @ref MTC_LOG_LEVEL_NULL...
 */
  public static void Mtc_CliCfgSetLogLevelX(int iLevel) {
    MtcCliCfgJNI.Mtc_CliCfgSetLogLevelX(iLevel);
  }

/**
 * @brief Set log print.
 *
 * @param [in] bPrint log print.
 *
 * @retval MtcCommonConstants::ZOK Set operation successfully.
 * @retval MtcCommonConstants::ZFAILED Set operation failed.
 */
  public static int Mtc_CliCfgSetLogPrint(boolean bPrint) {
    return MtcCliCfgJNI.Mtc_CliCfgSetLogPrint(bPrint);
  }

/**
 * @brief Get using detect local IP when client start and login.
 *
 * @retval true Detect local IP.
 * @retval false Not detect local IP.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetUseDetLclIp
 */
  public static boolean Mtc_CliCfgGetUseDetLclIp() {
    return MtcCliCfgJNI.Mtc_CliCfgGetUseDetLclIp();
  }

/**
 * @brief Set using detect local IP when client start and login.
 *
 * @param [in] bDetect Use default profile management.
 *
 * @retval MtcCommonConstants::ZOK Set detect option successfully.
 * @retval MtcCommonConstants::ZFAILED Set detect option failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetUseDetLclIp
 */
  public static int Mtc_CliCfgSetUseDetLclIp(boolean bDetect) {
    return MtcCliCfgJNI.Mtc_CliCfgSetUseDetLclIp(bDetect);
  }

/**
 * @brief Get support ability of network detection when client has logined.
 *
 * @retval true Detect network available.
 * @retval false Not detect available.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetSuptNetDetect
 */
  public static boolean Mtc_CliCfgGetSuptNetDetect() {
    return MtcCliCfgJNI.Mtc_CliCfgGetSuptNetDetect();
  }

/**
 * @brief Set support ability of network detection when client has logined.
 *
 * @param [in] bSupt Support network detection.
 *
 * @retval MtcCommonConstants::ZOK Set network detection successfully.
 * @retval MtcCommonConstants::ZFAILED Set network detection failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetSuptNetDetect
 */
  public static int Mtc_CliCfgSetSuptNetDetect(boolean bSupt) {
    return MtcCliCfgJNI.Mtc_CliCfgSetSuptNetDetect(bSupt);
  }

/**
 * @brief Get support ability of encrypt password.
 *
 * @retval true Password saved in crypto.
 * @retval false Password save in plain text.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetSuptEncPwd
 */
  public static boolean Mtc_CliCfgGetSuptEncPwd() {
    return MtcCliCfgJNI.Mtc_CliCfgGetSuptEncPwd();
  }

/**
 * @brief Set support ability of encrypt password.
 *
 * @param [in] bSupt Support encrypt password.
 *
 * @retval MtcCommonConstants::ZOK Set encrypt password successfully.
 * @retval MtcCommonConstants::ZFAILED Set encrypt password failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetSuptEncPwd
 */
  public static int Mtc_CliCfgSetSuptEncPwd(boolean bSupt) {
    return MtcCliCfgJNI.Mtc_CliCfgSetSuptEncPwd(bSupt);
  }

/**
 * @brief Get REGISTER capability flag.
 *
 * @return REGISTER capability, see @ref MTC_REG_CAP_OPT_IM etc.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetRegCap
 */
  public static int Mtc_CliCfgGetRegCap() {
    return MtcCliCfgJNI.Mtc_CliCfgGetRegCap();
  }

/**
 * @brief Set REGISTER capability flag.
 *
 * @param [in] iCapOpt REGISTER capability flag, see @ref MTC_REG_CAP_OPT_IM etc.
 *
 * @retval MtcCommonConstants::ZOK Set capability option successfully.
 * @retval MtcCommonConstants::ZFAILED Set capability option failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetRegCap
 */
  public static int Mtc_CliCfgSetRegCap(int iCapOpt) {
    return MtcCliCfgJNI.Mtc_CliCfgSetRegCap(iCapOpt);
  }

/**
 * @brief Clear REGISTER capability flag.
 *
 * @param [in] iCapOpt REGISTER capability flag, see @ref MTC_REG_CAP_OPT_IM etc.
 *
 * @retval MtcCommonConstants::ZOK Clear capability option successfully.
 * @retval MtcCommonConstants::ZFAILED Clear capability option failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetRegCap
 */
  public static int Mtc_CliCfgClrRegCap(int iCapOpt) {
    return MtcCliCfgJNI.Mtc_CliCfgClrRegCap(iCapOpt);
  }

/**
 * @brief Get CmccExtRegister extern capability flag.
 *
 * @return CmccExtRegister extern capability, see @ref MTC_EXT_REG_CAP_OPT_CMRED_BAG etc.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetCmccExtRegCap
 */
  public static int Mtc_CliCfgGetCmccExtRegCap() {
    return MtcCliCfgJNI.Mtc_CliCfgGetCmccExtRegCap();
  }

/**
 * @brief Set CmccExtRegister extern capability flag.
 *
 * @param [in] iCapOpt CmccExtRegister extern capability flag, see @ref MTC_EXT_REG_CAP_OPT_CMRED_BAG etc.
 *
 * @retval MtcCommonConstants::ZOK Set extern capability option successfully.
 * @retval MtcCommonConstants::ZFAILED Set extern capability option failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetCmccExtRegCap
 */
  public static int Mtc_CliCfgSetCmccExtRegCap(int iCapOpt) {
    return MtcCliCfgJNI.Mtc_CliCfgSetCmccExtRegCap(iCapOpt);
  }

/**
 * @brief Clear CmccExtRegister extern capability flag.
 *
 * @param [in] iCapOpt CmccExtRegister extern capability flag, see @ref MTC_EXT_REG_CAP_OPT_CMRED_BAG etc.
 *
 * @retval MtcCommonConstants::ZOK Clear extern capability option successfully.
 * @retval MtcCommonConstants::ZFAILED Clear extern capability option failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetCmccExtRegCap
 */
  public static int Mtc_CliCfgClrCmccExtRegCap(int iCapOpt) {
    return MtcCliCfgJNI.Mtc_CliCfgClrCmccExtRegCap(iCapOpt);
  }

/**
 * @brief Set Log file directory.
 *
 * @param [in] pcDir The log file directory.
 *
 * @retval MtcCommonConstants::ZOK Set directory successfully.
 * @retval MtcCommonConstants::ZFAILED Set directory failed.
 */
  public static int Mtc_CliCfgSetLogDir(String pcDir) {
    return MtcCliCfgJNI.Mtc_CliCfgSetLogDir(pcDir);
  }

/**
 * @brief Get Log file directory.
 *
 * @return The log file directory, default "".
 */
  public static String Mtc_CliCfgGetLogDir() {
    return MtcCliCfgJNI.Mtc_CliCfgGetLogDir();
  }

/**
 * @brief Set Login log file directory.
 *
 * @param [in] pcDir The login log file directory.
 *
 * @retval MtcCommonConstants::ZOK Set directory successfully.
 * @retval MtcCommonConstants::ZFAILED Set directory failed.
 */
  public static int Mtc_CliCfgSetLoginLogDir(String pcDir) {
    return MtcCliCfgJNI.Mtc_CliCfgSetLoginLogDir(pcDir);
  }

/**
 * @brief Get Login log file directory.
 *
 * @return The login log file directory, default "".
 */
  public static String Mtc_CliCfgGetLoginLogDir() {
    return MtcCliCfgJNI.Mtc_CliCfgGetLoginLogDir();
  }

/**
 * @brief Set license file name.
 *
 * @param [in] pcFileName The license file name.
 *
 * @retval MtcCommonConstants::ZOK Set file name successfully.
 * @retval MtcCommonConstants::ZFAILED Set file name failed.
 */
  public static int Mtc_CliCfgSetLicenseFileName(String pcFileName) {
    return MtcCliCfgJNI.Mtc_CliCfgSetLicenseFileName(pcFileName);
  }

/**
 * @brief Set aes key.
 *
 * @param [in] pcAesKey The aes key.
 *
 * @retval MtcCommonConstants::ZOK Set aes key successfully.
 * @retval MtcCommonConstants::ZFAILED Set aes key failed.
 */
  public static int Mtc_CliCfgSetAesKey(String pcAesKey) {
    return MtcCliCfgJNI.Mtc_CliCfgSetAesKey(pcAesKey);
  }

/**
 * @brief Set license context.
 *
 * @param [in] zContext The application context, only avaliable on Android.
 *
 * @retval MtcCommonConstants::ZOK Set file name successfully.
 * @retval MtcCommonConstants::ZFAILED Set file name failed.
 */
  public static int Mtc_CliCfgSetContext(Object zContext) {
    return MtcCliCfgJNI.Mtc_CliCfgSetContext(zContext);
  }

/**
 * @brief Get file encryption from database.
 *
 * @return The file encryption.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetFileEncrypt
 */
  public static boolean Mtc_CliCfgGetFileEncrypt() {
    return MtcCliCfgJNI.Mtc_CliCfgGetFileEncrypt();
  }

/**
 * @brief Set file encryption.
 *
 * @param [in] bFileEncrypt The file encryption.
 *
 * @retval MtcCommonConstants::ZOK Set file encryption successfully.
 * @retval MtcCommonConstants::ZFAILED Set file encryption failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetFileEncrypt
 */
  public static int Mtc_CliCfgSetFileEncrypt(boolean bFileEncrypt) {
    return MtcCliCfgJNI.Mtc_CliCfgSetFileEncrypt(bFileEncrypt);
  }

/**
 * @brief Get register service type.
 *
 * @return register service type, see @ref MtcCliCfgConstants::EN_MTC_REG_SRV_VOIP etc.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetRegSrvType
 */
  public static int Mtc_CliCfgGetRegSrvType() {
    return MtcCliCfgJNI.Mtc_CliCfgGetRegSrvType();
  }

/**
 * @brief Set register service type.
 *
 * @param [in] iSrvType register service type, see @ref MtcCliCfgConstants::EN_MTC_REG_SRV_VOIP etc.
 *
 * @retval MtcCommonConstants::ZOK Set register service type successfully.
 * @retval MtcCommonConstants::ZFAILED Set register service type failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetRegSrvType
 */
  public static int Mtc_CliCfgSetRegSrvType(int iSrvType) {
    return MtcCliCfgJNI.Mtc_CliCfgSetRegSrvType(iSrvType);
  }

/**
 * @brief Get wait register timer length.
 *
 * @return wait register timer length.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetTmrLenWaitReg
 */
  public static int Mtc_CliCfgGetTmrLenWaitReg() {
    return MtcCliCfgJNI.Mtc_CliCfgGetTmrLenWaitReg();
  }

/**
 * @brief Set wait register timer length.
 *
 * @param [in] iTmrLen wait register timer length.
 *
 * @retval MtcCommonConstants::ZOK Set wait register timer length successfully.
 * @retval MtcCommonConstants::ZFAILED wait register timer length failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetTmrLenWaitReg
 */
  public static int Mtc_CliCfgSetTmrLenWaitReg(int iTmrLen) {
    return MtcCliCfgJNI.Mtc_CliCfgSetTmrLenWaitReg(iTmrLen);
  }

/**
 * @brief Get support refresh before expire.
 *
 * @retval true refresh before expire.
 * @retval false refresh when expire.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetSuptRefreshBefExpr
 */
  public static boolean Mtc_CliCfgGetSuptRefreshBefExpr() {
    return MtcCliCfgJNI.Mtc_CliCfgGetSuptRefreshBefExpr();
  }

/**
 * @brief Set support refresh before expire.
 *
 * @param [in] bSupt Support refresh before expire.
 *
 * @retval MtcCommonConstants::ZOK Set refresh before expire successfully.
 * @retval MtcCommonConstants::ZFAILED Set refresh before expire failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetSuptRefreshBefExpr
 */
  public static int Mtc_CliCfgSetSuptRefreshBefExpr(boolean bSupt) {
    return MtcCliCfgJNI.Mtc_CliCfgSetSuptRefreshBefExpr(bSupt);
  }

/**
 * @brief Set check device ID type.
 *
 * @param [in] iType The device ID type @ref MtcCliConstants::EN_MTC_DEVICE_ID_SERIAL.
 *
 * @retval MtcCommonConstants::ZOK Set check device ID type successfully.
 * @retval MtcCommonConstants::ZFAILED Set check device ID type failed.
 *
 */
  public static int Mtc_CliCfgSetChkDevIdType(int iType) {
    return MtcCliCfgJNI.Mtc_CliCfgSetChkDevIdType(iType);
  }

/**
 * @brief Get timer self drive enable.
 *
 * @retval true enable timer self drive.
 * @retval false disable timer self drive.
 *
 * @see MtcCliCfg::Mtc_CliCfgSetTimerSelfDrvEnable
 */
  public static boolean Mtc_CliCfgGetTimerSelfDrvEnable() {
    return MtcCliCfgJNI.Mtc_CliCfgGetTimerSelfDrvEnable();
  }

/**
 * @brief Set timer self drive enable.
 *
 * @param [in] bEnable Enable timer self drive.
 *
 * @retval MtcCommonConstants::ZOK Set timer self drive enable successfully.
 * @retval MtcCommonConstants::ZFAILED Set timer self drive enable failed.
 *
 * @see MtcCliCfg::Mtc_CliCfgGetTimerSelfDrvEnable
 */
  public static int Mtc_CliCfgSetTimerSelfDrvEnable(boolean bEnable) {
    return MtcCliCfgJNI.Mtc_CliCfgSetTimerSelfDrvEnable(bEnable);
  }

/**
 * @brief Get logcat print flag.
 *
 * @retval true logcat print.
 * @retval false logcat not print.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgSetLogcatPrint
 */
  public static boolean Mtc_CliCfgGetLogcatPrint() {
    return MtcCliCfgJNI.Mtc_CliCfgGetLogcatPrint();
  }

/**
 * @brief Set logcat print flag.
 *
 * @param [in] bPrint logcat print.
 *
 * @retval MtcCommonConstants::ZOK Set logcat print flag successfully.
 * @retval MtcCommonConstants::ZFAILED Set logcat print flag failed.
 *
 * @see @ref MtcCliCfg::Mtc_CliCfgGetLogcatPrint
 */
  public static int Mtc_CliCfgSetLogcatPrint(boolean bPrint) {
    return MtcCliCfgJNI.Mtc_CliCfgSetLogcatPrint(bPrint);
  }

/**
 * @brief Get socket reuse address enable.
 *
 * @retval true enable socket reuse address.
 * @retval false disable socket reuse address.
 *
 * @see MtcCliCfg::Mtc_CliCfgSetSocketReuseEnable
 */
  public static boolean Mtc_CliCfgGetSocketReuseEnable() {
    return MtcCliCfgJNI.Mtc_CliCfgGetSocketReuseEnable();
  }

/**
 * @brief Set socket reuse address enable.
 *
 * @param [in] bEnable Enable socket reuse address.
 *
 * @retval MtcCommonConstants::ZOK Set socket reuse address enable successfully.
 * @retval MtcCommonConstants::ZFAILED Set socket reuse address enable failed.
 *
 * @see MtcCliCfg::Mtc_CliCfgGetSocketReuseEnable
 */
  public static int Mtc_CliCfgSetSocketReuseEnable(boolean bEnable) {
    return MtcCliCfgJNI.Mtc_CliCfgSetSocketReuseEnable(bEnable);
  }

/**
 * @brief Get udp socket connect enable.
 *
 * @retval true enable udp socket connect.
 * @retval false disable udp socket connect.
 *
 * @see MtcCliCfg::Mtc_CliCfgSetUdpConnectEnable
 */
  public static boolean Mtc_CliCfgGetUdpConnectEnable() {
    return MtcCliCfgJNI.Mtc_CliCfgGetUdpConnectEnable();
  }

/**
 * @brief Set udp socket connect enable.
 *
 * @param [in] bEnable Enable udp socket connect.
 *
 * @retval MtcCommonConstants::ZOK Set udp socket connect enable successfully.
 * @retval MtcCommonConstants::ZFAILED Set udp socket connect enable failed.
 *
 * @see MtcCliCfg::Mtc_CliCfgGetUdpConnectEnable
 */
  public static int Mtc_CliCfgSetUdpConnectEnable(boolean bEnable) {
    return MtcCliCfgJNI.Mtc_CliCfgSetUdpConnectEnable(bEnable);
  }

}
