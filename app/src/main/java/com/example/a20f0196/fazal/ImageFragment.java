package com.example.a20f0196.fazal;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.a20f0196.R;

public class ImageFragment extends Fragment {
    private ImageView imageView;
    private Bitmap image;
    private boolean visible;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_view, container, false);

        imageView = view.findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImageVisibility();
            }
        });

        return view;
    }

    public void setImage(Bitmap bitmap) {
        this.image = bitmap;
        imageView.setImageBitmap(image);
        imageView.setVisibility(View.VISIBLE);
        visible = true;
    }

    public void toggleImageVisibility() {

        if (visible) {
            imageView.setVisibility(View.GONE);
            visible = false;
        } else {
            imageView.setVisibility(View.VISIBLE);
            visible = true;
        }
    }
}

