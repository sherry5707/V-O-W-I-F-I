package com.kinstalk.her.vowifivoip;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.juphoon.rcs.JRClient;
import com.juphoon.rcs.JRLog;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * Created by Upon on 2017/12/19.
 */

public class JRQuotActivity extends BaseActivity {
    private TextView mAudio, mVideo, mMulti;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quot);

        initViews();
        requestHttp();
    }

    private void formatJson(String response) {
        try {
            JSONObject json = new JSONObject(response);
            String value = json.optString("value");
            JSONObject valueJson = new JSONObject(value);
            String quot = valueJson.optString("quotaProps");
            JSONArray quotArray = new JSONArray(quot);
            JRLog.log("yidao", quotArray.toString() + "");
            JSONObject audio = quotArray.getJSONObject(0);
            JSONObject video = quotArray.getJSONObject(1);
            JSONObject multi = quotArray.getJSONObject(2);
            String audioNum = audio.optString("quotaNum");
            String audioUsedNum = audio.optString("quotaUsedNum");

            String videoNum = video.optString("quotaNum");
            String videoUsedNum = video.optString("quotaUsedNum");

            String multiNum = multi.optString("quotaNum");
            String multiUsedNum = multi.optString("quotaUsedNum");
            JRLog.log("yidao", multiUsedNum + "");
            mAudio.setText("音频能力 总配额：" + audioNum + "\n"
                    + "已使用配额" + audioUsedNum);

            mVideo.setText("视频能力 总配额：" + videoNum + "\n"
                    + "已使用配额" + videoUsedNum);

            mMulti.setText("多方能力 总配额：" + multiNum + "\n"
                    + "已使用配额" + multiUsedNum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void requestHttp() {
        mProgressDialog.show();
        String phone = JRClient.getInstance().getCurLoginNumber();
        if (phone != null && phone.startsWith("+86")) {
            phone = phone.substring(3, phone.length());
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "当前没登录账号，请登录", Toast.LENGTH_SHORT).show();
            mProgressDialog.dismiss();
            return;
        }
        OkHttpUtils.post().url("http://101.207.176.139/rest2/client/getControlQuota")
                .addParams("phone", phone)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        mProgressDialog.hide();
                        Log.e("yidao", "onResponse: " + response);
                        formatJson(response);
                    }
                });
    }


    private void initViews() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("正在获取配额");
        mAudio = (TextView) findViewById(R.id.audio_quot);
        mVideo = (TextView) findViewById(R.id.video_quot);
        mMulti = (TextView) findViewById(R.id.multi_quot);
    }
}
