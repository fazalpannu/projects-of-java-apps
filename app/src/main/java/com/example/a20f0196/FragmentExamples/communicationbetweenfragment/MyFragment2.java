package com.example.a20f0196.FragmentExamples.communicationbetweenfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a20f0196.R;

import java.time.temporal.Temporal;

public class MyFragment2 extends Fragment {
    TextView textView;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragmentonelayout,container,false);
        return view;
    }
    public void onFragmentInterection(String Message)
    {
        textView=view.findViewById(R.id.cmfragmenttxt);
        textView.setText(Message);
    }
}
