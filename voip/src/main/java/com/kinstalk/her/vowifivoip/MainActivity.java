package com.kinstalk.her.vowifivoip;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
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
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.util.HashMap;
import java.util.List;

import common.RealmDataHelper;
import common.RealmHelper;
import io.realm.Realm;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener, JRClientCallback,JRMessageCallback {
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 100;
    private Realm mRealm;
    private PermissionListener listener = new PermissionListener() {

        @Override
        public void onSucceed(int requestCode, List<String> grantPermissions) {
            if (requestCode == REQUEST_WRITE_EXTERNAL_STORAGE) {
//                Toast.makeText(MainActivity.this, "开始初始化", Toast.LENGTH_SHORT).show();
                initSDK();
                //addTestAccount();
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndPermission.with(this)
                .requestCode(REQUEST_WRITE_EXTERNAL_STORAGE)
                .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.CAMERA,
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.BLUETOOTH,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .send();
    }

    //添加天津测试账号，方便调测
    private void addTestAccount(){
        boolean has = JRAccount.getInstance().getAccountList().contains("15620470411");
        if(!has && JRAccount.getInstance().createAccount("15620470411")){
            HashMap<JRAccountConstants,String> params = new HashMap<>();
            params.put(JRAccountConstants.JRAccountConfigKeyUserName,"+8615620470411");
            params.put(JRAccountConstants.JRAccountConfigKeyAuthName,"8615620470411@ims.mnc001.mcc460.3gppnetwork.org");
            params.put(JRAccountConstants.JRAccountConfigKeyPassword,"938930");
            params.put(JRAccountConstants.JRAccountConfigKeyRegIp,"103.3.99.209");
            params.put(JRAccountConstants.JRAccountConfigKeyRegRealm,"tj.rcs.ims.mnc001.mcc460.3gppnetwork.org");
            params.put(JRAccountConstants.JRAccountConfigKeySipPort,"5460");
            params.put(JRAccountConstants.JRAccountConfigKeySipTransportType,String.valueOf(MtcCliDbConstants.EN_MTC_TPT_TCP));
            params.put(JRAccountConstants.JRAccountConfigKeyRegType, String.valueOf(MtcCliCfgConstants.EN_MTC_REG_SRV_VOIP));
            JRAccount.getInstance().setAccountConfig("15620470411",params);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        AndPermission.onRequestPermissionsResult(requestCode, permissions, grantResults, listener);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                startActivity(new Intent(MainActivity.this, AccountListActivity.class));
                break;
/*            case 1:
//                showDialog();
                if(JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED){
                    Toast.makeText(this, "当前无账号登录", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(MainActivity.this, JRMessageListActivity.class));
                break;*/
//            case 2:
//                if(JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED){
//                    Toast.makeText(this, "当前无账号登录", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                showCallDialog();
//                break;
//            case 2:
//                startActivity(new Intent(MainActivity.this,JRQuotActivity.class));
//                break;
            case 1:
                startActivity(new Intent(MainActivity.this,AboutActivity.class));
                break;
        }
    }

    @Override
    public void onClientInitResult(boolean result, JRClientConstants.JRClientReason reason) {
        if (result) {
//            Toast.makeText(this, "sdk初始化成功", Toast.LENGTH_SHORT).show();
            RealmDataHelper.init(this);
            JRMessage.getInstance().addCallback(this);
            initViews();
//            addTestAccount();
        } else {
            Log.e("","onClientInitResult: " + reason);
            Toast.makeText(this, "sdk初始化失败"+reason, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClientLoginResult(boolean result, JRClientConstants.JRClientRegErrorCode reason) {
        if(result){
            mRealm = RealmHelper.getInstance();
        }
    }

    @Override
    public void onClientLogoutResult() {

    }

    @Override
    public void onClientStateChange(JRClientConstants.JRClientState state, int reason) {

    }

    private void initSDK() {
        JRClient.getInstance().addCallback(this);
        try {
            JRClient.getInstance().startInitWithAppkey(this, "27b118baebd5227a3d03663a759be3cb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initViews() {
        ListView mListView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_expandable_list_item_1);
        adapter.add("账号管理");
//        adapter.add("消息模块");
//        adapter.add("通话模块");
//        adapter.add("配额模块");
        adapter.add("关于");
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    private void showDialog() {
        final TextView tv = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("请输入")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(tv)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!TextUtils.isEmpty(tv.getText())) {
                            String peernumber = tv.getText().toString();
                            Intent intent = new Intent(MainActivity.this, JRMessageActivity.class);
                            intent.putExtra("account_phone", peernumber);
                            startActivity(intent);
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    private void showCallDialog() {
        View parentView = LayoutInflater.from(this).inflate(R.layout.layout_choice, null, true);
        final TextView tv = parentView.findViewById(R.id.number);
        final CheckBox isVideo = parentView.findViewById(R.id.is_video);
        final CheckBox isMulti = parentView.findViewById(R.id.is_multi);
        new AlertDialog.Builder(this)
                .setTitle("请输入")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(parentView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!TextUtils.isEmpty(tv.getText())) {
                            String peernumber = tv.getText().toString();
                            Intent intent = new Intent(MainActivity.this, JRCallActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            intent.putExtra(JRCommonValue.JRCALL_EXTRA_PHONE_NUMBER, peernumber);
                            intent.putExtra(JRCommonValue.JRCALL_EXTRA_IS_MULTI, isMulti.isChecked());
                            intent.putExtra(JRCommonValue.JRCALL_EXTRA_IS_VIDEO, isVideo.isChecked());
                            startActivity(intent);
                        }
//                        RealmHelper.getInstance(JRClient.getInstance().getCurAccount());
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    @Override
    public void onTextMessageUpdate(JRMessageItem message) {
        if (message != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, message);
        }
    }

    @Override
    public void onFileMessageUpdate(JRMessageItem message) {
        if (message != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, message);
        }
    }

    @Override
    public void onGeoMessageUpdate(JRMessageItem message) {
        if (message != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, message);
        }
    }

    @Override
    public void onTextMessageReceive(JRMessageItem message) {
        if (message != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, message);
        }
    }

    @Override
    public void onFileMessageReceive(JRMessageItem message) {
        if (message != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, message);
        }
    }

    @Override
    public void onGeoMessageReceive(JRMessageItem message) {
        if (message != null) {
            RealmDataHelper.insertOrUpdateMessage(mRealm, message);
        }
    }
}
