package com.example.a20f0196.asynclassexampleclass;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.a20f0196.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class webcontentdownload extends AppCompatActivity {
TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcontentdownload);
    textView=findViewById(R.id.edtasyntask);
    }

    public void download_web_content(View view) throws ExecutionException, InterruptedException {
        downloadwebcontent obj=new downloadwebcontent();


        String recievedata=obj.execute("https://www.google.com/").get();
        textView.setText(recievedata);
        Log.d("Tag","BAck in main");

    }
    public class downloadwebcontent extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {

            try {
                Log.d("Tag","Do inbackground in progress");
                URL url=new URL(strings[0]);
                HttpsURLConnection connection=(HttpsURLConnection)  url.openConnection();
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);
                int data=reader.read();
                String webcontent="";
                while (data !=-1)
                {
                    char ch=(char) data;
                    webcontent +=ch;
                    data=reader.read();
                }

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

return null;
        }
    }
}