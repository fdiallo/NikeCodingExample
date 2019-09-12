package com.example.nikecodingexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nikecodingexample.datasource.NikeRepository;
import com.example.nikecodingexample.model.Definition;
import com.example.nikecodingexample.model.NikeResponse;

public class NikeViewModel extends ViewModel {

    private MutableLiveData<NikeResponse> mutableLiveData;
    private NikeRepository newsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NikeRepository.getInstance();
        mutableLiveData = newsRepository.getDefintions("what", "174aaa5e70msha98004aff36d184p1ce1dejsn3a22afeded50");

    }

    public LiveData<NikeResponse> getNikeDefinitionsRepository() {
        return mutableLiveData;
    }

}
