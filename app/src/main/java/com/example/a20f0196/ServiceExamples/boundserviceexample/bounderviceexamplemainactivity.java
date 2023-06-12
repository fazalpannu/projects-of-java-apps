package com.example.a20f0196.ServiceExamples.boundserviceexample;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission_group.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a20f0196.R;

import java.io.File;
import java.util.ArrayList;


public class bounderviceexamplemainactivity extends AppCompatActivity {


    private myboundservice myboundservice;
    private boolean myboundserviceflag=false;
    private ServiceConnection myserviceconnection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder IBinder) {
            myboundservice.MyBinder myBinder=(myboundservice.MyBinder) IBinder;
            myboundservice =myBinder.getServiceMethod();
            myboundserviceflag =true;
            Log.d("Tag","connectoion created");

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounderviceexamplemainactivity);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent(this,myboundservice.class);
        bindService(intent,myserviceconnection,BIND_AUTO_CREATE);

    }








    @Override
    protected void onStop() {
        super.onStop();
        if (myboundserviceflag==true)
        {
            unbindService(myserviceconnection);

        }
    }

    public void playpause(View view) {
        if(myboundserviceflag == true)
        {
            if(! myboundservice.isplay())
            {
                myboundservice.play();
            }

        }
    }

    public void stopmusic(View view) {
        if(myboundserviceflag == true)
        {
            if( myboundservice.isplay())
            {
                myboundservice.stop();


            }

        }
    }


    public void forward(View view) {

        if(myboundserviceflag == true)
        {
            if( myboundservice.isplay())
            {
                myboundservice.forwardSong();


            }

        }
    }

    public void backward(View view) {
        if(myboundserviceflag == true)
        {
            if( myboundservice.isplay())
            {
                myboundservice.rewindSong();


            }

        }
    }

    public void pause(View view) {
        if(myboundserviceflag == true)
        {
            if( myboundservice.isplay())
        {
            myboundservice.pause();
        }

    }}
}