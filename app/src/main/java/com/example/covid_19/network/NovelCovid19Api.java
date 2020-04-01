package com.example.covid_19.network;

import com.example.covid_19.models.CovidCountriesStats;
import com.example.covid_19.models.TotalCovidStats;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NovelCovid19Api {

    @GET("all")
    Call<TotalCovidStats> getTotalCovidStats();

    @GET("countries?sort=cases")
    Call<List<CovidCountriesStats>> getAllCountriesCovidStats();

    @GET("countries/{country}")
    Call<CovidCountriesStats> getEachCountryCovidStats(@Path("country") String country);
}
