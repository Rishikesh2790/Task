package com.example.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class OpenHelperMethod extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String name = "databaseTask";

    public OpenHelperMethod(Context context)
    {
     super(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE PASSCODE(_id INTEGER PRIMARY KEY AUTOINCREMENT,PASSCODENAME TEXT,PASSCODETYPE TEXT,STARTTIME TEXT,ENDTIME TEXT,PASSCODECODE TEXT,DAY TEXT)";
        db.execSQL(sql);
        //insertData(name,code,db);
    }

    public void insertData(String name,String code,String title,String startime,String endtime,ArrayList<String> days,SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("PASSCODENAME",name);
        values.put("PASSCODETYPE",title);
        values.put("STARTTIME",startime);
        values.put("ENDTIME",endtime);
        values.put("PASSCODECODE",code);
        values.put("DAY",days.toString());

        db.insert("PASSCODE",null,values);
    }
    public ArrayList<Dataa> listContacts(){
        String sql = "SELECT * FROM PASSCODE";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Dataa> storeContacts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{

                String name = cursor.getString(cursor.getColumnIndex("PASSCODENAME"));
                String id = cursor.getString(cursor.getColumnIndex("_id"));
                String code = cursor.getString(cursor.getColumnIndex("PASSCODECODE"));
                String type = cursor.getString(cursor.getColumnIndex("PASSCODETYPE"));
                String starttime = cursor.getString(cursor.getColumnIndex("STARTTIME"));
                String endtime = cursor.getString(cursor.getColumnIndex("ENDTIME"));
                String days = cursor.getString(cursor.getColumnIndex("DAY"));
                storeContacts.add(new Dataa(id,name,code,type,starttime,endtime,days));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeContacts;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
