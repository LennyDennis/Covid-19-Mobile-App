package com.example.covid_19.network.covidAPINetwork;

import com.example.covid_19.models.covidAPI.CovidCountriesStats;
import com.example.covid_19.models.covidAPI.TotalCovidStats;

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
