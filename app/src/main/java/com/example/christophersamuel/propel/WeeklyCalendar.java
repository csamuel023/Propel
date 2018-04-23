package com.example.christophersamuel.propel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WeeklyCalendar extends AppCompatActivity {
    DailyActivityDatabase dailyActivityDatabase = new DailyActivityDatabase(this);
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_calendar);

        ListView day1List, day2List, day3List, day4List, day5List, day6List, day7List;
        day1List = (ListView) findViewById(R.id.day1List);
        day2List = (ListView) findViewById(R.id.day2List);
        day3List = (ListView) findViewById(R.id.day3List);
        day4List = (ListView) findViewById(R.id.day4List);
        day5List = (ListView) findViewById(R.id.day5List);
        day6List = (ListView) findViewById(R.id.day6List);
        day7List = (ListView) findViewById(R.id.day7List);

        db = dailyActivityDatabase.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from activities", null);

        ArrayList<String> day1 = new ArrayList<>();
        ArrayList<String> day2 = new ArrayList<>();
        ArrayList<String> day3 = new ArrayList<>();
        ArrayList<String> day4 = new ArrayList<>();
        ArrayList<String> day5 = new ArrayList<>();
        ArrayList<String> day6 = new ArrayList<>();
        ArrayList<String> day7 = new ArrayList<>();
        if (cursor.getCount() != 0){
            day1 = dailyActivityDatabase.getDailyActivities("1");
            ListAdapter listAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, day1);
            day1List.setAdapter(listAdapter1);

            day2 = dailyActivityDatabase.getDailyActivities("2");
            ListAdapter listAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, day2);
            day2List.setAdapter(listAdapter2);

            day3 = dailyActivityDatabase.getDailyActivities("3");
            ListAdapter listAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, day3);
            day3List.setAdapter(listAdapter3);

            day4 = dailyActivityDatabase.getDailyActivities("4");
            ListAdapter listAdapter4 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, day4);
            day4List.setAdapter(listAdapter4);

            day5 = dailyActivityDatabase.getDailyActivities("5");
            ListAdapter listAdapter5 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, day5);
            day5List.setAdapter(listAdapter5);

            day6 = dailyActivityDatabase.getDailyActivities("6");
            ListAdapter listAdapter6 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, day6);
            day6List.setAdapter(listAdapter6);

            day7 = dailyActivityDatabase.getDailyActivities("7");
            ListAdapter listAdapter7 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, day7);
            day7List.setAdapter(listAdapter7);
        }

    }
}
