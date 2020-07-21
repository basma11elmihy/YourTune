package com.linked_sys.yourtune.Activities.MainScreenNews;

import android.content.Context;

public interface MainNewsContract {

    interface MainNewsPresenter{
        void loadNews();
    }

    interface MainNewsView{
        Context getContext();


        void setAdapter(MainNewsAdapter newsAdapter);


    }
}
