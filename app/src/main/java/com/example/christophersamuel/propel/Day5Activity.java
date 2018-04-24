package com.example.christophersamuel.propel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Day5Activity extends AppCompatActivity {
    DailyActivityDatabase dailyActivityDatabase = new DailyActivityDatabase(this);
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day5);

        final int i = 4;
        Button nextDay = (Button)findViewById(R.id.next_day);
        nextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next_day = new Intent(Day5Activity.this, Day6Activity.class);
                startActivity(next_day);
            }
        });
        Button exercises = (Button)findViewById(R.id.addexercise);
        exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = dailyActivityDatabase.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from activities", null);
                if(cursor.getCount() != 0) {
                    if(!dailyActivityDatabase.searchExist("5")) {
                        Intent to_exercises = new Intent(Day5Activity.this, ExerciseActivities.class);
                        to_exercises.putExtra("id", "5");
                        to_exercises.putExtra("i", i);
                        startActivity(to_exercises);
                    }
                    else {
                        Toast exist = Toast.makeText(Day5Activity.this, "Exercises for day 5 is already added. move to day 6 or delete to add again",Toast.LENGTH_SHORT );
                        exist.show();
                    }
                }
            }
        });
        Button done = (Button)findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Day5Activity.this, ThirdActivity.class);
                startActivity(back);
            }
        });
        Button clear = (Button) findViewById(R.id.clear5);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dailyActivityDatabase.deleteActivities("5")){
                    Toast deleted = Toast.makeText(Day5Activity.this, "Exercises for day 5 deleted",Toast.LENGTH_SHORT );
                    deleted.show();
                }
                else{
                    Toast deleteF = Toast.makeText(Day5Activity.this, "Nothing to delete",Toast.LENGTH_SHORT );
                    deleteF.show();
                }
            }
        });
    }
}
