package com.example.christophersamuel.propel;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;

/**
 * Created by Jake on 4/25/2018.
 */

public class NotificationTime extends AppCompatActivity
{
    private TimePicker start;
    private TimePicker end;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_time);

        start = findViewById(R.id.timePicker);
        end = findViewById(R.id.timePicker2);
        start.setIs24HourView(true);
        end.setIs24HourView(true);
    }


    //Notification time
    //@TargetApi(24)
    public void notNext(View view)
    {
        //Initializes variables
        int notificationId = 1;
        int startHour;
        int startMinute;
        int endHour;
        Calendar calendar = null;

        //Prevents errors with lower api levels
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            startHour = start.getHour();
            startMinute = start.getMinute();
            endHour = end.getHour();
            calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, startHour);
            calendar.set(Calendar.MINUTE, startMinute);
        }


        Intent intent = new Intent(this, ThirdActivity.class);
        PendingIntent activity = PendingIntent.getActivity(this, notificationId, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Sets notifications immediately for demonstration purposes
        Notification notification1 = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentTitle("Notification")
                .setContentText("It's time to get fit! Get up and move around!")
                .setContentIntent(activity)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, notification1);


        Notification notification2 = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentTitle("Notification")
                .setContentText("Try some jumping jacks! Lets start with a set of 30")
                .setContentIntent(activity)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        notificationManager.notify(notificationId + 1, notification2);


        Notification notification3 = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true)
                .setContentTitle("Notification")
                .setContentText("Try some push-ups! Lets start with a set of 15!")
                .setContentIntent(activity)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        notificationManager.notify(notificationId + 2, notification3);

        //Prevents api version issues
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
        {
            //Sets timed repeating notifications
            Intent notificationIntent = new Intent(this, MoveNotification.class);
            notificationIntent.putExtra(MoveNotification.NOTIFICATION_ID, notificationId);
            notificationIntent.putExtra(MoveNotification.NOTIFICATION, notification1);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, notificationId, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            //Sets alarm
            AlarmManager alarmManager = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000*60, pendingIntent);
        }


        startActivity(intent);
    }
}
