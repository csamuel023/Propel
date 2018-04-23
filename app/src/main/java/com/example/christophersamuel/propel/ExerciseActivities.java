package com.example.christophersamuel.propel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ExerciseActivities extends AppCompatActivity {

    RadioGroup legRadio, chestRadio, bicepRadio, shoulderRadio, coreRadio, cardioRadio, backRadio;
    RadioButton legRaB, chestRaB, bicepsRaB, shoulderRaB, coreRaB, cardioRaB, backRaB;

    DailyActivityDatabase DADB = new DailyActivityDatabase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_activities);

        final int i = getIntent().getExtras().getInt("i");
        Button add = (Button)findViewById(R.id.btn);
        legRadio = (RadioGroup) findViewById(R.id.legRadio);
        chestRadio = (RadioGroup) findViewById(R.id.chestRadio);
        bicepRadio = (RadioGroup) findViewById(R.id.bicepRadio);
        backRadio = (RadioGroup) findViewById(R.id.backRadio);
        shoulderRadio = (RadioGroup) findViewById(R.id.shoulderRadio);
        coreRadio = (RadioGroup) findViewById(R.id.coreRadio);
        cardioRadio = (RadioGroup) findViewById(R.id.cardioRadio);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // leg
                int radioLegId = legRadio.getCheckedRadioButtonId();
                legRaB = findViewById(radioLegId);
                //chest
                int radioChestId = chestRadio.getCheckedRadioButtonId();
                chestRaB = findViewById(radioChestId);
                //biceps
                int radioBiceptId = bicepRadio.getCheckedRadioButtonId();
                bicepsRaB = findViewById(radioBiceptId);
                //back
                int radioBackId = backRadio.getCheckedRadioButtonId();
                backRaB = findViewById(radioBackId);
                //shoulders
                int radioShoulderId = shoulderRadio.getCheckedRadioButtonId();
                shoulderRaB = findViewById(radioShoulderId);
                //core
                int radioCoreId = coreRadio.getCheckedRadioButtonId();
                coreRaB = findViewById(radioCoreId);
                //cardio
                int radioCardioId = cardioRadio.getCheckedRadioButtonId();
                cardioRaB = findViewById(radioCardioId);

                Intent back;
                switch (i) {
                    case 0:
                        back = new Intent(ExerciseActivities.this, Day1Activity.class);
                        break;
                    case 1:
                        back = new Intent(ExerciseActivities.this, Day2Activity.class);
                        break;
                    case 2:
                        back = new Intent(ExerciseActivities.this, Day3Activity.class);
                        break;
                    case 3:
                        back = new Intent(ExerciseActivities.this, Day4Activity.class);
                        break;
                    case 4:
                        back = new Intent(ExerciseActivities.this, Day5Activity.class);
                        break;
                    case 5:
                        back = new Intent(ExerciseActivities.this, Day6Activity.class);
                        break;
                    default:
                        back = new Intent(ExerciseActivities.this, Day7Activity.class);
                }
                DailyActivityGetSet DAGS = new DailyActivityGetSet();
                DAGS.setLegs(legRaB.getText().toString());
                DAGS.setChest(chestRaB.getText().toString());
                DAGS.setBiceps(bicepsRaB.getText().toString());
                DAGS.setBack(backRaB.getText().toString());
                DAGS.setShoulders(shoulderRaB.getText().toString());
                DAGS.setCore(coreRaB.getText().toString());
                DAGS.setCardio(cardioRaB.getText().toString());
                DADB.insertDailyActivity(DAGS);
                startActivity(back);
            }
        });
    }
}

