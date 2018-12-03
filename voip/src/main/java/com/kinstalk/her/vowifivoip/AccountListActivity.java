package com.kinstalk.her.vowifivoip;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.juphoon.cmcc.app.lemon.MtcCliCfgConstants;
import com.juphoon.cmcc.app.lemon.MtcCliDbConstants;
import com.juphoon.cmcc.app.lemon.MtcProf;
import com.juphoon.rcs.JRAccount;
import com.juphoon.rcs.JRAccountConstants;
import com.juphoon.rcs.JRClient;
import com.juphoon.rcs.JRClientCallback;
import com.juphoon.rcs.JRClientConstants;
import com.kinstalk.her.dialer.ForceRequestPermissionsActivity;
import com.kinstalk.her.voipmode.data.StatusSP;

import java.util.HashMap;

import common.utils.JRNumberUtils;

import static com.kinstalk.her.dialer.ForceRequestPermissionsActivity.PREVIOUS_ACTIVITY_INTENT;
import static com.kinstalk.her.dialer.ForceRequestPermissionsActivity.redirect;
import static com.kinstalk.her.vowifivoip.MainApplication.WOLINK_BIND_KEY;
import static com.kinstalk.her.vowifivoip.MainApplication.WOLINK_NETWORK_KEY;

public class AccountListActivity extends BaseActivity implements JRClientCallback, OnClickListener {
    private static final String TAG = "AccountListActivity";
    private ListView mUserListView;
    private AccountAdapter mAdapter;
    private ProgressDialog mProgress;
    private String mCurLoginedUser;
    private String mLoginTag;

    //add by mengzhaoxue
    public static boolean startPermissionActivity(Activity activity) {
        if (StatusSP.getLoginStatus() == 1) {
            return false;
        }
        Intent intent = new Intent(activity, AccountListActivity.class);
        intent.putExtra(PREVIOUS_ACTIVITY_INTENT, activity.getIntent());
        activity.startActivity(intent);
        activity.finish();
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        JRClient.getInstance().addCallback(this);
        initViews();
    }

    @Override
    protected void onResume() {
        mAdapter.notifyDataSetChanged();
        super.onResume();
    }

    private void initViews() {
        mUserListView = (ListView) findViewById(R.id.list);
        mAdapter = new AccountAdapter(this);
        mUserListView.setAdapter(mAdapter);
        mUserListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (JRClient.getInstance().getState() == JRClientConstants.JRClientState.JR_REG_STATE_REGED) {
                    if (i == 0) {

                    } else if (i == 1) {
                        mProgress.setMessage("注销中");
                        mProgress.show();
                        Log.e(TAG, "onItemClick: mUserListView,logout");
                        JRClient.getInstance().logout();
                    }
                } else {
                    if (i == JRAccount.getInstance().getAccountList().size()) {
//                        startActivity(new Intent(AccountListActivity.this, CreateAccountActivity.class));
                        //因为希望去ForceRequestPermissionsActivity还能回来，所以就不使用static函数去ForceRequestPermissionsActivity
                        Intent intent = new Intent(AccountListActivity.this, ForceRequestPermissionsActivity.class);
                        startActivity(intent);
                    } else {
                        mProgress.setMessage("登录中");
                        mProgress.show();
                        JRAccount.getInstance().setAccountConfig(JRAccount.getInstance().getAccountList().get(i),
                                JRAccountConstants.JRAccountConfigKeyRegType, String.valueOf(MtcCliCfgConstants.EN_MTC_REG_SRV_VOIP));
                        StatusSP.setLoginAccount(JRAccount.getInstance().getAccountList().get(i));
                        int network_status = Settings.System.getInt(getContentResolver(), WOLINK_NETWORK_KEY, 1);
                        int bindStatus = Settings.System.getInt(getContentResolver(), WOLINK_BIND_KEY, 1);
                        if (network_status == 0 && bindStatus == 0) {
                            JRClient.getInstance().login(JRAccount.getInstance().getAccountList().get(i));
                        } else if (network_status != 0) {
                            //如果不是联通网络，就登出
                            Log.e(TAG, "onItemClick: not cu network,当前非联通网络");
                            Toast.makeText(MainApplication.sApp, "当前非联通网络", Toast.LENGTH_SHORT).show();
                            JRClient.getInstance().logout();
                            if (mProgress != null) {
                                mProgress.dismiss();
                            }
                        } else if (bindStatus == 2) {
                            Log.e(TAG, "onItemClick: not int number place,当前不在号码归属地");
                            Toast.makeText(MainApplication.sApp, "当前不在号码归属地", Toast.LENGTH_SHORT).show();
                            JRClient.getInstance().logout();
                            if (mProgress != null) {
                                mProgress.dismiss();
                            }
                        }
                        mLoginTag = JRAccount.getInstance().getAccountList().get(i);
                    }

                }
            }
        });
        mUserListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED && i < JRAccount.getInstance().getAccountList().size()) {
                    AccountActivity.openAccount(AccountListActivity.this, JRAccount.getInstance().getAccountList().get(i));
                } else if (JRClient.getInstance().getState() == JRClientConstants.JRClientState.JR_REG_STATE_REGED && i == 0) {
                    AccountActivity.openAccount(AccountListActivity.this, MtcProf.Mtc_ProfGetCurUser());
                } else if (JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED && i == JRAccount.getInstance().getAccountList().size()) {
                    if (JRAccount.getInstance().getAccountList().size() > 0){
                        if(!JRAccount.getInstance().getAccountList().contains("15620470411")){
                            Log.i(TAG, "onItemLongClick: addTestAccount");
                            addTestAccount();
                        }else {
                            Log.i(TAG, "onItemLongClick: do nothing");
                        }
                    }
                }
                return true;
            }
        });
        mProgress = new ProgressDialog(this);
        mProgress.setCancelable(false);
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
    public void onClientInitResult(boolean result, JRClientConstants.JRClientReason reason) {

    }

    @Override
    public void onClientLoginResult(boolean result, JRClientConstants.JRClientRegErrorCode reason) {
        mProgress.dismiss();
        if (result) {
//            Toast.makeText(this, "已登录", Toast.LENGTH_SHORT).show();
            mCurLoginedUser = mLoginTag;
            mAdapter.notifyDataSetChanged();
            if (StatusSP.getLoginStatus() == 0) {  //防止一个账号多个设备登录之后互相抢登录，多次被回调
                Log.e(TAG, "onClientLoginResult: 已登录");
                redirect(this);
            }
        } else {
            mCurLoginedUser = null;
        }
    }

    @Override
    public void onClientLogoutResult() {
        mProgress.dismiss();
        ActivityCollector.finishAll();
        Log.e(TAG, "onClientLogoutResult: ");
        if (JRAccount.getInstance().getAccountList().size() == 0) {
            ForceRequestPermissionsActivity.startPermissionActivity(this);
        } else {
            Intent intent = new Intent(MainApplication.sApp, AccountListActivity.class);
            startActivity(intent);
        }
//        Toast.makeText(this, "已登出", Toast.LENGTH_SHORT).show();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClientStateChange(JRClientConstants.JRClientState state, int reason) {
        if (JRClient.getInstance().getState() != JRClientConstants.JRClientState.JR_REG_STATE_REGED) {
            String errorString = JRNumberUtils.getStatMsg(reason, this);
            if (!TextUtils.isEmpty(errorString)) {
                Toast.makeText(this, errorString, Toast.LENGTH_SHORT).show();
                //如果登录出现error，就logout这个错误的账号，以防sdk一直重试
                JRClient.getInstance().logout();
            }
        }
        mProgress.dismiss();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

    }

    private static class AccountAdapter extends BaseAdapter {

        private Context mContext;
        AccountAdapter mAccountAdapter;

        public AccountAdapter(Context context) {
            mContext = context;
            mAccountAdapter = this;
        }

        @Override
        public int getCount() {
            //判断登录状态
            if (JRClient.getInstance().getState() == JRClientConstants.JRClientState.JR_REG_STATE_REGED) {
                return 2;
            } else {
                return JRAccount.getInstance().getAccountList().size() + 1;
            }
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_drawer, parent, false);
                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.drawer_item_title);
                holder.delete = (Button) convertView.findViewById(R.id.delete);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            if (JRClient.getInstance().getState() == JRClientConstants.JRClientState.JR_REG_STATE_REGED) {
                String curUser = MtcProf.Mtc_ProfGetCurUser();
                holder.delete.setVisibility(View.GONE);
                if (position == 0) {
                    holder.name.setText(curUser);
                } else if (position == 1) {
                    holder.name.setText("注销");
                }
            } else {
                //被挤下线之后要改为0
                StatusSP.setLoginStatus(0);
                if (position == JRAccount.getInstance().getAccountList().size()) {
                    holder.name.setText("添加");
                    holder.delete.setVisibility(View.GONE);
                } else {
                    holder.name.setText(JRAccount.getInstance().getAccountList().get(position));
                    holder.delete.setVisibility(View.VISIBLE);
                }
                holder.delete.setTag(position);
                holder.delete.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = (int) view.getTag();
                        if (JRAccount.getInstance().deleteAccount(JRAccount.getInstance().getAccountList().get(pos))) {
                            notifyDataSetChanged();
                        }
                    }
                });
            }

            return convertView;
        }

        class ViewHolder {
            TextView name;
            Button delete;

        }
    }
}
