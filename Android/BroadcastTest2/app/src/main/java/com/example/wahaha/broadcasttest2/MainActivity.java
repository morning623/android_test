package com.example.wahaha.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter externalFilter;
    private ExternalReceiver externalReceiver;
    private static final String TAG = "BroadCastT2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: " + this.toString() + " ,TaskID:" + getTaskId());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.wahaha.broadcasttest2.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.force_offline);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.wahaha.broadcastbestpractice.FORCE_OFFLIME");
                sendBroadcast(intent);
            }
        });


        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.wahaha.broadcasttest2.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);

        externalFilter = new IntentFilter();
        externalFilter.addAction("com.example.wahaha.broadcastbestpractice.TRIGGER");
        externalReceiver = new ExternalReceiver();
        registerReceiver(externalReceiver, externalFilter);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: " + this.toString() + " ,TaskID:" + getTaskId());
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
        unregisterReceiver(externalReceiver);
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }

    class ExternalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent intent_send = new Intent("com.example.wahaha.broadcastbestpractice.FORCE_OFFLIME");
            context.sendBroadcast(intent_send);
            Intent intent2 = new Intent(context, MainActivity.class);
            context.startActivity(intent2);
        }
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: " + this.toString() + " ,TaskID:" + getTaskId());
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: " + this.toString() + " ,TaskID:" + getTaskId());
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: " + this.toString() + " ,TaskID:" + getTaskId());
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: " + this.toString() + " ,TaskID:" + getTaskId());
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: " + this.toString() + " ,TaskID:" + getTaskId());
        super.onRestart();
    }
}
