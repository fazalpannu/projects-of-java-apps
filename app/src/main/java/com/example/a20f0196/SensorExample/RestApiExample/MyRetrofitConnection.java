package com.example.a20f0196.SensorExample.RestApiExample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitConnection {
    public  static Retrofit retrofit=null ;
    public  static String url="https://jsonplaceholder.typicode.com/";
    public static Retrofit getMyRetrofit()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
