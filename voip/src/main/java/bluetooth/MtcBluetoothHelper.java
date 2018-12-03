package bluetooth;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import com.juphoon.rcs.JRLog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MtcBluetoothHelper extends MtcBluetooth {
    private Context mContext;

    public interface Callback {
        void mtcBluetoothChanged();
    }

    public ArrayList<String> mNameList = new ArrayList<String>();
    public ArrayList<String> mAddressList = new ArrayList<String>();

    private boolean mSpeakerOn = false;

    public MtcBluetoothHelper(Context context) {
        super(context);
        mContext = context;
    }

    public void setCallback(Callback callback) {
        mCallback = (callback == null) ? null : new WeakReference<Callback>(callback);
    }

    public Callback getCallback() {
        return (mCallback == null) ? null : mCallback.get();
    }

    public boolean unlink(boolean speakerOn) {
        boolean ret = super.unlink();
        AudioManager audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setSpeakerphoneOn(speakerOn);
        mSpeakerOn = speakerOn;
        return ret;
    }

    @Override
    public void onScoAudioDisconnected() {
//        if (MtcLog.DEBUG) MtcLog.log(TAG, "onScoAudioDisconnected");
        AudioManager audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setSpeakerphoneOn(mSpeakerOn);
    }

    @Override
    public void onScoAudioConnected() {
//        if (MtcLog.DEBUG) MtcLog.log(TAG, "onScoAudioConnected");
        mSpeakerOn = false;
    }

    @Override
    public void onHeadsetDisconnected(final String address) {
        JRLog.log("yidao","bluetooth  dis");
        int index = mAddressList.indexOf(address);
        mAddressList.remove(index);
        mNameList.remove(index);
        Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.mtcBluetoothChanged();
    }

    @Override
    public void onHeadsetConnected(final String address, final String name) {
        JRLog.log("yidao","bluetooth  con");
        mAddressList.add(address);
        mNameList.add(name);
        Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.mtcBluetoothChanged();
    }

    public int getCount() {
        Log.e("yidao", "getCount: " + mNameList.size());
        return mNameList.size();
    }

    private WeakReference<Callback> mCallback;

    private static final String TAG = MtcBluetoothHelper.class.getName();
}
