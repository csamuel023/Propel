package com.example.christophersamuel.propel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LegsActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    DailyActivityDatabase DADB = new DailyActivityDatabase(this);
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legs);

        final int i = getIntent().getExtras().getInt("i");
        radioGroup = findViewById(R.id.radioGroup);
        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                Intent back;
                switch(i){
                    case 0:
                        back = new Intent(LegsActivity.this, Day1Activity.class);
                        break;
                    case 1:
                        back = new Intent(LegsActivity.this, Day2Activity.class);
                        break;
                    case 2:
                        back = new Intent(LegsActivity.this, Day3Activity.class);
                        break;
                    case 3:
                        back = new Intent(LegsActivity.this, Day4Activity.class);
                        break;
                    case 4:
                        back = new Intent(LegsActivity.this, Day5Activity.class);
                        break;
                    case 5:
                        back = new Intent(LegsActivity.this, Day6Activity.class);
                        break;
                    default:
                        back = new Intent(LegsActivity.this, Day7Activity.class);
                }

                startActivity(back);
            }
        });
    }
}
