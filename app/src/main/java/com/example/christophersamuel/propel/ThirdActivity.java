package com.example.christophersamuel.propel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
private Button bGoals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //Goals button
        bGoals = (Button) findViewById(R.id.bGoals);
        bGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoal();
            }
        });

    }
    public void openGoal(){
        Intent intent = new Intent(this,Goals.class);
        startActivity(intent);
    }
}
