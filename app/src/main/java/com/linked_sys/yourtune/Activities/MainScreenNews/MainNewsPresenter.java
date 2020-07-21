package com.linked_sys.yourtune.Activities.MainScreenNews;

import android.content.Context;

import com.linked_sys.yourtune.Model.DataModel.TopHeadline.Article;
import com.linked_sys.yourtune.Model.DataModel.TopHeadline.TopHeadlinesMain;
import com.linked_sys.yourtune.Model.NetworkModel.Retrofit.GeneralListener;
import com.linked_sys.yourtune.Model.NetworkModel.Retrofit.RetroApiCalling;

import java.util.ArrayList;

public class MainNewsPresenter implements MainNewsContract.MainNewsPresenter, GeneralListener {

    RetroApiCalling apiCalling;

    MainNewsContract.MainNewsView view;

    Context context;

    ArrayList<Article> listofarticles;


    public MainNewsPresenter(MainNewsContract.MainNewsView view) {
        this.view = view;
        this.context = view.getContext();
    }

    @Override
    public void loadNews() {
        apiCalling = new RetroApiCalling(context);
        apiCalling.getMainNews(this);

    }

    @Override
    public void getApiResponse(int status, String message, Object tApiResponse) {
        TopHeadlinesMain topHeadlinesMain = (TopHeadlinesMain) tApiResponse;

        listofarticles = (ArrayList<Article>) topHeadlinesMain.getArticles();

        MainNewsAdapter newsAdapter = new MainNewsAdapter(context,listofarticles);

        view.setAdapter(newsAdapter);
    }
}
