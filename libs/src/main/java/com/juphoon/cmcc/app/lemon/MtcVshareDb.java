/**
 * @file MtcVshareDb.java
 * @brief MtcVshareDb interface
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
 * @brief MtcVshareDb interface
 */
public class MtcVshareDb {
/**
 * @brief Get video codec count.
 *
 * @return Video used codec count.
 */
  public static int Mtc_VShareDbGetVideoCodecCount() {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoCodecCount();
  }

/**
 * @brief Get video codec from database.
 *
 * @param [in] ucPriority Codec priority.
 *
 * @return The string of Codec name successfully or empty string failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoCodecByPriority
 */
  public static String Mtc_VShareDbGetVideoCodecByPriority(short ucPriority) {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoCodecByPriority(ucPriority);
  }

/**
 * @brief Set the video codec priority.
 *
 * @param [in] pcCodec Codec name.
 * @param [in] ucPriority Codec priority.
 *
 * @retval MtcCommonConstants::ZOK Set the video codec priority successfully.
 * @retval MtcCommonConstants::ZFAILED Set the video codec priority failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoCodecByPriority
 */
  public static int Mtc_VShareDbSetVideoCodecByPriority(String pcCodec, short ucPriority) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoCodecByPriority(pcCodec, ucPriority);
  }

/**
 * @brief Get video bitrate.
 *
 * @retval Video bitrate parameter in bps.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoBitrate
 */
  public static int Mtc_VShareDbGetVideoBitrate() {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoBitrate();
  }

/**
 * @brief Set video bitrate.
 *
 * @param [in] iBitRate Video bitrate parameter in bps.
 *
 * @retval MtcCommonConstants::ZOK Set the video bitrate successfully.
 * @retval MtcCommonConstants::ZFAILED Set the video bitrate failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoBitrate
 */
  public static int Mtc_VShareDbSetVideoBitrate(int iBitRate) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoBitrate(iBitRate);
  }

/**
 * @brief Get video frame rate.
 *
 * @retval Video frame rate parameter in fps.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoFramerate
 */
  public static int Mtc_VShareDbGetVideoFramerate() {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoFramerate();
  }

/**
 * @brief Set video frame rate.
 *
 * @param [in] iFrameRate Video frame rate parameter in fps.
 *
 * @retval MtcCommonConstants::ZOK Set the video frame rate successfully.
 * @retval MtcCommonConstants::ZFAILED Set the video frame rate failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoFramerate
 */
  public static int Mtc_VShareDbSetVideoFramerate(int iFrameRate) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoFramerate(iFrameRate);
  }

/**
 * @brief Get video resolution.
 *
 * @param [out] piWidth Pixel value in horizontal direction.
 * @param [out] piHeight Pixel value in vertical direction.
 *
 * @retval MtcCommonConstants::ZOK Get the video resolution successfully.
 * @retval MtcCommonConstants::ZFAILED Get the video resolution failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoResolution
 */
  public static int Mtc_VShareDbGetVideoResolution(MtcNumber piWidth, MtcNumber piHeight) {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoResolution(piWidth, piHeight);
  }

/**
 * @brief Set video resolution.
 *
 * @param [in] iWidth Pixel value in horizontal direction.
 * @param [in] iHeight Pixel value in vertical direction.
 *
 * @retval MtcCommonConstants::ZOK Set the video resolution successfully.
 * @retval MtcCommonConstants::ZFAILED Set the video resolution failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoResolution
 */
  public static int Mtc_VShareDbSetVideoResolution(int iWidth, int iHeight) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoResolution(iWidth, iHeight);
  }

/**
 * @brief Get video resolution.
 *
 * @return The string of video resolution name or "UNKNOWN" failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoResolutionX
 */
  public static String Mtc_VShareDbGetVideoResolutionX() {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoResolutionX();
  }

/**
 * @brief Set video resolution.
 *
 * @param [in] pcName Video resolution name string.
 *
 * @retval MtcCommonConstants::ZOK Set the video resolution successfully.
 * @retval MtcCommonConstants::ZFAILED Set the video resolution failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoResolutionX
 */
  public static int Mtc_VShareDbSetVideoResolutionX(String pcName) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoResolutionX(pcName);
  }

/**
 * @brief Get resolution control of video stream.
 *
 * @retval true Resolution control is enabled for video stream.
 * @retval false Resolution control is disabled for video stream.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetResolutionControl
 */
  public static boolean Mtc_VShareDbGetResolutionControl() {
    return MtcVshareDbJNI.Mtc_VShareDbGetResolutionControl();
  }

/**
 * @brief Set resolution control of video stream.
 *
 * @param [in] bEnable true to enable resolution control, otherwise to disable.
 *
 * @retval MtcCommonConstants::ZOK Set successfully.
 * @retval MtcCommonConstants::ZFAILED Set failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetResolutionControl
 */
  public static int Mtc_VShareDbSetResolutionControl(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetResolutionControl(bEnable);
  }

/**
 * @brief Get framerate control of video stream.
 *
 * @retval true Framerate control is enabled for video stream.
 * @retval false Framerate control is disabled for video stream.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetFramerateControl
 */
  public static boolean Mtc_VShareDbGetFramerateControl() {
    return MtcVshareDbJNI.Mtc_VShareDbGetFramerateControl();
  }

/**
 * @brief Set framerate control of video stream.
 *
 * @param [in] bEnable true to enable framerate control, otherwise to disable.
 *
 * @retval MtcCommonConstants::ZOK Set successfully.
 * @retval MtcCommonConstants::ZFAILED Set failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetFramerateControl
 */
  public static int Mtc_VShareDbSetFramerateControl(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetFramerateControl(bEnable);
  }

/**
 * @brief Get CPU load control of video stream.
 *
 * @retval true CPU load control is enabled for video stream.
 * @retval false CPU load control is disabled for video stream.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetCpuLoadControl
 */
  public static boolean Mtc_VShareDbGetCpuLoadControl() {
    return MtcVshareDbJNI.Mtc_VShareDbGetCpuLoadControl();
  }

/**
 * @brief Set CPU load control of video stream.
 *
 * @param [in] bEnable true to enable CPU load control, otherwise to disable.
 *
 * @retval MtcCommonConstants::ZOK Set successfully.
 * @retval MtcCommonConstants::ZFAILED Set failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetCpuLoadControl
 */
  public static int Mtc_VShareDbSetCpuLoadControl(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetCpuLoadControl(bEnable);
  }

/**
 * @brief Get CPU load control of video stream.
 *
 * @return CPU load control target, from 0 to 100.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetCpuLoadTarget
 */
  public static int Mtc_VShareDbGetCpuLoadTarget() {
    return MtcVshareDbJNI.Mtc_VShareDbGetCpuLoadTarget();
  }

/**
 * @brief Set CPU load control of video stream.
 *
 * @param [in] iTarget CPU load control target, from 0 to 100.
 *
 * @retval MtcCommonConstants::ZOK Set successfully.
 * @retval MtcCommonConstants::ZFAILED Set failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetCpuLoadTarget
 */
  public static int Mtc_VShareDbSetCpuLoadTarget(int iTarget) {
    return MtcVshareDbJNI.Mtc_VShareDbSetCpuLoadTarget(iTarget);
  }

/**
 * @brief Get FIR of video stream.
 *
 * @retval true FIR is enabled for video stream.
 * @retval false FIR is disabled for video stream.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetFir
 */
  public static boolean Mtc_VShareDbGetFir() {
    return MtcVshareDbJNI.Mtc_VShareDbGetFir();
  }

/**
 * @brief Set FIR of video stream.
 *
 * @param [in] bEnable true to enable FIR, otherwise to disable.
 *
 * @retval MtcCommonConstants::ZOK Set successfully.
 * @retval MtcCommonConstants::ZFAILED Set failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetFir
 */
  public static int Mtc_VShareDbSetFir(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetFir(bEnable);
  }

/**
 * @brief Get key frame period of video stream.
 *
 * @return Key frame period in milliseconds for video stream.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetFramerateControl
 */
  public static int Mtc_VShareDbGetKeyPeriod() {
    return MtcVshareDbJNI.Mtc_VShareDbGetKeyPeriod();
  }

/**
 * @brief Set framerate control of video stream.
 *
 * @param [in] iTimeLen Key frame period in milliseconds.
 *
 * @retval MtcCommonConstants::ZOK Set successfully.
 * @retval MtcCommonConstants::ZFAILED Set failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetKeyPeriod
 */
  public static int Mtc_VShareDbSetKeyPeriod(int iTimeLen) {
    return MtcVshareDbJNI.Mtc_VShareDbSetKeyPeriod(iTimeLen);
  }

/**
 * @brief Get bw efficiency mode of video stream.
 *
 * @retval true BEM is enabled for video stream.
 * @retval false BEM is disabled for video stream.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoBem
 */
  public static boolean Mtc_VShareDbGetVideoBem() {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoBem();
  }

/**
 * @brief Set bw efficiency mode of video stream.
 *
 * @param [in] bEnable true to enable BEM, otherwise to disable BEM.
 *
 * @retval MtcCommonConstants::ZOK Set the video BEM option successfully.
 * @retval MtcCommonConstants::ZFAILED Set the video BEM option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoBem
 */
  public static int Mtc_VShareDbSetVideoBem(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoBem(bEnable);
  }

/**
 * @brief Get ARS option of video stream.
 *
 * @retval true ARS is enabled for video stream.
 * @retval false ARS is disabled for video stream.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoArs
 */
  public static boolean Mtc_VShareDbGetVideoArs() {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoArs();
  }

/**
 * @brief Set ARS option of video stream.
 *
 * @param [in] bEnable true to enable ARS, otherwise to disable ARS.
 *
 * @retval MtcCommonConstants::ZOK Set the video ARS option successfully.
 * @retval MtcCommonConstants::ZFAILED Set the video ARS option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoArs
 */
  public static int Mtc_VShareDbSetVideoArs(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoArs(bEnable);
  }

/**
 * @brief Get ARS parameter from database.
 *
 * @param [out] piBrHi Highest bitrate.
 * @param [out] piBrLo Lowest bitrate.
 * @param [out] piFrHi Highest framerate.
 * @param [out] piFrLo Lowest framerate.

 * @retval MtcCommonConstants::ZOK Get successfully.
 * @retval MtcCommonConstants::ZFAILED Get failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoArsParm
 */
  public static int Mtc_VShareDbGetVideoArsParm(MtcNumber piBrHi, MtcNumber piBrLo, MtcNumber piFrHi, MtcNumber piFrLo) {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoArsParm(piBrHi, piBrLo, piFrHi, piFrLo);
  }

/**
 * @brief Set ARS parameter.
 *
 * @param [in] iBrHi Highest bitrate.
 * @param [in] iBrLo Lowest bitrate.
 * @param [in] iFrHi Highest framerate.
 * @param [in] iFrLo Lowest framerate.
 *
 * @retval MtcCommonConstants::ZOK Set successfully.
 * @retval MtcCommonConstants::ZFAILED Set failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoArsParm
 */
  public static int Mtc_VShareDbSetVideoArsParm(int iBrHi, int iBrLo, int iFrHi, int iFrLo) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoArsParm(iBrHi, iBrLo, iFrHi, iFrLo);
  }

/**
 * @brief Set option of red/fec.
 *
 * @param [in] bEnable true to enable red/fec, otherwise to disable red/fec.
 *
 * @retval MtcCommonConstants::ZOK Set successfully.
 * @retval MtcCommonConstants::ZFAILED Set failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoRedFec
 */
  public static int Mtc_VShareDbSetVideoRedFec(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoRedFec(bEnable);
  }

/**
 * @brief Get option of red/fec.
 *
 * @retval true ARS is enabled red/fec.
 * @retval false ARS is disabled red/fec.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoRedFec
 */
  public static boolean Mtc_VShareDbGetVideoRedFec() {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoRedFec();
  }

/**
 * @brief Get NACK option from database.
 *
 * @retval true Start NACK.
 * @retval false Do not start NACK.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetNackEnable
 */
  public static boolean Mtc_VShareDbGetNackEnable() {
    return MtcVshareDbJNI.Mtc_VShareDbGetNackEnable();
  }

/**
 * @brief Set NACK option.
 *
 * @param [in] bEnable NACK option.
 *
 * @retval MtcCommonConstants::ZOK Set NACK option successfully.
 * @retval MtcCommonConstants::ZFAILED Set NACK option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetNackEnable
 */
  public static int Mtc_VShareDbSetNackEnable(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetNackEnable(bEnable);
  }

/**
 * @brief Get TMMBR option from database.
 *
 * @retval true Start TMMBR.
 * @retval false Do not start TMMBR.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetTmmbrEnable
 */
  public static boolean Mtc_VShareDbGetTmmbrEnable() {
    return MtcVshareDbJNI.Mtc_VShareDbGetTmmbrEnable();
  }

/**
 * @brief Set TMMBR option.
 *
 * @param [in] bEnable TMMBR option.
 *
 * @retval MtcCommonConstants::ZOK Set TMMBR option successfully.
 * @retval MtcCommonConstants::ZFAILED Set TMMBR option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetTmmbrEnable
 */
  public static int Mtc_VShareDbSetTmmbrEnable(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetTmmbrEnable(bEnable);
  }

/**
 * @brief Get RPSI option from database.
 *
 * @retval true Start RPSI.
 * @retval false Do not start RPSI.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetRpsiEnable
 */
  public static boolean Mtc_VShareDbGetRpsiEnable() {
    return MtcVshareDbJNI.Mtc_VShareDbGetRpsiEnable();
  }

/**
 * @brief Set RPSI option.
 *
 * @param [in] bEnable RPSI option.
 *
 * @retval MtcCommonConstants::ZOK Set RPSI option successfully.
 * @retval MtcCommonConstants::ZFAILED Set RPSI option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetRpsiEnable
 */
  public static int Mtc_VShareDbSetRpsiEnable(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetRpsiEnable(bEnable);
  }

/**
 * @brief Get small NALU option from database.
 *
 * @retval true Enable small NALU.
 * @retval false Disable small NALU.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetSmallNaluEnable
 */
  public static boolean Mtc_VShareDbGetSmallNaluEnable() {
    return MtcVshareDbJNI.Mtc_VShareDbGetSmallNaluEnable();
  }

/**
 * @brief Set small NALU option.
 *
 * @param [in] bEnable Small NALU option.
 *
 * @retval MtcCommonConstants::ZOK Set small NALU option successfully.
 * @retval MtcCommonConstants::ZFAILED Set small NALU option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetSmallNaluEnable
 */
  public static int Mtc_VShareDbSetSmallNaluEnable(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetSmallNaluEnable(bEnable);
  }

/**
 * @brief Get the authorization for user to use Video Share service.
 *
 * @retval true Indicates that Video Share service is disabled.
 * @retval false Indicates that Video Share service is disabled.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVsAuth
 */
  public static boolean Mtc_VShareDbGetVsAuth() {
    return MtcVshareDbJNI.Mtc_VShareDbGetVsAuth();
  }

/**
 * @brief Get whether or not the SDP attribute and value (e.g. a=recordpref:nopreference) 
 *   is included in the Video Share invitation.
 *
 * @retval -1 Indicates inclusion of the attribute and value is up to the user's preference.
 * @retval 0 Indicates the attribute is never included (default value).
 * @retval 1 Indicates the attribute is always included .
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetAllowVsSave
 */
  public static int Mtc_VShareDbGetAllowVsSave() {
    return MtcVshareDbJNI.Mtc_VShareDbGetAllowVsSave();
  }

/**
 * @brief Get the maximum authorized duration time for a Video Share session.
 *
 * @return timer value in seconds, value equals to 0 means no limitation.
 */
  public static int Mtc_VShareDbGetMaxTimeVideoShare() {
    return MtcVshareDbJNI.Mtc_VShareDbGetMaxTimeVideoShare();
  }

/**
 * @brief Set the authorization for user to use Video Share service.
 *
 * @param [in] bVsAuth Video Share service enable flag;
 *
 * @retval MtcCommonConstants::ZOK Set enable flag successfully.
 * @retval MtcCommonConstants::ZFAILED Set enable flag failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVsAuth
 */
  public static int Mtc_VShareDbSetVsAuth(boolean bVsAuth) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVsAuth(bVsAuth);
  }

/**
 * @brief Set whether or not the SDP attribute and value (e.g. a=recordpref:nopreference) 
 *   is included in the Video Share invitation.
 *
 * @param [in] iAllowVsSave The allow type.
 *
 * @retval MtcCommonConstants::ZOK Set allow type successfully.
 * @retval MtcCommonConstants::ZFAILED Set allow type failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetAllowVsSave
 */
  public static int Mtc_VShareDbSetAllowVsSave(int iAllowVsSave) {
    return MtcVshareDbJNI.Mtc_VShareDbSetAllowVsSave(iAllowVsSave);
  }

/**
 * @brief Get parameter for coordination of video orientation.
 *
 * @param [out] pbSend true: CVO for sending is enabled.
 * @param [out] pbRecv true: CVO for receiving is enabled.
 * @param [out] piId RTP extension ID for CVO.
 *
 * @retval MtcCommonConstants::ZOK Get option successfully.
 * @retval MtcCommonConstants::ZFAILED Get option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetVideoOrientParm
 */
  public static int Mtc_VShareDbGetVideoOrientParm(MtcNumber pbSend, MtcNumber pbRecv, MtcNumber piId) {
    return MtcVshareDbJNI.Mtc_VShareDbGetVideoOrientParm(pbSend, pbRecv, piId);
  }

/**
 * @brief Set parameter for coordination of video orientation.
 *
 * @param [in] bSend true to enable CVO for sending.
 * @param [in] bRecv true to enable CVO for receiving.
 * @param [in] iId RTP extension ID for CVO.
 *
 * @retval MtcCommonConstants::ZOK Set option successfully.
 * @retval MtcCommonConstants::ZFAILED Set option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetVideoOrientParm
 */
  public static int Mtc_VShareDbSetVideoOrientParm(boolean bSend, boolean bRecv, int iId) {
    return MtcVshareDbJNI.Mtc_VShareDbSetVideoOrientParm(bSend, bRecv, iId);
  }

/**
 * @brief Get SRTP crypto type from database.
 *
 * @return SRTP crypto type, @ref MtcCallDbConstants::EN_MTC_DB_SRTP_CRYPTO_OFF.
 *
 * @see MtcVshareDb::Mtc_VShareDbSetSrtpCryptoType
 */
  public static int Mtc_VShareDbGetSrtpCryptoType() {
    return MtcVshareDbJNI.Mtc_VShareDbGetSrtpCryptoType();
  }

/**
 * @brief Set SRTP crypto type.
 *
 * @param [in] iType SRTP crypto type, @ref MtcCallDbConstants::EN_MTC_DB_SRTP_CRYPTO_OFF.
 *
 * @retval MtcCommonConstants::ZOK Set SRTP crypto type successfully.
 * @retval MtcCommonConstants::ZFAILED Set SRTP crypto type failed.
 *
 * @see MtcVshareDb::Mtc_VShareDbGetSrtpCryptoType
 */
  public static int Mtc_VShareDbSetSrtpCryptoType(int iType) {
    return MtcVshareDbJNI.Mtc_VShareDbSetSrtpCryptoType(iType);
  }

/**
 * @brief Get authenticated SRTP option from database.
 *
 * @retval true Enable authenticated SRTP.
 * @retval false Disable authenticated SRTP.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetSrtpAuthRtp
 */
  public static boolean Mtc_VShareDbGetSrtpAuthRtp() {
    return MtcVshareDbJNI.Mtc_VShareDbGetSrtpAuthRtp();
  }

/**
 * @brief Set authenticated SRTP option.
 *
 * @param [in] bEnable true to enable authenticated SRTP, false to disable.
 *
 * @retval MtcCommonConstants::ZOK Set authenticated SRTP option successfully.
 * @retval MtcCommonConstants::ZFAILED Set authenticated SRTP option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetSrtpAuthRtp
 */
  public static int Mtc_VShareDbSetSrtpAuthRtp(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetSrtpAuthRtp(bEnable);
  }

/**
 * @brief Get encrypted SRTP option from database.
 *
 * @retval true Enable encrypted SRTP.
 * @retval false Disable encrypted SRTP.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetSrtpEncryptRtp
 */
  public static boolean Mtc_VShareDbGetSrtpEncryptRtp() {
    return MtcVshareDbJNI.Mtc_VShareDbGetSrtpEncryptRtp();
  }

/**
 * @brief Set encrypted SRTP option.
 *
 * @param [in] bEnable true to enable encrypted SRTP, false to disable.
 *
 * @retval MtcCommonConstants::ZOK Set encrypted SRTP option successfully.
 * @retval MtcCommonConstants::ZFAILED Set encrypted SRTP option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetSrtpEncryptRtp
 */
  public static int Mtc_VShareDbSetSrtpEncryptRtp(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetSrtpEncryptRtp(bEnable);
  }

/**
 * @brief Get encrypted SRTCP option from database.
 *
 * @retval true Enable encrypted SRTCP.
 * @retval false Disable encrypted SRTCP.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbSetSrtpEncryptRtcp
 */
  public static boolean Mtc_VShareDbGetSrtpEncryptRtcp() {
    return MtcVshareDbJNI.Mtc_VShareDbGetSrtpEncryptRtcp();
  }

/**
 * @brief Set encrypted SRTCP option.
 *
 * @param [in] bEnable true to enable encrypted SRTCP, false to disable.
 *
 * @retval MtcCommonConstants::ZOK Set encrypted SRTCP option successfully.
 * @retval MtcCommonConstants::ZFAILED Set encrypted SRTCP option failed.
 *
 * @see @ref MtcVshareDb::Mtc_VShareDbGetSrtpEncryptRtcp
 */
  public static int Mtc_VShareDbSetSrtpEncryptRtcp(boolean bEnable) {
    return MtcVshareDbJNI.Mtc_VShareDbSetSrtpEncryptRtcp(bEnable);
  }

}