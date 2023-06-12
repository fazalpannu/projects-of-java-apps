package com.example.a20f0196.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a20f0196.R;

import java.util.ArrayList;
import java.util.HashMap;

public class multicolumnlistviewexample extends AppCompatActivity {
    ListView listView;
    Activity activity;
    public ArrayList<HashMap<String,String>> list;
    public static final String First_Column="first";
    public static final String Second_Column="Second";
    public static final String Third_Column="Third";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multicolumnlistviewexample);
        listView=findViewById(R.id.lstmulticolumnexample);
        list= new ArrayList<HashMap<String, String>>();
        loaddata();
        multicolumnlisteviewadapter adapter=new multicolumnlisteviewadapter(list,this);
        listView.setAdapter(adapter);

    }
    public void loaddata()
    {
        HashMap<String,String> hashMap1=new HashMap<String, String>();
        hashMap1.put(First_Column,"ali");
        hashMap1.put(Second_Column,"fazal");
        hashMap1.put(Third_Column,"ali");
        list.add(hashMap1);

        HashMap<String,String> hashMap2=new HashMap<String, String>();
        hashMap2.put(First_Column,"ali");
        hashMap2.put(Second_Column,"fazal");
        hashMap2.put(Third_Column,"ali");

        list.add(hashMap2);


        HashMap<String,String> hashMap3=new HashMap<String, String>();
        hashMap3.put(First_Column,"ali");
        hashMap3.put(Second_Column,"fazal");
        hashMap3.put(Third_Column,"ali");

        list.add(hashMap3);

    }

}