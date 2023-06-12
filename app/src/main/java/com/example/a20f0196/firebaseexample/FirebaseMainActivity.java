package com.example.a20f0196.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.a20f0196.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseMainActivity extends AppCompatActivity {
FirebaseDatabase database;
DatabaseReference reference;
TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);


        database=FirebaseDatabase.getInstance("https://f-0196-smd-final-default-rtdb.firebaseio.com/");
        reference=database.getReference("MyDatabase");

        textView= findViewById(R.id.txtfirebase);
    }

    public void senddatatofirebase(View view) {
//reference.child("student").child("Name").setValue("ali");
//        reference.child("student").child("age").setValue("23");
//        Log.d("TAG","sent");


        String id=reference.push().getKey();
        String name="ALI";
        String city="fsd";
        Fast_student obj=new Fast_student(id,name,city);
        reference.child(id).setValue(obj);

//reference.setValue("myfirstname");

    }

    public void readfromfirebase(View view) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value=snapshot.getValue().toString();
                textView.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}