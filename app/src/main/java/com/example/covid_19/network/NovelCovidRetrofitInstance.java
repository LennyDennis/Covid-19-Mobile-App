package com.example.covid_19.network;

import com.example.covid_19.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NovelCovidRetrofitInstance {

    private static Retrofit retrofit = null;

    public static NovelCovid19Api getNovelCovidRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.COVID19_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(NovelCovid19Api.class);

    }
}
