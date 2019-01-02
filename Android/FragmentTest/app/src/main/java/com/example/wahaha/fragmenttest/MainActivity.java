package com.example.wahaha.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int SIZE_SMALL = 0;
    private static final int SIZE_LARGE = 1;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        if(null == findViewById(R.id.right_layout)){
            type = SIZE_SMALL;
        }else{
            type = SIZE_LARGE;
        }
        if(SIZE_LARGE == type){
            replaceFragment(new RightFragment());
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                if(SIZE_LARGE == type){
                    replaceFragment(new AnotherRightFragment());
                }else{
                    Toast.makeText(this,"SMALL", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
