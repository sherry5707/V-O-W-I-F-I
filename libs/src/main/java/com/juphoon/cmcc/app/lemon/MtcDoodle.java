/**
 * @file MtcDoodle.java
 * @brief MtcDoodle interface
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
 * @brief MtcDoodle interface
 */
public class MtcDoodle implements MtcDoodleConstants {
/**
 * @brief Create image object.
 * @return            Image object.
 */
  public static long Mtc_DoodleCreateImage() {
    return MtcDoodleJNI.Mtc_DoodleCreateImage();
  }

/**
 * @brief Delete image object.
 * @param  zImage The image object.
 */
  public static void Mtc_DoodleDeleteImage(long zImage) {
    MtcDoodleJNI.Mtc_DoodleDeleteImage(zImage);
  }

/**
 * @brief Create image object from text.
 * @param  pcMsg The text.
 * @return       The Image object.
 */
  public static long Mtc_DoodleParseImage(String pcMsg) {
    return MtcDoodleJNI.Mtc_DoodleParseImage(pcMsg);
  }

/**
 * @brief Save image object to text.
 * @param  zImage The image object.
 * @return        The text string.
 */
  public static String Mtc_DoodlePrintImage(long zImage) {
    return MtcDoodleJNI.Mtc_DoodlePrintImage(zImage);
  }

/**
 * @brief Set image attributes.
 * @param  zImage The image object.
 * @param  pcInfo The attributes in JSON format which contains
 *                @ref MtcDoodlePageIdKey
 *                @ref MtcDoodleImageTypeKey
 *                @ref MtcDoodleImageNameKey
 *                @ref MtcDoodleImageUriKey
 *                @ref MtcDoodleResolutionKey
 *                @ref MtcDoodlePositionKey
 * @return        MtcCommonConstants::ZOK on succeed, otherwise failed.
 */
  public static int Mtc_DoodleSetImageAttr(long zImage, String pcInfo) {
    return MtcDoodleJNI.Mtc_DoodleSetImageAttr(zImage, pcInfo);
  }

/**
 * @brief Get image attributes.
 * @param  zImage The image object.
 * @return        The attributes in JSON format which contains
 *                @ref MtcDoodlePageIdKey
 *                @ref MtcDoodleImageTypeKey
 *                @ref MtcDoodleImageNameKey
 *                @ref MtcDoodleImageUriKey
 *                @ref MtcDoodleResolutionKey
 *                @ref MtcDoodlePositionKey
 */
  public static String Mtc_DoodleGetImageAttr(long zImage) {
    return MtcDoodleJNI.Mtc_DoodleGetImageAttr(zImage);
  }

/**
 * @brief Create action object.
 * @return            The action object.
 */
  public static long Mtc_DoodleCreateAction() {
    return MtcDoodleJNI.Mtc_DoodleCreateAction();
  }

/**
 * @brief Delete action object.
 * @param  zAction The action object.
 */
  public static void Mtc_DoodleDeleteAction(long zAction) {
    MtcDoodleJNI.Mtc_DoodleDeleteAction(zAction);
  }

/**
 * @brief Create action object from text.
 * @param  pcMsg The text.
 * @return       The action object.
 */
  public static long Mtc_DoodleParseAction(String pcMsg) {
    return MtcDoodleJNI.Mtc_DoodleParseAction(pcMsg);
  }

/**
 * @brief Save action object to text.
 * @param  zAction The action object.
 * @return         The text string.
 */
  public static String Mtc_DoodlePrintAction(long zAction) {
    return MtcDoodleJNI.Mtc_DoodlePrintAction(zAction);
  }

/**
 * @brief Set action attributes.
 * @param  zAction The action object.
 * @param  pcInfo  The attributes in JSON format which contains
 *                 @ref MtcDoodleActionTypeKey
 *                 @ref MtcDoodleSeqNoKey
 *                 @ref MtcDoodleBrushKey
 *                 @ref MtcDoodlePageIdKey
 *                 @ref MtcDoodleContentKey
 * @return         MtcCommonConstants::ZOK on succeed, otherwise failed.
 */
  public static int Mtc_DoodleSetActionAttr(long zAction, String pcInfo) {
    return MtcDoodleJNI.Mtc_DoodleSetActionAttr(zAction, pcInfo);
  }

/**
 * @brief Get action attributes.
 * @param  zAction The action object.
 * @return         The attributes in JSON format which contains
 *                 @ref MtcDoodleActionTypeKey
 *                 @ref MtcDoodleSeqNoKey
 *                 @ref MtcDoodleBrushKey
 *                 @ref MtcDoodlePageIdKey
 *                 @ref MtcDoodleContentKey
 */
  public static String Mtc_DoodleGetActionAttr(long zAction) {
    return MtcDoodleJNI.Mtc_DoodleGetActionAttr(zAction);
  }

/**
 * @brief Add action position.
 * @param  zAction The action object.
 * @param  fX      The X value from -1.0 to 1.0.
 * @param  fY      The Y value from -1.0 to 1.0.
 * @return         MtcCommonConstants::ZOK on succeed, otherwise failed.
 */
  public static int Mtc_DoodleAddActionPosition(long zAction, float fX, float fY) {
    return MtcDoodleJNI.Mtc_DoodleAddActionPosition(zAction, fX, fY);
  }

/**
 * @brief Set action positions.
 * @param  zAction The action object.
 * @param  fX      The value from -1.0 to 1.0.
 * @param  fY      The value from -1.0 to 1.0.
 * @param  iIntVal The interval.
 * @return         MtcCommonConstants::ZOK on succeed, otherwise failed.
 */
  public static int Mtc_DoodleAddActionPositionX(long zAction, float fX, float fY, int iIntVal) {
    return MtcDoodleJNI.Mtc_DoodleAddActionPositionX(zAction, fX, fY, iIntVal);
  }

/**
 * @brief Get count of positions in action object.
 * @param  zAction The action object.
 * @return         The count of positions.
 */
  public static int Mtc_DoodleGetActionPositionCount(long zAction) {
    return MtcDoodleJNI.Mtc_DoodleGetActionPositionCount(zAction);
  }

/**
 * @brief Get the interval of position.
 * @param  zAction The action object.
 * @param  iIndex  The index of position, from 0 to count-1.
 * @return         The interval in milliseconds.
 */
  public static int Mtc_DoodleGetActionIntval(long zAction, int iIndex) {
    return MtcDoodleJNI.Mtc_DoodleGetActionIntval(zAction, iIndex);
  }

/**
 * @brief Get the X value of position.
 * @param  zAction The action object.
 * @param  iIndex  The index of position, from 0 to count-1.
 * @return         The X value of postion.
 */
  public static float Mtc_DoodleGetActionPositionX(long zAction, int iIndex) {
    return MtcDoodleJNI.Mtc_DoodleGetActionPositionX(zAction, iIndex);
  }

/**
 * @brief Get the Y value of position.
 * @param  zAction The action object.
 * @param  iIndex  The index of position, from 0 to count-1.
 * @return         The Y value of postion.
 */
  public static float Mtc_DoodleGetActionPositionY(long zAction, int iIndex) {
    return MtcDoodleJNI.Mtc_DoodleGetActionPositionY(zAction, iIndex);
  }

/**
 * @brief Get the path of action.
 * @param  zAction The action object.
 * @return         The path in JSON format which is array contains
 *                 all positions. Each position is array of number.
 *                 First number is interval in milliseoncds.
 *                 Second number is X value of position.
 *                 Third number is Y value of position.
 */
  public static String Mtc_DoodleGetActionPath(long zAction) {
    return MtcDoodleJNI.Mtc_DoodleGetActionPath(zAction);
  }

/**
 * @brief Create session object.
 * @return            The session object.
 */
  public static long Mtc_DoodleCreateSession() {
    return MtcDoodleJNI.Mtc_DoodleCreateSession();
  }

/**
 * @brief Delete session object.
 * @param  zSession The session object.
 */
  public static void Mtc_DoodleDeleteSession(long zSession) {
    MtcDoodleJNI.Mtc_DoodleDeleteSession(zSession);
  }

/**
 * @brief Set page count.
 * @param  zSession The session object.
 * @param  iCount   The count of pages.
 * @return          MtcCommonConstants::ZOK on succeed, otherwise failed.
 */
  public static int Mtc_DoodleSessionSetPageCount(long zSession, int iCount) {
    return MtcDoodleJNI.Mtc_DoodleSessionSetPageCount(zSession, iCount);
  }

/**
 * @brief Add image object to session.
 *
 * You must not delete image after add this image to the session.
 * The image will replace the exist one with same MtcDoodlePageIdKey.
 * 
 * @param  zSession The session object.
 * @param  zImage   The image object.
 * @return          MtcCommonConstants::ZOK on succeed, otherwise failed.
 */
  public static int Mtc_DoodleSessionAddImage(long zSession, long zImage) {
    return MtcDoodleJNI.Mtc_DoodleSessionAddImage(zSession, zImage);
  }

/**
 * @brief Get the count of image.
 * @param  zSession The session object.
 * @return          The count of images.
 */
  public static int Mtc_DoodleSessionGetImageCount(long zSession) {
    return MtcDoodleJNI.Mtc_DoodleSessionGetImageCount(zSession);
  }

/**
 * @brief Enumrate the image object.
 * @param  zSession The session object.
 * @param  iIndex   The index of image, from 0 to count-1.
 * @return          The image object.
 */
  public static long Mtc_DoodleSessionEnumImage(long zSession, int iIndex) {
    return MtcDoodleJNI.Mtc_DoodleSessionEnumImage(zSession, iIndex);
  }

/**
 * @brief Add action object to session.
 * @param  zSession The session object.
 * @param  bSelf    true indicates the action was taken by self.
 *                  Otherwise the actions was taken by peer.
 * @param  zAction  The action object.
 * @return          MtcCommonConstants::ZOK on succeed, otherwise failed.
 */
  public static int Mtc_DoodleSessionAddAction(long zSession, boolean bSelf, long zAction) {
    return MtcDoodleJNI.Mtc_DoodleSessionAddAction(zSession, bSelf, zAction);
  }

/**
 * @brief Get count of actions.
 * @param  zSession The session object.
 * @return          The count of actions.
 */
  public static int Mtc_DoodleSessionGetActionCount(long zSession) {
    return MtcDoodleJNI.Mtc_DoodleSessionGetActionCount(zSession);
  }

/**
 * @brief Enumrate the actions in session.
 * @param  zSession The session object.
 * @param  iIndex   The index of action, from 0 to count-1.
 * @return          The action object.
 */
  public static long Mtc_DoodleSessionEnumAction(long zSession, int iIndex) {
    return MtcDoodleJNI.Mtc_DoodleSessionEnumAction(zSession, iIndex);
  }

/**
 * @brief Enumrate the self flags in session.
 * @param  zSession The session object.
 * @param  iIndex   The index of action, from 0 to count-1.
 * @return          The self flag.
 */
  public static boolean Mtc_DoodleSessionEnumSelf(long zSession, int iIndex) {
    return MtcDoodleJNI.Mtc_DoodleSessionEnumSelf(zSession, iIndex);
  }

}