package com.example.localnotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class AutoNotification extends AppCompatActivity {
 public static    Calendar cal;
 Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent notificationIntent = new Intent(AutoNotification.this, Alarm_Notification.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(AutoNotification.this,
                0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

       cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE,0 );
        cal.add(Calendar.SECOND, 1);
     //   alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
//for 24 hours (day)
    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),
            1000 * 60 * 60 *24,broadcast);
    //for 15 minutes
    //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),15 * 60 * 1000,broadcast);
            }
        });
    }
}
