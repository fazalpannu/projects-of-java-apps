package com.example.a20f0196.broadcastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.a20f0196.R;

public class AirPlaneModeChangeMainActivity extends AppCompatActivity {
    AIrPlaneModeChange aIrPlaneModeChange=new AIrPlaneModeChange();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_plane_mode_change_main);


    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(aIrPlaneModeChange,intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(aIrPlaneModeChange);
    }
}