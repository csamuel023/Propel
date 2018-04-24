package com.example.christophersamuel.propel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

private Button bGoals;
private Button btn;
private Button bSummary;
private Button bSeeSchedule;
private Button createProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //Goals button
        bSummary = (Button) findViewById(R.id.bSummary);
        bSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSummary();
            }
        });
        bGoals = (Button) findViewById(R.id.bGoals);
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
                openDay1();
            }
        });
        bSeeSchedule = (Button) findViewById(R.id.bSeeSchedule);
        bSeeSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,WeeklyCalendar.class);
                startActivity(intent);
        // create profile button
        createProfile = (Button) findViewById(R.id.createProfile);
        createProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateProfile();
            }
        });
            }
        });

    }
    public void openGoal(){
        Intent intent = new Intent(this,Goals.class);
        startActivity(intent);
    }

    public void openDay1() {
        Intent intent = new Intent(ThirdActivity.this, Day1Activity.class);
        startActivity(intent);
    }
    public void openSummary(){
        Intent intent = new Intent(this, Summary.class);
        startActivity(intent);
    }
    public void openCreateProfile() {
        Intent intent = new Intent(ThirdActivity.this, BodyInfo.class);
        startActivity(intent);
    }
}
