package com.example.covid_19.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.covid_19.R;
import com.example.covid_19.network.NovelCovid19Api;
import com.example.covid_19.network.NovelCovidRetrofitInstance;
import com.example.covid_19.network.TotalCovidStats;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    TotalCovidStats totalCovidStats;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        NovelCovid19Api retrofitInstance = NovelCovidRetrofitInstance.getNovelCovidRetrofitInstance();

        Call<TotalCovidStats> call = retrofitInstance.getTotalCovidStats();

        call.enqueue(new Callback<TotalCovidStats>() {
            @Override
            public void onResponse(Call<TotalCovidStats> call, Response<TotalCovidStats> response) {
                if (response.isSuccessful()) {
                    totalCovidStats = response.body();
                }
            }

            @Override
            public void onFailure(Call<TotalCovidStats> call, Throwable t) {
                Log.d(TAG, "onFailure: The total covid stats request failed");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
