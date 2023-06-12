package com.example.a20f0196.ServiceExamples;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MyServiceExampleOne extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
    return START_STICKY;//service call
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service stop", Toast.LENGTH_SHORT).show();
    }
}
