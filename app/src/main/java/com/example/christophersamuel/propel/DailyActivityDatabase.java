package com.example.christophersamuel.propel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DailyActivityDatabase extends SQLiteOpenHelper{

    //Setup database
    private static final int DATABASE_VERSION =2;
    //private static final String DATABASE_NAME = "dailyActivities.db";
    private static final String TABLE_NAME = "activities";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_LEGS = "legs";
    private static final String COLUMN_CHEST = "chest";
    private static final String COLUMN_BICEPS = "biceps";
    private static final String COLUMN_BACK = "back";
    private static final String COLUMN_SHOULDERS = "shoulders";
    private static final String COLUMN_CORE = "core";
    private static final String COLUMN_CARDIO = "cardio";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table activities (ID integer primary key not null , " +
            "legs text not null, chest text not null, biceps text not null, back text not null, shoulders text not null, " +
            "core text not null, cardio text not null);";


    public DailyActivityDatabase(Context context){
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
    public void insertDailyActivity(DailyActivityGetSet DAGS){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount() +1;

        values.put(COLUMN_ID, count);
        values.put(COLUMN_LEGS, DAGS.getLegs());
        values.put(COLUMN_CHEST, DAGS.getChest());
        values.put(COLUMN_BICEPS, DAGS.getBiceps());
        values.put(COLUMN_BACK, DAGS.getBack());
        values.put(COLUMN_SHOULDERS, DAGS.getShoulders());
        values.put(COLUMN_CORE, DAGS.getCore());
        values.put(COLUMN_CARDIO, DAGS.getCardio());

        db.insert(TABLE_NAME, null, values);
        cursor.close();
        db.close();
    }
    public ArrayList getDailyActivities(String id){
        db = this.getReadableDatabase();
        String query = "select id, legs, chest, biceps, back, shoulders, core, cardio from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<String> info = new ArrayList<String>();
        String legs = "--------", chest = "--------", back = "--------", shoulders = "--------", biceps = "--------", core = "--------", cardio = "--------";
        String ID;
        if (cursor.moveToNext()) {
           do{
               ID = cursor.getString(0);
               if(ID == id){
                   legs = cursor.getString(1);
                   info.add(0,legs);
                   chest = cursor.getString(2);
                   info.add(1,chest);
                   biceps = cursor.getString(3);
                   info.add(2,biceps);
                   back = cursor.getString(4);
                   info.add(3,back);
                   shoulders = cursor.getString(5);
                   info.add(4,shoulders);
                   core = cursor.getString(6);
                   info.add(5,core);
                   cardio = cursor.getString(7);
                   info.add(6,cardio);
               }
           }
           while(cursor.moveToNext());
        }
        cursor.close();
        return info;
    }
}
