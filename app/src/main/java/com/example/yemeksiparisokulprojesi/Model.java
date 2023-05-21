package com.example.yemeksiparisokulprojesi;

public class Model {


    String mFoodName;
    String mFoodDetail;
    int mFoodPhoto;

    public Model(String mFoodName, String mFoodDetail, int mFoodPhoto) {
        this.mFoodName = mFoodName;
        this.mFoodDetail = mFoodDetail;
        this.mFoodPhoto = mFoodPhoto;
    }




    public String getmFoodName() {
        return mFoodName;
    }

    public String getmFoodDetail() {
        return mFoodDetail;
    }

    public int getmFoodPhoto() {
        return mFoodPhoto;
    }
}
