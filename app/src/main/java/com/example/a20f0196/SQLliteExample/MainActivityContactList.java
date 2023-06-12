package com.example.a20f0196.SQLliteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.a20f0196.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityContactList extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact_list);
        DbQuerie dbQuerie=new DbQuerie(getApplicationContext());
        listView=findViewById(R.id.lstfazal);
        ArrayList<HashMap<String,String>> ContactList= dbQuerie.getContactlist();

        SimpleAdapter adapter=new SimpleAdapter(
                this,ContactList,R.layout.newlayoutmain,
                new String[]{"_id","firstName","lastName","phoneNumber"},
                new int[]{R.id.txtid,R.id.txtfirstname,R.id.txtlastname,R.id.phonenumber}
                );
                    listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivityContactList.this,EditContactActivity.class);
                intent.putExtra("id",String.valueOf(position+1));
                startActivity(intent);
            }
        });


        }


    public void OpenNewContactActivity(View view) {

        Intent intent=new Intent(this,NewContactActivity.class);
        startActivity(intent);

    }
}