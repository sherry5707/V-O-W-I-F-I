package com.kinstalk.her.voipmode.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.kinstalk.her.vowifivoip.MainApplication;

public class StatusSP {
    private static final String TAG = "StatusSP";
    private static final String SP_NAME = "vowifi_sp_name";
    private static final String SP_KEY_LOGIN_STATUS = "key_login_status";
    private static final String SP_KEY_LOGIN_ACCOUNT = "key_cur_account";
    private static final String SP_KEY_IPDEV_LOGOUT = "key_ipdev_logout";

    public static void setLoginStatus(int flag) {
        SharedPreferences sharedPreferences = MainApplication.sApp.getSharedPreferences(SP_NAME, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SP_KEY_LOGIN_STATUS, flag);
        editor.commit();
    }

    public static String getLoginAccount() {
        SharedPreferences sharedPreferences = MainApplication.sApp.getSharedPreferences(SP_NAME, Context.MODE_MULTI_PROCESS);
        String accountName = sharedPreferences.getString(SP_KEY_LOGIN_ACCOUNT, null);
        Log.i(TAG, "SP_KEY_LOGIN_ACCOUNT: " + accountName);
        return accountName;
    }

    public static void setLoginAccount(String name) {
        SharedPreferences sharedPreferences = MainApplication.sApp.getSharedPreferences(SP_NAME, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SP_KEY_LOGIN_ACCOUNT, name);
        editor.commit();
    }

    public static int getLoginStatus() {
        SharedPreferences sharedPreferences = MainApplication.sApp.getSharedPreferences(SP_NAME, Context.MODE_MULTI_PROCESS);
        int status = sharedPreferences.getInt(SP_KEY_LOGIN_STATUS, 0);
        Log.i(TAG, "getLoginStatus: " + status);
        return status;
    }

    /**
     * 表示是否是由于限网那边的status导致vowifi logout。是1否0
     * @param flag
     */
    public static void setIpdevLogout(int flag) {
        SharedPreferences sharedPreferences = MainApplication.sApp.getSharedPreferences(SP_NAME, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SP_KEY_IPDEV_LOGOUT, flag);
        editor.commit();
    }

    public static int getIpdevLogout() {
        SharedPreferences sharedPreferences = MainApplication.sApp.getSharedPreferences(SP_NAME, Context.MODE_MULTI_PROCESS);
        int status = sharedPreferences.getInt(SP_KEY_IPDEV_LOGOUT, 0);
        Log.i(TAG, "getLoginStatus: " + status);
        return status;
    }
}
