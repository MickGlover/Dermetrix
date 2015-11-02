package com.example.mick.Dermetrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mick.Dermetrix.R;

public class Tracking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
    }

    public void goToCalendarActivity(View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }

}
