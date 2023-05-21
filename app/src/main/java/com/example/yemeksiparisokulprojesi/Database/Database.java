package com.example.yemeksiparisokulprojesi.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FoodApp";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String qry1="create table users(kullaniciAdi VARCHAR PRIMARY KEY,email text , sifre text)";
        sqLiteDatabase.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void kayit(String kullaniciAdi,String email,String sifre)
    {

        ContentValues cv= new ContentValues();
        cv.put("kullaniciAdi",kullaniciAdi);
        cv.put("email",email);
        cv.put("sifre",sifre);

        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();

    }

    public int giris(String kullaniciAdi,String sifre)
    {
        int sonuc=0;
        String str[]=new String[2];
        str[0]=kullaniciAdi;
        str[1]=sifre;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where kullaniciAdi = ? and sifre = ?",str);
        if(c.moveToFirst())
        {
            sonuc=1;
        }
        return sonuc;

    }

}
