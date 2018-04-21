package com.example.christophersamuel.propel;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Jake on 4/21/2018.
 */

public class MoveNotification extends BroadcastReceiver
{
    public static final String NOTIFICATION_ID = "MOVE_NOTIFICATION";
    public static final String NOTIFICATION = "Get up and move!";

    @Override
    public void onReceive(final Context context, Intent intent)
    {
        NotificationManager notificationManager = (NotificationManager) (context.getSystemService(Context.NOTIFICATION_SERVICE));

        Notification notification = intent.getParcelableExtra(NOTIFICATION);
        int notificationId = intent.getIntExtra(NOTIFICATION_ID, 0);
        notificationManager.notify(notificationId, notification);
    }
}
