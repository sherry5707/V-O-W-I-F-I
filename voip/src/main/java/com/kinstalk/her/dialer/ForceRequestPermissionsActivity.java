/*
 * Copyright (C) 2015 add by geniusgithub begin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kinstalk.her.dialer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.juphoon.cmcc.app.lemon.MtcCliCfgConstants;
import com.juphoon.cmcc.app.lemon.MtcCliDbConstants;
import com.juphoon.rcs.JRAccount;
import com.juphoon.rcs.JRAccountConstants;
import com.juphoon.rcs.JRClient;
import com.juphoon.rcs.JRClientCallback;
import com.juphoon.rcs.JRClientConstants;
import com.juphoon.rcs.JRMessage;
import com.juphoon.rcs.JRMessageCallback;
import com.juphoon.rcs.JRMessageItem;
import com.kinstalk.her.voipmode.VoWifiPublicMode;
import com.kinstalk.her.voipmode.data.StatusSP;
import com.kinstalk.her.vowifivoip.MainApplication;
import com.kinstalk.her.vowifivoip.R;
import com.yanzhenjie.permission.PermissionListener;

import java.util.HashMap;
import java.util.List;

import common.RealmDataHelper;
import common.RealmHelper;
import common.utils.JRNumberUtils;
import io.realm.Realm;

import static com.kinstalk.her.vowifivoip.MainApplication.WOLINK_BIND_KEY;
import static com.kinstalk.her.vowifivoip.MainApplication.WOLINK_NETWORK_KEY;


@TargetApi(23)
public class ForceRequestPermissionsActivity extends AppCompatActivity implements
        JRClientCallback, JRMessageCallback,
        View.OnClickListener, RadioGroup.OnCheckedChangeListener {


    private final static String TAG = "ForceRequestPermissionsActivity";

    public static final String PREVIOUS_ACTIVITY_INTENT = "previous_intent";
    public static final String ACTION_FINISH = "force_request_action_finish";

    private EditText mEdtAccount;
    private EditText mEdtPassword;
    private EditText mEdtRealm;
    private EditText mEdtPort;
    private EditText mEdtIP;
    private EditText mEdtAuth;
    private Button mSave;
    private RadioGroup mRadioGroupTpt;
    private LinearLayout disableLayout;
    private TextView disableTips;
    private LinearLayout createAccountLayout;

    private BroadcastReceiver bindStatusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (ACTION_FINISH.equals(intent.getAction())) ;
            {
                finish();
            }
        }
    };

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_FINISH);
        this.registerReceiver(bindStatusReceiver, filter);
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");

        //add by mengzhaoxue
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_main_login);
        initView();
        registerReceiver();
        JRClient.getInstance().addCallback(this);
    }

    @SuppressLint("LongLogTag")
    private void initView() {
        int networkStatus = Settings.System.getInt(getContentResolver(), WOLINK_NETWORK_KEY, 1);
        int bindStatus = Settings.System.getInt(getContentResolver(), WOLINK_BIND_KEY, 1);
        disableLayout = (LinearLayout) findViewById(R.id.tips_layout);
        disableTips = (TextView) findViewById(R.id.tips);
        createAccountLayout = (LinearLayout) findViewById(R.id.create_account_layout);
        if (networkStatus == 1) {
            //非联通网络
            disableLayout.setVisibility(View.VISIBLE);
            createAccountLayout.setVisibility(View.GONE);
            disableTips.setText(R.string.required_cunet_promo);
        } else if (bindStatus == 1) {
            disableLayout.setVisibility(View.VISIBLE);
            createAccountLayout.setVisibility(View.GONE);
            disableTips.setText(R.string.required_bind_promo);
        } else if (bindStatus == 2) {
            disableLayout.setVisibility(View.VISIBLE);
            createAccountLayout.setVisibility(View.GONE);
            disableTips.setText(R.string.required_number_home_promo);
        } else if (networkStatus == 0 && bindStatus == 0) {
            disableLayout.setVisibility(View.GONE);
            createAccountLayout.setVisibility(View.VISIBLE);
        }
    }

    private void initLayoutViews() {
        mEdtAccount = (EditText) findViewById(R.id.edt_account);
        mEdtPassword = (EditText) findViewById(R.id.edt_password);
        mEdtRealm = (EditText) findViewById(R.id.edt_realm);
        mEdtPort = (EditText) findViewById(R.id.edt_port);
        mEdtIP = (EditText) findViewById(R.id.edt_ip);
        mEdtAuth = (EditText) findViewById(R.id.edt_auth);
        mSave = (Button) findViewById(R.id.button_save);
        mSave.setOnClickListener(this);
        mRadioGroupTpt = (RadioGroup) findViewById(R.id.radio_group_tpt);
        mRadioGroupTpt.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bindStatusReceiver);
    }

    public static boolean startPermissionActivity(Activity activity) {
        //判断登录状态
        if (StatusSP.getLoginStatus() == 1) {
            return false;
        }
        Intent intent = new Intent(activity, ForceRequestPermissionsActivity.class);
        intent.putExtra(PREVIOUS_ACTIVITY_INTENT, activity.getIntent());
        activity.startActivity(intent);
        activity.finish();
        return true;
    }

    public static void redirect(Activity activity) {
//        mPreviousActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        startActivity(mPreviousActivityIntent);
        Intent intent = new Intent(activity, DialtactsActivity.class);
        activity.startActivity(intent);
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    /**
     * ********************vowifi***********
     */
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 100;
    private Realm mRealm;
    private ProgressDialog mProgress;

    @SuppressLint("LongLogTag")
    private void initViews() {
        mProgress = new ProgressDialog(this);
        mProgress.setCancelable(false);

        initLayoutViews();
        int size = JRAccount.getInstance().getAccountList().size();
        Log.e(TAG, "initViews: account size:" + size);
        if (size == 0) {
            loadTestData();
        }
    }

    private int[] mRadioItems = new int[]{R.id.radio_tpt_udp, R.id.radio_tpt_tcp, R.id.radio_tpt_tls};

    @SuppressLint("LongLogTag")
    private void loadTestData() {
        mEdtAccount.setText("2866667786");
        mEdtPassword.setText("123456");
        mEdtAuth.setText("+862866667786@ngv.ims.chinaunicom.cn");
        mEdtRealm.setText("ngv.ims.chinaunicom.cn");
        mEdtIP.setText("119.4.202.1");
        mRadioGroupTpt.check(mRadioItems[0]);
        mEdtPort.setText("5060");

/*        mEdtAccount.setText("15620470411");
        mEdtPassword.setText("938930");
        mEdtAuth.setText("8615620470411@ims.mnc001.mcc460.3gppnetwork.org");
        mEdtRealm.setText("tj.rcs.ims.mnc001.mcc460.3gppnetwork.org");
        mEdtIP.setText("103.3.99.209");
        mRadioGroupTpt.check(mRadioItems[1]);
        mEdtPort.setText("5460");*/
    }

    private void login() {
        if (mProgress != null) {
            mProgress.setMessage("登录中");
            mProgress.show();
        }
        VoWifiPublicMode.login(mEdtAccount.getText().toString());
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onClientInitResult(boolean result, JRClientConstants.JRClientReason reason) {
        if (result) {
//            Toast.makeText(this, "sdk初始化成功", Toast.LENGTH_SHORT).show();
            RealmDataHelper.init(this);
            JRMessage.getInstance().addCallback(this);
            if (JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED) {
                StatusSP.setLoginStatus(0);
            } else {
                StatusSP.setLoginStatus(1);
            }
            initViews();
//            addTestAccount();
        } else {
            Log.e("", "onClientInitResult: " + reason);
            Toast.makeText(this, "sdk初始化失败" + reason, Toast.LENGTH_SHORT).show();
        }
    }

    //添加天津测试账号，方便调测
    private void addTestAccount() {
        boolean has = JRAccount.getInstance().getAccountList().contains("15620470411");
        if (!has && JRAccount.getInstance().createAccount("15620470411")) {
            HashMap<JRAccountConstants, String> params = new HashMap<>();
            params.put(JRAccountConstants.JRAccountConfigKeyUserName, "+8615620470411");
            params.put(JRAccountConstants.JRAccountConfigKeyAuthName, "8615620470411@ims.mnc001.mcc460.3gppnetwork.org");
            params.put(JRAccountConstants.JRAccountConfigKeyPassword, "938930");
            params.put(JRAccountConstants.JRAccountConfigKeyRegIp, "103.3.99.209");
            params.put(JRAccountConstants.JRAccountConfigKeyRegRealm, "tj.rcs.ims.mnc001.mcc460.3gppnetwork.org");
            params.put(JRAccountConstants.JRAccountConfigKeySipPort, "5460");
            params.put(JRAccountConstants.JRAccountConfigKeySipTransportType, String.valueOf(MtcCliDbConstants.EN_MTC_TPT_TCP));
            params.put(JRAccountConstants.JRAccountConfigKeyRegType, String.valueOf(MtcCliCfgConstants.EN_MTC_REG_SRV_VOIP));
            JRAccount.getInstance().setAccountConfig("15620470411", params);
        }
    }

    @Override
    public void onClientLoginResult(boolean result, JRClientConstants.JRClientRegErrorCode jrClientRegErrorCode) {
        if (mProgress != null) {
            mProgress.dismiss();
        }
        if (result) {
            mRealm = RealmHelper.getInstance();
//            Toast.makeText(this, "已登录", Toast.LENGTH_SHORT).show();
            StatusSP.setLoginStatus(1);
            redirect(this);
        }
    }

    @Override
    public void onClientLogoutResult() {
        if (mProgress != null) {
            mProgress.dismiss();
        }
        StatusSP.setLoginStatus(0);
//        Toast.makeText(this, "已登出", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClientStateChange(JRClientConstants.JRClientState jrClientState, int reason) {
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

    @SuppressLint("LongLogTag")
    @Override
    public void onClick(View view) {
        int id = view.getId();
        int tptType = -1;
        if (id == R.id.button_save) {
            if (!TextUtils.isEmpty(mEdtAccount.getText().toString())) {
                if (JRAccount.getInstance().createAccount(mEdtAccount.getText().toString())) {
                    HashMap<JRAccountConstants, String> params = new HashMap<>();
                    params.put(JRAccountConstants.JRAccountConfigKeyUserName, "+86" + mEdtAccount.getText().toString());
                    params.put(JRAccountConstants.JRAccountConfigKeyAuthName, mEdtAuth.getText().toString());
                    params.put(JRAccountConstants.JRAccountConfigKeyPassword, mEdtPassword.getText().toString());
                    params.put(JRAccountConstants.JRAccountConfigKeyRegIp, mEdtIP.getText().toString());
                    params.put(JRAccountConstants.JRAccountConfigKeyRegRealm, mEdtRealm.getText().toString());
                    params.put(JRAccountConstants.JRAccountConfigKeySipPort, mEdtPort.getText().toString());
                    switch (mRadioGroupTpt.getCheckedRadioButtonId()) {
                        case R.id.radio_tpt_udp:
                            tptType = MtcCliDbConstants.EN_MTC_TPT_UDP;
                            break;
                        case R.id.radio_tpt_tcp:
                            tptType = MtcCliDbConstants.EN_MTC_TPT_TCP;
                            break;
                        case R.id.radio_tpt_tls:
                            tptType = MtcCliDbConstants.EN_MTC_TPT_TLS;
                            break;
                    }
                    params.put(JRAccountConstants.JRAccountConfigKeySipTransportType, String.valueOf(tptType));
                    params.put(JRAccountConstants.JRAccountConfigKeyRegType, String.valueOf(MtcCliCfgConstants.EN_MTC_REG_SRV_VOIP));
                    JRAccount.getInstance().setAccountConfig(mEdtAccount.getText().toString(), params);
                    int network_status = Settings.System.getInt(getContentResolver(), WOLINK_NETWORK_KEY, 1);
                    int bindStatus = Settings.System.getInt(getContentResolver(), WOLINK_BIND_KEY, 1);
                    if (network_status == 0 && bindStatus == 0) {
                        login();
                    } else if (network_status != 0) {
                        //如果不是联通网络，就登出
                        Log.e(TAG, "onItemClick: not cu network,当前非联通网络");
                        Toast.makeText(MainApplication.sApp, "当前非联通网络", Toast.LENGTH_SHORT).show();
                        JRClient.getInstance().logout();
                    } else if (bindStatus == 2) {
                        Log.e(TAG, "onItemClick: not number place,当前不在号码归属地");
                        Toast.makeText(MainApplication.sApp, "当前不在号码归属地", Toast.LENGTH_SHORT).show();
                        JRClient.getInstance().logout();
                    }
//                    finish();
                }
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}
