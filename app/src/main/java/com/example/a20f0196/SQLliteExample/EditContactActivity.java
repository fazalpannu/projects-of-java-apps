package com.example.a20f0196.SQLliteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.a20f0196.R;

import java.util.HashMap;

public class EditContactActivity extends AppCompatActivity {


    EditText firstName, lastName, phoneNumber, emailAddress, homeAddress;
    DbQuerie dbQuerie;
    String id;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        Intent intent=getIntent();
         id=intent.getExtras().getString("id");
        dbQuerie=new DbQuerie(getApplicationContext());
        HashMap<String,String> singleContact= dbQuerie.getSingleContact(id);



        firstName = (EditText) findViewById(R.id.editfirstname);
        lastName = (EditText) findViewById(R.id.editsecondname);
        phoneNumber = (EditText) findViewById(R.id.editphonenumber);
        emailAddress = (EditText) findViewById(R.id.editemailaddress);
        homeAddress = (EditText) findViewById(R.id.edithomeaddress);

    }

    public void update(View view) {
        HashMap<String,String> contact=new HashMap<String ,String>();
        contact.put("firstName",firstName.getText().toString());
        contact.put("lastName",lastName.getText().toString());
        contact.put("phoneNumber",phoneNumber.getText().toString());
        contact.put("emailAddress",emailAddress.getText().toString());
        contact.put("homeAddress",homeAddress.getText().toString());
        dbQuerie.updateContact( id, contact);

        Intent intent= new Intent(this,MainActivityContactList.class);
        startActivity(intent);
    }

    public void delete(View view) {

        dbQuerie.deleteContact(id);
        Intent intent= new Intent(this,MainActivityContactList.class);
        startActivity(intent);
    }
}