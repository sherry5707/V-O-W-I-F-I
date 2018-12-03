package com.kinstalk.her.vowifivoip;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.juphoon.cmcc.app.lemon.MtcCall;
import com.juphoon.cmcc.app.lemon.MtcNumber;
import com.juphoon.cmcc.app.lemon.ST_MTC_RECT;
import com.juphoon.rcs.JRCall;
import com.juphoon.rcs.JRCallCallback;
import com.juphoon.rcs.JRCallConstants;
import com.juphoon.rcs.JRCallItem;
import com.juphoon.rcs.JRCallMember;
import com.juphoon.rcs.JRCallStorage;
import com.juphoon.rcs.JRClient;
import com.juphoon.rcs.JRLog;
import com.juphoon.rcs.JRMediaDevice;
import com.juphoon.rcs.JRMediaDeviceCanvas;
import com.juphoon.rcs.JRMediaDeviceContancts;
import com.juphoon.rcs.utils.JRCommonUtils;
import com.juphoon.rcs.utils.JRRingUtils;
import com.juphoon.rcs.utils.JRVideoUtils;
import com.kinstalk.her.contactscommon.common.model.Contact;
import com.kinstalk.her.voipmode.data.CallRecord;
import com.kinstalk.her.voipmode.data.ContactInfo;
import com.kinstalk.her.voipmode.data.MyDBProviderHelper;
import com.kinstalk.her.voipmode.utils.NumberToChineseUtil;
import com.kinstalk.qloveaicore.AIManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import bluetooth.MtcBluetoothHelper;
import bluetooth.MtcHeadsetPlugReceiver;
import common.CommonValue;
import common.utils.JRNumberUtils;
import ui.Statistics;
import ui.call.CallCell;
import ui.call.OperationLayer;

import static ui.call.OperationLayer.isUndialableAnonymous;

/**
 * Created by Upon on 2018/2/6.
 */

public class JRCallActivity extends AppCompatActivity implements JRCallCallback, View.OnClickListener, CallCell.Callback, MtcHeadsetPlugReceiver.Callback, MtcBluetoothHelper.Callback {
    private static final String TAG = "JRCallActivity";
    private static final int UPDATE_END = 0;
    private JRCallItem mCurItem;
    private JRCallItem mAnotherItem;
    private JRCallConstants.State mOldState;
    private JRCallConstants.State mOldAnotherState;
    private boolean isAnotherItem;
    private JRMediaDeviceCanvas mLocalCanvas;
    private JRMediaDeviceCanvas mRemoteCanvas;
    private Statistics mStatistics;
    private FrameLayout mVideoLayout;

    private MtcBluetoothHelper mMtcBluetoothHelper;
    private MtcHeadsetPlugReceiver mHeadsetPlugReceiver;
    private AlertDialog mAlertDialog;
    private int mAudio = 0;
    private boolean isChooseMode = false;
    //audio state
    private static final int AUDIO_RECEIVER = 0;
    private static final int AUDIO_HEADSET = 1;
    private static final int AUDIO_SPEAKER = 2;
    private static final int AUDIO_BLUETOOTH = 3;
    private static final int AUDIO_STRINGS[] = {
            R.string.receiver,
            R.string.headset,
            R.string.speaker};

    private static final int AUDIO_DRAWABLES[] = {
            R.drawable.call_audio_receiver,
            R.drawable.call_audio_headset,
            R.drawable.call_audio_speaker,
            R.drawable.call_audio_bluetooth};

    private OperationLayer mOperationLayer = new OperationLayer(this);

    private ViewGroup mViewMain;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_END:
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Window window = getWindow();
        WindowManager.LayoutParams attrs = window.getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;

        window.setAttributes(attrs);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jr_call);
        initViews();
        initLayers();
        initListeners();
        handleIntent(getIntent());
    }

    @Override
    public void onBackPressed() {
        if (mCurItem != null) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @SuppressLint("StringFormatInvalid")
    private void handleIntent(Intent intent) {
        Log.i(TAG, "handleIntent: ");

        mMtcBluetoothHelper = new MtcBluetoothHelper(this);
        mMtcBluetoothHelper.setCallback(this);
        mMtcBluetoothHelper.start();
        mHeadsetPlugReceiver = new MtcHeadsetPlugReceiver();
        mHeadsetPlugReceiver.start(this);
        mHeadsetPlugReceiver.setCallback(this);

        int sessId = intent.getIntExtra(JRCommonValue.JRCALL_EXTRA_SESSION_ID, -1);
        String phoneNumber = intent.getStringExtra(JRCommonValue.JRCALL_EXTRA_PHONE_NUMBER);
        boolean isVideo = intent.getBooleanExtra(JRCommonValue.JRCALL_EXTRA_IS_VIDEO, false);
        boolean isMulti = intent.getBooleanExtra(JRCommonValue.JRCALL_EXTRA_IS_MULTI, false);
        Log.i(TAG, "handleIntent: sessId:" + sessId);
        if (sessId != -1) {
            //add by mengzhaoxue
            mOperationLayer.setEventSwitchItemVisibility(false);
            //end
            mCurItem = JRCallStorage.getInstance().getCallItem(sessId);
            setInComing(mCurItem);
            String filterPhoneNumber = phoneNumberFilter(mCurItem.getMemberList().get(0).getNumber());
            Log.i(TAG, "handleIntenit: incomint number:" + filterPhoneNumber);

            insertCallRecord(mCurItem.getMemberList().get(0).getNumber(), CallLog.Calls.INCOMING_TYPE);
            //语音播报
            String ttsWithName = String.format(getString(R.string.call_in_with_number_tts),
                    isUndialableAnonymous(filterPhoneNumber) ? "匿名号码" : getNameByNumber(filterPhoneNumber));
            AIManager.getInstance(this).playTextWithStr(ttsWithName, null);
        } else {
            if (isMulti) {
//                JRRingUtils.playAudio(this, R.raw.ring_back, false);
                if (!TextUtils.isEmpty(phoneNumber)) {
                    String[] phones = phoneNumber.split(";");
                    ArrayList<String> phoneList = new ArrayList<>();
                    phoneList.addAll(Arrays.asList(phones));
                    boolean s = JRCall.getInstance().createMultiCall(phoneList, false, null);
                }
                return;
            }
            if (!TextUtils.isEmpty(phoneNumber)) {
                //add by mengzhaoxue
                mOperationLayer.setEventSwitchItemVisibility(false);
                //end
                Log.i(TAG, "handleIntent: outcoming");
                insertCallRecord(phoneNumber, CallLog.Calls.OUTGOING_TYPE);
                if (mMtcBluetoothHelper.getCount() > 0) {
                    setAudio(3);
                }
//                JRRingUtils.playAudio(this, R.raw.ring_back, false);
                boolean s = JRCall.getInstance().call(JRCommonUtils.formatPhoneWithCountryCode(phoneNumber), isVideo, null);
                if (!s) {
                    Toast.makeText(this, "接口调用失败", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }

    /**
     * 判断number是否是数字，防止内网号码被联通后台匿名
     *
     * @param numberStr
     * @return
     */
    public static boolean isPhoneNumber(String numberStr) {
        boolean isPhoneNumber = true;
        try {
            long number = Long.parseLong(numberStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            isPhoneNumber = false;
        }
        return isPhoneNumber;
    }

    //移除手机号+86
    public static String phoneNumberFilter(String number) {
        if (number.contains("+")) {
            number = number.substring(3, number.length());
        }
        Log.i(TAG, "after phoneNumberFilter: number:" + number);
        return number;
    }

    private String getNameByNumber(String number) {
        ContactInfo contact = MyDBProviderHelper.getContactByContactIdFromSystemDB(this, number);
        if (contact != null) {
            return contact.getNickname();
        } else {
            return NumberToChineseUtil.getChinese(number);
        }
    }

    private void initViews() {
        mViewMain = (ViewGroup) findViewById(R.id.call_main);
        mVideoLayout = (FrameLayout) findViewById(R.id.video_view);
        mOperationLayer.setParentView(mViewMain);
    }


    private void initLayers() {
        mOperationLayer.setEventReceiver(new OperationLayer.EventReceiver() {
            @Override
            public void onEvent(String event, String... args) {
                if (OperationLayer.EVENT_SHOWN.equals(event)) {
                } else if (OperationLayer.EVENT_HIDDEN.equals(event)) {

                } else if (OperationLayer.EVENT_STATISTIC.equals(event)) {
                    if (mStatistics == null) {
                        mStatistics = new Statistics(getApplicationContext(), JRCallStorage.getInstance().getCurItem().getCallId());
                        mViewMain.addView(mStatistics);
                    }
                    if (mStatistics.isShow()) {
                        mStatistics.hideStat();
                    } else {
                        mStatistics.showStat();
                    }
                } else if (OperationLayer.EVENT_ANSWER_DEFAULT.equals(event)) {
                    if (JRCall.getInstance().answer(mCurItem, mCurItem.isVideo())) {
                        mOperationLayer.setStateText("接听中", true, false);
                        mOperationLayer.setStatusIncoming(false, false);
                    }
                    JRRingUtils.stop();
                } else if (OperationLayer.EVENT_ANSWER_CAMERA_OFF.equals(event)) {
                    if (JRCall.getInstance().answer(mCurItem, false)) {
                        mOperationLayer.setStateText("接听中", true, false);
                        mOperationLayer.setStatusIncoming(false, false);
                    }
                    JRRingUtils.stop();
                } else if (OperationLayer.EVENT_SWITCH_FRONT_REAR.equals(event)) {
                    JRCall.getInstance().switchCamera(JRCallStorage.getInstance().getCurItem());
                } else if (OperationLayer.EVENT_ANSWER_DECLINE.equals(event)) {
                    if (JRCall.getInstance().endCall(mCurItem, JRCallConstants.TremReason.DECLINE)) {
                        mOperationLayer.setStateText(getString(R.string.ending), true, false);
                    }
                    mHandler.sendEmptyMessageDelayed(UPDATE_END, 1500);
                } else if (OperationLayer.EVENT_END.equals(event)) {
                    if (mAnotherItem != null && mCurItem != null) {
                        JRCall.getInstance().endCall(JRCallStorage.getInstance().getCurItem(), JRCallConstants.TremReason.NOMAL);
                        return;
                    }
                    JRCall.getInstance().endCall(JRCallStorage.getInstance().getCurItem(), JRCallConstants.TremReason.NOMAL);
                    mHandler.sendEmptyMessageDelayed(UPDATE_END, 1500);
                } else if (OperationLayer.EVENT_MERGE_CALL.equals(event)) {
                    if (mCurItem != null && mAnotherItem != null) {
                        String curNumber = mCurItem.getMemberList().get(0).getNumber();
                        String otherNumber = mAnotherItem.getMemberList().get(0).getNumber();
                        ArrayList<String> list = new ArrayList<String>();
                        list.add(curNumber);
                        list.add(otherNumber);
                        JRCall.getInstance().createMultiCall(list, false, null);
                    }
                } else if (OperationLayer.EVENT_MUTE.equals(event)) {
                    JRCall.getInstance().mute(JRCallStorage.getInstance().getCurItem());
                } else if (OperationLayer.EVENT_SPEAKER.equals(event)) {
                    mMtcBluetoothHelper.start();
                    if (mMtcBluetoothHelper.getCount() > 0) {
                        selectAudio();
                        return;
                    }
                    JRMediaDevice.getInstance().enableSpeaker(null, !mOperationLayer.isSpeakerOn());
                    mOperationLayer.setSpeakerOn(!mOperationLayer.isSpeakerOn());
                } else if (OperationLayer.EVENT_AUDIO_TO_VIDEO.equals(event)) {
                    JRCall.getInstance().updateCall(JRCallStorage.getInstance().getCurItem(), true);
                } else if (OperationLayer.EVENT_VIDEO_TO_AUDIO.equals(event)) {
                    if (JRCall.getInstance().updateCall(JRCallStorage.getInstance().getCurItem(), false)) {
                        JRMediaDevice.getInstance().stopCamera();
                        mLocalCanvas = null;
                        if (mRemoteCanvas != null) {
                            JRMediaDevice.getInstance().stopVideo(mRemoteCanvas);
                        }
                        mRemoteCanvas = null;
                        mVideoLayout.removeAllViews();
                        mVideoLayout.setVisibility(View.GONE);
                        mOperationLayer.setSpeakerOn(false);
                        JRMediaDevice.getInstance().enableSpeaker(null, false);
                    }
                } else if (OperationLayer.EVENT_ADD_CALL.equals(event)) {
                    if (JRCallStorage.getInstance().getCurItem().isConference()) {
                        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                        startActivityForResult(intent, CommonValue.REQUEST_ADD_MEMBER);
                    } else if (JRCallStorage.getInstance().getCurItem().isHold()) {
                        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                        startActivityForResult(intent, CommonValue.REQUEST_ADD_CALL);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(JRCallActivity.this);
                        String[] items = {"多方通话", "添加通话"};
                        builder.setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (i == 0) {
                                    Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                                    try {
                                        startActivityForResult(intent, CommonValue.REQUEST_TO_MULTI_CALL);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    JRCall.getInstance().hold(JRCallStorage.getInstance().getCurItem());
                                    Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                                    try {
                                        startActivityForResult(intent, CommonValue.REQUEST_ADD_CALL);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                        builder.create().show();
                    }
                } else if (OperationLayer.EVENT_HOLD_CALL.equals(event)) {
                    if (JRCall.getInstance().hold(JRCallStorage.getInstance().getCurItem())) {
                        if (JRCallStorage.getInstance().getCurItem().isHold()) {
                            mOperationLayer.setHold(false, true);
                        } else {
                            mOperationLayer.setHold(true, true);
                        }
                    }
                } else if (OperationLayer.EVENT_SWITCH_ITEM.equals(event)) {
                    HashMap<Integer, JRCallItem> itemMap = JRCallStorage.getInstance().getItemMap();
                    final ArrayList<JRCallItem> items = new ArrayList<>();
                    items.addAll(itemMap.values());
                    ArrayList<Integer> itemIds = new ArrayList<>();
                    ArrayList<String> phones = new ArrayList<>();
                    itemIds.addAll(itemMap.keySet());
                    for (JRCallItem item : items) {
                        if (TextUtils.equals(item.getMemberList().get(0).getNumber(), JRCallStorage.getInstance().getCurItem().getMemberList().get(0).getNumber())) {
                            phones.add(item.getMemberList().get(0).getNumber() + "(当前)");
                        } else {
                            phones.add(item.getMemberList().get(0).getNumber());
                        }
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(JRCallActivity.this);
                    final String[] phoneArray = phones.toArray(new String[phones.size()]);
                    builder.setItems(phoneArray, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (phoneArray[which].contains("当前")) {
                                return;
                            }
                            isChooseMode = true;
                            if (TextUtils.equals(phoneArray[which], mCurItem.getMemberList().get(0).getNumber())) {
                                JRCall.getInstance().hold(mAnotherItem);
                            } else {
                                JRCall.getInstance().hold(mCurItem);
                            }
                        }
                    });
                    builder.setTitle("点击切换至该通话");
                    builder.create().show();
                }
            }

        });
    }

    private void initListeners() {
        JRCall.getInstance().addCallback(this);
    }

    @Override
    public void onCallItemUpdated(JRCallItem item, JRCallConstants.Error error, int updateType) {
        updateCall(item, updateType);
        if (error != null) {
            String strError = JRCallConstants.dealWithError(error);
        }
    }

    @Override
    public void onCallItemRemove(JRCallItem item, JRCallConstants.TremReason reason) {
        if (mCurItem != null) {
            if (reason == JRCallConstants.TremReason.NO_QUOTA) {
                Toast.makeText(this, "未查询到此次通话的能力", Toast.LENGTH_SHORT).show();
            }
            if (reason == JRCallConstants.TremReason.NONE) {
                if (mCurItem.getCallId() == item.getCallId()) {
                    mCurItem = null;
                    return;
                }
            }
            if (item.getCallId() != mCurItem.getCallId()) {
                updateCall(item, -1);
            } else {
                updateCall(mCurItem, -1);
            }
        }
    }

    @Override
    public void onCallItemAdd(JRCallItem item) {
        updateCall(item, -1);
    }

    @Override
    protected void onDestroy() {
        mMtcBluetoothHelper.stop();
        mHeadsetPlugReceiver.stop(this);
        if (CallCell.sCallArray != null) {
            CallCell.sCallArray.clear();
        }
        JRRingUtils.stop();
        if (mRemoteCanvas != null) {
            JRMediaDevice.getInstance().stopVideo(mRemoteCanvas);
        }
        JRMediaDevice.getInstance().stopAudio();
        JRCall.getInstance().removeCallback(this);
        JRCallStorage.getInstance().setItemToActive(null);
        JRMediaDevice.getInstance().stopCamera();
        JRMediaDevice.getInstance().enableSpeaker(null, false);
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        Cursor cursor = getContentResolver().query(data.getData(), null, null, null, null);
        String phone = getNumberWithCursor(cursor);
        switch (requestCode) {
            case CommonValue.REQUEST_ADD_CALL:
                JRCall.getInstance().call(phone, false, null);
                break;
            case CommonValue.REQUEST_ADD_MEMBER:
                if (!TextUtils.isEmpty(phone)) {
                    if (JRCall.getInstance().addMultiCallMember(phone)) {
                        CallCell.addCall(1, JRNumberUtils.formatPhoneByCountryCode(phone), JRNumberUtils.formatPhoneByCountryCode(phone), this, JRCommonValue.EN_MTC_CONF_PARTP_STATE_PENDING);
                    }
                }
                break;
            case CommonValue.REQUEST_TO_MULTI_CALL:
                if (!TextUtils.isEmpty(phone)) {
                    if (mCurItem.getMemberList().size() > 0) {
                        String oldNumber = mCurItem.getMemberList().get(0).getNumber();
                        ArrayList<String> newList = new ArrayList<>();
                        newList.add(oldNumber);
                        newList.add(phone);
                        JRCall.getInstance().createMultiCall(newList, false, null);
                    }
                }
                break;
        }
    }

    private String getNumberWithCursor(Cursor contactCursor) {
        if (contactCursor == null)
            return null;

        if (!contactCursor.moveToFirst())
            return null;

        int phoneColumn = contactCursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
        int nameColumn = contactCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
        int thumbColunm = contactCursor.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI);
        int phoneNum = contactCursor.getInt(phoneColumn);
        String name = contactCursor.getString(nameColumn);
        String thumbUri = contactCursor.getString(thumbColunm);
        String phoneNumber = "";
        if (phoneNum > 0) {
            // 获得联系人的ID号
            int idColumn = contactCursor.getColumnIndex(ContactsContract.Contacts._ID);
            String contactId = contactCursor.getString(idColumn);
            // 获得联系人电话的cursor
            Cursor phoneCursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "="
                            + contactId, null, null);
            if (phoneCursor.moveToFirst()) {
                for (; !phoneCursor.isAfterLast(); phoneCursor.moveToNext()) {
                    int index = phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    int typeIndex = phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE);
                    int phoneType = phoneCursor.getInt(typeIndex);
                    phoneNumber = phoneCursor.getString(index);
                    phoneNumber = phoneNumber.replace(" ", "").replace("-", "");
                }
                if (!phoneCursor.isClosed()) {
                    phoneCursor.close();
                }
            }
        }
        contactCursor.close();
        return phoneNumber;
    }

    private void setInComing(JRCallItem item) {
        if (item == null) {
            return;
        }
        if (item.isConference()) {
            List<JRCallMember> list = item.getMemberList();
            for (JRCallMember member : list) {
                CallCell.addCall(1, JRNumberUtils.formatPhoneByCountryCode(member.getNumber()), JRNumberUtils.formatPhoneByCountryCode(member.getNumber()), this, getMtcState(member.getState()));
            }
        }
        mOperationLayer.setOneCallViewsGone();
        mOperationLayer.setConfInComingViewsGone();
        if (item.getMemberList().size() > 0) {
            mOperationLayer.onUserInfoChanged(item.getMemberList().get(0).getDisplayName(), item.getMemberList().get(0).getNumber());
        }
        mOperationLayer.resetStateText();
        mOperationLayer.setStateText("", false, false);
        mOperationLayer.setStatusIncoming(true, item.isVideo());
        JRRingUtils.startRing(getBaseContext(), R.raw.ringtone_music_box);
    }

    private void updateCall(final JRCallItem item, int updateType) {
        Log.i(TAG, "updateCall: item:" + item + ",updateType:" + updateType + "count:" + item.getMemberList().size());
        //add by mengzhaoxue:如果不是多方会话或者有anotherItem呼入，那么切换会话的icon要隐藏。
        if (item.getMemberList().size() > 1) {
            mOperationLayer.setEventSwitchItemVisibility(true);
        } else {
            //如果本来有another item，但是现在挂断了，那么切换会话的Icon要隐藏
            if (item != null && item.getCallState() == JRCallConstants.State.ENDED && mCurItem != null) {
                mOperationLayer.setEventSwitchItemVisibility(false);
            }
        }
        //end
        if (updateType == JRCallConstants.UPDATE_TYPE_CALL_TO_VIDEO_FAILED) {
            Toast.makeText(this, "转视频通话失败，对方拒绝或不具备视频通话能力", Toast.LENGTH_SHORT).show();
            return;
        }
        if (item == null) {
            return;
        }
        if (mCurItem == null) {
            isAnotherItem = false;
            mCurItem = item;
            mAnotherItem = null;
        } else if (item.getCallId() == mCurItem.getCallId()) {
            isAnotherItem = false;
            mCurItem = item;
            if (mAnotherItem != null && mCurItem.getCallState() == JRCallConstants.State.ENDED) {
                mCurItem = null;
                mOperationLayer.hideMergeCall(false);
                return;
            }
            if (mAnotherItem != null && mCurItem.isHold()) {
                if (isChooseMode) {
                    JRCallStorage.getInstance().setItemToActive(mAnotherItem);
                    JRCall.getInstance().hold(mAnotherItem);
                    mOperationLayer.onUserInfoChanged(mAnotherItem.getMemberList().get(0).getDisplayName(), mAnotherItem.getMemberList().get(0).getNumber());
                    isChooseMode = false;
                }
            }
        } else if (item.getCallId() != mCurItem.getCallId()) {
            isAnotherItem = true;
            mAnotherItem = item;
            if (mCurItem != null && mAnotherItem.isHold()) {
                if (isChooseMode) {
                    JRCallStorage.getInstance().setItemToActive(mCurItem);
                    JRCall.getInstance().hold(mCurItem);
                    isChooseMode = false;
                    mOperationLayer.onUserInfoChanged(mCurItem.getMemberList().get(0).getDisplayName(), mCurItem.getMemberList().get(0).getNumber());
                }
            }
        }
        Log.i(TAG, "updateCall: here!!!!!!!!state:" + item.getCallState());
        //为了解决被叫未接通就挂断，音箱界面不消失的bug，加了是否是ended的判断
        if (!item.isActive() && item.getCallState() != JRCallConstants.State.INCOMING
                && item.getCallState() != JRCallConstants.State.ENDED) {
            return;
        }
        if (item.isConference()) {
            List<JRCallMember> list = item.getMemberList();
            for (JRCallMember member : list) {
                CallCell.addCall(1, JRNumberUtils.formatPhoneByCountryCode(member.getNumber()), JRNumberUtils.formatPhoneByCountryCode(member.getNumber()), this, getMtcState(member.getState()));
            }
            mOperationLayer.setOneCallViewsGone();
        }
        JRLog.log("yidao", "istoconf " + item.isToConference());
        if (!isAnotherItem) {
            mOldState = item.getCallState();
        } else {
            mOldAnotherState = item.getCallState();
        }
        if (!item.isVideo()) {
            JRMediaDevice.getInstance().stopCamera();
            mLocalCanvas = null;
            if (mRemoteCanvas != null) {
                JRMediaDevice.getInstance().stopVideo(mRemoteCanvas);
            }
            mRemoteCanvas = null;
            mVideoLayout.removeAllViews();
            mVideoLayout.setVisibility(View.GONE);
        } else {
            initSurfaceView();
        }
        if (updateType == JRCallConstants.UPDATE_TYPE_CALL_REQ_VIDEO) {
            AlertDialog.Builder builder = new AlertDialog.Builder(JRCallActivity.this);
            builder.setTitle("通知");
            builder.setMessage("对方邀请你视频通话，是否接受?");
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    JRCall.getInstance().answerUpdate(item, false);
                }
            });
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    JRCall.getInstance().answerUpdate(item, true);
                    initSurfaceView();
                }
            });
            builder.create().show();
            if (isAnotherItem) {
                mOldAnotherState = JRCallConstants.State.TALKING;
            } else {
                mOldState = JRCallConstants.State.TALKING;
            }
        }
        updateCallState(item, isAnotherItem);
        mOperationLayer.setLayoutState(item);
        if (mAnotherItem != null) {
            mOperationLayer.showMergeCall();
        } else {
            mOperationLayer.hideMergeCall(item.isVideo());
        }
        if (item.isHold()) {
            mOperationLayer.setHold(true, true);
            mOperationLayer.setStateText("挂起", false, false);
            if (mAnotherItem != null) {
                JRCall.getInstance().answer(mAnotherItem, false);
            }
            return;
        } else {
            mOperationLayer.setHold(false, true);
            if (item.getTalkingBeginTime() != 0 && item.getCallState() == JRCallConstants.State.TALKING) {
                long duration = System.currentTimeMillis() - item.getTalkingBeginTime();
                mOperationLayer.setBaseTime(SystemClock.elapsedRealtime() - duration);
                mOperationLayer.startTimer();
            }
        }
        if (item.isHeld()) {
            mOperationLayer.setHeld(item.isHeld(), !item.isHeld());
            mOperationLayer.setStateText("被挂起", false, false);
        } else {
            if (item.getTalkingBeginTime() != 0 && item.getCallState() == JRCallConstants.State.TALKING) {
                long duration = System.currentTimeMillis() - item.getTalkingBeginTime();
                mOperationLayer.setBaseTime(SystemClock.elapsedRealtime() - duration);
                mOperationLayer.startTimer();
            }
        }
    }

    private void updateCallState(final JRCallItem item, boolean isAnother) {
        switch (item.getCallState()) {
            case INCOMING:
                if (isAnother && mCurItem != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("提示");
                    builder.setMessage("有一路通话接入，是否接听");
                    builder.setCancelable(false);
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            JRCall.getInstance().endCall(item, JRCallConstants.TremReason.BUSY);
                        }
                    });
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (mCurItem.isHold()) {
                                JRCall.getInstance().answer(item, false);
                            } else {
                                JRCall.getInstance().hold(mCurItem);
                            }
                            mOperationLayer.onUserInfoChanged(item.getMemberList().get(0).getDisplayName(), item.getMemberList().get(0).getNumber());
                            mOperationLayer.setEventSwitchItemVisibility(true);
                        }
                    });
                    builder.create().show();
                }
                break;
            case OUTGOING:
                if (item.isConference()) {
                    mOperationLayer.enterConference();
                    List<JRCallMember> list = item.getMemberList();
                    for (JRCallMember member : list) {
                        CallCell.addCall(1, JRNumberUtils.formatPhoneByCountryCode(member.getNumber()), JRNumberUtils.formatPhoneByCountryCode(member.getNumber()), this, getMtcState(member.getState()));
                    }
                }
                if (item.getMemberList().size() > 0) {
                    mOperationLayer.onUserInfoChanged(item.getMemberList().get(0).getDisplayName(), item.getMemberList().get(0).getNumber());
                }
                String number = mCurItem.getMemberList().get(0).getNumber();
                mOperationLayer.setStateText(getString(R.string.calling), false, false);
                mOperationLayer.setStatusIncoming(false, item.isVideo());
                break;
            case ALERTED:
                mOperationLayer.setStateText(getString(R.string.alerting), false, false);
                mOperationLayer.setStatusIncoming(false, item.isVideo());
                break;
            case CONNECTING:

                break;
            case DIDEND:
                Log.i(TAG, "updateCallState: DIDEND");
                break;
            case ENDED:
                Log.i(TAG, "updateCallState: ENDED");
                if (isAnother) {
                    if (mCurItem == null) {
                        mOperationLayer.setStateText(getString(R.string.ending), false, false);
                        mHandler.sendEmptyMessageDelayed(UPDATE_END, 1500);
                        return;
                    } else {
                        mAnotherItem = null;
                        JRCall.getInstance().hold(mCurItem);
                        if (mCurItem.getMemberList().size() > 0) {
                            mOperationLayer.onUserInfoChanged(mCurItem.getMemberList().get(0).getDisplayName(), mCurItem.getMemberList().get(0).getNumber());
                        }
                    }
                } else {
                    if (mAnotherItem == null) {
                        mOperationLayer.setStateText(getString(R.string.ending), false, false);
                        mHandler.sendEmptyMessageDelayed(UPDATE_END, 1500);
                        return;
                    } else {
                        mCurItem = null;
                        JRCall.getInstance().hold(mAnotherItem);
                        if (mAnotherItem.getMemberList().size() > 0) {
                            mOperationLayer.onUserInfoChanged(mAnotherItem.getMemberList().get(0).getDisplayName(), mAnotherItem.getMemberList().get(0).getNumber());
                        }
                    }
                }
                break;
            case RECEIVED:

                break;
            case TALKING:
                if (mMtcBluetoothHelper.getCount() > 0) {
                    setAudio(3);
                }
                if (item.isVideo()) {
                    if (mRemoteCanvas == null) {
                        mRemoteCanvas = JRMediaDevice.getInstance().startVideo(JRMediaDeviceContancts.VIDEO_CAMERA_FRONT);
                        mVideoLayout.addView(mRemoteCanvas.getVideoView());
                        shrinkPreviewSurfaceView(mLocalCanvas.getVideoView(), item.getCallId());
                    }
                    mVideoLayout.setVisibility(View.VISIBLE);
                }
                mOperationLayer.setStatusIncoming(false, item.isVideo());
                if (isAnother && mOldAnotherState != item.getCallState()) {
                    mOperationLayer.resetStateText();
                    mOperationLayer.setHold(false, true);
                    mOperationLayer.showMergeCall();
                    mOperationLayer.setBaseTime(SystemClock.elapsedRealtime());
                    mOperationLayer.startTimer();
                } else if (!isAnother && mOldState != item.getCallState()) {
                    mOperationLayer.resetStateText();
                    mOperationLayer.setHold(false, true);
                    mOperationLayer.hideMergeCall(item.isVideo());
                    mOperationLayer.setBaseTime(SystemClock.elapsedRealtime());
                    mOperationLayer.startTimer();
                }
                break;
        }
    }

    /**
     * 生成通话记录
     *
     * @param callLogType CallLog.Calls.INCOMING_TYPE
     *                    CallLog.Calls.OUTGOING_TYPE
     * @return
     */
    private void insertCallRecord(String phoneNumber, int callLogType) {
        Log.i(TAG, "insertCallRecord: phonenumber:" + phoneNumber + ",type:" + callLogType);
        //插入接入通话记录
        CallRecord callRecord = new CallRecord();
        if (!TextUtils.isEmpty(phoneNumber)) {
            callRecord.setmNumber(phoneNumber);
            callRecord.setmCallLogType(callLogType);
            callRecord.setmCallLogDate(System.currentTimeMillis());
            MyDBProviderHelper.insertCallRecord(MainApplication.sApp, callRecord);
        }
    }

    public void shrinkPreviewSurfaceView(SurfaceView surfaceView, int callId) {
        if (surfaceView == null)
            return;

        MtcNumber localWidth = new MtcNumber();
        MtcNumber localHeight = new MtcNumber();
        MtcCall.Mtc_SessGetVideoLocalSize(callId, localHeight, localWidth);
        if (surfaceView.getWidth() == localWidth.getValue() && surfaceView.getHeight() == localHeight.getValue()) {
            return;
        }
        int screenWidth = JRCommonUtils.getScreenWidth(JRClient.getInstance().getContext());
        int screenHeight = JRCommonUtils.getScreenWidth(JRClient.getInstance().getContext());
        ST_MTC_RECT localRect = JRVideoUtils.calcLocalRect(localWidth.getValue(),
                localHeight.getValue(), screenWidth, screenHeight);
        JRVideoUtils.setViewRect(surfaceView, localRect);
        surfaceView.setOnTouchListener(new JRVideoUtils.OnTouchMoveListener());
    }

    public void onClickDialpad(View v) {
        String dtmfStr = v.getTag().toString();
        mOperationLayer.appendDtmf(dtmfStr);
        if (dtmfStr.length() > 0) {
            JRCall.getInstance().sendDtmf(mCurItem, getJRDtmf(dtmfStr.substring(0, 1)));
        }
    }

    public void onConferenceCellClick(View view) {
        final CallCell callCell = (CallCell) view.getTag();
        if (callCell != null) {
            boolean isInvite = false;
            if (mCurItem != null) {
                for (JRCallMember member : mCurItem.getMemberList()) {
                    JRLog.log("", member.getNumber() + "    " + callCell.mPhone);
                    if (TextUtils.equals(JRNumberUtils.formatPhoneByCountryCode(member.getNumber()), callCell.mPhone)) {
                        if (member.getState() == JRCallConstants.MemberState.LEAVED || member.getState() == JRCallConstants.MemberState.DIALINGOUT) {
                            isInvite = true;
                        }
                    }
                }
            }
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            if (isInvite) {
                b.setMessage(String.format(getString(R.string.invite_member_message), callCell.mName));
            } else {
                b.setMessage(String.format(getString(R.string.kick_member_message), callCell.mName));
            }

            final boolean finalIsInvite = isInvite;
            b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String[] num = {callCell.mPhone};
                    if (finalIsInvite) {
                        JRCall.getInstance().addMultiCallMember(num[0]);
                    } else {
                        JRCall.getInstance().removeMultiCallMember(num[0]);
                    }
//                    callCell.onClick();
                }
            });
            b.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            b.show();

        }
    }

    @Override
    public void onClick(View view) {

    }

    private int getMtcState(JRCallConstants.MemberState state) {
        if (state == JRCallConstants.MemberState.ALERTING) {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_ALERTING;
        } else if (state == JRCallConstants.MemberState.CONNECTED) {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_CONNED;
        } else if (state == JRCallConstants.MemberState.CONNECTING) {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_PENDING;
        } else if (state == JRCallConstants.MemberState.DIALINGIN) {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_DIALINGIN;
        } else if (state == JRCallConstants.MemberState.DIALINGOUT) {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_DIALINGOUT;
        } else if (state == JRCallConstants.MemberState.LEAVED) {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_DISCED;
        } else if (state == JRCallConstants.MemberState.ENDING) {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_DISCING;
        } else if (state == JRCallConstants.MemberState.ONHOLD) {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_ONHOLD;
        } else {
            return JRCommonValue.EN_MTC_CONF_PARTP_STATE_PENDING;
        }
    }

    private JRCallConstants.Dtmf getJRDtmf(String dtmf) {
        switch (dtmf) {
            case "0":
                return JRCallConstants.Dtmf.DTMF_0;
            case "1":
                return JRCallConstants.Dtmf.DTMF_1;
            case "2":
                return JRCallConstants.Dtmf.DTMF_2;
            case "3":
                return JRCallConstants.Dtmf.DTMF_3;
            case "4":
                return JRCallConstants.Dtmf.DTMF_4;
            case "5":
                return JRCallConstants.Dtmf.DTMF_5;
            case "6":
                return JRCallConstants.Dtmf.DTMF_6;
            case "7":
                return JRCallConstants.Dtmf.DTMF_7;
            case "8":
                return JRCallConstants.Dtmf.DTMF_8;
            case "9":
                return JRCallConstants.Dtmf.DTMF_9;
            case "*":
                return JRCallConstants.Dtmf.DTMF_STAR;
            case "#":
                return JRCallConstants.Dtmf.DTMF_POUND;
            case "A":
                return JRCallConstants.Dtmf.DTMF_A;
            case "B":
                return JRCallConstants.Dtmf.DTMF_B;
            case "C":
                return JRCallConstants.Dtmf.DTMF_C;
            case "D":
                return JRCallConstants.Dtmf.DTMF_D;
            default:
                return JRCallConstants.Dtmf.DTMF_0;
        }
    }

    private void initSurfaceView() {
        if (mLocalCanvas == null) {
            mLocalCanvas = JRMediaDevice.getInstance().startCamera(JRMediaDeviceContancts.VIDEO_CAMERA_FRONT);
            mVideoLayout.addView(mLocalCanvas.getVideoView());
        }

        mVideoLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void callCellDidEndConference(CallCell callCell) {

    }

    @Override
    public void callCellNeedsReloadData(CallCell callCell) {
        mOperationLayer.setConferenceList(CallCell.sCallArray);
    }

    @Override
    public void callCellStateChanged(CallCell callCell) {

    }

    @Override
    public void mtcHeadsetStateChanged(boolean plugged) {

    }

    @Override
    public void mtcBluetoothChanged() {
        updateCall(JRCallStorage.getInstance().getCurItem(), -1);
    }

    private void selectAudio() {
        final CallAudioAdapter audioAdapter = new CallAudioAdapter();
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAlertDialog = null;
                if (which < 0) return;
                int audio = audioAdapter.mAudioArray[which];
                setAudio(audio);
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setNegativeButton(android.R.string.cancel, listener);
        builder.setAdapter(audioAdapter, listener);
        mAlertDialog = builder.create();
        mAlertDialog.show();
    }

    class CallAudioAdapter extends BaseAdapter {

        int mAudioArray[];

        CallAudioAdapter() {
            mAudioArray = new int[]{
                    mHeadsetPlugReceiver.mPlugged ? AUDIO_HEADSET : AUDIO_RECEIVER,
                    AUDIO_SPEAKER,
                    AUDIO_BLUETOOTH};
        }

        @Override
        public int getCount() {
            return mAudioArray.length;
        }

        @Override
        public Object getItem(int position) {
            return mAudioArray[position];
        }

        @Override
        public long getItemId(int position) {
            return mAudioArray[position];
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(JRCallActivity.this).inflate(android.R.layout.select_dialog_singlechoice, null);
            }
            CheckedTextView tv = (CheckedTextView) convertView.findViewById(android.R.id.text1);
            int audio = mAudioArray[position];
            if (audio == AUDIO_BLUETOOTH) {
                tv.setText(mMtcBluetoothHelper.mNameList.get(0));
            } else {
                tv.setText(AUDIO_STRINGS[audio]);
            }
            tv.setCompoundDrawablesWithIntrinsicBounds(AUDIO_DRAWABLES[audio], 0, 0, 0);
            tv.setCompoundDrawablePadding((int) (JRCallActivity.this.getResources().getDisplayMetrics().density * 10));
            tv.setChecked(audio == mAudio);
            return convertView;
        }
    }

    private void setAudio(int audio) {
        switch (audio) {
            case AUDIO_RECEIVER:
            case AUDIO_HEADSET:
//                        mOperationLayer.setAudioImage(R.drawable.call_receiver_normal);
                mMtcBluetoothHelper.unlink(false);
                break;
            case AUDIO_SPEAKER:
//                        mOperationLayer.setAudioImage(R.drawable.call_speaker_normal);
                mMtcBluetoothHelper.unlink(true);
                break;
            case AUDIO_BLUETOOTH:
//                        mOperationLayer.setAudioImage(R.drawable.call_bluetooth_normal);
                mMtcBluetoothHelper.link(mMtcBluetoothHelper.mAddressList.get(0));
                break;
        }
        mAudio = audio;
    }
}
