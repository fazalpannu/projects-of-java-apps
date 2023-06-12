package com.example.a20f0196.filehandling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20f0196.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileHandlingMainActivity extends AppCompatActivity {
EditText editText;
TextView textView;
String FILE_NAME="MyTextFile";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handling_main);
    editText=findViewById(R.id.filehandlinng);
    textView=findViewById(R.id.txtfilehandling);

    }

    public void save_text(View view) {
        String TextDate= editText.getText().toString();
        try {
            FileOutputStream outputStream=openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            outputStream.write(TextDate.getBytes());
            editText.setText("");
            Snackbar.make(view,"text save",Snackbar.LENGTH_LONG).show();

            outputStream.close();
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void show_txtdata(View view) {
        String readTextData="";
        try {
            FileInputStream inputStream=openFileInput(FILE_NAME);
            InputStreamReader reader= new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String text=bufferedReader.readLine();
            if(text==null)
            {
                Toast.makeText(this,"file empty",Toast.LENGTH_SHORT).show();

            }
            else {
                while (text!=null)
                {
                    readTextData=readTextData+text;
                    text=bufferedReader.readLine();
                }
                bufferedReader.close();
                inputStream.close();
                reader.close();
                textView.setText(readTextData);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}