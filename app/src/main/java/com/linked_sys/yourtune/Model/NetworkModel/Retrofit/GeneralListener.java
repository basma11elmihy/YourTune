package com.linked_sys.yourtune.Model.NetworkModel.Retrofit;

public interface GeneralListener<T> {
    void getApiResponse(int status, String message,
                        T tApiResponse);
}
