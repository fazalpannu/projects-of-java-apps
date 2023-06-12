package com.example.a20f0196.permissionexamplle;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission_group.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a20f0196.R;

import java.util.Calendar;

public class permissionexample1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissionexample1);
    }

    public void requestforpermission(View view) {
        ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION,CAMERA},101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==101 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this,"permission granted",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkforpermission() {
        int result_p1= ContextCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION);

        int result_p2= ContextCompat.checkSelfPermission(this, CAMERA);
        return  result_p1== PackageManager.PERMISSION_GRANTED&&
                result_p2==PackageManager.PERMISSION_GRANTED;
    }

    public void check_for_permission(View view) {
        if(!checkforpermission())
        {
            Toast.makeText(this,"Permission already granted",Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this,"Request for permission",Toast.LENGTH_SHORT).show();
        }
    }
}