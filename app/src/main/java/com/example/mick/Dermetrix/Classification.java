package com.example.mick.Dermetrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mick.Dermetrix.R;

import java.util.ArrayList;

public class Classification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification);

        OurDatabase mydb = new OurDatabase(this);
        String newImage = mydb.getPicture();
        ImageView mImageView = (ImageView) findViewById(R.id.MyImageView);
        Bitmap newestBitmap = BitmapFactory.decodeFile(newImage);
        mImageView.setImageBitmap(newestBitmap);

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

        for(int j=0;j<newestBitmap.getHeight();j++) {
            for (int i = 0; i < newestBitmap.getWidth(); i++) {
                int pixel = newestBitmap.getPixel(i, j);
                redCount += (pixel & 0x00ff0000) >>16;
                greenCount += (pixel & 0x0000ff00)>>8;
                blueCount += pixel & 0x000000ff;
            }
        }
        float redPercent = (float)redCount/(float)(greenCount+blueCount+redCount);
        TextView text = (TextView) findViewById(R.id.textView2);
        text.setText(Float.toString(redPercent));
        if(redPercent < .35){
            mImageView0.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        } else if(redPercent < .37){
            mImageView1.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        } else if(redPercent < .39){
            mImageView2.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        } else if(redPercent < .40){
            mImageView3.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        } else if(redPercent < .42){
            mImageView4.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        } else {
            mImageView5.getBackground().setColorFilter(Color.parseColor("#ffff00"), PorterDuff.Mode.MULTIPLY);
        }






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

    //this is bad practive. dont do it
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
    }
}
