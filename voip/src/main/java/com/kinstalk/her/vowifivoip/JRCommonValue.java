package com.kinstalk.her.vowifivoip;

import com.juphoon.cmcc.app.lemon.MtcCallConstants;
import com.juphoon.cmcc.app.lemon.MtcCliConstants;
import com.juphoon.cmcc.app.lemon.MtcConfConstants;
import com.juphoon.cmcc.app.lemon.MtcImConstants;

/**
 * Created by Upon on 2018/2/7.
 */

public class JRCommonValue implements MtcCallConstants,MtcImConstants,MtcConfConstants,MtcCliConstants{
    public static final String JRCALL_EXTRA_SESSION_ID = "call_session_id";
    public static final String JRCALL_EXTRA_PHONE_NUMBER = "call_phone_number";
    public static final String JRCALL_EXTRA_IS_VIDEO = "call_is_video";
    public static final String JRCALL_EXTRA_IS_MULTI = "call_is_multi";
}
