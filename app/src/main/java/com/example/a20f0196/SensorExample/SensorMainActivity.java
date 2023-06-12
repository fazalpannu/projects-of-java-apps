package com.example.a20f0196.SensorExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a20f0196.R;

public class SensorMainActivity extends AppCompatActivity implements SensorEventListener {
  View view;
  SensorManager sensorManager;
  Boolean color=false;
  Long lasttimestamp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_main);
        view=findViewById(R.id.txtsensor);
        lasttimestamp=System.currentTimeMillis();
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()== Sensor.TYPE_ACCELEROMETER)
        {
            getAccelerometerValues(event);
        }
    }

    private void getAccelerometerValues(SensorEvent event) {

        float[] values = event.values;

        float x= values[0];

        float y=values[1];
        float z=values[2];
        float Accelerator= (x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        long actualtime=event.timestamp;
        if (Accelerator>=3)
        {
            if (actualtime-lasttimestamp<150)
            {
                return;
            }
            lasttimestamp=actualtime;
            Toast.makeText(this, "Device was moved", Toast.LENGTH_SHORT).show();
if(color)
{
    view.setBackgroundColor(Color.BLUE);
}
else
{
    view.setBackgroundColor(Color.BLACK);
}
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
