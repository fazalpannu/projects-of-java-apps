package com.example.a20f0196.mola;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.a20f0196.R;

import java.io.InputStream;

public class MainActivityfragment extends AppCompatActivity {
    private EditText imageUrlEditText;
    private Button downloadButton;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityfragment2);
        imageUrlEditText = findViewById(R.id.imageUrl);
        downloadButton = findViewById(R.id.downloadButton);
        imageView = findViewById(R.id.imageView);

        // Set a click listener on the button



    }

    public void onClick1(View view) {

        String imageUrl = imageUrlEditText.getText().toString();
        new DownloadImageTask().execute(imageUrl);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

            @Override
            protected Bitmap doInBackground(String... urls) {
                String imageUrl = urls[0];
                Bitmap bitmap = null;
                try {
                    InputStream in = new java.net.URL(imageUrl).openStream();
                    bitmap = BitmapFactory.decodeStream(in);
                } catch (Exception e) {

                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                imageView.setImageBitmap(result);
            }
    }
}