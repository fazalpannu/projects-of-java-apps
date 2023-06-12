package com.example.a20f0196.fazal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import com.example.a20f0196.R;

public class fragment extends AppCompatActivity {
    EditText editText;
    Button button;
    ImageFragment fragment1, fragment2, fragment3, fragment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment2);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);

        fragment1 = new ImageFragment();
        fragment2 = new ImageFragment();
        fragment3 = new ImageFragment();
        fragment4 = new ImageFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_1, fragment1)
                .add(R.id.fragment_container_2, fragment2)
                .add(R.id.fragment_container_3, fragment3)
                .add(R.id.fragment_container_4, fragment4)
                .commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editText.getText().toString();
                new DownloadImageTask(fragment1).execute(url);
                new DownloadImageTask(fragment2).execute(url);
                new DownloadImageTask(fragment3).execute(url);
                new DownloadImageTask(fragment4).execute(url);
            }
        });
    }
    public void toggleImageVisibility(ImageFragment fragment) {
        fragment.toggleImageVisibility();
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageFragment fragment;

        public DownloadImageTask(ImageFragment fragment) {
            this.fragment = fragment;
        }

        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                fragment.setImage(result);
            } else {
                Toast.makeText(fragment.this, "Unable to download image", Toast.LENGTH_SHORT).show();
            }
        }
    }
}