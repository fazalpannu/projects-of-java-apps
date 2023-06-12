//package com.example.a20f0196.CardViewExample;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.example.a20f0196.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyClassViewAdapter extends RecyclerView.Adapter<MyClassViewAdapter.My_CardView_Holder>{
//public Context context;
//
//    public MyClassViewAdapter(Context context, ArrayList<mymodel> modelList) {
//        this.context = context;
//        this.modelList = modelList;
//    }
//
//    public ArrayList<mymodel> modelList;
//    @NonNull
//    @Override
//    public My_CardView_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card,parent,false);
//       return new My_CardView_Holder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull My_CardView_Holder holder, int position) {
//        mymodel mymodel1=modelList.get(position);
//        holder.name.setText(mymodel1.getName());
//        holder.name.setText(mymodel1.getDownloadCount());
//        Glide.with(context).load(mymodel1.getThumbnail()).into(holder.thumbnail);
//
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return  modelList.size();
//    }
//
//    public class My_CardView_Holder extends RecyclerView.ViewHolder
//    {
//ImageView thumbnail;
//TextView name ,count;
//
//        public My_CardView_Holder(@NonNull View v) {
//            super(v);
//            thumbnail=v.findViewById(R.id.imgcardview);
//            name=v.findViewById(R.id.txt1cardview);
//            count=v.findViewById(R.id.txt2cardview);
//        }
//    }
//}
