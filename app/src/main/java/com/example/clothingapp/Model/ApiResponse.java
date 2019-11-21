package com.example.clothingapp.Model;

public class ApiResponse {
    private String quote;

    public Parameters getParam(){
        return new Parameters(quote);
    }
}
