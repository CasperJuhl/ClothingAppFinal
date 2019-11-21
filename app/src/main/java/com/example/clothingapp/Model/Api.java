package com.example.clothingapp.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET(".rest/")
    Call<ApiResponse> getPokemon();
}