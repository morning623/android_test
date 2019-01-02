package com.example.chenwa.activityt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: "+this.toString()+" Task id is "+getTaskId());
        setContentView(R.layout.second_layout);
        if(savedInstanceState != null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
        }
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        String tempData2 = outState.getString("data_key");
        if(tempData2 != null)
        {
            Log.d(TAG, "onSaveInstanceState: already have "+tempData2);
        }
        outState.putString("data_key", tempData);
        Log.d(TAG, "onSaveInstanceState: "+this.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: "+this.toString());
    }

    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
}
