package com.linked_sys.yourtune.Model.NetworkModel.Retrofit;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroSingleton {

    private static RetroSingleton instance = null;
    private RetroInterface client;

    public static RetroSingleton getInstance() {
        if (instance == null) {
            instance = new RetroSingleton();
        }

        return instance;
    }
    // Build retrofit once when creating a single instance
    public RetroSingleton() {
        // Implement a method to build your retrofit
        buildRetrofit();
    }

    private void buildRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl("https://newsapi.org/v2/")

                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder.client(httpClient.build())
                        .build();
        this.client = retrofit.create(RetroInterface.class);
    }
    public RetroInterface getClient(){
        return this.client;
    }
}
