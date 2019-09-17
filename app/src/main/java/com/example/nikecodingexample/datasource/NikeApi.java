package com.example.nikecodingexample.datasource;

import com.example.nikecodingexample.model.NikeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NikeApi {

    @GET("define")
    Call<NikeResponse> getNikeListDefinitions(@Query("term") String term, @Query("X-RapidAPI-Key") String key);

}