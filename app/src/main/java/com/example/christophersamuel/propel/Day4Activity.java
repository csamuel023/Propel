package com.example.christophersamuel.propel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Day4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day4);

        final int i = 3;
        Button nextDay = (Button)findViewById(R.id.next_day);
        nextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next_day = new Intent(Day4Activity.this, Day5Activity.class);
                startActivity(next_day);
            }
        });
        Button exercises = (Button)findViewById(R.id.addexercise);
        exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_exercises = new Intent(Day4Activity.this, ExercisesActivity.class);
                to_exercises.putExtra("i", i);
                startActivity(to_exercises);
            }
        });
    }
}