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


    public void page10(View view)
    {
        setContentView(R.layout.page_10);
    }

    public void back(View view)
    {
        setContentView(R.layout.activity_main);
    }

    //Next button code for body info
    //Body info
    public void biNext(View view)
    {
        /*RadioGroup rg = findViewById(R.id.radioGroup2);
        int id = rg.getCheckedRadioButtonId();
        RadioButton checked = findViewById(id);*/

        EditText height = findViewById(R.id.inHeight);
        EditText weight = findViewById(R.id.inWeight);
        EditText age = findViewById(R.id.inAge);
        RadioButton rb = findViewById(R.id.rbMale);
        boolean gender = rb.isChecked();
        RadioButton rb3 = findViewById(R.id.rbActive);
        boolean active = rb3.isChecked();
        RadioButton rb4 = findViewById(R.id.rbPassive);

    }

    //NotificationOption
    public void nopNext(View view)
    {
        //RadioGroup rg = findViewById(R.id.radiogroup);
        RadioButton yes = findViewById(R.id.notOpYes);
        RadioButton no = findViewById(R.id.notOpNo);

        if(yes.isChecked())
        {
            setContentView(R.layout.notification_time);
        }
        else if(no.isChecked())
        {
            setContentView(R.layout.activity_main);
        }
        else
        {
            //Do nothing for now
        }
    }

    //page10
    public void toSum(View view)
    {
        setContentView(R.layout.activity_summary);
    }

    //page10
    public void toGoals(View view)
    {
        setContentView(R.layout.activity_goals);
    }

    //Notification time
    @TargetApi(24)
    public void notNext(View view)
    {
        //Initializes variables
        int notificationId = 1;
        TimePicker start = findViewById(R.id.timePicker);
        TimePicker end = findViewById(R.id.timePicker2);
        int startHour = start.getCurrentHour();
        int endHour = end.getCurrentHour();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, startHour);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Notification")
                .setContentText("It's time to get fit! Move around!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //Sets up intents
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent activity = PendingIntent.getActivity(this, notificationId, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(activity);

        Notification notification = builder.build();

        Intent notificationIntent = new Intent(this, MoveNotification.class);
        notificationIntent.putExtra(MoveNotification.NOTIFICATION_ID, notificationId);
        notificationIntent.putExtra(MoveNotification.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, notificationId, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        //Sets alarm
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
    }


}
