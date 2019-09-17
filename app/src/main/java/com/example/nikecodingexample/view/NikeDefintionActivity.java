package com.example.nikecodingexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.nikecodingexample.R;
import com.example.nikecodingexample.adapter.NikeAdapter;
import com.example.nikecodingexample.model.Definition;
import com.example.nikecodingexample.model.NikeResponse;
import com.example.nikecodingexample.viewmodel.NikeViewModel;

import java.util.ArrayList;
import java.util.List;

public class NikeDefintionActivity extends AppCompatActivity {

    ArrayList<Definition> definitionsArrayList = new ArrayList<>();
    NikeAdapter nikeAdapter;
    RecyclerView rvNikeDefinitions;
    NikeViewModel nikeViewModel;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nike_defintion);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String term = extras.getString("term");
        }

        rvNikeDefinitions = findViewById(R.id.rvNikeDefinitions);

        nikeViewModel = ViewModelProviders.of(this).get(NikeViewModel.class);
        nikeViewModel.init();

        nikeViewModel.init();
        nikeViewModel.getNikeDefinitionsRepository().observe(this, new Observer<NikeResponse>() {
            @Override
            public void onChanged(NikeResponse newsResponse) {
                List<Definition> nikeDefinitions = newsResponse.getDefinitions();
                definitionsArrayList.addAll(nikeDefinitions);
                nikeAdapter.notifyDataSetChanged();
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        if (nikeAdapter == null) {
            nikeAdapter = new NikeAdapter(NikeDefintionActivity.this, definitionsArrayList);
            rvNikeDefinitions.setLayoutManager(new LinearLayoutManager(this));
            rvNikeDefinitions.setAdapter(nikeAdapter);
            rvNikeDefinitions.setItemAnimator(new DefaultItemAnimator());
            rvNikeDefinitions.setNestedScrollingEnabled(true);
        } else {
            nikeAdapter.notifyDataSetChanged();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                nikeViewModel.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                nikeViewModel.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }


}
