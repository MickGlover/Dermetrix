package com.example.mick.Dermetrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mick.Dermetrix.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseExample extends AppCompatActivity {

    //Here
    private OurDatabase mydb; //This needs to be included if you want multiple methods to access the database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_example);

        //and here
        mydb = new OurDatabase(this); //This should be included in the onCreate method
    }

    //THIS IS THE IMPORTANT PART. IT WILL SHOW HOW TO ACCESS THE DATA IN THE DATABASE
    //See above comments to set up
    public void updateData(View view){
        mydb = new OurDatabase(this);

        Context context = getApplicationContext();
// convert drawable to bitmap


        String[] tags = {"awesome","cool"};
        EditText selectedID = (EditText) findViewById(R.id.idInput); //Gets the ID from the edditable text
        int intID = Integer.parseInt(selectedID.getText().toString()); //Converts ID to integer from whatever EditText is.

        //The following are used to get individual data
        String d = null;
        try {
            d = mydb.getDate(intID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int score = mydb.getScore(intID);
        String picture  = mydb.getPicture(intID); //IF something comes up red select it press alt enter for suggestions
                                                  //Import class will normally be the best option
        String[] tags2 = mydb.getTagArray(intID);


       //Now we display the data we got

        TextView dateDisplay = (TextView) findViewById(R.id.textViewDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd " + "\n" + "hh:mm:ss");
        String dateString = dateFormat.format(d);
        dateDisplay.setText(dateString);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_database_example, menu);
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
}
