package com.example.mick.Dermetrix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mick.Dermetrix.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Classification extends AppCompatActivity {
    private int score;
    private int percentRed;
    private String newImagePath;
    private SharedPreferences mPrefs;
    private int generatedScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);
        mPrefs = getSharedPreferences("bias", 0);

        dispatchTakePictureIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_classification, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //this is bad practice. dont do it
    public void choose0(View view){
        ImageView mImageView0 = (ImageView) findViewById(R.id.score0);
        mImageView0.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        ImageView mImageView1 = (ImageView) findViewById(R.id.score1);
        mImageView1.getBackground().clearColorFilter();
        ImageView mImageView2 = (ImageView) findViewById(R.id.score2);
        mImageView2.getBackground().clearColorFilter();
        ImageView mImageView3 = (ImageView) findViewById(R.id.score3);
        mImageView3.getBackground().clearColorFilter();
        ImageView mImageView4 = (ImageView) findViewById(R.id.score4);
        mImageView4.getBackground().clearColorFilter();
        ImageView mImageView5 = (ImageView) findViewById(R.id.score5);
        mImageView5.getBackground().clearColorFilter();
        score = 0;
        TextView text = (TextView) findViewById(R.id.textViewScore);
        text.setText("Score: " + Integer.toString(score));

    }

    public void choose1(View view){
        ImageView mImageView0 = (ImageView) findViewById(R.id.score0);
        mImageView0.getBackground().clearColorFilter();
        ImageView mImageView1 = (ImageView) findViewById(R.id.score1);
        mImageView1.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        ImageView mImageView2 = (ImageView) findViewById(R.id.score2);
        mImageView2.getBackground().clearColorFilter();
        ImageView mImageView3 = (ImageView) findViewById(R.id.score3);
        mImageView3.getBackground().clearColorFilter();
        ImageView mImageView4 = (ImageView) findViewById(R.id.score4);
        mImageView4.getBackground().clearColorFilter();
        ImageView mImageView5 = (ImageView) findViewById(R.id.score5);
        mImageView5.getBackground().clearColorFilter();
        score = 1;
        TextView text = (TextView) findViewById(R.id.textViewScore);
        text.setText("Score: " + Integer.toString(score));

    }

    public void choose2(View view){
        ImageView mImageView0 = (ImageView) findViewById(R.id.score0);
        mImageView0.getBackground().clearColorFilter();
        ImageView mImageView1 = (ImageView) findViewById(R.id.score1);
        mImageView1.getBackground().clearColorFilter();
        ImageView mImageView2 = (ImageView) findViewById(R.id.score2);
        mImageView2.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        ImageView mImageView3 = (ImageView) findViewById(R.id.score3);
        mImageView3.getBackground().clearColorFilter();
        ImageView mImageView4 = (ImageView) findViewById(R.id.score4);
        mImageView4.getBackground().clearColorFilter();
        ImageView mImageView5 = (ImageView) findViewById(R.id.score5);
        mImageView5.getBackground().clearColorFilter();
        score = 2;
        TextView text = (TextView) findViewById(R.id.textViewScore);
        text.setText("Score: " + Integer.toString(score));

    }
    public void choose3(View view){
        ImageView mImageView0 = (ImageView) findViewById(R.id.score0);
        mImageView0.getBackground().clearColorFilter();
        ImageView mImageView1 = (ImageView) findViewById(R.id.score1);
        mImageView1.getBackground().clearColorFilter();
        ImageView mImageView2 = (ImageView) findViewById(R.id.score2);
        mImageView2.getBackground().clearColorFilter();
        ImageView mImageView3 = (ImageView) findViewById(R.id.score3);
        mImageView3.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        ImageView mImageView4 = (ImageView) findViewById(R.id.score4);
        mImageView4.getBackground().clearColorFilter();
        ImageView mImageView5 = (ImageView) findViewById(R.id.score5);
        mImageView5.getBackground().clearColorFilter();
        score = 3;
        TextView text = (TextView) findViewById(R.id.textViewScore);
        text.setText("Score: " + Integer.toString(score));

    }
    public void choose4(View view){
        ImageView mImageView0 = (ImageView) findViewById(R.id.score0);
        mImageView0.getBackground().clearColorFilter();
        ImageView mImageView1 = (ImageView) findViewById(R.id.score1);
        mImageView1.getBackground().clearColorFilter();
        ImageView mImageView2 = (ImageView) findViewById(R.id.score2);
        mImageView2.getBackground().clearColorFilter();
        ImageView mImageView3 = (ImageView) findViewById(R.id.score3);
        mImageView3.getBackground().clearColorFilter();
        ImageView mImageView4 = (ImageView) findViewById(R.id.score4);
        mImageView4.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        ImageView mImageView5 = (ImageView) findViewById(R.id.score5);
        mImageView5.getBackground().clearColorFilter();
        score = 4;
        TextView text = (TextView) findViewById(R.id.textViewScore);
        text.setText("Score: " + Integer.toString(score));

    }
    public void choose5(View view){
        ImageView mImageView0 = (ImageView) findViewById(R.id.score0);
        mImageView0.getBackground().clearColorFilter();
        ImageView mImageView1 = (ImageView) findViewById(R.id.score1);
        mImageView1.getBackground().clearColorFilter();
        ImageView mImageView2 = (ImageView) findViewById(R.id.score2);
        mImageView2.getBackground().clearColorFilter();
        ImageView mImageView3 = (ImageView) findViewById(R.id.score3);
        mImageView3.getBackground().clearColorFilter();
        ImageView mImageView4 = (ImageView) findViewById(R.id.score4);
        mImageView4.getBackground().clearColorFilter();
        ImageView mImageView5 = (ImageView) findViewById(R.id.score5);
        mImageView5.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        score = 5;
        TextView text = (TextView) findViewById(R.id.textViewScore);
        text.setText("Score: " + Integer.toString(score));
    }

    static final int REQUEST_TAKE_PHOTO = 1;

    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                newImagePath = photoFile.getAbsolutePath();
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);


            }
        }
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(null);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();

        return image;
    }


    @Override
    protected void onActivityResult(final int requestCode,final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setContentView(R.layout.activity_classification);
        ImageView mImageView = (ImageView) findViewById(R.id.MyImageView);
        Bitmap newestBitmap = BitmapFactory.decodeFile(newImagePath);
        mImageView.setImageBitmap(newestBitmap);
        analyzeImage();

    }

    public void analyzeImage(){
        ImageView mImageView0 = (ImageView) findViewById(R.id.score0);
        mImageView0.getBackground().clearColorFilter();
        ImageView mImageView1 = (ImageView) findViewById(R.id.score1);
        mImageView1.getBackground().clearColorFilter();
        ImageView mImageView2 = (ImageView) findViewById(R.id.score2);
        mImageView2.getBackground().clearColorFilter();
        ImageView mImageView3 = (ImageView) findViewById(R.id.score3);
        mImageView3.getBackground().clearColorFilter();
        ImageView mImageView4 = (ImageView) findViewById(R.id.score4);
        mImageView4.getBackground().clearColorFilter();
        ImageView mImageView5 = (ImageView) findViewById(R.id.score5);
        mImageView5.getBackground().clearColorFilter();

        long redCount = 0;
        long blueCount = 0;
        long greenCount = 0;

        Bitmap newestBitmap = BitmapFactory.decodeFile(newImagePath);

        for(int j=0;j<newestBitmap.getHeight();j++) {
            for (int i = 0; i < newestBitmap.getWidth(); i++) {
                int pixel = newestBitmap.getPixel(i, j);
                redCount += (pixel & 0x00ff0000) >>16;
                greenCount += (pixel & 0x0000ff00)>>8;
                blueCount += pixel & 0x000000ff;
            }
        }
        float bias = mPrefs.getFloat("bias", 0);
        float redPercent = bias + (float)redCount/(float)(greenCount+blueCount+redCount);


        if(redPercent < .35 ){
            mImageView0.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
            score = 0;
        } else if(redPercent < .365){
            mImageView1.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
            score = 1;
        } else if(redPercent < .380){
            mImageView2.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
            score = 2;
        } else if(redPercent < .395){
            mImageView3.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
            score = 3;
        } else if(redPercent < .41){
            mImageView4.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
            score = 4;
        } else {
            mImageView5.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
            score = 5;
        }

        TextView text = (TextView) findViewById(R.id.textViewScore);
        text.setText("Score: " + Integer.toString(score));
        generatedScore = score;
    }

    public void saveData(View view){
        OurDatabase mydb = new OurDatabase(this);
        EditText note = (EditText) findViewById(R.id.editTextNote);
        String tags[] = {note.getText().toString()};
        mydb.saveEntry(newImagePath, score, new Date().toString(),tags);
        SharedPreferences.Editor mEditor = mPrefs.edit();
        float bias = mPrefs.getFloat("bias", 0);
        float newBias = (float) (bias + (score - generatedScore)*.015);
        mEditor.putFloat("bias",newBias).commit();
        finish();
    }
}
