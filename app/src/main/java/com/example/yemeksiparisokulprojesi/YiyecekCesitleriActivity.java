package com.example.yemeksiparisokulprojesi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

public class YiyecekCesitleriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yiyecek_cesitleri);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yemek)));
        CardView burger=findViewById(R.id.cardvBurger);
        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YiyecekCesitleriActivity.this,BurgerActivity.class));
            }
        });


        CardView pizza=findViewById(R.id.cardvPizza);
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YiyecekCesitleriActivity.this,PizzaActivity.class));
            }
        });

        CardView doner=findViewById(R.id.cardvDoner);
        doner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YiyecekCesitleriActivity.this,DonerActivity.class));
            }
        });

        CardView kebap=findViewById(R.id.cardvKebap);
        kebap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YiyecekCesitleriActivity.this,KebapActivity2.class));
            }
        });

        CardView tatli=findViewById(R.id.cardvTatli);
        tatli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YiyecekCesitleriActivity.this,TatliActivity.class));
            }
        });

        CardView icecek=findViewById(R.id.cardvIcecek);
        icecek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YiyecekCesitleriActivity.this,IcecekActivity.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cikis:
                Intent i=new Intent(YiyecekCesitleriActivity.this,LoginActivity.class);
                startActivity(i);
                return true;
            case R.id.sepet:
                startActivity(new Intent(YiyecekCesitleriActivity.this,SummaryActivity.class));
                return true;
            case R.id.siparis:
                startActivity(new Intent(YiyecekCesitleriActivity.this,SiparislerimActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
