package com.example.mynews.retrofit;

import com.example.mynews.model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

import java.util.ArrayList;

public interface APIInterface {

    @GET("everything")
    Observable<News> getNews(@Query("q") String sources, @Query("apiKey") String apiKey, @Query("page") Integer Page);

    /*@GET("everything?q=android&apiKey=4f7e4d1de39c438aac2a98fb1b3f5c97&page=1")
    Observable<News> getNews();*/
}
