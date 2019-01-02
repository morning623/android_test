package com.example.wahaha.networktest;

import android.app.Application;
import android.content.Context;

/**
 * Created by wahaha on 2018/12/7.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
