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

import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity24;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity25;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity26;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity27;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity28;

public class IcecekActivity extends AppCompatActivity {
    TextView kola,fanta,ayran,gazoz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icecek);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yemek)));
        kola=findViewById(R.id.kolafiyat);
        fanta=findViewById(R.id.fantafiyat);
        ayran=findViewById(R.id.ayranfiyat);
        gazoz=findViewById(R.id.gazozfiyat);
        kola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IcecekActivity.this, InfoActivity25.class));
            }
        });
        fanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IcecekActivity.this, InfoActivity26.class));
            }
        });
        ayran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IcecekActivity.this, InfoActivity27.class));
            }
        });
        gazoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IcecekActivity.this, InfoActivity28.class));
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
                startActivity(new Intent(IcecekActivity.this,SummaryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}