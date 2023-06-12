package com.example.a20f0196.FragmentExamples.communicationbetweenfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a20f0196.R;

public class CMMainActivity extends AppCompatActivity
        implements ButtonPressListner.onButtonPressListner
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmmain);
    }

    @Override
    public void onButtonPressed(String Message) {
        MyFragment2 obj=(MyFragment2) getSupportFragmentManager().findFragmentById(R.id.frag2);
        obj.onFragmentInterection(Message);
    }
}