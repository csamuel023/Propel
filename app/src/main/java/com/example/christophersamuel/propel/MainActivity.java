package com.example.christophersamuel.propel;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button btn2;
    private ArrayList<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_login = new Intent(MainActivity.this, LoginSinup.class);
                open_login.putExtra("users", users);
                startActivity(open_login);
            }
        });

        btn2 = (Button)findViewById(R.id.button8);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_login = new Intent(MainActivity.this, SecondActivity.class);
                open_login.putExtra("users", users);
                startActivity(open_login);
            }
        });

    }

    public void back(View view)
    {
        setContentView(R.layout.activity_main);
    }


}
