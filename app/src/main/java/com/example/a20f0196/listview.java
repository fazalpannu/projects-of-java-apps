package com.example.a20f0196;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listview extends AppCompatActivity {
    ListView listView;
    SharedPreferences getshrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView=findViewById(R.id.listsong);
         getshrd=getSharedPreferences("demo",0);

    }

    @Override
    protected void onStart() {
        super.onStart();

        String name =getshrd.getString("name","name not");
        String cnic =getshrd.getString("cnic","name not");
        String phone =getshrd.getString("phone","name not");
        String sgpa =getshrd.getString("sgpa","name not");
        String cgpa =getshrd.getString("cgpa","name not");
        ArrayList<String> list=new ArrayList<>();
        list.add(name);
        list.add(cnic);
        list.add(phone);
        list.add(sgpa);
        list.add(cgpa);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

    }
}