package com.example.a20f0196.FragmentExamples.staticfragmentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a20f0196.R;

public class staticfragmentmainactivity extends AppCompatActivity implements ContactsFragment.ListSelectionListener
{
public static String[] contactsarray;
    public static String[] contactDetailarray;
    contactdetailsfragment detailfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staticfragmentmainactivity);
        contactsarray=getResources().getStringArray(R.array.contacts_array);
        contactDetailarray=getResources().getStringArray(R.array.details_array);
    detailfragment=(contactdetailsfragment)  getSupportFragmentManager().findFragmentById(R.id.detailfragment);
    }

    @Override
    public void onSleection(int position) {
        if(detailfragment.getShownIndex() != position)
        {
            detailfragment.ContactIndex(position);
        }
    }
}