package com.example.a20f0196.firebaseactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class updateactivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;

    private EditText mNameEditText;
    private EditText DepartmentEditText;
    private EditText mRegNoEditText;
    private EditText mCgpaEditText;
    private EditText mEmailEditText;
    private Button mUpdateStudentRecordButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateactivity);
        database= FirebaseDatabase.getInstance("https://fazal-383505-default-rtdb.firebaseio.com/");
        reference=database.getReference("MyDatabase");
        mNameEditText = findViewById(R.id.Name1);
        DepartmentEditText = findViewById(R.id.dept1);
        mRegNoEditText = findViewById(R.id.reg1);
        mCgpaEditText = findViewById(R.id.cgpa1);
        mEmailEditText = findViewById(R.id.email1);
        mUpdateStudentRecordButton = findViewById(R.id.update_student_record_button);

        //...

        mUpdateStudentRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regNo = mRegNoEditText.getText().toString();
                String name = mNameEditText.getText().toString();
                String dept =  DepartmentEditText.getText().toString();
                String cgpa = mCgpaEditText.getText().toString();
                String email = mEmailEditText.getText().toString();

                // Update the student record with the specified registration number
                updateStudentRecord(regNo, name, dept, cgpa, email);
            }
        });
    }




    public void updateStudentRecord(String regNo, String name, String dept, String cgpa, String email) {
        // Query the database to find the student record with the specified registration number
        Query query = reference.child("students").orderByChild("regNo").equalTo(regNo);

        // Attach a listener to retrieve the matching data
        query.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // If a matching student record is found, update it in the database
                if (snapshot.exists()) {
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        childSnapshot.getRef().child("name").setValue(name);
                        childSnapshot.getRef().child("dept").setValue(dept);
                        childSnapshot.getRef().child("cgpa").setValue(cgpa);
                        childSnapshot.getRef().child("email").setValue(email);
                    }
                    Toast.makeText(updateactivity.this, "Student record updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(updateactivity.this, "No matching student record found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("TAG", "updateStudentRecord:onCancelled", error.toException());
            }
        });
    }

}