package com.example.mick.Dermetrix;

import android.content.Intent;
import android.os.Bundle;
import android.provider.BaseColumns;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mick.Dermetrix.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Date;

public class Tracking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);


        GraphView graph = (GraphView) findViewById(R.id.graph);
        // generate Dates

// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        OurDatabase mydb = new OurDatabase(this);
        int score;
        Date date,d1 = null,d2 = null;
        DataPoint[] data = new DataPoint[mydb.getNumOfRows()];
        int i = 1;
        while (i < mydb.getNumOfRows()) {
            try {
                if(i==1) d1= mydb.getDate(i);
                if(i==mydb.getNumOfRows()) d2 = mydb.getDate(i);
                date = mydb.getDate(i);
                score = mydb.getScore(i);
                data[i] = (new DataPoint(date, score));
            } catch (Exception parseException){}
            i++;
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(data);
        graph.addSeries(series);

// set date label formatter
        graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(this));
        graph.getGridLabelRenderer().setNumHorizontalLabels(7); // only 4 because of the space

// set manual x bounds to have nice steps
        graph.getViewport().setMinX(d1.getTime());
        graph.getViewport().setMaxX(d2.getTime());
        graph.getViewport().setXAxisBoundsManual(true);
        graph.addSeries(series);

    }

}
