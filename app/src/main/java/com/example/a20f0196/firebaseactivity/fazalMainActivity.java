package com.example.a20f0196.firebaseactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a20f0196.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class fazalMainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;

    private RecyclerView mRecyclerView;
    private StudentAdapter mAdapter;
    ArrayList<Student> stud = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazal_main);
        database = FirebaseDatabase.getInstance("https://fazal-383505-default-rtdb.firebaseio.com/");
        reference = database.getReference("MyDatabase");

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Student> students = getReportAllStudentsCgpaLessThan2();

//        mAdapter = new StudentAdapter(this, stud);
//        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setStudents(stud);
    }





    public ArrayList<Student> getReportAllStudentsCgpaLessThan2() {
        // Query the database to retrieve all student records with a CGPA of 1.99 or less
        Query query = reference.child("students").orderByChild("cgpa").endAt(4.00);

//        Query query = reference.child("students").orderByChild("cgpa").endAt(1.99);
//        Query query = reference.child("students").orderByChild("dept").equalTo("CS");
//        Query query = reference.child("students").orderByChild("dept").equalTo("SE");
        ArrayList<Student> students = new ArrayList<>();
        // Attach a listener to retrieve the data
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    Student student = childSnapshot.getValue(Student.class);
                    students.add(student);
                }
                mAdapter = new StudentAdapter(fazalMainActivity.this, students);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.setStudents(students);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("TAG", "getReportAllStudentsCgpaLessThan2:onCancelled", error.toException());
            }
        });
        return students;
    }



}