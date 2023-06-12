package com.example.a20f0196.firebaseactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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


public class threecgpaBlankFragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference reference;

    private RecyclerView mRecyclerView;
    private StudentAdapter mAdapter;
    ArrayList<Student> stud = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_threecgpa_blank, container, false);

        database = FirebaseDatabase.getInstance("https://fazal-383505-default-rtdb.firebaseio.com/");
        reference = database.getReference("MyDatabase");

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Student> students = getReportAllStudentsCgpaLessThan2();

//        mAdapter = new StudentAdapter(getActivity(), stud);
//        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setStudents(stud);
        return view;
    }

//    public void getReportAllStudentsCgpaGreaterThan3() {
//        // Query the database to retrieve all student records with a CGPA of 3.0 or greater
////        Query query = reference.child("students").orderByChild("cgpa").startAt(3.0);
//        Query query = reference.child("students").orderByChild("cgpa").endAt(1.99);
//        stud.clear();
//        // Attach a listener to retrieve the data
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
//                    Student student = childSnapshot.getValue(Student.class);
//                    stud.add(student);
//                }
//
//                mAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.e("TAG", "getReportAllStudentsCgpaGreaterThan3:onCancelled", error.toException());
//            }
//        });
//    }
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
            mAdapter = new StudentAdapter(getActivity(), students);
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