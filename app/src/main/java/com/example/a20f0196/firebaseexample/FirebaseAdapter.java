package com.example.a20f0196.firebaseexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.TaskExecutor;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a20f0196.R;

import java.util.ArrayList;

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseAdapter.Viewholder>{
    ArrayList<NewStudents> StudentArrayList;
    Context context;

    public FirebaseAdapter(ArrayList<NewStudents> studentArrayList, Context context) {
        StudentArrayList = studentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message_items,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.textView.setText(StudentArrayList.get(position).getName());
        Glide.with(context).load(StudentArrayList.get(position).getUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder{
ImageView imageView;
TextView textView;

    public Viewholder(@NonNull View view) {
        super(view);

        textView= view.findViewById(R.id.firebasetextview);
        imageView=view.findViewById(R.id.firebaseimageview);
    }}
}
