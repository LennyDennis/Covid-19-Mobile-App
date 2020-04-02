package com.example.covid_19.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.covid_19.R;
import com.example.covid_19.models.covidAPI.TotalCovidStats;
import com.example.covid_19.network.covidAPINetwork.NovelCovid19Api;
import com.example.covid_19.network.covidAPINetwork.NovelCovidRetrofitInstance;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    @BindView(R.id.confirmed_deaths)
    TextView confirmedDeaths;
    @BindView(R.id.confirmed_recoveries)
    TextView confirmedRecoveries;
    @BindView(R.id.confirmed_cases)
    TextView confirmedCases;

    TotalCovidStats totalCovidStats;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        NovelCovid19Api retrofitInstance = NovelCovidRetrofitInstance.getNovelCovidRetrofitInstance();

        Call<TotalCovidStats> call = retrofitInstance.getTotalCovidStats();

        call.enqueue(new Callback<TotalCovidStats>() {
            @Override
            public void onResponse(Call<TotalCovidStats> call, Response<TotalCovidStats> response) {
                if (response.isSuccessful()) {
                    totalCovidStats = response.body();
                    String totalDeaths = Integer.toString(totalCovidStats.getDeaths());
                    confirmedDeaths.setText(totalDeaths);
                    String totalCases = Integer.toString(totalCovidStats.getCases());
                    confirmedCases.setText(totalCases);
                    String totalRecoveries = Integer.toString(totalCovidStats.getRecovered());
                    confirmedRecoveries.setText(totalRecoveries);

                } else {
                    Log.d(TAG, "onResponse: the call wasn't successful");
                }
            }

            @Override
            public void onFailure(Call<TotalCovidStats> call, Throwable t) {
                Log.d(TAG, "onFailure: ", t);
            }
        });

        return view;
    }
}
