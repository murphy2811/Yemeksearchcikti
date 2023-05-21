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


import com.example.yemeksiparisokulprojesi.sepeteekle.InfoAcitivity4;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity2;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity3;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity5;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity6;


public class BurgerActivity extends AppCompatActivity {
    TextView klasikBF,steakBF,mushBF,bbqBF,jalapenoBF,patates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yemek)));
        klasikBF=findViewById(R.id.klasikbfiyat);
        steakBF=findViewById(R.id.steakbfiyat);
        mushBF=findViewById(R.id.mushroombfiyat);
        bbqBF=findViewById(R.id.bbqbfiyat);
        jalapenoBF=findViewById(R.id.jalapenobfiyat);
        patates=findViewById(R.id.patatesfiyat);
        klasikBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BurgerActivity.this, InfoActivity.class));
            }
        });
        steakBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BurgerActivity.this, InfoActivity2.class));
            }
        });
        mushBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BurgerActivity.this, InfoActivity3.class));
            }
        });
        bbqBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BurgerActivity.this, InfoAcitivity4.class));
            }
        });
        jalapenoBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BurgerActivity.this, InfoActivity5.class));
            }
        });
        patates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BurgerActivity.this, InfoActivity6.class));
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
                startActivity(new Intent(BurgerActivity.this,SummaryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}