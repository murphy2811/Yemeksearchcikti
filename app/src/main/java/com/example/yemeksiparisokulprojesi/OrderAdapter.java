package com.example.yemeksiparisokulprojesi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity2;
import com.example.yemeksiparisokulprojesi.sepeteekle.InfoActivity3;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Model> modelList;
    Context context;

    public OrderAdapter(Context context, List<Model> modelList) {
                this.context = context;
                this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        // here we will find the position and start setting the output on our views

        String nameofFood = modelList.get(position).getmFoodName();
        String descriptionoffood = modelList.get(position).getmFoodDetail();
        int images = modelList.get(position).getmFoodPhoto();

        holder.mFoodName.setText(nameofFood);
        holder.mFoodDescription.setText(descriptionoffood);
        holder.imageView.setImageResource(images);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    // in order to make our views responsive we can implement onclicklistener on our recyclerview

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // here we will find the views on which we will inflate our data

        TextView mFoodName, mFoodDescription;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mFoodName = itemView.findViewById(R.id.foodName);
            mFoodDescription = itemView.findViewById(R.id.descriptioninfo);
            imageView = itemView.findViewById(R.id.imageViewInfo);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            // lets get the position of the view in list and then work on it

            int position = getAdapterPosition();

            if (position == 0) {
                Intent intent = new Intent(context, InfoActivity.class);
                context.startActivity(intent);
            }
            if (position == 1) {
                Intent intent2 = new Intent(context, InfoActivity2.class);
                context.startActivity(intent2);
            }
            if (position == 2) {
                Intent intent3 = new Intent(context, InfoActivity3.class);
                context.startActivity(intent3);
            }

        }
    }
}
