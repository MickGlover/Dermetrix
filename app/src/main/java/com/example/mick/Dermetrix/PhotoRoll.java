package com.example.mick.Dermetrix;

import android.content.Intent;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mick.Dermetrix.R;

import java.util.ArrayList;

public class PhotoRoll extends ActionBarActivity {
    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_roll);

        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(PhotoRoll.this, DetailsActivity.class);
                intent.putExtra("imagePath", item.getImagePath());
                intent.putExtra("score", Integer.toString(item.getScore()));
                intent.putExtra("date", item.getDate());
                intent.putExtra("tagArray", MyFunctions.serialize(item.getTagArray()));
                //Start details activity
                startActivity(intent);
            }
        });
    }

    /**
     * Prepare some actual data for gridview
     */
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        OurDatabase mydb = new OurDatabase(this);
        int i;
        for (i = 1; i < mydb.getNumOfRows()+1; i++)
        {
            imageItems.add(mydb.getImageItem(i));
        }
        return imageItems;
    }
}
