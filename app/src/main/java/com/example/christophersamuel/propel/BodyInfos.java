package com.example.christophersamuel.propel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class BodyInfos extends AppCompatActivity {
    private Button bUpdate, bOption, bTime;
    DatabaseForBodyInfo databaseForBodyInfo = new DatabaseForBodyInfo(this);
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_infos);
        final EditText height = (EditText) findViewById(R.id.inHeight);
        final EditText weight = (EditText) findViewById(R.id.inWeight);
        final EditText age = (EditText) findViewById(R.id.inAge);

        db = databaseForBodyInfo.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from body",null);
        if(cursor.getCount() != 0){
            ArrayList<String> AL = databaseForBodyInfo.getBody("1");
            height.setText(AL.get(0));
            weight.setText(AL.get(1));
            age.setText(AL.get(2));
            RadioGroup gender = (RadioGroup) findViewById(R.id.rgGender);
            RadioGroup userType = (RadioGroup) findViewById(R.id.rgUser);
            RadioButton getGender, getUser;
            if(AL.get(3).equals("Male")){
                getGender = (RadioButton) findViewById(R.id.rbMale);
                getGender.toggle();
            }
            else {
                getGender = (RadioButton) findViewById(R.id.rbFemale);
                getGender.toggle();
            }
            if(AL.get(4).equals("Active")){
                getUser = (RadioButton) findViewById(R.id.rbActive);
                getUser.toggle();
            }
            else{
                getUser = (RadioButton) findViewById(R.id.rbPassive);
                getUser.toggle();
            }


        }
        bOption = (Button) findViewById(R.id.bOption);
        bTime = (Button) findViewById(R.id.bTime);
        bUpdate = (Button) findViewById(R.id.bUpdate);
        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup gender = (RadioGroup) findViewById(R.id.rgGender);
                RadioGroup userType = (RadioGroup) findViewById(R.id.rgUser);
                RadioButton getGender, getUser;
                int radioGender = gender.getCheckedRadioButtonId();
                getGender = findViewById(radioGender);
                //chest
                int radioUser = userType.getCheckedRadioButtonId();
                getUser = findViewById(radioUser);
                if(databaseForBodyInfo.searchExist("1")) {
                    databaseForBodyInfo.deleteBody("1");
                }
                    BodyInfoGetSet bodyInfoGetSet = new BodyInfoGetSet();
                    bodyInfoGetSet.setHeighteight(height.getText().toString());
                    bodyInfoGetSet.setWeight(weight.getText().toString());
                    bodyInfoGetSet.setAge(age.getText().toString());
                    bodyInfoGetSet.setGender(getGender.getText().toString());
                    bodyInfoGetSet.setUserType(getUser.getText().toString());
                    databaseForBodyInfo.insertBodyInfo(bodyInfoGetSet, "1");
                if(getUser.getText().toString().equals("Active")){

                   bOption.setVisibility(View.VISIBLE);

                   bTime.setVisibility(View.INVISIBLE);

                }
                else{
                    bTime.setVisibility(View.VISIBLE);
                    bOption.setVisibility(View.INVISIBLE);
                }

            }
        });
        bOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BodyInfos.this, NotificationOption.class);
                startActivity(intent);
            }
        });
        bTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BodyInfos.this, NotificationTime.class);
                startActivity(intent);
            }
        });


    }
}

