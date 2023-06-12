package com.example.a20f0196.FragmentExamples.staticfragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.a20f0196.R;

public class ContactsFragment extends ListFragment {
public ListSelectionListener mListener=null;
    public interface  ListSelectionListener
    {
        public void onSleection(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener =(ListSelectionListener)  getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter( new ArrayAdapter<String>(getActivity(), R.layout.contacttextview,staticfragmentmainactivity.contactsarray));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        getListView().setItemChecked(position,true);
        mListener.onSleection(position);
    }
}
