package com.example.a20f0196.listviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a20f0196.R;

import java.util.ArrayList;
import java.util.HashMap;

public class multicolumnlisteviewadapter extends BaseAdapter {
    public ArrayList<HashMap<String,String>> list;
    Activity activity;
    public static final String First_Column="first";
    public static final String Second_Column="Second";
    public static final String Third_Column="Third";

    public multicolumnlisteviewadapter(ArrayList<HashMap<String, String>> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater  inflater= activity.getLayoutInflater();
        ViewHolder viewHolder=new ViewHolder();
        if(view==null)
        {
            view=inflater.inflate(R.layout.multicolumnlistview,null);
            viewHolder.textView1=view.findViewById(R.id.txt1multicolumnexample);
            viewHolder.textView2=view.findViewById(R.id.txt2multicolumnexample);
            viewHolder.textView3=view.findViewById(R.id.txt3multicolumnexample);
            view.setTag(viewHolder);
        }
        else
            viewHolder =( ViewHolder)  view.getTag();
        HashMap<String,String> hashmap= new HashMap<String, String>();
        hashmap=list.get(position);
        viewHolder.textView1.setText(hashmap.get(First_Column));
        viewHolder.textView2.setText(hashmap.get(Second_Column));
        viewHolder.textView3.setText(hashmap.get(Third_Column));
        return view;

    }
    public  class ViewHolder
    {
        TextView textView1,textView2,textView3;
    }
}
