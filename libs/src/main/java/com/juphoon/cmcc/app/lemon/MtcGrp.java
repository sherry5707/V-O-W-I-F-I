/**
 * @file MtcGrp.java
 * @brief MtcGrp interface
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
 * @brief MtcGrp interface
 */
public class MtcGrp implements MtcGrpConstants {
/**
 * @brief Load all pre-arranged groups from OMA XDMS.
 * 
 * The result will be notified by callbacks which were set by 
 * @ref mtcGrpCbLoadAllOk or @ref mtcGrpCbLoadAllFailed.
 *
 * @retval MtcCommonConstants::ZOK Start loading groups successfully.
 * @retval MtcCommonConstants::ZFAILED Client loading groups failed.
 */
  public static int Mtc_GrpsLoadAllGrp() {
    return MtcGrpJNI.Mtc_GrpsLoadAllGrp();
  }

/**
 * @brief Load a pre-arranged group from OMA XDMS.
 * 
 * @retval MtcCommonConstants::ZOK Start loading a group successfully.
 * @retval MtcCommonConstants::ZFAILED Client loading a group failed.
 */
  public static int Mtc_GrpsLoadGrp(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpsLoadGrp(iGrpId);
  }

/**
 * @brief Load a pre-arranged group by group uri from OMA XDMS.
 *
 * The result will be notified by callbacks which were set by 
 * @ref mtcGrpCbLoadOk or @ref mtcGrpCbLoadFailed.
 *
 * @return The id of group successfully or ZMAXUINT failed.
 */
  public static int Mtc_GrpsLoadGrpU(String pcGrpUri) {
    return MtcGrpJNI.Mtc_GrpsLoadGrpU(pcGrpUri);
  }

/**
 * @brief Upload a pre-arranged group into OMA XDMS.
 *
 * The result will be notified by callbacks which were set by 
 * @ref mtcGrpCbGrpAddOk or @ref mtcGrpCbGrpAddFailed.
 *
 * @retval MtcCommonConstants::ZOK Start uploading a group successfully.
 * @retval MtcCommonConstants::ZFAILED Client uploading a group failed.
 */
  public static int Mtc_GrpsUploadGrp(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpsUploadGrp(iGrpId);
  }

/**
 * @brief Get OMA pre-arranged group set size.
 *
 * @return Pre-arranged group set size.
 *
 * @see @ref MtcGrp::Mtc_GrpsGetGrp
 */
  public static int Mtc_GrpsGetSize() {
    return MtcGrpJNI.Mtc_GrpsGetSize();
  }

/**
 * @brief Get One pre-arranged group by index.
 *
 * @param [in] iIndex The index of group.
 *
 * @return The id of group.
 *
 * @see @ref MtcGrp::Mtc_GrpsGetSize
 */
  public static int Mtc_GrpsGetGrp(int iIndex) {
    return MtcGrpJNI.Mtc_GrpsGetGrp(iIndex);
  }

/**
 * @brief Add One pre-arranged group and update change to xdms.
 *
 * The result will be notified by callbacks which were set by 
 * @ref mtcGrpCbGrpAddOk or @ref mtcGrpCbGrpAddFailed.
 *
 * @param [in] zCookie The user cookie.
 * @param [in] pcDispName The group display name.
 * @param [in] pcSubject The group subject.
 *
 * @return The id of group when add group successfully, otherwise return ZMAXUINT.
 *
 * @see @ref MtcGrp::Mtc_GrpsRmvGrp
 */
  public static int Mtc_GrpsAddGrp(Object zCookie, String pcDispName, String pcSubject) {
    return MtcGrpJNI.Mtc_GrpsAddGrp(zCookie, pcDispName, pcSubject);
  }

/**
 * @brief Add One pre-arranged group in local cache.
 *
 * @param [in] zCookie The user cookie.
 * @param [in] pcDispName The group display name.
 * @param [in] pcSubject The group subject.
 *
 * @return The id of group when add group successfully, otherwise return ZMAXUINT.
 *
 * @see @ref MtcGrp::Mtc_GrpsRmvGrp
 */
  public static int Mtc_GrpsAddGrpL(Object zCookie, String pcDispName, String pcSubject) {
    return MtcGrpJNI.Mtc_GrpsAddGrpL(zCookie, pcDispName, pcSubject);
  }

/**
 * @brief Rmove One pre-arranged group and update change to xdms.
 *
 * The result will be notified by callbacks which were set by 
 * @ref mtcGrpCbGrpRmvOk or @ref mtcGrpCbGrpRmvFailed.
 *
 * @param [in] iGrpId The group id.
 *
 * @retval MtcCommonConstants::ZOK Remove one group successfully.
 * @retval MtcCommonConstants::ZFAILED Remove one group failed.
 *
 * @see @ref MtcGrp::Mtc_GrpsAddGrp
 */
  public static int Mtc_GrpsRmvGrp(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpsRmvGrp(iGrpId);
  }

/**
 * @brief Find One pre-arranged group by uri.
 *
 * @param [in] pcUri The group uri.
 *
 * @return One group Id.
 *
 * @see @ref MtcGrp::Mtc_GrpsRmvGrp
 */
  public static int Mtc_GrpsFindGrp(String pcUri) {
    return MtcGrpJNI.Mtc_GrpsFindGrp(pcUri);
  }

/**
 * @brief Get owner of a pre-arranged group.
 *
 * @param [in] iGrpId The group id.
 *
 * @return true if group is owner, otherwise return false.
 */
  public static boolean Mtc_GrpGetOwner(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpGetOwner(iGrpId);
  }

/**
 * @brief Get cookie of a pre-arranged group.
 *
 * @param [in] iGrpId The group id.
 *
 * @return The group cookie id.
 *
 * @see @ref MtcGrp::Mtc_GrpSetCookie
 */
  public static Object Mtc_GrpGetCookie(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpGetCookie(iGrpId);
  }

/**
 * @brief Set cookie of a pre-arranged group.
 *
 * @param [in] iGrpId The group id.
 * @param [in] zCookie The group cookie.
 *
 * @retval MtcCommonConstants::ZOK Set group cookie successfully.
 * @retval MtcCommonConstants::ZFAILED Set group cookie failed.
 *
 * @see @ref MtcGrp::Mtc_GrpGetCookie
 */
  public static int Mtc_GrpSetCookie(int iGrpId, Object zCookie) {
    return MtcGrpJNI.Mtc_GrpSetCookie(iGrpId, zCookie);
  }

/**
 * @brief Get group uri of a pre-arranged group.
 *
 * @param [in] iGrpId The group id.
 *
 * @return Group URI. 
 *   The caller must copy it, then use.
 *
 * @see @ref MtcGrp::Mtc_GrpSetCookie
 */
  public static String Mtc_GrpGetUri(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpGetUri(iGrpId);
  }

/**
 * @brief Get a pre-arranged group display name.
 *
 * @param [in] iGrpId The group id.
 *
 * @return The group name.
 *   The caller must copy it, then use.
 *
 * @see @ref MtcGrp::Mtc_GrpSetDispName
 */
  public static String Mtc_GrpGetDispName(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpGetDispName(iGrpId);
  }

/**
 * @brief Set a pre-arranged group(only owner) name and update change to xdms.
 *
 * @param [in] iGrpId The group id.
 * @param [in] pcDispName The group display Name.
 *
 * @retval MtcCommonConstants::ZOK Set group display name successfully.
 * @retval MtcCommonConstants::ZFAILED Set group display name failed.
 *
 * @see @ref MtcGrp::Mtc_GrpGetDispName
 */
  public static int Mtc_GrpSetDispName(int iGrpId, String pcDispName) {
    return MtcGrpJNI.Mtc_GrpSetDispName(iGrpId, pcDispName);
  }

/**
 * @brief Set a pre-arranged group name(only owner).
 *
 * @param [in] iGrpId The group id.
 * @param [in] pcDispName The group display Name.
 *
 * @retval MtcCommonConstants::ZOK Set group display name successfully.
 * @retval MtcCommonConstants::ZFAILED Set group display name failed.
 *
 * @see @ref MtcGrp::Mtc_GrpGetDispName
 */
  public static int Mtc_GrpSetDispNameL(int iGrpId, String pcDispName) {
    return MtcGrpJNI.Mtc_GrpSetDispNameL(iGrpId, pcDispName);
  }

/**
 * @brief Get a pre-arranged group min participant count.
 *
 * @param [in] iGrpId The group id.
 *
 * @return The minimum participant count.
 *
 * @see @ref MtcGrp::Mtc_GrpSetMinPartCountL
 */
  public static int Mtc_GrpGetMinPartCount(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpGetMinPartCount(iGrpId);
  }

/**
 * @brief Set a pre-arranged group min participant count(only owner).
 *
 * @param [in] iGrpId The group id.
 * @param [in] iCount The group min participant count.
 *
 * @retval MtcCommonConstants::ZOK Set group min participant count successfully.
 * @retval MtcCommonConstants::ZFAILED Set group min participant count failed.
 *
 * @see @ref MtcGrp::Mtc_GrpGetMinPartCount
 */
  public static int Mtc_GrpSetMinPartCountL(int iGrpId, int iCount) {
    return MtcGrpJNI.Mtc_GrpSetMinPartCountL(iGrpId, iCount);
  }

/**
 * @brief Get a pre-arranged group max participant count.
 *
 * @param [in] iGrpId The group id.
 *
 * @return The maximum participant count.
 *
 * @see @ref MtcGrp::Mtc_GrpSetMaxPartCountL
 */
  public static int Mtc_GrpGetMaxPartCount(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpGetMaxPartCount(iGrpId);
  }

/**
 * @brief Set a pre-arranged group max participant count(only owner).
 *
 * @param [in] iGrpId The group id.
 * @param [in] iCount The group max participant count.
 *
 * @retval MtcCommonConstants::ZOK Set group max participant count successfully.
 * @retval MtcCommonConstants::ZFAILED Set group max participant count failed.
 *
 * @see @ref MtcGrp::Mtc_GrpGetMaxPartCount
 */
  public static int Mtc_GrpSetMaxPartCountL(int iGrpId, int iCount) {
    return MtcGrpJNI.Mtc_GrpSetMaxPartCountL(iGrpId, iCount);
  }

/**
 * @brief Add a entry into one pre-arranged group(only owner) and update change to xdms.
 *
 * The result will be notified by callbacks which were set by 
 * @ref mtcGrpCbEntryAddOk or @ref mtcGrpCbEntryAddFailed.
 *
 * @param [in] iGrpId The group id.
 * @param [in] zCookie The user cookie.
 * @param [in] pcDispName The entry display name.
 * @param [in] pcUri The entry URI.
 *
 * @return The id of entry, add one entry successfully, otherwise return ZMAXUINT.
 *
 * @see @ref MtcGrp::Mtc_GrpGetSize
 */
  public static int Mtc_GrpAddEntry(int iGrpId, Object zCookie, String pcDispName, String pcUri) {
    return MtcGrpJNI.Mtc_GrpAddEntry(iGrpId, zCookie, pcDispName, pcUri);
  }

/**
 * @brief Add a entry into one pre-arranged group(only owner).
 *
 * @param [in] iGrpId The group id.
 * @param [in] zCookie The user cookie.
 * @param [in] pcDispName The entry display name.
 * @param [in] pcUri The entry URI.
 *
 * @return The id of entry when add one entry successfully, otherwise return ZMAXUINT.
 *
 * @see @ref MtcGrp::Mtc_GrpGetSize
 */
  public static int Mtc_GrpAddEntryL(int iGrpId, Object zCookie, String pcDispName, String pcUri) {
    return MtcGrpJNI.Mtc_GrpAddEntryL(iGrpId, zCookie, pcDispName, pcUri);
  }

/**
 * @brief Remove one entry from pre-arranged group and update change to xdms.
 *
 * The result will be notified by callbacks which were set by 
 * @ref mtcGrpCbEntryRmvOk or @ref mtcGrpCbEntryRmvFailed.
 *
 * @param [in] iEntryId The id of entry.
 *
 * @retval MtcCommonConstants::ZOK Start to remove one entry successfully.
 * @retval MtcCommonConstants::ZFAILED Start to remove one entry failed.
 *
 * @see @ref MtcGrp::Mtc_GrpAddEntry
 */
  public static int Mtc_GrpRmvEntry(int iEntryId) {
    return MtcGrpJNI.Mtc_GrpRmvEntry(iEntryId);
  }

/**
 * @brief Remove one entry from OMA pre-arranged group.
 *
 * @param [in] iEntryId The id of entry.
 *
 * @retval MtcCommonConstants::ZOK Start to remove one entry successfully.
 * @retval MtcCommonConstants::ZFAILED Start to remove one entry failed.
 *
 * @see @ref MtcGrp::Mtc_GrpAddEntry
 */
  public static int Mtc_GrpRmvEntryL(int iEntryId) {
    return MtcGrpJNI.Mtc_GrpRmvEntryL(iEntryId);
  }

/**
 * @brief Get OMA entry from one pre-arranged group.
 *
 * @param [in] iGrpId The group id.
 *
 * @return Entry set size.
 *
 * @see @ref MtcGrp::Mtc_GrpGetEntry
 */
  public static int Mtc_GrpGetSize(int iGrpId) {
    return MtcGrpJNI.Mtc_GrpGetSize(iGrpId);
  }

/**
 * @brief Get an entry from one pre-arranged group by index.
 *
 * @param [in] iGrpId The group id.
 * @param [in] iIndex The index of entry.
 *
 * @return One Entry Id.
 *
 * @see @ref MtcGrp::Mtc_GrpGetSize
 */
  public static int Mtc_GrpGetEntry(int iGrpId, int iIndex) {
    return MtcGrpJNI.Mtc_GrpGetEntry(iGrpId, iIndex);
  }

/**
 * @brief Find an entry from one pre-arranged group.
 *
 * @param [in] iGrpId The group id.
 * @param [in] pcUri The entry uri.
 *
 * @return The entry id.
 *
 * @see @ref MtcGrp::Mtc_GrpGetEntry
 */
  public static int Mtc_GrpFindEntry(int iGrpId, String pcUri) {
    return MtcGrpJNI.Mtc_GrpFindEntry(iGrpId, pcUri);
  }

/**
 * @brief Get entry cookie id.
 *
 * @param [in] iEntryId The id of entry.
 *
 * @return Entry cookie id. 
 *
 * @see @ref MtcGrp::Mtc_GrpEntrySetCookie
 */
  public static Object Mtc_GrpEntryGetCookie(int iEntryId) {
    return MtcGrpJNI.Mtc_GrpEntryGetCookie(iEntryId);
  }

/**
 * @brief Set entry cookie id.
 *
 * @param [in] iEntryId The id of entry.
 * @param [in] zCookie The cookie id of entry.
 *
 * @retval MtcCommonConstants::ZOK Set entry cookie id successfully.
 * @retval MtcCommonConstants::ZFAILED Set entry cookie id failed.
 *
 * @see @ref MtcGrp::Mtc_GrpEntryGetCookie
 */
  public static int Mtc_GrpEntrySetCookie(int iEntryId, Object zCookie) {
    return MtcGrpJNI.Mtc_GrpEntrySetCookie(iEntryId, zCookie);
  }

/**
 * @brief Get an entry display name.
 *
 * @param [in] iEntryId The entry id.
 *
 * @return Entry display name.
 * The caller must copy it, then use.
 *
 * @see @ref MtcGrp::Mtc_GrpEntrySetDispName
 */
  public static String Mtc_GrpEntryGetDispName(int iEntryId) {
    return MtcGrpJNI.Mtc_GrpEntryGetDispName(iEntryId);
  }

/**
 * @brief Set an entry display name and update change to xdms.
 *
 * @param [in] iEntryId The entry id.
 * @param [in] pcDispName The display Name.
 *
 * @retval MtcCommonConstants::ZOK Set display name successfully.
 * @retval MtcCommonConstants::ZFAILED Set display name failed.
 *
 * @see @ref MtcGrp::Mtc_GrpEntryGetDispName
 */
  public static int Mtc_GrpEntrySetDispName(int iEntryId, String pcDispName) {
    return MtcGrpJNI.Mtc_GrpEntrySetDispName(iEntryId, pcDispName);
  }

/**
 * @brief Set an entry display name.
 *
 * @param [in] iEntryId The entry id.
 * @param [in] pcDispName The display Name.
 *
 * @retval MtcCommonConstants::ZOK Set display name successfully.
 * @retval MtcCommonConstants::ZFAILED Set display name failed.
 *
 * @see @ref MtcGrp::Mtc_GrpEntryGetDispName
 */
  public static int Mtc_GrpEntrySetDispNameL(int iEntryId, String pcDispName) {
    return MtcGrpJNI.Mtc_GrpEntrySetDispNameL(iEntryId, pcDispName);
  }

/**
 * @brief Get an entry uri.
 *
 * @param [in] iEntryId The entry id.
 *
 * @return Entry uri.
 * The caller must copy it, then use.
 *
 * @see @ref MtcGrp::Mtc_GrpEntryGetDispName
 */
  public static String Mtc_GrpEntryGetUri(int iEntryId) {
    return MtcGrpJNI.Mtc_GrpEntryGetUri(iEntryId);
  }

/**
 * @brief Get the pre-arranged group id of one entry.
 *
 * @param [in] iEntryId The entry id.
 *
 * @return The group id.
 *
 * @see @ref MtcGrp::Mtc_GrpEntryGetDispName
 */
  public static int Mtc_GrpEntryGetGrpId(int iEntryId) {
    return MtcGrpJNI.Mtc_GrpEntryGetGrpId(iEntryId);
  }

}