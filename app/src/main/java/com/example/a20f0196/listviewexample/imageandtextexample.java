package com.example.a20f0196.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.a20f0196.R;

public class imageandtextexample extends AppCompatActivity {
 String Name[]= {"ALi","Ahmad","Laiba","Maryyam","Nawaz"};
 String Text[]={"Hello Ali","Ok Ahmad","Noted","Vote ko izzat do","Mujy ku nikala"};
 int Image[]={R.drawable.one,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.fifth};

  ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageandtextexample);
        listView=findViewById(R.id.lstimageandtext);
        imageandtextadapter adapter=new imageandtextadapter(this,Name,Text,Image);
        listView.setAdapter(adapter);
    }
}