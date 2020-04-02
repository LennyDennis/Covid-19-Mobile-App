package com.example.covid_19.network.newsAPINetwork;

import com.example.covid_19.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRetrofitInstance {

    private static Retrofit retrofit = null;

    public static NewsAPI getNewsAPIRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.NEWS_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(NewsAPI.class);
    }

}
