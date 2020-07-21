package com.linked_sys.yourtune.Model.NetworkModel.Retrofit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


import com.linked_sys.yourtune.Model.DataModel.TopHeadline.TopHeadlinesMain;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroApiCalling {

    private RetroSingleton apiClient;
    private RetroInterface apiInterface;
    private Context context;

    public RetroApiCalling (Context context)
    {
        this.context = context;
        apiClient = new RetroSingleton();
        apiInterface = apiClient.getClient();
    }

    public void getMainNews(final GeneralListener registerListener )
    {
        Call<TopHeadlinesMain> call = apiInterface.getMainNews();
//
        call.enqueue(new Callback<TopHeadlinesMain>() {
            @Override
            public void onResponse(Call<TopHeadlinesMain> call, Response<TopHeadlinesMain> response)
            {
                Log.e("onResponse", response.raw().toString());
                if (response.body() != null) {
                    registerListener.getApiResponse(0,
                            null, response.body());
                }


              else {
                        Toast.makeText(context, " Unknown Error " , Toast.LENGTH_SHORT).show();
                    }



            }
            @Override
            public void onFailure(Call<TopHeadlinesMain> call, Throwable t)
            {
                Log.e("onResponse" ,call.request().toString());
                //fail internet connection
                if (t instanceof IOException)
                {
                    Log.e("ApiCheck**" , "no internet connection");
                    registerListener.getApiResponse(1 ,
                            t.getMessage() , null);
                }
                //fail conversion issue
                else {
                    registerListener.getApiResponse(1 ,
                            t.getMessage() , null);
                }
            }
        });

    }

}
