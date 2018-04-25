package com.example.christophersamuel.propel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewGoal extends AppCompatActivity {
    DatabaseForGoals dbForGoal = new DatabaseForGoals(this);
    SQLiteDatabase db;
    ArrayList<String> GoalInfo = new ArrayList<String>();
    private Button bDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goal);

        TextView one = (TextView) findViewById(R.id.one);
        TextView two = (TextView) findViewById(R.id.two);
        TextView three = (TextView) findViewById(R.id.three);
        TextView four = (TextView) findViewById(R.id.four);
        db = dbForGoal.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from goalsDB",null);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            // get strings from create goal method
            String Steps = bundle.getString("steps");
            String StepDay = bundle.getString("stepDay");
            String Calories = bundle.getString("calories");
            String CaloriesDay = bundle.getString("caloriesDay");
            String Lbs = bundle.getString("lbs");
            String LbsDay = bundle.getString("lbsWeek");

            //Create strings to display
            String stepGoal = Steps + " Steps in " + StepDay + " Day(s)";
            String caloriesGoal = Calories + " Calories in " + CaloriesDay + "Day(s)";
            String lbsGoal = Lbs + " Lbs in " + LbsDay + " Week(s)";

            // save data into database
            GoalInfo info = new GoalInfo();
            info.setSteps(Steps);
            info.setStepDay(StepDay);
            info.setCalories(Calories);
            info.setCaloriesDay(CaloriesDay);
            info.setLbs(Lbs);
            info.setLbsDay(LbsDay);
            // count that info has entered at least once
            dbForGoal.insertGoalInfo(info);

            // assigns text view into variable


            // update the text on View Goals
            one.setText(stepGoal);
            two.setText(caloriesGoal);
            three.setText(lbsGoal);
            four.setText("");
        }
        else if(cursor.getCount() != 0){

            GoalInfo = dbForGoal.retrieveInfo();
            String stepGoal = GoalInfo.get(0) + " Steps in " + GoalInfo.get(1) + " Day(s)";
            String caloriesGoal = GoalInfo.get(2) + " Calories in " + GoalInfo.get(3) + " Day(s)";
            String lbsGoal = GoalInfo.get(4) + " Lbs in " + GoalInfo.get(5) + " Week(s)";

            one.setText(stepGoal);
            two.setText(caloriesGoal);
            three.setText(lbsGoal);
            if(!GoalInfo.get(0).equals("--------"))
                four.setText("");
        }
        cursor.close();
        bDone = (Button) findViewById(R.id.bDoneE);
        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGoals();
            }
        });
    }
    public void openGoals(){
        Intent intent = new Intent(this, Goals.class);
        startActivity(intent);
    }
}

