package com.example.yemeksiparisokulprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity15;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity16;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity17;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity18;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity19;

public class KebapActivity2 extends AppCompatActivity {
    TextView adanaKF,tavuksisF,cigersisF,beytiF,icliF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebap2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yemek)));
        adanaKF=findViewById(R.id.adanakfiyat);
        tavuksisF=findViewById(R.id.tavuksisfiyat);
        cigersisF=findViewById(R.id.cigersisfiyat);
        beytiF=findViewById(R.id.beytikfiyat);
        icliF=findViewById(R.id.iclikoftekfiyat);
        adanaKF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KebapActivity2.this, InfoActivity15.class));
            }
        });
        tavuksisF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KebapActivity2.this, InfoActivity16.class));
            }
        });
        cigersisF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KebapActivity2.this, InfoActivity17.class));
            }
        });
        beytiF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KebapActivity2.this, InfoActivity18.class));
            }
        });
        icliF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KebapActivity2.this, InfoActivity19.class));
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
                startActivity(new Intent(KebapActivity2.this,SummaryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}