package com.linked_sys.yourtune.Activities.MainScreenNews;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.linked_sys.yourtune.R;

public class MainActivity extends AppCompatActivity implements MainNewsContract.MainNewsView {


    AutoCompleteTextView autoCompleteTextView;
    ImageView searchicon;
    private RecyclerView newsRv;
    MainNewsContract.MainNewsPresenter mainNewsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView = findViewById(R.id.autocomplete_tv);
        searchicon = findViewById(R.id.search_ic);
        newsRv = findViewById(R.id.trending_songs_rv);
        newsRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mainNewsPresenter = new MainNewsPresenter(this);
        mainNewsPresenter.loadNews();
//        searchicon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                autoCompleteTextView.setVisibility(View.VISIBLE);
//
//            }
//        });

    }


    @Override
    public Context getContext() {
        return MainActivity.this;
    }

    @Override
    public void setAdapter(MainNewsAdapter newsAdapter) {
        newsRv.setAdapter(newsAdapter);
    }
}
