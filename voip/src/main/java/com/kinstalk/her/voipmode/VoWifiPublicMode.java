package com.kinstalk.her.voipmode;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.juphoon.cmcc.app.lemon.MtcCliCfgConstants;
import com.juphoon.rcs.JRAccount;
import com.juphoon.rcs.JRAccountConstants;
import com.juphoon.rcs.JRClient;
import com.kinstalk.her.dialer.ForceRequestPermissionsActivity;
import com.kinstalk.her.voipmode.data.StatusSP;
import com.kinstalk.her.vowifivoip.JRCallActivity;
import com.kinstalk.her.vowifivoip.JRCommonValue;
import com.kinstalk.her.vowifivoip.MainActivity;
import com.kinstalk.her.vowifivoip.R;

import static com.kinstalk.her.vowifivoip.JRCallActivity.isPhoneNumber;
import static com.kinstalk.her.vowifivoip.JRCallActivity.phoneNumberFilter;

public class VoWifiPublicMode {
    private static final String TAG = "VoWifiPublicMode";
    public static void callOut(Context context, String phoneNumber) {
        if (!isPhoneNumber(phoneNumberFilter(phoneNumber))) {
            Toast.makeText(context, context.getString(R.string.invalid_number), Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(context, JRCallActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra(JRCommonValue.JRCALL_EXTRA_PHONE_NUMBER, phoneNumber);
//        intent.putExtra(JRCommonValue.JRCALL_EXTRA_IS_MULTI, isMulti.isChecked());
//        intent.putExtra(JRCommonValue.JRCALL_EXTRA_IS_VIDEO, isVideo.isChecked());
        context.startActivity(intent);
    }

    public static void login(String name) {
        if(TextUtils.isEmpty(name)){
            Log.e(TAG, "login name is null ");
        }else {
            StatusSP.setLoginAccount(name);
            int size = JRAccount.getInstance().getAccountList().size();
            if (size > 0) {
                if(JRAccount.getInstance().getAccountList().contains(name)) {
                    JRAccount.getInstance().setAccountConfig(name,
                            JRAccountConstants.JRAccountConfigKeyRegType, String.valueOf(MtcCliCfgConstants.EN_MTC_REG_SRV_VOIP));
                    Log.e("VoWifiPublicMode", "login: account:" + name);
                    JRClient.getInstance().login(name);
                }else {
                    Log.e(TAG, "login,account:"+name+" is not exsit");
                }
            }
        }
    }
}
