package com.example.christophersamuel.propel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import com.example.christophersamuel.propel.R;

import java.util.ArrayList;

public class ViewGoal extends AppCompatActivity {
    private Button bDone;
    ArrayList<String> storeGoal = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goal);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            // get strings from create goal method
            String Steps = bundle.getString("steps");
            String StepDay = bundle.getString("stepDay");
            String Calories = bundle.getString("calories");
            String CaloriesDay = bundle.getString("caloriesDay");
            String Lbs = bundle.getString("lbs");
            String LbsDay = bundle.getString("lbsWeek");

            TextView one = (TextView) findViewById(R.id.one);
            TextView two = (TextView) findViewById(R.id.two);
            TextView three = (TextView) findViewById(R.id.three);
            TextView four = (TextView) findViewById(R.id.four);
            //Create strings to display
            String stepGoal = Steps + " Steps in " + StepDay + " Day(s)";
            String caloriesGoal = Calories + " Calories in " + CaloriesDay + "Day(s)";
            String lbsGoal = Lbs + " Lbs in " + LbsDay + "Week(s)";
            // store String in an array
            storeGoal.add(0,stepGoal);
            storeGoal.add(1,caloriesGoal);
            storeGoal.add(2,lbsGoal);
            // assigns text view into variable


            // update the text on View Goals
            one.setText(storeGoal.get(0));
            two.setText(storeGoal.get(1));
            three.setText(storeGoal.get(2));
            four.setText("");
        }
        bDone = (Button) findViewById(R.id.bDone);
        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGoals();
            }
        });
    }
    public void openGoals(){
        Intent intent = new Intent(this, ViewGoal.class);
        startActivity(intent);
    }
}

