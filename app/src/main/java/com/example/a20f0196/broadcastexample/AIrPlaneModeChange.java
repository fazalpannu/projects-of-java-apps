package com.example.a20f0196.broadcastexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AIrPlaneModeChange extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirplaneModeOn(context.getApplicationContext()))
        {
            Toast.makeText(context,"On Airplane",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(context,"Off Airplane",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAirplaneModeOn(Context applicationContext) {

        return Settings.System.getInt(applicationContext.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0)!=0;
    }
}
