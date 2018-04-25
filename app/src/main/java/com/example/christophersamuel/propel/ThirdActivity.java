package com.example.christophersamuel.propel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

private Button bGoals;
private Button btn;
private Button bSummary;
private Button bSeeSchedule;
private Button bUpdateProfile;
DatabaseForBodyInfo databaseForBodyInfo = new DatabaseForBodyInfo(this);
SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        db = databaseForBodyInfo.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from body",null);
        //Goals button
        bSummary = (Button) findViewById(R.id.bSummary);
        bSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSummary();
            }
        });
        bGoals = (Button) findViewById(R.id.bGoals);
        // create profile button
        bUpdateProfile = (Button) findViewById(R.id.bUpdateProfile);
        bUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, BodyInfos.class);
                startActivity(intent);
            }
        });
        bGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoal();
            }
        });
        // Button Create schedule
        btn = (Button) findViewById(R.id.bCreateSchedule);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = databaseForBodyInfo.getReadableDatabase();
                Cursor cursor = db.rawQuery("select * from body",null);
                if(cursor.getCount() != 0){
                    if(databaseForBodyInfo.searchExist("1")){
                        ArrayList<String> AL = databaseForBodyInfo.getBody("1");
                        if(AL.get(4).equals("Active")){
                            openDay1();
                        }
                        else{
                            Toast.makeText(ThirdActivity.this, "Only active user can use this feature, change to active to use this feature", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            }
        });
        bSeeSchedule = (Button) findViewById(R.id.bSeeSchedule);
        bSeeSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = databaseForBodyInfo.getReadableDatabase();
                Cursor cursor = db.rawQuery("select * from body",null);
                if(cursor.getCount() != 0){
                    if(databaseForBodyInfo.searchExist("1")){
                        ArrayList<String> AL = databaseForBodyInfo.getBody("1");
                        if(AL.get(4).equals("Active")){
                            Intent intent = new Intent(ThirdActivity.this,WeeklyCalendar.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(ThirdActivity.this, "Only active user can use this feature, change to active to use this feature", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            }
        });

    }
    public void openGoal(){
        Intent intent = new Intent(this,Goals.class);
        startActivity(intent);
    }

    public void openDay1() {
        Intent intent = new Intent(this, Day1Activity.class);
        startActivity(intent);
    }
    public void openSummary(){
        Intent intent = new Intent(this, Summary.class);
        startActivity(intent);
    }
}
