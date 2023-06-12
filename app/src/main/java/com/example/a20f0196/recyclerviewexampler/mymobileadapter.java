package com.example.a20f0196.recyclerviewexampler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20f0196.R;

import java.util.ArrayList;

public class mymobileadapter extends RecyclerView.Adapter<mymobileadapter.ViewHolder>{
    private ArrayList<mymobile> mymobileList;

    public mymobileadapter(ArrayList<mymobile> mymobileList) {
        this.mymobileList = mymobileList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_row,parent,false);
    ViewHolder obj=new ViewHolder(view);
    return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
mymobile mymobile1= mymobileList.get(position);
holder.M_Name.setText(mymobile1.getName());
holder.M_company.setText(mymobile1.getCompany());
holder.M_Price.setText(mymobile1.getPrice());
    }

    @Override
    public int getItemCount() {
        return mymobileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
public TextView M_Name,M_company,M_Price;
        public ViewHolder(@NonNull View v) {
            super(v);
            M_Name=v.findViewById(R.id.txtmobilename);
            M_company=v.findViewById(R.id.txtmobilecompany);
            M_Price=v.findViewById(R.id.txtmobileprice);

        }
    }
}
