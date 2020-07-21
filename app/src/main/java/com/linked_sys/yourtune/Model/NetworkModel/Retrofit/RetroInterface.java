package com.linked_sys.yourtune.Model.NetworkModel.Retrofit;
import com.linked_sys.yourtune.Model.DataModel.TopHeadline.TopHeadlinesMain;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroInterface {

    @GET("top-headlines?country=us&apiKey=094b5fccf1b2415780ff7c6bf432b25b")
    Call<TopHeadlinesMain> getMainNews();
}
