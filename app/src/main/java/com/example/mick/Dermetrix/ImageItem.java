package com.example.mick.Dermetrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

public class ImageItem {
    private String imagePath;
    private int score;
    private String date;
    private String[] tagArray;

    public ImageItem(String imagePath, int score, String date, String[] tagArray) {
        super();

        this.imagePath = imagePath;
        this.score = score;
        this.date = date;
        this.tagArray = tagArray;

    }

    public String getImagePath() {return imagePath;}

    public Bitmap getImage() {
        return BitmapFactory.decodeFile(imagePath);
    }

    public int getScore() {return score;}

    public String getDate() {return date;}

    public String[] getTagArray() {return tagArray;}

}
