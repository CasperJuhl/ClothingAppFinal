package com.example.clothingapp.Model;

public class Model {

    private static Model instance;
    public static Model getInstance(){
        if(instance == null)
            instance = new Model();

        return instance;
    }

    public boolean login(String username, String password) {
        boolean loginOK = false;
        if(username.equals("casper") && password.equals("casper"))
        {
            loginOK = true;
        }
        return  loginOK;
    }
}
