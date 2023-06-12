package com.example.a20f0196;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button botton;
    TextView textview1,textview2,textview3,textview4,textview5;
    EditText editText1,editText2,editText3,editText4,editText5;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botton=findViewById(R.id.save1);
        textview1=findViewById(R.id.textView5);
        textview2=findViewById(R.id.textView);
        textview3=findViewById(R.id.textView2);
        textview4=findViewById(R.id.textView3);
        textview5=findViewById(R.id.textView4);
        editText1=findViewById(R.id.Name1);
        editText2=findViewById(R.id.cnic);
        editText3=findViewById(R.id.phone);
        editText4=findViewById(R.id.sgpa);
        editText5=findViewById(R.id.cgpa1);


    }

    public void start(View view) {
        String name= editText1.getText().toString();
        String cnic= editText2.getText().toString();
        String phone= editText3.getText().toString();
        String sgpa= editText4.getText().toString();
        String cgpa= editText5.getText().toString();


        SharedPreferences shrd=getSharedPreferences("demo",0);
        SharedPreferences.Editor editor=shrd.edit();

        editor.putString("name",name);
        editor.putString("cnic",cnic);
        editor.putString("phone",phone);
        editor.putString("sgpa",sgpa);
        editor.putString("cgpa",cgpa);
        editor.apply();
        Intent intent = new Intent(this, listview.class);
        startActivity(intent);
    }
}