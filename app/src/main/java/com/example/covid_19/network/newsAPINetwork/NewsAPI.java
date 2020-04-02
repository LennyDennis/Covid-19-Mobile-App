package com.example.covid_19.network.newsAPINetwork;

import com.example.covid_19.models.newsAPI.NewsHeadlinesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsAPI {

    @GET("everything?q=COVID&from=2020-03-16&apiKey=847afbc2227e4249b52570b1f8cbbae6&pageSize=30&page=1")
    Call<NewsHeadlinesResponse> getHeadlines();

}
