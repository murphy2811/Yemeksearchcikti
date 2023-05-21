package com.example.yemeksiparisokulprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Tam ekran yapmak icin
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //İlk once marha adı ve simgesinnin cıkmasını saglayalım
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent intent=new Intent(MainActivity.this,LoginActivity.class);
               startActivity(intent);
               finish();
            }
        },2000);
    }
}