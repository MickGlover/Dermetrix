package com.example.mick.Dermetrix;

import java.util.Calendar;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Reminders extends Activity{

    DatePicker pickerDate;
    TimePicker pickerTime;
    Button buttonSetAlarm;
    TextView info;

    final static int RQS_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        info = (TextView)findViewById(R.id.info);
        pickerDate = (DatePicker)findViewById(R.id.pickerdate);
        pickerTime = (TimePicker)findViewById(R.id.pickertime);

        Calendar now = Calendar.getInstance();

        pickerDate.init(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                null);

        pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));

        buttonSetAlarm = (Button)findViewById(R.id.setalarm);
        buttonSetAlarm.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Calendar current = Calendar.getInstance();

                Calendar cal = Calendar.getInstance();
                cal.set(pickerDate.getYear(),
                        pickerDate.getMonth(),
                        pickerDate.getDayOfMonth(),
                        pickerTime.getCurrentHour(),
                        pickerTime.getCurrentMinute(),
                        00);

                if (cal.compareTo(current) <= 0) {
                    //The set Date/Time already passed
                    Toast.makeText(getApplicationContext(),
                            "Invalid Date/Time",
                            Toast.LENGTH_LONG).show();
                } else {
                    setAlarm(cal);
                }

            }
        });
    }

    private void setAlarm(Calendar targetCal){

//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        Intent myIntent = new Intent(MainActivity.this, com.example.terryrice.practicecalendar.AlarmReceiver.class);
//        PendingIntent  pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_HOUR, targetCal.getTime().getHours());
        i.putExtra(AlarmClock.EXTRA_MINUTES, targetCal.getTime().getMinutes());
        startActivity(i);


        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        //       AlarmManager.AlarmClockInfo info = new AlarmManager.AlarmClockInfo(targetCal.getTimeInMillis(),pendingIntent);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);

//        info.setText("\n\n***\n"
//                + "Alarm is set@ " + targetCal.getTime() + "\n"
//                + "***\n");




    }

}