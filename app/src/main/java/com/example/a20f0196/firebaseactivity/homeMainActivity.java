package com.example.a20f0196.firebaseactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a20f0196.R;

public class homeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
    }

    public void report(View view) {
        Intent intent=new Intent(this,reportMainActivity.class);
        startActivity(intent);
    }

    public void update(View view) {
        Intent intent=new Intent(this,updateactivity.class);
        startActivity(intent);
    }

    public void add_student(View view) {
        Intent intent=new Intent(this,firebaseMainActivity.class);
        startActivity(intent);
    }

    public void delete(View view) {
        Intent intent=new Intent(this,deleteactivity.class);
        startActivity(intent);
    }
}