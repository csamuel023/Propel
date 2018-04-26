package com.example.christophersamuel.propel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Summary extends AppCompatActivity {
    private Button bDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        DatabaseForUserManualEnter databaseForUserManualEnter = new DatabaseForUserManualEnter(this);
        DailyActivityDatabase dailyActivityDatabase = new DailyActivityDatabase(this);
        SQLiteDatabase db;
       // SQLiteDatabase db1;
        TextView passCalories, totalCalories, activeWillBurn, Activites;
        passCalories = (TextView) findViewById(R.id.passCalories);
        totalCalories = (TextView) findViewById(R.id.toaltCalories);
        activeWillBurn = (TextView) findViewById(R.id.activeWillBurn);
        Activites = (TextView) findViewById(R.id.textActive);
        db = databaseForUserManualEnter.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from enter",null);
        //db1 = dailyActivityDatabase.getWritableDatabase();
       // Cursor cursor1 = db.rawQuery("select * from activities", null);
        if(cursor.getCount() != 0){
            int calPush, calJump, passCal;
            if(databaseForUserManualEnter.searchExist("1")){
                ArrayList<String> AL = databaseForUserManualEnter.getEnter("1");

                if(AL.get(0).equals("")){
                    calPush = 0;
                }
                else {
                    calPush = Integer.parseInt(AL.get(0));
                }
                if(AL.get(1).equals("")){
                    calJump = 0;
                }
                else {
                    calJump = Integer.parseInt(AL.get(1));
                }
                if(AL.get(2).equals("")){
                     passCal = 0;
                }
                else{
                    passCal = Integer.parseInt(AL.get(2));
                }
                passCal = passCal / 20;
                passCalories.setText(String.valueOf(passCal));

                calPush = calPush * (1/2);

                calJump = calJump * 2;
                int totalCal = passCal + calPush + calJump;
                totalCalories.setText(String.valueOf(totalCal));
                String activity = AL.get(0) + " (Push) " + AL.get(1) + " (Jump) " + AL.get(2) + " (Steps) ";
                Activites.setText(activity);
            }
        }
        bDone = (Button) findViewById(R.id.bDoneS);
        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Summary.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }
}
