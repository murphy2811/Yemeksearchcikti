package com.example.yemeksiparisokulprojesi.sepeteekle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yemeksiparisokulprojesi.Database.OrderContract;
import com.example.yemeksiparisokulprojesi.R;
import com.example.yemeksiparisokulprojesi.SummaryActivity;
import com.example.yemeksiparisokulprojesi.UserAuthSign;

public class InfoActivity12 extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, foodName, foodPrice,foodDescription;
    CheckBox secenek1, secenek2;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        foodDescription=findViewById(R.id.foodText);
        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity  = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        foodName = findViewById(R.id.foodName);
        foodPrice = findViewById(R.id.foodPrice);
        secenek1 = findViewById(R.id.secenekk1);
        addtoCart = findViewById(R.id.addtocart);
        secenek2 = findViewById(R.id.secenekk2);



        foodName.setText("Et Döner");
        foodPrice.setText("0");
        imageView.setImageResource(R.drawable.img_24);
        foodDescription.setText("Et Döner,Soğan,Domates,Patates Kızartması");

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity == 0){
                    Toast.makeText(InfoActivity12.this, "Adet 0 dan Fazla Olmalı", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(InfoActivity12.this, SummaryActivity.class);
                    startActivity(intent);
                    SaveCart();
                }

            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = 80;
                quantity++;
                displayQuantity();
                int fooddPrice = basePrice * quantity;
                String setnewPrice = String.valueOf(fooddPrice);
                foodPrice.setText(setnewPrice);


                // checkBoxes functionality

                int ifCheckBox = CalculatePrice(secenek1, secenek2);
                foodPrice.setText(ifCheckBox+ " TL ");

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 80;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(InfoActivity12.this, "Adet 0 dan Fazla Olmalı", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int fooddPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(fooddPrice);
                    foodPrice.setText(setnewPrice);


                    // checkBoxes functionality

                    int ifCheckBox = CalculatePrice(secenek1, secenek2);
                    foodPrice.setText(ifCheckBox+ " TL ");
                }
            }
        });



    }

    private boolean SaveCart() {
        UserAuthSign userAuthSign=UserAuthSign.getInstance();
        // getting the values from our views
        String name = foodName.getText().toString();
        String price = foodPrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);
        System.out.println(userAuthSign.getAuthUserName());
        if (secenek1.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_SECENEK1, secenek1.getText().toString() + " : Evet " );
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_SECENEK1, secenek1.getText().toString() + " : Hayır");
        }

        if (secenek2.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_SECENEK2, secenek2.getText().toString() + " : Evet ");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_SECENEK2, secenek2.getText().toString() + " : Hayır ");
        }
        values.put(OrderContract.OrderEntry.kullaniciAdi,userAuthSign.getAuthUserName());

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Sepete Eklenemedi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sepete Eklendi", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private int CalculatePrice(CheckBox secenek1, CheckBox secenek2) {

        int basePrice = 80;

        if (secenek1.isChecked()) {
            //ekleme 1
            basePrice = basePrice + 10;
        }

        if (secenek2.isChecked()) {
            // ekleme 2
            basePrice = basePrice + 15;
        }

        return basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_SECENEK1,
                OrderContract.OrderEntry.COLUMN_SECENEK2
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int secenekk1 = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SECENEK1);
            int secenekk2 = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SECENEK1);


            String nameofdrink = cursor.getString(name);
            String priceofdrink = cursor.getString(price);
            String quantityofdrink = cursor.getString(quantity);
            String yesSecenek1 = cursor.getString(secenekk1);
            String yesSecenek2 = cursor.getString(secenekk2);

            foodName.setText(nameofdrink);
            foodPrice.setText(priceofdrink);
            quantitynumber.setText(quantityofdrink);
            secenek1.setText(yesSecenek1);
            secenek2.setText(yesSecenek2);
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {


        foodName.setText("");
        foodPrice.setText("");
        quantitynumber.setText("");

    }
}