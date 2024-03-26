package com.example.f1api.web;


import com.example.f1api.model.CatResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatApiClient {
    @GET("breeds")
    Call<CatResponse> getCats();

    @GET("breeds")
    Call<CatResponse> getCatsPaged(@Query("page") int page);
}
