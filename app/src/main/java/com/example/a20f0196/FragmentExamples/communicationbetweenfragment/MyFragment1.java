package com.example.a20f0196.FragmentExamples.communicationbetweenfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a20f0196.R;

public class MyFragment1 extends Fragment {
    ButtonPressListner.onButtonPressListner buttonPressListner;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListner=(ButtonPressListner.onButtonPressListner) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup=(ViewGroup) inflater.inflate(R.layout.fragmentonelayout,container,false);
    myFunction(viewGroup);
    return viewGroup;
    }
    private void myFunction(ViewGroup viewGroup )
    {
        TextView textView= viewGroup.findViewById(R.id.cmfragmenttxt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressListner.onButtonPressed("message from fragment");
            }
        });



    }

}
