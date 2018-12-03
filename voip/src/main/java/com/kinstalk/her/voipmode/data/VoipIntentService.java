package com.kinstalk.her.voipmode.data;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.github.promeg.pinyinhelper.Pinyin;
import com.kinstalk.her.dialer.DialtactsActivity;
import com.kinstalk.her.voipmode.VoWifiPublicMode;
import com.kinstalk.her.voipmode.utils.RegexItem;
import com.kinstalk.her.voipmode.utils.RegexList;
import com.kinstalk.her.vowifivoip.MainApplication;
import com.kinstalk.her.vowifivoip.R;
import com.kinstalk.qloveaicore.AIManager;
import com.kinstalk.qloveaicore.CmdCallback;
import com.tencent.xiaowei.info.QLoveResponseInfo;
import com.tencent.xiaowei.info.XWResponseInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kinstalk.com.qloveaicore.AICoreDef;

import static com.kinstalk.her.dialer.DialtactsActivity.EXTRA_SHOW_TAB;
import static com.kinstalk.her.dialer.list.ListsFragment.TAB_INDEX_ALL_CONTACTS;
import static com.kinstalk.her.dialer.list.ListsFragment.TAB_INDEX_HISTORY;
import static com.kinstalk.her.dialer.list.ListsFragment.TAB_SHOW_DIAPAD;

public class VoipIntentService extends IntentService {
    private static final String TAG = "VoipIntentService";
    private static final String INTENT_MAKE_CALL = "makeCall";
    private static final String INTENT_OPEN_CALL_LOG = "openCallRecord";
    private static final String INTENT_OPEN_CMCC_VOIP = "openCmccVoip";
    private static final String INTENT_OPEN_CONTACTS = "openContactList";
    private static final String INTENT_OPEN_DIAPADS = "openNumerKeyboard";
    private static final String INTENT_RECALL = "reCall";
    private static final String INTENT_REJECTCALL = "rejectCmccVoipCall";
    private static final String INTENT_ACCEPTCALL = "acceptCmccVoipCall";
    private static final String INTENT_UPDATELOG = "reportCmccVoipLog";

    private static final MyCallback callback = new MyCallback();

    private static class MyCallback extends CmdCallback {

        @Override
        public void handleQLoveResponseInfo(String s, QLoveResponseInfo qLoveResponseInfo, byte[] bytes) {
            Log.i(TAG, "handleQLoveResponseInfo,s:" + s + ",qLoveResponseInfo:" + qLoveResponseInfo + ",bytes:" + bytes);
            //app在AICore中的注册成功后，后续相关的语音命令处理工作都在改方法中处理。
            //voip 相关工作[开始]
            processData(s, qLoveResponseInfo, bytes);
            //voip 相关工作[结束]
        }
    }

    public VoipIntentService() {
        super("VoipIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onHandleIntent: ");
        if (intent != null) {
            String voiceId = intent.getStringExtra(AICoreDef.AI_INTENT_SERVICE_VOICEID);
            QLoveResponseInfo rspData = intent.getParcelableExtra(AICoreDef.AI_INTENT_SERVICE_INFO);
            byte[] extendData = intent.getByteArrayExtra(AICoreDef.AI_INTENT_SERVICE_DATA);
            //Log.d(TAG, " onHandleIntent ");
            Log.d(TAG, " intent service " + intent + "rspData " + rspData + " extradata " + extendData);
            //app在未注册到AICore时，处理相关的语音，后续流程会有注册动作，
            //后续的处理工作在CmdCallback的回调方法handleQLoveResponseInfo中执行。
            //XXXXXXX 相关工作[开始]
            processData(voiceId, rspData, extendData);
        }
    }

    /**
     * 相关工作的示例方法，请按照应用实际情况定义
     */
    @SuppressLint("StringFormatInvalid")
    private static void processData(String voiceId, QLoveResponseInfo qLoveResponseInfo, byte[] extendData) {
        if (qLoveResponseInfo != null) {
            XWResponseInfo xwResponseInfo = qLoveResponseInfo.xwResponseInfo;
            Log.e(TAG, "processData: xwResponseInfo:" + xwResponseInfo);
            String requestText = xwResponseInfo.requestText;//语音文本
            Log.i(TAG, "processData: requestText:" + requestText);
            CmdStructure cmd = requestMachRegex(requestText);
            if (cmd != null) {
                if (INTENT_MAKE_CALL.equals(cmd.getIntentName())) {
                    if ("name".equals(cmd.getKey())) {
                        Log.i(TAG, "processData: call out by name:" + cmd.getValue());
                        if (!TextUtils.isEmpty(cmd.getValue())) {
                            String pinyin = "";
                            for (char c : cmd.getValue().toCharArray()) {
                                pinyin = pinyin + Pinyin.toPinyin(c);
                            }
                            Log.i(TAG, "processData: INTENT_MAKE_CALL by name,pingying:" + pinyin);
                            String number = MyDBProviderHelper.getNumberByPinYin(pinyin);
                            if (!TextUtils.isEmpty(number)) {
                                VoWifiPublicMode.callOut(MainApplication.sApp, number);
                            } else {
                                Log.i(TAG, "processData: INTENT_MAKE_CALL,no such contact");
                                AIManager.getInstance(MainApplication.sApp).playTextWithStr(
                                        String.format(MainApplication.sApp.getString(R.string.voice_callout_no_contacts),
                                                cmd.getValue()), null);
                            }
                        }
                    } else if ("number".equals(cmd.getKey())) {
                        Log.i(TAG, "processData: call out by number:" + cmd.getValue());
                        VoWifiPublicMode.callOut(MainApplication.sApp, cmd.getValue());
                    }
                }
            }
        }
    }

    private static CmdStructure requestMachRegex(String requestText) {
        ArrayList<RegexItem> regexList = new RegexList().contents;
        int k = 0;
        for (int num = 0; num < regexList.size(); num++) {
            Pattern r = regexList.get(num).regex;
            String[] tags = regexList.get(num).tags;

            // 现在创建 matcher 对象
            Matcher m = r.matcher(requestText);
            if (m.find()) {
                System.out.println("Pattern: " + r.pattern());
                System.out.println(requestText + ">>> Much: " + m.group(0));
                String key = null;
                String value = null;
                for (int seq = 1; seq <= tags.length; seq++) {
                    System.out.println(tags[seq - 1] + ": " + m.group(seq));
                    key = tags[seq - 1];
                    value = m.group(seq);
                }
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    CmdStructure cmd;
                    if(!isValueNumber(value)) {
                         cmd= new CmdStructure(regexList.get(num).intentName, "name", value);
                    }else {
                        cmd= new CmdStructure(regexList.get(num).intentName, "number", value);
                    }
                    Log.i(TAG, "requestMachRegex: cmd:" + cmd);
                    return cmd;
                }
                k++;
            } else {
                System.out.println("NO MATCH: " + requestText);
            }
        }
        return null;
    }

    /**
     * 判断是否是电话号码
     * @param value
     * @return
     */
    private static boolean isValueNumber(String value) {
        String number;
        try {
            number = String.valueOf(Long.parseLong(value));
            return true;
        } catch (NumberFormatException e) {
            Log.i(TAG, "isValueNumber: not number");
            return false;
        }
    }

    public static String buildJson(String type, String pkg, String svc) {
        JSONObject json = new JSONObject();
        try {
            json.put("type", type);
            json.put("pkg", pkg);
            json.put("svcClass", svc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
