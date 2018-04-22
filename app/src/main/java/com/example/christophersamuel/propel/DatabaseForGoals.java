package com.example.christophersamuel.propel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseForGoals extends SQLiteOpenHelper {

    //Setup database
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "goalsDB.db";
    private static final String TABLE_NAME = "goalsDB";
    private static final String COLUMN_STEPS = "steps";
    private static final String COLUMN_STEPDAY = "stepDay";
    private static final String COLUMN_CALORIES = "calories";
    private static final String COLUMN_CALORIESDAY = "caloriesDay";
    private static final String COLUMN_LBS = "lbs";
    private static final String COLUMN_LBSDAY = "lbsDay";

    private static final String TABLE_NAME_A = "activities";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_LEGS = "legs";
    private static final String COLUMN_CHEST = "chest";
    private static final String COLUMN_BICEPS = "biceps";
    private static final String COLUMN_BACK = "back";
    private static final String COLUMN_SHOULDERS = "shoulders";
    private static final String COLUMN_CORE = "core";
    private static final String COLUMN_CARDIO = "cardio";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table goalsDB (steps integer primary key not null, " +
            "stepDay integer not null, calories integer not null, " +
            "caloriesDay integer not null, lbs integer not null, lbsDay integer not null);";
    private static final String TABLE_CREATE_A = "create table activities (ID integer primary key not null , " +
            "legs text not null, chest text not null, biceps text not null, back text not null, shoulders text not null, " +
            "core text not null, cardio text not null);";

    public DatabaseForGoals(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_A);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query1 = "DROP TABLE IF EXISTS " + TABLE_NAME;
        String query2 = "DROP TABLE IF EXISTS " + TABLE_NAME_A;
        db.execSQL(query1);
        db.execSQL(query2);
        this.onCreate(db);
    }
    // Insert sign up information
    public void insertGoalInfo(GoalInfo info){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        values.put(COLUMN_STEPS, info.getSteps());
        values.put(COLUMN_STEPDAY, info.getStepDay());
        values.put(COLUMN_CALORIES, info.getCalories());
        values.put(COLUMN_CALORIESDAY, info.getCaloriesDay());
        values.put(COLUMN_LBS, info.getLbs());
        values.put(COLUMN_LBSDAY, info.getLbsDay());
        db.insert(TABLE_NAME, null, values);
    }
    public ArrayList retrieveInfo() {
        db = this.getReadableDatabase();
        String query = "select steps, stepDay, calories, caloriesDay, lbs, lbsDay from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<String> info = new ArrayList<String>();
        String steps = "--------", stepDay = "--------", calories = "--------", caloriesDay = "--------", lbs = "--------", lbsDay = "--------";
        if (cursor.moveToNext()) {
            cursor.moveToLast();
            steps = cursor.getString(0);
            info.add(0,steps);
            stepDay = cursor.getString(1);
            info.add(1,stepDay);
            calories = cursor.getString(2);
            info.add(2,calories);
            caloriesDay = cursor.getString(3);
            info.add(3,caloriesDay);
            lbs = cursor.getString(4);
            info.add(4,lbs);
            lbsDay = cursor.getString(5);
            info.add(5,lbsDay);

        }
        return info;
    }
    public void insertDailyActivity(DailyActivityGetSet DAGS){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_NAME_A;
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

        db.insert(TABLE_NAME_A, null, values);

    }
    public ArrayList getDailyActivities(int id){
        db = this.getReadableDatabase();
        String query = "select id, legs, chest, biceps, back, shoulders, core, cardio from " + TABLE_NAME_A;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<String> info = new ArrayList<String>();
        String legs = "--------", chest = "--------", back = "--------", shoulders = "--------", biceps = "--------", core = "--------", cardio = "--------";
        int ID;
        if (cursor.moveToNext()) {
            do{
                ID = cursor.getInt(0);
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
        return info;
    }
}
