package com.example.a20f0196.listviewexample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a20f0196.R;

public class imageandtextadapter extends ArrayAdapter<String> {
    Activity activity;
    String[] Name;
    String[] Text;
    int[] Image;


    public imageandtextadapter( Activity activity,String[] name, String[] text, int[] image) {
        super(activity, R.layout.imageandtext,text);
        this.activity = activity;
        Name = name;
        Text = text;
        Image = image;
    }

    public imageandtextadapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    @SuppressLint("MissingInflatedId")
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View ViewHolder=inflater.inflate(R.layout.imageandtext,null);
         TextView textName =ViewHolder.findViewById(R.id.txtoneimageandtext);
        TextView textText =ViewHolder.findViewById(R.id.txtsecondimageandtext);
        ImageView imageView=ViewHolder.findViewById(R.id.imgimagandtext);
        textName.setText(Name[position]);
        textText.setText(Text[position]);
        imageView.setImageResource(Image[position]);
        return ViewHolder;

    }
}
