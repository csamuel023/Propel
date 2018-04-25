package com.example.christophersamuel.propel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseForUserManualEnter extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String TABLE_ENTER = "enter";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PUSH = "push";
    private static final String COLUMN_JUMP = "jump";
    private static final String COLUMN_STEP = "steps";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table enter (id integer primary key not null, " +
            "push integer not null, jump integer not null, steps integer not null);";
    public DatabaseForUserManualEnter(Context context){
        super(context, TABLE_ENTER,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_ENTER;
        db.execSQL(query);
        this.onCreate(db);
    }
    public void insertUserEnter(UserManuallyGetSet userManuallyGetSet, String id){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_ENTER;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        values.put(COLUMN_ID, id );
        values.put(COLUMN_PUSH, userManuallyGetSet.getPush());
        values.put(COLUMN_JUMP, userManuallyGetSet.getJump());
        values.put(COLUMN_STEP, userManuallyGetSet.getSteps());

        db.insert(TABLE_ENTER, null, values);
        cursor.close();
        db.close();
    }
    public ArrayList<String> getEnter(String id) {
        db = this.getReadableDatabase();
        String query = "select id, push, jump, steps from " + TABLE_ENTER;
        Cursor cursor = db.rawQuery(query, null);
        String ID, push, jump, steps;
        ArrayList<String> AL = new ArrayList<>();
        if (cursor.moveToNext())
            do {
                ID= cursor.getString(0);
                if (ID.equalsIgnoreCase(id)) {
                    push = cursor.getString(1);
                    AL.add(0,push);
                    jump = cursor.getString(2);
                    AL.add(1,jump);
                    steps = cursor.getString(3);
                    AL.add(2,steps);
                }
            }
            while (cursor.moveToNext());
        cursor.close();
        return AL;
    }
    public boolean searchExist(String id) {
        db = this.getReadableDatabase();
        String query = "select id, push, jump, steps from " + TABLE_ENTER;
        Cursor cursor = db.rawQuery(query, null);
        String ID;
        if (cursor.moveToNext())
            do {
                ID = cursor.getString(0);
                if (ID.equals(id)) {
                    return true;
                }
            }
            while (cursor.moveToNext());
        cursor.close();
        return false;
    }
    public boolean deleteEnter(String id){
        db = this.getReadableDatabase();
        String query = "select id, push, jump, steps from " + TABLE_ENTER;
        String queryd = "delete from " + TABLE_ENTER + " where " +COLUMN_ID + " = " +id + "";
        Cursor cursor = db.rawQuery(query, null);
        String ID;
        if (cursor.moveToNext())
            do {
                ID = cursor.getString(0);
                if (ID.equals(id)) {
                    db.execSQL(queryd);
                    return true;
                }
            }
            while (cursor.moveToNext());
        cursor.close();
        return false;
    }
}

