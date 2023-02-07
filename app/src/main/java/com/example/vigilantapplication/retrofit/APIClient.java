package com.example.vigilantapplication.retrofit;

import com.example.vigilantapplication.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.user_login_base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}



