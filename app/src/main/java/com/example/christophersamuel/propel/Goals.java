package com.example.christophersamuel.propel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.christophersamuel.propel.R;

public class Goals extends AppCompatActivity {
    private Button bCreateGoal;
    private Button bViewGoal;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        //Set up buttons
        bCreateGoal = (Button) findViewById(R.id.bCreateGoal);
        bCreateGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGoal_short_long();
            }

        });
        bViewGoal = (Button) findViewById(R.id.bViewGoal);
        bViewGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewGoal();
            }
        });
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeeklyCalendar();
            }
        });
    }
    public void openGoal_short_long(){
        Intent intent1 = new Intent(this,Goal_short_long.class);
        startActivity(intent1);
    }
    public void openViewGoal(){
        Intent intent2 = new Intent(this,ViewGoal.class);
        startActivity(intent2);
    }
    public void openWeeklyCalendar(){
        Intent intent3 = new Intent(this,WeeklyCalendar.class);
        startActivity(intent3);
    }
}
