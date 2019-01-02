package com.example.chenwa.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private EditText editText;
private ImageView imageView;
private ProgressBar progressBar;
private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.edit_text);
        imageView = (ImageView)findViewById(R.id.image_view);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        progressBar2 = (ProgressBar)findViewById(R.id.progress_bar2);
    }

    @Override
    public void onClick(View view) {
        String inputText;
        switch (view.getId()) {
            case R.id.button:
                inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                inputText = editText.getText().toString();
                if(inputText.equals("image") ) {
                    imageView.setImageResource(R.drawable.img_2);
                }else if(inputText.equals("bar") ){
                    if(progressBar.getVisibility() == View.GONE){
                        progressBar.setVisibility(View.VISIBLE);
                    }else{
                        progressBar.setVisibility(View.GONE);
                    }
                }else if(inputText.equals("bar2") ){
                    int progress = progressBar2.getProgress();
                    progress = progress + 10;
                    progressBar2.setProgress(progress);
                }else if(inputText.equals("alert") ){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("This is Dialog");
                    dialog.setMessage("Somthing important.");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }else if(inputText.equals("progressDialog") ){
                    ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("This is ProgressDialog");
                    progressDialog.setMessage("Loading ...");
                    progressDialog.setCancelable(true);
                    progressDialog.show();
                }
                break;
            default:
                break;

        }
    }
}
