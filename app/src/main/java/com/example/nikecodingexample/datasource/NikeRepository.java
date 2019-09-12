package com.example.nikecodingexample.datasource;

import androidx.lifecycle.MutableLiveData;

import com.example.nikecodingexample.model.Definition;
import com.example.nikecodingexample.model.NikeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NikeRepository {


    private static NikeRepository newsRepository;

    public static NikeRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new NikeRepository();
        }
        return newsRepository;
    }

    private NikeApi nikeApi;

    public NikeRepository(){
        nikeApi = RetrofitService.createService(NikeApi.class);
    }

    public MutableLiveData<NikeResponse> getDefintions(String term, String key){
        final MutableLiveData<NikeResponse> nikeDefinitionsData = new MutableLiveData<>();
        nikeApi.getNikeListDefinitons(term, key).enqueue(new Callback<NikeResponse>() {
            @Override
            public void onResponse(Call<NikeResponse> call,
                                   Response<NikeResponse> response) {
                if (response.isSuccessful()){
                    nikeDefinitionsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<NikeResponse> call, Throwable t) {
                nikeDefinitionsData.setValue(null);
            }
        });
        return nikeDefinitionsData;
    }
}
