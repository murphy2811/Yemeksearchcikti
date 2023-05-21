package com.example.yemeksiparisokulprojesi;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.yemeksiparisokulprojesi.Database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // getting theviews

        TextView foodName, yesSecenek1, yesSecenek2, price, quantity;


        foodName = view.findViewById(R.id.foodNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        yesSecenek1 = view.findViewById(R.id.Secenek1);
        yesSecenek2 = view.findViewById(R.id.Secenek2);
        quantity = view.findViewById(R.id.quantityinOrderSummary);

        // getting the values by first getting the position of their columns

        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofdrink = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityoffood = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int secenek1 = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SECENEK1);
        int secenek2 = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SECENEK2);


        String nameofdrink = cursor.getString(name);
        String pricesofdrink = cursor.getString(priceofdrink);
        String quantitysoffood = cursor.getString(quantityoffood);
        String yessSecenek1 = cursor.getString(secenek1);
        String yessSecenek2 = cursor.getString(secenek2);



        foodName.setText(nameofdrink);
        price.setText(pricesofdrink);
        yesSecenek1.setText(yessSecenek1);
        yesSecenek2.setText(yessSecenek2);
        quantity.setText(quantitysoffood);





    }
}
