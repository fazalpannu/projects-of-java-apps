package com.example.a20f0196.firebaseactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20f0196.R;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> mStudents;
    private Context mContext;

    public StudentAdapter(Context context, List<Student> students) {
        this.mContext = context;
        this.mStudents = students;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = mStudents.get(position);
        holder.nameTextView.setText(student.getName());
        holder.departmentTextView.setText(student.getDept());
        holder.regNoTextView.setText(student.getRegNo());
        holder.cgpaTextView.setText(String.valueOf(student.getCgpa()));
        holder.emailTextView.setText(student.getEmail());
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public void setStudents(List<Student> students) {
        mStudents = students;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView departmentTextView;
        public TextView regNoTextView;
        public TextView cgpaTextView;
        public TextView emailTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
            departmentTextView = itemView.findViewById(R.id.department_text_view);
            regNoTextView = itemView.findViewById(R.id.reg_no_text_view);
            cgpaTextView = itemView.findViewById(R.id.cgpa_text_view);
            emailTextView = itemView.findViewById(R.id.email_text_view);
        }
    }

}

