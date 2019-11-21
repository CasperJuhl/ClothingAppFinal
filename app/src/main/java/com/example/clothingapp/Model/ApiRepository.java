package com.example.clothingapp.Model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository {

    private static ApiRepository instance;
    private MutableLiveData<Parameters> params;

    private ApiRepository() {
        params = new MutableLiveData<>();
    }

    public static synchronized ApiRepository getInstance() {
        if (instance == null) {
            instance = new ApiRepository();
        }
        return instance;
    }

    public LiveData<Parameters> getParams() {
        return params;
    }

    public void updateView() {
        Api api = ServiceGenerator.getApi();
        Call<ApiResponse> call = api.getPokemon();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.code() == 200) {
                    params.setValue(response.body().getParam());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
