package com.example.christophersamuel.propel;

import android.app.job.JobInfo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    //Setup database
    private static final int DATABASE_VERSION =1;
    //private static final String DATABASE_NAME = "contacts.db";
    static final String TABLE_NAME = "contacts";
    static final String COLUMN_ID = "ID";
    static final String COLUMN_UNAME = "uname";
    static final String COLUMN_EMAIL = "email";
    static final String COLUMN_PASS = "password";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (ID integer primary key not null, " +
            "email text not null, uname text not null, password text not null);";


    public DatabaseHelper(Context context){
        super(context, TABLE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
    // Insert sign up information
    public void insertContact(Contact contact){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        values.put(COLUMN_ID, count);
        values.put(COLUMN_UNAME, contact.getUname());
        values.put(COLUMN_EMAIL, contact.getEmail());
        values.put(COLUMN_PASS, contact.getPassword());

        db.insert(TABLE_NAME, null, values);
        cursor.close();
        db.close();
    }
    // Search for matching uname and pass
    public String searchPass(String uname) {
        db = this.getReadableDatabase();
        String query = "select uname, password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String uName, passW = "Not Found!";
        if (cursor.moveToNext())
            do {
                uName = cursor.getString(0);
                if (uName.equalsIgnoreCase(uname)) {
                    passW = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        cursor.close();
        return passW;
    }

}
