package com.example.christophersamuel.propel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Goal_short_long extends AppCompatActivity {
    private Button bDone;
    EditText steps;
    EditText stepDay;
    EditText calories;
    EditText caloriesDay;
    EditText lbs;
    EditText lbsDay;
    private String Steps;
    private String StepDay;
    private String Calories;
    private String CaloriesDay;
    private String Lbs;
    private String LbsDay;
    ArrayList<String> goalInfo = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_short_long);

        steps = (EditText) findViewById(R.id.steps);            // define edit text
        stepDay = (EditText) findViewById(R.id.stepDay);
        calories = (EditText) findViewById(R.id.calories);
        caloriesDay = (EditText) findViewById(R.id.caloriesDay);
        lbs = (EditText) findViewById(R.id.lbs);
        lbsDay = (EditText) findViewById(R.id.lbsDay);

        bDone = (Button) findViewById(R.id.bDoneE);              //define button
        bDone.setOnClickListener(new View.OnClickListener() {   // when click done, save info and
            @Override                                           // move back to Goals
            public void onClick(View view) {
                Steps = steps.getText().toString();             //get info from edit text
                StepDay = stepDay.getText().toString();
                Calories = calories.getText().toString();
                CaloriesDay = caloriesDay.getText().toString();
                Lbs = lbs.getText().toString();
                LbsDay = lbsDay.getText().toString();

                openGoalView(Steps, StepDay, Calories, CaloriesDay, Lbs, LbsDay);

            }

        });
    }
    public void openGoalView(String Steps, String StepDay, String Calories, String CaloriesDay,
                             String Lbs, String LbsDay){
        Intent intent = new Intent(this, com.example.christophersamuel.propel.ViewGoal.class);
        intent.putExtra("steps", Steps);
        intent.putExtra("stepDay", StepDay);
        intent.putExtra("calories", Calories);
        intent.putExtra("caloriesDay", CaloriesDay);
        intent.putExtra("lbs", Lbs);
        intent.putExtra("lbsWeek", LbsDay);
        startActivity(intent);
    }
}
