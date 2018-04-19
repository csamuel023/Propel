package com.example.christophersamuel.propel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExercisesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises);

        final int i = getIntent().getExtras().getInt("i");
        Button legs = (Button)findViewById(R.id.legs);
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_legs = new Intent(ExercisesActivity.this, LegsActivity.class);
                to_legs.putExtra("i", i);
                startActivity(to_legs);
            }
        });
        Button chest = (Button)findViewById(R.id.chest);
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_chest = new Intent(ExercisesActivity.this, ChestActivity.class);
                to_chest.putExtra("i", i);
                startActivity(to_chest);
            }
        });
        Button biceps = (Button)findViewById(R.id.biceps);
        biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_biceps = new Intent(ExercisesActivity.this, BicepsActivity.class);
                to_biceps.putExtra("i", i);
                startActivity(to_biceps);
            }
        });
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_back = new Intent(ExercisesActivity.this, BackActivity.class);
                to_back.putExtra("i", i);
                startActivity(to_back);
            }
        });
        Button shoulders = (Button)findViewById(R.id.shoulders);
        shoulders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_shoulders = new Intent(ExercisesActivity.this, ShouldersActivity.class);
                to_shoulders.putExtra("i", i);
                startActivity(to_shoulders);
            }
        });
        Button core = (Button)findViewById(R.id.core);
        core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_core = new Intent(ExercisesActivity.this, CoreActivity.class);
                to_core.putExtra("i", i);
                startActivity(to_core);
            }
        });
        Button cardio = (Button)findViewById(R.id.cardio);
        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_cardio = new Intent(ExercisesActivity.this, CardioActivity.class);
                to_cardio.putExtra("i", i);
                startActivity(to_cardio);
            }
        });
    }
}
