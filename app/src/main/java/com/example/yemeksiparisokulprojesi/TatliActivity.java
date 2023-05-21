package com.example.yemeksiparisokulprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity12;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity19;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity20;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity21;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity22;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity23;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity24;

public class TatliActivity extends AppCompatActivity {
    TextView eklerF,tiramisuF,magnoliaF,fbaklavaF,sutlacF;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tatli);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yemek)));
        eklerF=findViewById(R.id.eklerfiyat);
        tiramisuF=findViewById(R.id.tiramisufiyat);
        magnoliaF=findViewById(R.id.magnoliafiyat);
        fbaklavaF=findViewById(R.id.baklavafiyat);
        sutlacF=findViewById(R.id.sutlacfiyat);
        eklerF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TatliActivity.this, InfoActivity20.class));
            }
        });
        tiramisuF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TatliActivity.this, InfoActivity21.class));
            }
        });
        magnoliaF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TatliActivity.this, InfoActivity22.class));
            }
        });
        fbaklavaF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TatliActivity.this, InfoActivity23.class));
            }
        });
        sutlacF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TatliActivity.this, InfoActivity24.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sepet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Sepet:
                startActivity(new Intent(TatliActivity.this,SummaryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}