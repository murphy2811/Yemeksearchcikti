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

import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity10;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity11;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity7;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity8;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity9;

import org.w3c.dom.Text;

public class PizzaActivity extends AppCompatActivity {
    TextView karisikPF,margheritaPF,tavukluPF,napoliPF,veggiPizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yemek)));
        karisikPF=findViewById(R.id.karisikpfiyat);
        margheritaPF=findViewById(R.id.margheritapfiyat);
        tavukluPF=findViewById(R.id.tavuklupfiyat);
        napoliPF=findViewById(R.id.napolipfiyat);
        veggiPizza=findViewById(R.id.veggipfiyat);
        karisikPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PizzaActivity.this, InfoActivity7.class));
            }
        });
        margheritaPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PizzaActivity.this, InfoActivity8.class));
            }
        });
        tavukluPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PizzaActivity.this, InfoActivity9.class));
            }
        });
        napoliPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PizzaActivity.this, InfoActivity10.class));
            }
        });
        veggiPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PizzaActivity.this, InfoActivity11.class));
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
                startActivity(new Intent(PizzaActivity.this,SummaryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}