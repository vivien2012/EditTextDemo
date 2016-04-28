package com.example.edittext;

import android.app.Application;
import android.content.Context;

/**
 * Created on 16/4/28.
 */
public class MyApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
