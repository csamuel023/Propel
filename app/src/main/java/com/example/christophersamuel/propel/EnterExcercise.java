package com.example.christophersamuel.propel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterExcercise extends AppCompatActivity {
    private Button bDoneE;
    DatabaseForUserManualEnter databaseForUserManualEnter = new DatabaseForUserManualEnter(this);
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_excercise);
        final EditText pushUp, jumpJack, steps;
        pushUp = (EditText) findViewById(R.id.push);
        jumpJack = (EditText)findViewById(R.id.jump);
        steps = (EditText) findViewById(R.id.stepss);
        bDoneE = (Button) findViewById(R.id.bDoneE);
        bDoneE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = databaseForUserManualEnter.getReadableDatabase();
                Cursor cursor = db.rawQuery("select * from enter",null);
                if(cursor.getCount() != 0){
                    if(databaseForUserManualEnter.searchExist("1")){
                        databaseForUserManualEnter.deleteEnter("1");
                    }
                }
                UserManuallyGetSet userManuallyGetSet = new UserManuallyGetSet();
                userManuallyGetSet.setPush(pushUp.getText().toString());
                userManuallyGetSet.setJump(jumpJack.getText().toString());
                userManuallyGetSet.setSteps(steps.getText().toString());
                databaseForUserManualEnter.insertUserEnter(userManuallyGetSet, "1");
                Intent intent = new Intent(EnterExcercise.this, Goals.class);
                startActivity(intent);
            }
        });
    }
}
