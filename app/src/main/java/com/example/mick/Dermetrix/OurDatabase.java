package com.example.mick.Dermetrix;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;

import java.io.ByteArrayOutputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.content.Context.*;
import static android.database.sqlite.SQLiteDatabase.*;

/**
 * Created by mick on 11/18/2015.
 */
public class OurDatabase extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase mydatabase;
    String ARRAY_DIVIDER = "F42@sf^";

    public OurDatabase(Context context)
    {
        super(context, "Image Data", null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS OURTABLE(ID INTEGER PRIMARY KEY AUTOINCREMENT, image BLOB, score INT , date VARCHAR, tags VARCHAR);");

    }

    public OurDatabase(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    private String serialize(String content[]){
        return TextUtils.join(ARRAY_DIVIDER, content);
    }

    private String[] deserialize(String content){
        return content.split(ARRAY_DIVIDER);
    }


    public void saveEntry(String imagePath, int score, String date, String[] tagArray){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues cv = new  ContentValues();
        cv.put("image",  imagePath);
        cv.put("score", score);
        cv.put("date", date);
        cv.put("tags", serialize(tagArray));

        db.insert("OURTABLE", null, cv);

    }

    public ImageItem getImageItem(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from OURTABLE where id=" + id + "", null);
        res.moveToFirst();
        return new ImageItem(res.getString(1),res.getInt(2),res.getString(3),this.deserialize(res.getString(4)));

    }

    public Date getDate(int id) throws ParseException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from OURTABLE where id=" + id + "", null);
        res.moveToFirst();
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = format.parse(res.getString(3));
        return date;
    }

    public int getScore(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from OURTABLE where id=" + id + "", null);
        res.moveToFirst();
        return res.getInt(2);
    }

    public String getPicture(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from OURTABLE where id=" + id + "", null);
        res.moveToFirst();
        return res.getString(1);
    }

    public String getPicture(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from OURTABLE", null);
        res.moveToLast();
        return res.getString(1);
    }

    public String[] getTagArray(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from OURTABLE where id=" + id + "", null);
        res.moveToFirst();
        return this.deserialize(res.getString(4));
    }

    public int getNumOfRows(){

        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "OURTABLE");

        return numRows;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS OURTABLE(ID INTEGER PRIMARY KEY AUTOINCREMENT, image BLOB, score INT , date VARCHAR, tags VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS OURTABLE");
        onCreate(db);
    }
}