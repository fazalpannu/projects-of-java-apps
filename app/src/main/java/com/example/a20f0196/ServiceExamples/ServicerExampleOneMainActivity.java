package com.example.a20f0196.ServiceExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a20f0196.R;

public class ServicerExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicer_example_one_main);
    }

    public void StartService(View view) {
        Intent intent=new Intent(this,MyServiceExampleOne.class);
        startService(intent);
    }

    public void stopservice(View view) {
        Intent intent=new Intent(this,MyServiceExampleOne.class);
        stopService(intent);
    }
}