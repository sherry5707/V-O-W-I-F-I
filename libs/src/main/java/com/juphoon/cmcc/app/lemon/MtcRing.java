/**
 * @file MtcRing.java
 * @brief MtcRing interface
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
 * @brief MtcRing interface
 */
public class MtcRing implements MtcRingConstants {
/**
 * @brief Play ring, and ring type see @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 *
 * It will play the custom set file if found. Or it will try to play
 * the default ring file. The default ring file path formed by the directory
 * set by @ref MtcRing::Mtc_RingSetDir, the ring name and ".wav" for extension name.
 *
 * @param [in] iType The ring Type, see @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 * @param [in] iMilliSeconds The playing time length in milliseconds, 
 *                           0 is for forever.
 *
 * @retval MtcCommonConstants::ZOK Audio plays ring successfully.
 * @retval MtcCommonConstants::ZFAILED Audio plays ring failed.
 *
 * @see @ref MtcRing::Mtc_RingPlayX Mtc_RingStop
 */
  public static int Mtc_RingPlay(int iType, int iMilliSeconds) {
    return MtcRingJNI.Mtc_RingPlay(iType, iMilliSeconds);
  }

/**
 * @brief Play ring with no loop, and ring type see @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 *
 * It will play the custom set file if found. Or it will try to play
 * the default ring file. The default ring file path formed by the directory
 * set by @ref MtcRing::Mtc_RingSetDir, the ring name and ".wav" for extension name.
 *
 * @param [in] iType The ring Type, see @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 *
 * @retval MtcCommonConstants::ZOK Audio plays ring successfully.
 * @retval MtcCommonConstants::ZFAILED Audio plays ring failed.
 *
 * @see @ref MtcRing::Mtc_RingPlay
 */
  public static int Mtc_RingPlayNoLoop(int iType) {
    return MtcRingJNI.Mtc_RingPlayNoLoop(iType);
  }

/**
 * @brief Play ring file.
 *
 * The ring name and ".wav" for extension name.
 *
 * @param [in] pcFileName File name of ring file.
 * @param [in] iMilliSeconds The playing time length in milliseconds, 
 *                           0 is for forever.
 *
 * @retval MtcCommonConstants::ZOK Audio plays ring successfully.
 * @retval MtcCommonConstants::ZFAILED Audio plays ring failed.
 *
 * @see @ref MtcRing::Mtc_RingPlay Mtc_RingStop
 */
  public static int Mtc_RingPlayX(String pcFileName, int iMilliSeconds) {
    return MtcRingJNI.Mtc_RingPlayX(pcFileName, iMilliSeconds);
  }

/**
 * @brief Audio stop playback.
 *
 * @param [in] iType The ring Type, see @ref MtcRingConstants::EN_MTC_RING_TONE_0. ZMAXUINT to
                     stop every ring play.
 *
 * @see @ref MtcRing::Mtc_RingPlay Mtc_RingPlayX
 */
  public static void Mtc_RingStop(int iType) {
    MtcRingJNI.Mtc_RingStop(iType);
  }

/**
 * @brief Audio is playing.
 *
 * @retval true Audio is playing.
 * @retval false Audio is not playing.
 *
 * @see @ref MtcRing::Mtc_RingPlay
 */
  public static boolean Mtc_RingIsPlay() {
    return MtcRingJNI.Mtc_RingIsPlay();
  }

/**
 * @brief Get mute status.
 *
 * @retval true In mute.
 * @retval false In unmute.
 *
 * @see @ref MtcRing::Mtc_RingSetMute
 */
  public static boolean Mtc_RingGetMute() {
    return MtcRingJNI.Mtc_RingGetMute();
  }

/**
 * @brief Set mute status.
 *
 * @param [in] bMute true to mute ring, false to unmute ring.
 *
 * @retval MtcCommonConstants::ZOK Set mute status successfully.
 * @retval MtcCommonConstants::ZFAILED Set mute status failed.
 *
 * @see @ref MtcRing::Mtc_RingGetMute
 */
  public static int Mtc_RingSetMute(boolean bMute) {
    return MtcRingJNI.Mtc_RingSetMute(bMute);
  }

/**
 * @brief Get mute status of specific type.
 *
 * @param [in] iType Ring type, @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 *
 * @retval true In mute.
 * @retval false In unmute.
 *
 * @see MtcRing::Mtc_RingSetMuteType
 */
  public static boolean Mtc_RingGetMuteType(int iType) {
    return MtcRingJNI.Mtc_RingGetMuteType(iType);
  }

/**
 * @brief Set mute status of specific type.
 *
 * @param [in] iType Ring type, @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 * @param [in] bMute true to mute ring, false to unmute ring.
 *
 * @retval MtcCommonConstants::ZOK Set mute status successfully.
 * @retval MtcCommonConstants::ZFAILED Set mute status failed.
 *
 * @see MtcRing::Mtc_RingGetMuteType
 */
  public static int Mtc_RingSetMuteType(int iType, boolean bMute) {
    return MtcRingJNI.Mtc_RingSetMuteType(iType, bMute);
  }

/**
 * @brief Get ring name by type.
 *
 * @param [in] iType The ring Type, see @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 *
 * @return The ring name if found, otherwise return empty string.
 *
 * @see @ref MtcRing::Mtc_RingGetType
 */
  public static String Mtc_RingGetName(int iType) {
    return MtcRingJNI.Mtc_RingGetName(iType);
  }

/**
 * @brief Get ring description by type.
 *
 * @param [in] iType The ring Type, see @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 *
 * @return The ring description if found, otherwise return empty string.
 *
 * @see @ref MtcRing::Mtc_RingGetType
 */
  public static String Mtc_RingGetDesc(int iType) {
    return MtcRingJNI.Mtc_RingGetDesc(iType);
  }

/**
 * @brief Get ring type by name.
 *
 * @param [in] pcName The ring name string.
 *
 * @return The ring type if found. Or return -1.
 *
 * @see @ref MtcRing::Mtc_RingGetName
 */
  public static int Mtc_RingGetType(String pcName) {
    return MtcRingJNI.Mtc_RingGetType(pcName);
  }

/**
 * @brief Get custom ring file name by type.
 *
 * @param [in] iType The ring Type, see @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 *
 * @return The ring custom ring file name if found, otherwise return empty string.
 *
 * @see @ref MtcRing::Mtc_RingSetCtmName
 */
  public static String Mtc_RingGetCtmName(int iType) {
    return MtcRingJNI.Mtc_RingGetCtmName(iType);
  }

/**
 * @brief Set custom ring file name.
 *
 * @param [in] iType The ring Type, see @ref MtcRingConstants::EN_MTC_RING_TONE_0.
 * @param [in] pcName The ring file name.
 *
 * @retval MtcCommonConstants::ZOK Set custom ring file name successfully.
 * @retval MtcCommonConstants::ZFAILED Set custom ring file name failed.
 *
 * @see @ref MtcRing::Mtc_RingGetCtmName
 */
  public static int Mtc_RingSetCtmName(int iType, String pcName) {
    return MtcRingJNI.Mtc_RingSetCtmName(iType, pcName);
  }

/**
 * @brief Get directory for default ring file.
 *
 * @return The directory for default ring file.
 *
 * @see @ref MtcRing::Mtc_RingSetDir
 */
  public static String Mtc_RingGetDir() {
    return MtcRingJNI.Mtc_RingGetDir();
  }

/**
 * @brief Set directory for default ring file.
 *
 * @param [in] pcName The directory name.
 * @param [in] wLen The string length of directory name.
 *
 * @retval MtcCommonConstants::ZOK Set directory for default ring file successfully.
 * @retval MtcCommonConstants::ZFAILED Set directory for default ring file failed.
 *
 * @see @ref MtcRing::Mtc_RingGetDir
 */
  public static void Mtc_RingSetDir(String pcName, int wLen) {
    MtcRingJNI.Mtc_RingSetDir(pcName, wLen);
  }

}
