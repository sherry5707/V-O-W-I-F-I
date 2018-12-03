package com.kinstalk.her.voipmode;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.kinstalk.her.vowifivoip.MainApplication;
import com.kinstalk.her.vowifivoip.R;

public class VowWifiService extends Service{
    public static final int STICKY_ID = 11012;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(STICKY_ID, new Notification());
        startService(new Intent(this, FakeService.class));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
