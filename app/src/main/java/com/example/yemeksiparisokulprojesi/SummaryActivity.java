package com.example.yemeksiparisokulprojesi;

import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yemeksiparisokulprojesi.Database.OrderContract;
import com.example.yemeksiparisokulprojesi.Database.OrderContract;

public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    Button odeme,devamA;
    TextView toplamFiyatt;
    private String kullaniciAdi;
    public CartAdapter mAdapter;
    public static final int LOADER = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        UserAuthSign userAuthSign =UserAuthSign.getInstance();
        odeme=findViewById(R.id.siparis);
        devamA=findViewById(R.id.devamAliveris);
        toplamFiyatt=findViewById(R.id.toplamFiyat);
        devamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SummaryActivity.this,YiyecekCesitleriActivity.class));
            }
        });
        kullaniciAdi=UserAuthSign.getInstance().getAuthUserName();


        Button clearthedata = findViewById(R.id.clearthedatabase);

        clearthedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, OrderContract.OrderEntry.kullaniciAdi + "=?", new String[]{kullaniciAdi});            }
        });

        getLoaderManager().initLoader(LOADER, null, this);

        ListView listView = findViewById(R.id.list);
        mAdapter = new CartAdapter(this, null);
        listView.setAdapter(mAdapter);

    odeme.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SummaryActivity.this,kartadres.class);
            intent.putExtra("Toplam",toplamFiyatt.getText().toString());
            startActivity(intent);
        }
    });

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_SECENEK1,
                OrderContract.OrderEntry.COLUMN_SECENEK2,
        };
        kullaniciAdi=UserAuthSign.getInstance().getAuthUserName();
        String selection = OrderContract.OrderEntry.kullaniciAdi + "=?";
        String[] selectionArgs = {kullaniciAdi};

        return new CursorLoader(this, OrderContract.OrderEntry.CONTENT_URI,
                projection,
                selection,
                selectionArgs,
                null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
        int total = calculateTotalPrice(data);
        toplamFiyatt.setText(String.format("%d TL", total));
    }
    private int calculateTotalPrice(Cursor data) {
        int total = 0;
        if (data != null && data.moveToFirst()) {
            int priceColumnIndex = data.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            do {
                int price = data.getInt(priceColumnIndex);
                total += price;
            } while (data.moveToNext());
        }
        return total;
    }
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mAdapter.swapCursor(null);
    }
}