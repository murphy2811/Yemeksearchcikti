package com.example.yemeksiparisokulprojesi;

public class UserAuthSign {

    private String authUserName;

    private static UserAuthSign userAuthSign;

    private UserAuthSign() {
    }

    public String getAuthUserName() {
        return authUserName;
    }

    public void setAuthUserName(String authUserName) {
        this.authUserName = authUserName;
    }
    public static UserAuthSign getInstance(){
        if(userAuthSign==null){
            userAuthSign=new UserAuthSign();
        }
        return userAuthSign;
    }
}
