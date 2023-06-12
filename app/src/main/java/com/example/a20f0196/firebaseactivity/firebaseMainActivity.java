package com.example.a20f0196.firebaseactivity;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a20f0196.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class firebaseMainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;

        private EditText mNameEditText;
        private EditText mDepartmentEditText;
        private EditText mRegNoEditText;
        private EditText mCgpaEditText;
        private EditText mEmailEditText;
        private Button mAddStudentRecordButton;

//        private FirebaseHelper mFirebaseHelper;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_firebase_main2);
            database= FirebaseDatabase.getInstance("https://fazal-383505-default-rtdb.firebaseio.com/");
            reference=database.getReference("MyDatabase");
            mNameEditText = findViewById(R.id.Name1);
            mDepartmentEditText = findViewById(R.id.dept1);
            mRegNoEditText = findViewById(R.id.reg1);
            mCgpaEditText = findViewById(R.id.cgpa1);
            mEmailEditText = findViewById(R.id.email1);
            mAddStudentRecordButton = findViewById(R.id.save1);


//            mFirebaseHelper = new FirebaseHelper();

            mAddStudentRecordButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = mNameEditText.getText().toString();
                    String dept = mDepartmentEditText.getText().toString();
                    String regNo = mRegNoEditText.getText().toString();
                    float cgpa = Float.parseFloat(mCgpaEditText.getText().toString());
                    String email = mEmailEditText.getText().toString();
                    String key = reference.child("students").push().getKey();
                    // Create a new Student object
                    Student student = new Student(name, dept, regNo, cgpa, email);
                    reference.child("students").child(key).setValue(student);
                    // Add the student record to the database
//                    mFirebaseHelper.addStudentRecord(student);

                    Toast.makeText(firebaseMainActivity.this, "Student record added successfully", LENGTH_SHORT).show();

//                    Intent intent= new Intent(firebaseMainActivity.this,deleteactivity.class);
//                    startActivity(intent);
                }

            });
        }



}