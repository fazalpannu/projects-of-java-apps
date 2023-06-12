package com.example.a20f0196.recyclerviewexampler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.a20f0196.R;

import java.util.ArrayList;
import java.util.List;

public class recyclerviewmainactivity extends AppCompatActivity {
 RecyclerView recyclerView;
 ArrayList<mymobile > mymobileList=new ArrayList<>();
 mymobileadapter adapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerviewmainactivity);

    recyclerView=findViewById(R.id.my_recycle_view);
    adapter=new mymobileadapter(mymobileList);
    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(adapter);
        insert();
    }
    public void insert()
    {
mymobile obj1=new mymobile("Note 10","samsung","10000");
mymobileList.add(obj1);

        mymobile obj2=new mymobile("Note 10","samsung","10000");
        mymobileList.add(obj2);

adapter.notifyDataSetChanged();
    }
}