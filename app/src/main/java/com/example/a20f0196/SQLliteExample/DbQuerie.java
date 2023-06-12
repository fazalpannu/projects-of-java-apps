package com.example.a20f0196.SQLliteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbQuerie extends SQLiteOpenHelper {

 public DbQuerie(Context context)
 {
     super(context,"ContactsDB",null,1);
     Log.d("TAg","DAta base Created");
 }

    @Override
    public void onCreate(SQLiteDatabase db) {

       String SqlTableQuery="CREATE TABLE  CONTACTS ("+"_id  INTEGER PRIMARY KEY AUTOINCREMENT,"+"FirstNAME TEXT,"+"LastNAME TEXT,"+"PhoneNumber TEXT,"+"emailADDRESS TEXT,"+ "homeAddress TEXT)";
       db.execSQL(SqlTableQuery);

        Log.d("TAg","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




    public void InsertSingleContact(HashMap<String,String> contact)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
//        contentValues.put("_id",contact.get("_id"));
        contentValues.put("FirstNAME",contact.get("firstName"));
        contentValues.put("LastNAME",contact.get("lastName"));
        contentValues.put("PhoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailADDRESS",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));
        long result=db.insert("CONTACTS",null,contentValues);
        if (result!=-1)
        {
            Log.d("TAG","NEW CONTACT INSEET WITH ID"+result);
        }
        else {
            Log.d("TAG","NEW CONTACT INSERTION FAILED");
        }
        db.close();
    }

    public ArrayList<HashMap<String, String>> getContactlist() {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<HashMap<String, String>> contactlist = new ArrayList<HashMap<String, String>>();
        String Query = "SELECT * FROM  CONTACTS";

        Cursor cursor = db.rawQuery(Query, null);
        if (cursor.moveToFirst())
        {
            do {

                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("_id", cursor.getString(0));

                    hashMap.put("firstName", cursor.getString(1));
                    hashMap.put("lastName", cursor.getString(2));
                    hashMap.put("phoneNumber", cursor.getString(3));
                    hashMap.put("emailAddress", cursor.getString(4));
                    hashMap.put("homeAddress", cursor.getString(5));
                    contactlist.add(hashMap);

            } while (cursor.moveToNext());

        }

        return contactlist;
    }

    public HashMap<String,String > getSingleContact(String id)
    {
        SQLiteDatabase db= getReadableDatabase();
        HashMap<String,String> hashMap =new HashMap<String,String>();

        String Query =  "SELECT * FROM CONTACTS WHERE  _id= " +id;
        Cursor cursor = db.rawQuery(Query,null);
        if(cursor.moveToFirst())
        {


            hashMap.put("_id",cursor.getString(0));
            hashMap.put("firstName",cursor.getString(1));
            hashMap.put("lastName",cursor.getString(2));
            hashMap.put("phoneNumber",cursor.getString(3));
            hashMap.put("emailAddress",cursor.getString(4));
            hashMap.put("homeAddress",cursor.getString(5));
        }
        return hashMap;
    }

    public void updateContact(String id, HashMap<String, String> contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FirstNAME", contact.get("firstName"));
        contentValues.put("LastNAME", contact.get("lastName"));
        contentValues.put("PhoneNumber", contact.get("phoneNumber"));
        contentValues.put("emailADDRESS", contact.get("emailAddress"));
        contentValues.put("homeAddress", contact.get("homeAddress"));
        int result = db.update("CONTACTS", contentValues, "_id=?", new String[]{"2"});
        if (result > 0) {
            Log.d("TAG", "CONTACT UPDATED WITH ID " + id);
        } else {
//            Toast.makeText(context, "CONTACT UPDATE FAILED", Toast.LENGTH_SHORT).show();
            Log.d("TAG", "CONTACT UPDATE FAILED");
        }
        db.close();
    }



    public void deleteContact(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete("CONTACTS", "_id=?", new String[]{id});
        if (result > 0) {
            Log.d("TAG", "CONTACT DELETED WITH ID " + id);
        } else {
            Log.d("TAG", "CONTACT DELETION FAILED");
        }
        db.close();
    }





}

