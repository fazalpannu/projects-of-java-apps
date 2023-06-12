package com.example.a20f0196.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.a20f0196.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class NewStudentMainActivity extends AppCompatActivity {
FirebaseDatabase database;
DatabaseReference reference;
RecyclerView recyclerView;
ArrayList<NewStudents> messagelist;
FirebaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student_main);
        recyclerView=findViewById(R.id.firebaserecyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        database=FirebaseDatabase.getInstance("https://fazal-383505-default-rtdb.firebaseio.com/");
        reference=database.getReference("MyDatabase");
        messagelist =new ArrayList<>();

    }

    public  void ReadDataBaseFromFirebase()
    {
        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot:datasnapshot.getChildren())
                {
                    NewStudents students=new NewStudents();
                    students.setName(Objects.requireNonNull(snapshot.child("Name").getValue()).toString());
                    students.setUrl(Objects.requireNonNull(snapshot.child("Picture").getValue()).toString());
                    messagelist.add(students);
                }

                adapter=new FirebaseAdapter(messagelist,getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}