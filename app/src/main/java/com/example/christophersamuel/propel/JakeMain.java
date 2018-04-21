package com.example.christophersamuel.propel;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;

import java.io.IOException;

public class JakeMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bodyinfo(View view)
    {
        setContentView(R.layout.bodyinfo);
    }


    public void notificationOption(View view)
    {
        setContentView(R.layout.notification_option);
    }

    public void notificationTime(View view)
    {
        setContentView(R.layout.notification_time);
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
        RadioButton rb = findViewById(R.id.radioButton);
        boolean gender = (rb.isChecked()) ? true : false;
        RadioButton rb3 = findViewById(R.id.radioButton3);
        boolean active = (rb3.isChecked()) ? true : false;
        RadioButton rb4 = findViewById(R.id.radioButton4);

        try
        {
            BodyInfo.saveBodyInfo(height.getText().toString(), weight.getText().toString(), age.getText().toString(), gender, active, this.getApplicationContext());
        }
        catch(IOException e)
        {
            return;
        }

        if(rb3.isChecked())//Should be active
        {
            setContentView(R.layout.notification_option);
        }
        else if(rb4.isChecked())//Should be passive
        {
            setContentView(R.layout.notification_time);
        }
        else
        {
            //Do nothing for now
        }
    }

    //NotificationOption
    public void nopNext(View view)
    {
        //RadioGroup rg = findViewById(R.id.radiogroup);
        RadioButton yes = findViewById(R.id.radioButton);
        RadioButton no = findViewById(R.id.radioButton2);

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
        calendar.set(Calendar.HOUR_OF_DAY, (startHour + endHour) / 2);


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
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

}
