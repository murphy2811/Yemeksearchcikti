package com.example.yemeksiparisokulprojesi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class kartadres extends AppCompatActivity {

    EditText aciklama,adresbilgileri,kartisim,kartno,karttarih,kartcvv;

    String kullaniciadi,foodnames,food;
    Button btnsatinal;
    SQLiteDatabase database,database2 ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kartadres);
        aciklama=findViewById(R.id.aciklamaa);
        adresbilgileri=findViewById(R.id.adress);
        btnsatinal=findViewById(R.id.btnSatınAl);
        kartisim=findViewById(R.id.isim_soyisim);
        kartno=findViewById(R.id.kart_numarası);
        karttarih=findViewById(R.id.son_kullanma_tarihi);
        kartcvv=findViewById(R.id.cvv);
        kullaniciadi=UserAuthSign.getInstance().getAuthUserName();

        database=this.openOrCreateDatabase("FoodApp",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS siparislerimm (id INTEGER PRİMARY KEY,foods VARCHAR,aciklama VARCHAR,adres VARCHAR,fiyat VARCHAR,kullaniciAdi)");

        Intent i=getIntent();
        String fiyat=i.getStringExtra("Toplam") ;
        database2=this.openOrCreateDatabase("FoodApp",MODE_PRIVATE,null);



        btnsatinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=database2.rawQuery("SELECT * FROM orderig WHERE kullaniciAdi ='" +kullaniciadi+"'",null);
                int foodindex=cursor.getColumnIndex("name");
                String virgül=",";
                while (cursor.moveToNext()) {
                    food = cursor.getString(foodindex);
                    if (foodnames != null){
                        foodnames=foodnames+ food + virgül ;
                    }
                    else {
                        foodnames=food+virgül;

                    }
                }
                database.execSQL("INSERT INTO siparislerimm (foods,aciklama,adres,fiyat,kullaniciAdi) VALUES ('" +foodnames+"','" +aciklama.getText().toString()+"','"+adresbilgileri.getText().toString()+"','"+fiyat+"','"+kullaniciadi+"')");
                Toast.makeText(kartadres.this, "SİPARİŞİNİZ ALINDI", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(kartadres.this,SiparislerimActivity.class);
                startActivity(intent);


            }
        });

    }
}
