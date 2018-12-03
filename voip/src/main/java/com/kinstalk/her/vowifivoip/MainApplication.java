package com.kinstalk.her.vowifivoip;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.juphoon.cmcc.app.lemon.MtcProvDb;
import com.juphoon.rcs.JRAccount;
import com.juphoon.rcs.JRAutoConfig;
import com.juphoon.rcs.JRAutoConfigCallback;
import com.juphoon.rcs.JRAutoConfigState;
import com.juphoon.rcs.JRCall;
import com.juphoon.rcs.JRCallCallback;
import com.juphoon.rcs.JRCallConstants;
import com.juphoon.rcs.JRCallItem;
import com.juphoon.rcs.JRCallMember;
import com.juphoon.rcs.JRCallStorage;
import com.juphoon.rcs.JRClient;
import com.juphoon.rcs.JRClientCallback;
import com.juphoon.rcs.JRClientConstants;
import com.juphoon.rcs.JRLog;
import com.juphoon.rcs.JRMessage;
import com.juphoon.rcs.JRMessageCallback;
import com.juphoon.rcs.JRMessageItem;
import com.juphoon.rcs.utils.MtcAudioUtils;
import com.kinstalk.her.voipmode.VoWifiPublicMode;
import com.kinstalk.her.voipmode.data.StatusSP;
import com.kinstalk.util.SystemProperty;

import common.RealmDataHelper;
import common.RealmHelper;
import common.utils.JRNumberUtils;
import io.realm.Realm;

import static com.kinstalk.her.dialer.ForceRequestPermissionsActivity.ACTION_FINISH;

/**
 * Created by Upon on 2017/12/17.
 */

public class MainApplication extends Application implements
        JRCallCallback, JRClientCallback, JRMessageCallback, JRAutoConfigCallback {
    private static final String TAG = "MainApplication";
    /**
     * 此action表示设备绑定
     */
    private static final String ACTION_DEVICE_BIND_FROM_WOLINK = "com.kinstalk.ipdev.bind";
    /**
     * 此action表示设备解绑
     */
    public static final String ACTION_DEVICE_UNBIND_FROM_WOLINK = "com.kinstalk.ipdev.unbind";
    public static final String CUEI_PROPERTY_KEY = "ro.product.cuei";
    /**
     * 0表示联通网络，1表示非联通
     */
    public static final String WOLINK_NETWORK_KEY = "wolink_homenet";
    /**
     * 0表示绑定正常，1表示未绑定，2表示当前不在固话归属地
     */
    public static final String WOLINK_BIND_KEY = "wolink_phonebind";
    public static Context sApp;

    public static final String DMS_ADRESS = "https://dms.digits8.com/dms/getConf";

    public static final String DEFAULT_CUEI = "200016030000001";

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "Get broadcast: " + intent.getAction());
            int networkStatus = Settings.System.getInt(getContentResolver(), WOLINK_NETWORK_KEY, 1);
            int bindStatus = Settings.System.getInt(getContentResolver(), WOLINK_BIND_KEY, 1);
            String CUEI = SystemProperty.get(CUEI_PROPERTY_KEY, DEFAULT_CUEI);
            Log.e(TAG, "onReceive: networkStatus:" + networkStatus + ",bindStatus:" + bindStatus + ",CUEI:" + CUEI);
            if (ACTION_DEVICE_BIND_FROM_WOLINK.equals(intent.getAction())) {
                if (bindStatus == 0 && networkStatus == 0) {
                    //如果是绑定状态，就直接激活VoWifi功能
                    initSDK();
                    StatusSP.setIpdevLogout(0);
                } else if (bindStatus == 1) {
                    //如果未绑定，需要传CUEI给sdk通知它拉取
                    if (!TextUtils.isEmpty(CUEI)) {
                        MtcProvDb.Mtc_ProvDbSetImei(CUEI);
//                        initSDK();
                        JRClient.getInstance().logout();
                        StatusSP.setIpdevLogout(1);
                    } else {
                        Log.e(TAG, "onReceive: CUEI is null");
                        JRClient.getInstance().logout();
                        StatusSP.setIpdevLogout(1);
                    }
                } else if (bindStatus == 2) {
//                    JRClient.getInstance().logout();
//                    StatusSP.setIpdevLogout(1);
//                    Log.e(TAG, "onReceive: 当前不在固话归属地");
//                    initSDK();
                } else if (networkStatus == 1) {
                    JRClient.getInstance().logout();
                    StatusSP.setIpdevLogout(1);
                    Log.e(TAG, "onReceive: 不在联通网络");
                }
            } else if (ACTION_DEVICE_UNBIND_FROM_WOLINK.equals(intent.getAction())) {
                Log.e(TAG, "onReceive: ACTION_DEVICE_UNBIND_FROM_WOLINK so logout");
                if (StatusSP.getLoginStatus() == 1) {
//                    JRClient.getInstance().logout();
                    StatusSP.setIpdevLogout(1);
                }
            }
        }
    };

    @Override
    public void onCreate() {
        sApp = this;
        registerReceiver();

        //todo:如果自动配置完成，就不能在这里initSDK
        int networkStatus = Settings.System.getInt(getContentResolver(), WOLINK_NETWORK_KEY, 1);
        int bindStatus = Settings.System.getInt(getContentResolver(), WOLINK_BIND_KEY, 1);
        Log.e(TAG, "onCreate: networkStatus:" + networkStatus + ",bindStatus:" + bindStatus);

        //init包括了login,因为我在init成功以后会login
        initSDK();

        super.onCreate();
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_DEVICE_BIND_FROM_WOLINK);
        filter.addAction(ACTION_DEVICE_UNBIND_FROM_WOLINK);
        registerReceiver(receiver, filter);
    }

    @Override
    public void onCallItemUpdated(JRCallItem item, JRCallConstants.Error error, int updateType) {

    }

    @Override
    public void onCallItemRemove(JRCallItem item, JRCallConstants.TremReason reason) {

    }

    @Override
    public void onCallItemAdd(JRCallItem item) {
        if (JRCallStorage.getInstance().getCurItem() != null) {
            JRLog.log("yidao", "当前有活跃callItem 不需要启动activity");
            return;
        }
        Intent intent = new Intent(this, JRCallActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra(JRCommonValue.JRCALL_EXTRA_SESSION_ID, item.getCallId());
        startActivity(intent);
    }

    /**
     * *********************************vowifi*****************************
     */
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 100;
    private Realm mRealm;
    private ProgressDialog mProgress;

    private void initSDK() {
        SDKInitializer.initialize(this);
        Realm.init(this);
        MtcAudioUtils.init(this);
        JRCall.getInstance().addCallback(this);
        JRAutoConfig.getInstance().addCallback(this);
        JRClient.getInstance().addCallback(this);
        JRClient.getInstance().startInitWithAppkey(this, "27b118baebd5227a3d03663a759be3cb");
    }

    private void login() {
        if (mProgress != null) {
            mProgress.setMessage("登录中");
            mProgress.show();
        }
        VoWifiPublicMode.login(StatusSP.getLoginAccount());
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onClientInitResult(boolean result, JRClientConstants.JRClientReason reason) {
        if (result) {
//            Toast.makeText(this, "sdk初始化成功", Toast.LENGTH_SHORT).show();
            RealmDataHelper.init(this);
            JRMessage.getInstance().addCallback(this);
            Log.i(TAG, "onClientInitResult: account:" + JRAccount.getInstance().getAccountList().size());
            //todo:判断是否是联通网络
            int network_status = Settings.System.getInt(getContentResolver(), WOLINK_NETWORK_KEY, 1);
            int bindStatus = Settings.System.getInt(getContentResolver(), WOLINK_BIND_KEY, 2);
            Log.i(TAG, "onClientInitResult: network_status:" + network_status);
            if (JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED
//                    && JRAccount.getInstance().getAccountList().size() > 0
//                    && StatusSP.getLoginStatus() == 1
                    //todo
//                    && network_status == 0
                    && bindStatus != 1) {
                //为了重启后自动登录
                Log.e(TAG, "onClientInitResult: will autoConfig");
                autoConfig();
//                login();
            } else if (network_status != 0) {
                //如果不是联通网络，就登出
                //todo
                Log.e(TAG, "onClientInitResult: not cu network,当前非联通网络");
                Toast.makeText(this, getString(R.string.not_cu_network), Toast.LENGTH_SHORT).show();
                JRClient.getInstance().logout();
                if (mProgress != null) {
                    mProgress.dismiss();
                }
            } else if (bindStatus == 2) {
                Log.e(TAG, "onClientInitResult: not number place,当前不在号码归属地");
                Toast.makeText(this, getString(R.string.not_number_address), Toast.LENGTH_SHORT).show();
//                JRClient.getInstance().logout();
                if (mProgress != null) {
                    mProgress.dismiss();
                }
            }
        } else {
            Log.e(TAG, "onClientInitResult,reson:" + reason);
            Toast.makeText(this, "sdk初始化失败" + reason, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClientLoginResult(boolean result, JRClientConstants.JRClientRegErrorCode jrClientRegErrorCode) {
        if (mProgress != null) {
            mProgress.dismiss();
        }
        if (result) {
            mRealm = RealmHelper.getInstance();
            if (StatusSP.getLoginStatus() == 0) {  //防止被多次回调后弹出多个toast
                Log.e(TAG, "onClientLoginResult: 已登录");
                Toast.makeText(this, "VoWifi已登录", Toast.LENGTH_SHORT).show();
            }
            StatusSP.setLoginStatus(1);
            sendBroadcast(new Intent(ACTION_FINISH));
        } else {
            Log.e(TAG, "onClientLoginResult: errorCode:" + jrClientRegErrorCode);
        }
    }

    @Override
    public void onClientLogoutResult() {
        Log.e(TAG, "onClientLogoutResult: ");
        if (mProgress != null) {
            mProgress.dismiss();
        }
        if (JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED) {
            StatusSP.setLoginStatus(0);
            Toast.makeText(this, "VoWifi已登出", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClientStateChange(JRClientConstants.JRClientState jrClientState, int reason) {
        Log.i(TAG, "onClientStateChange: state:" + jrClientState + ",reason:" + reason
                + ",state:" + JRClient.getInstance().getState());
        if (JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED) {
            String errorString = JRNumberUtils.getStatMsg(reason, this);
            if (!TextUtils.isEmpty(errorString)) {
                Toast.makeText(this, errorString, Toast.LENGTH_SHORT).show();
                //如果登录出现error，就logout这个错误的账号，以防sdk一直重试
                JRClient.getInstance().logout();
            }
        }
        if (mProgress != null) {
            mProgress.dismiss();
        }
    }

    @Override
    public void onTextMessageUpdate(JRMessageItem jrMessageItem) {
        if (jrMessageItem != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, jrMessageItem);
        }
    }

    @Override
    public void onFileMessageUpdate(JRMessageItem jrMessageItem) {
        if (jrMessageItem != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, jrMessageItem);
        }
    }

    @Override
    public void onGeoMessageUpdate(JRMessageItem jrMessageItem) {
        if (jrMessageItem != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, jrMessageItem);
        }
    }

    @Override
    public void onTextMessageReceive(JRMessageItem jrMessageItem) {
        if (jrMessageItem != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, jrMessageItem);
        }
    }

    @Override
    public void onFileMessageReceive(JRMessageItem jrMessageItem) {
        if (jrMessageItem != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, jrMessageItem);
        }
    }

    @Override
    public void onGeoMessageReceive(JRMessageItem jrMessageItem) {
        if (jrMessageItem != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, jrMessageItem);
        }
    }

    public static void autoConfig() {
        Log.i(TAG, "autoConfig: ");
//        String CUEI = SystemProperty.get(CUEI_PROPERTY_KEY, DEFAULT_CUEI);
//        if (!TextUtils.isEmpty(CUEI)) {
//            Log.e(TAG, "autoConfig: CUEI:"+CUEI);
            JRAutoConfig.getInstance().startAutoConfig(DMS_ADRESS, DEFAULT_CUEI, "");
//        } else {
//            Toast.makeText(sApp, sApp.getString(R.string.cuei_null), Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void onAutoConfigResult(boolean b) {
        Log.e(TAG, "onAutoConfigResult: result:" + b);
    }

    @Override
    public void onAutoConfigReceivedAgreement(String s, String s1) {
        Log.e(TAG, "onAutoConfigReceivedAgreement: s:" + s + ",s1:" + s1);
        JRAutoConfig.getInstance().acceptAgreement();
    }

    @Override
    public void onAutoConfigStateChanged(int i) {
        Log.e(TAG, "onAutoConfigStateChanged: i" + i);
    }
}
