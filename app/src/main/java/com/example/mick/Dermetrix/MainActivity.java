package com.example.mick.Dermetrix;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.util.Log;
import android.view.Window;

import com.example.mick.Dermetrix.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "The onStart() event");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "The onResume() event");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"The onPause() event");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "the onStop() event");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"The onDestroy() event");
    }

    public void goToCalendarActivity(View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }
    public void goToFindTreatmentActivity(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void goToPhotoRollActivity(View view) {
        Intent intent = new Intent(this, PhotoRoll.class);
        startActivity(intent);
    }
    public void goToRemindersActivity(View view) {
        Intent intent = new Intent(this, Reminders.class);
        startActivity(intent);
    }
    public void goToTakePictureActivity(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder

                .setMessage("Ready to take a picture?\n" +
                        "Make sure you have: \n" +
                        "\n" +
                        "Proper lighting\n" +
                        "No make-up on\n" +
                        "No hair in your face\n" +
                        "A close zoom\n" +
                        "Your face centered in the frame\n" +
                        "Neutral expression")
                .setPositiveButton("Ready",  new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(getBaseContext(), Classification.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Not Ready", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                })
                .show();

    }
    public void goToTrackingActivity(View view) {
        Intent intent = new Intent(this, Tracking.class);
        startActivity(intent);
    }
    public void goToSpecificPhoto(View view) {
        Intent intent = new Intent(this, Reminders.class);
        startActivity(intent);
    }


}
