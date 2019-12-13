package com.wd.common.utils;



import com.wd.common.app.MyApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class HttpUtils666 {
    public static HttpUtils666 httpUtils = null;
    private final Retrofit retrofit;

    private HttpUtils666() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.PATHS)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static HttpUtils666 getHttpUtils() {
        if (httpUtils == null) {
            synchronized (HttpUtils666.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils666();
                }
            }
        }
        return httpUtils;
    }
}
