package com.kinstalk.her.vowifivoip;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.juphoon.rcs.JRMessage;
import com.juphoon.rcs.JRMessageCallback;
import com.juphoon.rcs.JRMessageConstants;
import com.juphoon.rcs.JRMessageItem;
import com.juphoon.rcs.MtcUtils;

import java.util.ArrayList;


/**
 * Created by Upon on 2017/12/17.
 */

public class MessageSendActivity extends BaseActivity implements JRMessageCallback {
    String phone;
    EditText mEtText;
    ListView mListView;
    MessageAdapter mAdapter;
    ArrayList<JRMessageItem> mItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null) {
            phone = getIntent().getStringExtra("account_phone");
            setContentView(R.layout.activity_message_send);
            getSupportActionBar().setTitle(phone);
            findView();
            init();
            JRMessage.getInstance().addCallback(this);
        } else {
            finish();
        }
    }

    private void init() {
        mItems = new ArrayList<>();
        mAdapter = new MessageAdapter(this);
        mAdapter.setData(mItems);
        mListView.setAdapter(mAdapter);
    }

    private void findView() {
        mEtText = (EditText) findViewById(R.id.et_text);
        mListView = (ListView) findViewById(R.id.message_list);
    }

    private void updateTextMessageById(JRMessageItem message) {
        for (JRMessageItem item : mItems) {
            if (TextUtils.equals(item.getImdnId(), message.getImdnId())) {
                item = message;
                break;
            }
        }
        mItems.add(message);
    }

    private void updateFileMessageById(JRMessageItem message) {
        for (JRMessageItem item : mItems) {
            if (TextUtils.equals(item.getTransId(), message.getTransId())) {
                item = message;
                break;
            }
        }
        mItems.add(message);
    }

    @Override
    public void onTextMessageUpdate(JRMessageItem message) {
        updateTextMessageById(message);
    }

    @Override
    public void onFileMessageUpdate(JRMessageItem message) {
        updateFileMessageById(message);
    }

    @Override
    public void onGeoMessageUpdate(JRMessageItem message) {
        updateTextMessageById(message);
    }

    @Override
    public void onTextMessageReceive(JRMessageItem message) {
        mItems.add(message);
        mAdapter.setData(mItems);
    }

    @Override
    public void onFileMessageReceive(JRMessageItem message) {
        mItems.add(message);
        mAdapter.setData(mItems);
    }

    @Override
    public void onGeoMessageReceive(JRMessageItem message) {
        mItems.add(message);
        mAdapter.setData(mItems);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case 1:
                String locationName = data.getStringExtra(LocationBaiduActivity.LOCATION_NAME);
                double latitude = data.getDoubleExtra(LocationBaiduActivity.LOCATION_LATITUDE, 0.0);
                double longitude = data.getDoubleExtra(LocationBaiduActivity.LOCATION_LONGITUDE, 0.0);
                float radius = data.getFloatExtra(LocationBaiduActivity.LOCATION_RADIUS, 0.0f);
                JRMessage.getInstance().sendGeoMessage(phone, latitude, longitude, radius, locationName, null);
                break;
            case 2:
                String srcPath = MtcUtils.getPath(this, data.getData());
                Toast.makeText(this, srcPath + "", Toast.LENGTH_SHORT).show();
                JRMessage.getInstance().sendFileMessage(phone, JRMessageConstants.Type.IMAGE, srcPath, srcPath, null);
                break;
        }
    }

    public void onSendText(View v) {
        if (!TextUtils.isEmpty(mEtText.getText())) {
            JRMessage.getInstance().sendTextMessage(phone, mEtText.getText().toString(), null);
        }
    }

    public void onChooseFile(View v) {
        Intent chooseImageIntent = MtcUtils
                .getMediaByTypeIntent("image/*", false);
        if (chooseImageIntent != null) {
            startActivityForResult(chooseImageIntent,
                    2);
        }
    }

    public void onSendGeo(View v) {
        startActivityForResult(new Intent(this,
                LocationBaiduActivity.class), 1);
    }
}
