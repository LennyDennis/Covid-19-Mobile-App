package com.example.covid_19.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NovelCovid19Api {

    @GET("all")
    Call<TotalCovidStats> getTotalCovidStats();

    @GET("countries?sort=cases")
    Call<CovidCountriesStats> getAllCountriesCovidStats();

    @GET("countries/{country}")
    Call<CovidCountriesStats> getEachCountryCovidStats(@Path("country") String country);
}
