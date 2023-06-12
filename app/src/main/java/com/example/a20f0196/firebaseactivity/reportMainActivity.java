package com.example.a20f0196.firebaseactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.a20f0196.R;

public class reportMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_main);
    }

    public void onecgpa(View view) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        anecgpaBlankFragment onecgpaBlankFragment=new anecgpaBlankFragment();
        fragmentTransaction.replace(R.id.reportfrag,onecgpaBlankFragment);
        fragmentTransaction.commit();



    }


    public void threecgpa(View view) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        threecgpaBlankFragment ThreecgpaBlankFragment=new threecgpaBlankFragment();
        fragmentTransaction.replace(R.id.reportfrag,ThreecgpaBlankFragment);
        fragmentTransaction.commit();
    }

    public void cs_dept(View view) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        csBlankFragment csBlankFragment=new csBlankFragment();
        fragmentTransaction.replace(R.id.reportfrag,csBlankFragment);
        fragmentTransaction.commit();
    }

    public void se_dept(View view) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        seBlankFragment seBlankFragment=new seBlankFragment();
        fragmentTransaction.replace(R.id.reportfrag,seBlankFragment);
        fragmentTransaction.commit();

    }
}