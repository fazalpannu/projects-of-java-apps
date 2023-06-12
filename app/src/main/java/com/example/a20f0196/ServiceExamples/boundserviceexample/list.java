package com.example.a20f0196.ServiceExamples.boundserviceexample;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a20f0196.R;

import java.io.File;
import java.util.ArrayList;

public class list extends AppCompatActivity {

    public ListView myListViewForSongs;
    public   String[] items;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myListViewForSongs=findViewById(R.id.musiclist);
        ActivityCompat.requestPermissions(this,new String[]{READ_EXTERNAL_STORAGE},101);

//        check_for_permission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==101 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
        {
            Display();
            Toast.makeText(this,"permission granted",Toast.LENGTH_SHORT).show();

        }
    }

    public ArrayList<File> findsong(File file)
    {
        ArrayList<File> arrayList=new ArrayList<>();
        File[] files=file.listFiles();
        for (File singleFile:files)
        {
            if(singleFile.isDirectory()&& !singleFile.isHidden())
            {
                arrayList.addAll(findsong(singleFile));
            }
            else {
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav") )
                {
                    arrayList.add(singleFile);
                }
            }
        }
        return arrayList;
    }

    void Display(){
        final ArrayList<File> mySongs =findsong(Environment.getExternalStorageDirectory());
        items=new String[mySongs.size()];

        for(int i=0;i<mySongs.size();i++)
        {
            items[i]=mySongs.get(i).getName().toString().replace(".mp3","").replace(".wav","");
        }
        ArrayAdapter<String> myadapter=new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1,items);
        myListViewForSongs.setAdapter(myadapter);

    }


}