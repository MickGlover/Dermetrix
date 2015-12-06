package com.example.mick.Dermetrix;

import android.text.TextUtils;

/**
 * Created by mick on 12/5/2015.
 */
public class MyFunctions {
    private static String ARRAY_DIVIDER = "F42@sf^";

    public static String serialize(String content[]){
        return TextUtils.join(ARRAY_DIVIDER, content);
    }

    public static String[] deserialize(String content){
        return content.split(ARRAY_DIVIDER);
    }
}
