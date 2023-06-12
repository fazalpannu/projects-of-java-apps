package com.example.a20f0196.firebaseactivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    FirebaseDatabase database;
    DatabaseReference reference;

    public FirebaseHelper() {
        database=FirebaseDatabase.getInstance("https://fazal-383505-default-rtdb.firebaseio.com/");
        reference=database.getReference("MyDatabase");
    }

    public void addStudentRecord(Student student) {
        // Generate a unique key for the student record
        String key = reference.child("students").push().getKey();

        // Add the student record to the database under the "students" node with the unique key
        reference.child("students").child(key).setValue(student);
    }
}
