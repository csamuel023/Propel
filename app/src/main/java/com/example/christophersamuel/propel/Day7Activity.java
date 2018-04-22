package com.example.christophersamuel.propel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Day7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day7);

        final int i = 6;
        Button exercises = (Button)findViewById(R.id.addexercise);
        exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_exercises = new Intent(Day7Activity.this, ExerciseActivities.class);
                to_exercises.putExtra("i", i);
                startActivity(to_exercises);
            }
        });
        Button done = (Button)findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Day7Activity.this, ThirdActivity.class);
                startActivity(back);
            }
        });
    }
}
