package com.example.yemeksiparisokulprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yemeksiparisokulprojesi.Database.Database;

public class KayitActivity extends AppCompatActivity {

    EditText edKayitAd,edKayitEmail,edKayitSifre,edKayitSifreOnay;
    Button btnKayitOl;
    TextView tvHesapVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        edKayitAd=findViewById(R.id.edKayitKulAdi);
        edKayitEmail=findViewById(R.id.edKayitEmail);
        edKayitSifre=findViewById(R.id.edKayitSifre);
        edKayitSifreOnay=findViewById(R.id.edKayitSifreOnay);
        btnKayitOl=findViewById(R.id.btnKayitOl);
        tvHesapVar=findViewById(R.id.tvHesapVar);


        tvHesapVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KayitActivity.this,LoginActivity.class));
            }
        });



        btnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String kullaniciAdi=edKayitAd.getText().toString();
                String email=edKayitEmail.getText().toString();
                String sifre=edKayitSifre.getText().toString();
                String sifreonay=edKayitSifreOnay.getText().toString();
                Database database = new Database(getApplicationContext());
                String qry1="create table if not exists users(kullaniciAdi VARCHAR PRIMARY KEY,email text , sifre text)";
                SQLiteDatabase db=database.getWritableDatabase();
                db.execSQL(qry1);
                if(!TextUtils.isEmpty(kullaniciAdi) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(sifre) && !TextUtils.isEmpty(sifreonay)){
                    if(sifre.compareTo(sifreonay)==0){
                        if(sifre.length()>=6 && sifre.length()<=15){
                            if (!isValidEmail(email)) {
                                Toast.makeText(KayitActivity.this, "Geçerli Bir E-posta Giriniz", Toast.LENGTH_SHORT).show();
                            }else{
                                database.kayit(kullaniciAdi,email,sifre);
                                Toast.makeText(KayitActivity.this, "Başarıyla Kayıt Oldunuz", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(KayitActivity.this,LoginActivity.class));
                            }
                        }else{
                            Toast.makeText(KayitActivity.this, "Şifre Karakter Sayısı 6-15 Olmalıdır", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(KayitActivity.this, "Şifreler Aynı Olmalı", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(KayitActivity.this, "Tüm Bilgilerin Dolu Olduğundan Emin Olunuz!!", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}