package com.example.a20f0196.SensorExample.RestApiExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20f0196.R;

import java.util.List;

public class myrestadapter extends RecyclerView.Adapter<myrestadapter.ViewHolder>{
 public List<MypPostModel> list;
 public Context context;

    public myrestadapter(List<MypPostModel> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.myrestlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.name.setText(list.get(position).getTitle());
holder.content.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,content;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            name=itemView.findViewById(R.id.txtrestname);
            content=itemView.findViewById(R.id.txtrestcontent);
        }
    }
}
