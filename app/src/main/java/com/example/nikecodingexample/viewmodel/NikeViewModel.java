package com.example.nikecodingexample.viewmodel;

import android.widget.Filter;
import android.widget.Filterable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.nikecodingexample.datasource.NikeRepository;
import com.example.nikecodingexample.model.Definition;
import com.example.nikecodingexample.model.NikeResponse;

import java.util.ArrayList;
import java.util.List;

public class NikeViewModel extends ViewModel  implements Filterable {

    private LiveData<NikeResponse> liveData;
    private NikeRepository newsRepository;
    ArrayList<Definition> definitionsList;
    private List<Definition> definitionsListFiltered;

    public void init(){
        if (liveData != null){
            return;
        }
        newsRepository = NikeRepository.getInstance();
        liveData = newsRepository.getDefintions("what", "174aaa5e70msha98004aff36d184p1ce1dejsn3a22afeded50");

    }

    public LiveData<NikeResponse> getNikeDefinitionsRepository() {
        return liveData;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    definitionsListFiltered = definitionsList;
                } else {
                    List<Definition> filteredList = new ArrayList<>();
                    for (Definition definition : definitionsList) {
                        if (definition.getDefinition().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(definition);
                        }
                    }
                    definitionsListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = definitionsListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                definitionsListFiltered = (ArrayList<Definition>) filterResults.values;
            }
        };
    }

}
