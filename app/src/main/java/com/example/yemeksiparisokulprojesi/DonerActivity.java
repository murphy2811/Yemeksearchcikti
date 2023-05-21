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

import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity11;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity12;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity13;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity14;

import org.w3c.dom.Text;

public class DonerActivity extends AppCompatActivity {
    TextView tavukDF,etDF,tavukTF,etTF;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doner);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yemek)));
        tavukDF=findViewById(R.id.tavukdfiyat);
        etDF=findViewById(R.id.etdfiyat);
        tavukTF=findViewById(R.id.tavukDtabakfiyat);
        etTF=findViewById(R.id.etdtabakfiyat);
        tavukDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonerActivity.this, InfoActivity11.class));
            }
        });
        etDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonerActivity.this, InfoActivity12.class));
            }
        });
        tavukTF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonerActivity.this, InfoActivity13.class));
            }
        });
        etTF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonerActivity.this, InfoActivity14.class));
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
                startActivity(new Intent(DonerActivity.this,SummaryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}