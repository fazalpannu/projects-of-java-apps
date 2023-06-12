package com.example.a20f0196.firebaseactivity;

import static android.widget.Toast.LENGTH_SHORT;

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

public class deleteactivity extends AppCompatActivity {
    private Button mDeleteStudentRecordButton;
    FirebaseDatabase database;
    EditText mRegNoEditText;
    DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteactivity);
        database= FirebaseDatabase.getInstance("https://fazal-383505-default-rtdb.firebaseio.com/");
        reference=database.getReference("MyDatabase");
        mDeleteStudentRecordButton = findViewById(R.id.delete_student_record_button);
        mRegNoEditText=findViewById(R.id.mRegNo);

        //...

        mDeleteStudentRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regNo = mRegNoEditText.getText().toString();

                // Delete the student record with the specified registration number
                deleteStudentRecord(regNo);
            }
        });

    }

    public void deleteStudentRecord(String regNo) {
        // Query the database to find the student record with the specified registration number
        Query query = reference.child("students").orderByChild("regNo").equalTo(regNo);

        // Attach a listener to retrieve the matching data
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // If a matching student record is found, delete it from the database
                if (snapshot.exists()) {
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        childSnapshot.getRef().removeValue();
                    }
                    Toast.makeText(deleteactivity.this, "Student record deleted successfully", LENGTH_SHORT).show();
                } else {
                    Toast.makeText(deleteactivity.this, "No matching student record found", LENGTH_SHORT).show();
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("TAG", "deleteStudentRecord:onCancelled", error.toException());
            }
        });











    }
}