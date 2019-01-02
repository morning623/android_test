package com.example.wahaha.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wahaha on 2018/11/13.
 */

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";
    
    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: Thread id is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Thread id is " + Thread.currentThread().getId());
    }
}
