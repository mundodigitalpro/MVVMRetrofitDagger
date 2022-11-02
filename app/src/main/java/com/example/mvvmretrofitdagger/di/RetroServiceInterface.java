package com.example.mvvmretrofitdagger.di;

import com.example.mvvmretrofitdagger.model.RecyclerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {

    @GET("repositories")
    Call<RecyclerList> getDataFromAPI(@Query("q")String query);
}
