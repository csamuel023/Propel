package com.example.christophersamuel.propel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseForBodyInfo extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String TABLE_BODY = "body";
    private static final String COLUMN_BODY_ID = "id";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_USERTYPE = "userType";
    SQLiteDatabase db;
    private static final String TABLE_CREATE_BODY = "create table body (id integer primary key not null, " +
            "height integer not null, weight integer not null, age integer not null, gender text not null, userType text not null);";
    public DatabaseForBodyInfo(Context context){
        super(context, TABLE_BODY,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_BODY);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_BODY;
        db.execSQL(query);
        this.onCreate(db);
    }
    public void insertBodyInfo(BodyInfoGetSet bodyInfoGetSet, String id){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_BODY;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        values.put(COLUMN_BODY_ID, id );
        values.put(COLUMN_HEIGHT, bodyInfoGetSet.getHeight());
        values.put(COLUMN_WEIGHT, bodyInfoGetSet.getWeight());
        values.put(COLUMN_AGE, bodyInfoGetSet.getAge());
        values.put(COLUMN_GENDER, bodyInfoGetSet.getGender());
        values.put(COLUMN_USERTYPE, bodyInfoGetSet.getUserType());

        db.insert(TABLE_BODY, null, values);
        cursor.close();
        db.close();
    }
    public ArrayList<String> getBody(String id) {
        db = this.getReadableDatabase();
        String query = "select id, height, weight, age, gender, userType from " + TABLE_BODY;
        Cursor cursor = db.rawQuery(query, null);
        String ID, height, weight, age, gender, userType;
        ArrayList<String> AL = new ArrayList<>();
        if (cursor.moveToNext())
            do {
                ID= cursor.getString(0);
                if (ID.equalsIgnoreCase(id)) {
                    height = cursor.getString(1);
                    AL.add(0,height);
                    weight = cursor.getString(2);
                    AL.add(1,weight);
                    age = cursor.getString(3);
                    AL.add(2,age);
                    gender = cursor.getString(4);
                    AL.add(3,gender);
                    userType = cursor.getString(5);
                    AL.add(4,userType);
                }
            }
            while (cursor.moveToNext());
        cursor.close();
        return AL;
    }
    public boolean searchExist(String id) {
        db = this.getReadableDatabase();
        String query = "select id, height, weight, age, gender, userType from " + TABLE_BODY;
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
    public boolean deleteBody(String id){
        db = this.getReadableDatabase();
        String query = "select id, height, weight, age, gender, userType from " + TABLE_BODY;
        String queryd = "delete from " + TABLE_BODY + " where " +COLUMN_BODY_ID + " = " +id + "";
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
