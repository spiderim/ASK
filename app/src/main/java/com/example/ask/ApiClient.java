package com.example.ask;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {
    private static final String BASE_URl="https://newsapi.org/v2/";
    private static Retrofit retrofit=null;
    static Retrofit getClient()
    {
        if(retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(BASE_URl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return  retrofit;
    }
}