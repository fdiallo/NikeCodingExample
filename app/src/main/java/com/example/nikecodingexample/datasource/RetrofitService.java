package com.example.nikecodingexample.datasource;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static String BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com/";

    /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
*/

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
           // .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
