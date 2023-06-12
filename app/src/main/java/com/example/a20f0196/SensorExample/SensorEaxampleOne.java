package com.example.a20f0196.SensorExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a20f0196.R;

public class SensorEaxampleOne extends AppCompatActivity {
        TextView textView;
        SensorManager sensorManager;
        Sensor sensor;
    @SuppressLint({"ServiceCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_eaxample_one);
        textView = findViewById(R.id.txtsensorvalue);
        sensorManager = (SensorManager) getSystemService(this.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (sensor == null) {

            textView.setText("no sensor value");
        } else {
            sensorManager.registerListener(proximitySensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }


    }


    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
             if (event.values[0]==0)
                textView.setText("object near");
            } else {
                textView.setText("object ias away");
            }


        }


        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

}