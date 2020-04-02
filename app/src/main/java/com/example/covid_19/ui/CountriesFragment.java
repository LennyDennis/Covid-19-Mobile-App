package com.example.covid_19.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;
import com.example.covid_19.adapters.CountriesRecyclerViewAdapter;
import com.example.covid_19.models.covidAPI.CovidCountriesStats;
import com.example.covid_19.network.covidAPINetwork.NovelCovid19Api;
import com.example.covid_19.network.covidAPINetwork.NovelCovidRetrofitInstance;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountriesFragment extends Fragment {

    private static final String TAG = "CountriesFragment";

    @BindView(R.id.countries_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.countries_error)
    TextView textView;
    RecyclerView.LayoutManager layoutManager;

    private List<CovidCountriesStats> countriesStatsList;

    public CountriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries, container, false);
        ButterKnife.bind(this, view);

        NovelCovid19Api covid19Api = NovelCovidRetrofitInstance.getNovelCovidRetrofitInstance();

        Call<List<CovidCountriesStats>> call = covid19Api.getAllCountriesCovidStats();

        call.enqueue(new Callback<List<CovidCountriesStats>>() {
            @Override
            public void onResponse(Call<List<CovidCountriesStats>> call, Response<List<CovidCountriesStats>> response) {
                if (response.isSuccessful()) {
                    countriesStatsList = response.body();
                    CountriesRecyclerViewAdapter countriesAdapter = new CountriesRecyclerViewAdapter(getContext(), countriesStatsList);
                    recyclerView.setAdapter(countriesAdapter);
                    layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    showCountries();
                } else {
                    Log.d(TAG, "onResponse: call response unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<List<CovidCountriesStats>> call, Throwable t) {
                Log.d(TAG, "onFailure: call failed");
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void showCountries() {
        recyclerView.setVisibility(View.VISIBLE);
    }
}
