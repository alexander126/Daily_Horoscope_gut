package com.example.alex.daily_horoscope;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver{
    public AlarmReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, iService.class);
        context.startService(intent1);
    }
}