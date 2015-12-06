package com.example.mick.Dermetrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        String score = getIntent().getStringExtra("score");
        String imagePath = getIntent().getStringExtra("imagePath");
        String date = getIntent().getStringExtra("date");
        String tagArray = getIntent().getStringExtra("tagArray");
        //need to add the date and rating data right here


        //I think this is where we can add the date and rating value to the image
        //also we can add text to the image here maybe? I'm not sure how to create a text input though

        ImageView imageView = (ImageView) findViewById(R.id.MyImageView);
        Bitmap newestBitmap = BitmapFactory.decodeFile(imagePath);
        imageView.setImageBitmap(newestBitmap);

        TextView textViewScore = (TextView) findViewById(R.id.TextViewScore);
        textViewScore.setText("Score:  " + score);

        TextView textViewDate = (TextView) findViewById(R.id.TextViewDate);
        textViewDate.setText("Date:  " + date);
    }
}
