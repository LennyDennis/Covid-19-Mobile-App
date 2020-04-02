package com.example.covid_19.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covid_19.R;
import com.example.covid_19.models.CovidCountriesStats;

import java.util.List;

public class CountriesRecyclerViewAdapter extends RecyclerView.Adapter<CountriesRecyclerViewAdapter.CountryViewHolder> {

    private List<CovidCountriesStats> countriesStatsList;
    private Context context;

    public CountriesRecyclerViewAdapter(Context context, List<CovidCountriesStats> countriesStatsList) {
        this.countriesStatsList = countriesStatsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_view, parent, false);
        CountryViewHolder countryViewHolder = new CountryViewHolder(view);
        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(countriesStatsList.get(position).getCountryInfo().getFlag())
                .into(holder.countryFlag);
        holder.countryName.setText(countriesStatsList.get(position).getCountry());
        String cases = Integer.toString(countriesStatsList.get(position).getCases());
        holder.countryTotalCases.setText("Cases\n" + cases);
        String deaths = Integer.toString(countriesStatsList.get(position).getDeaths());
        holder.countryTotalDeaths.setText("Deaths\n" + deaths);
        String recovered = Integer.toString(countriesStatsList.get(position).getRecovered());
        holder.countryTotalRecoveries.setText("Recovered\n" + recovered);
        String todayCases = Integer.toString(countriesStatsList.get(position).getTodayCases());
        holder.countryTodayCases.setText("Today's Cases\n" + todayCases);
        String todayDeaths = Integer.toString(countriesStatsList.get(position).getTodayDeaths());
        holder.countryTodayDeaths.setText("Today's Deaths\n" + todayDeaths);
    }

    @Override
    public int getItemCount() {
        return countriesStatsList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        ImageView countryFlag;
        TextView countryName;
        TextView countryTotalCases;
        TextView countryTotalDeaths;
        TextView countryTotalRecoveries;
        TextView countryTodayCases;
        TextView countryTodayDeaths;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            countryFlag = itemView.findViewById(R.id.country_flag);
            countryName = itemView.findViewById(R.id.country_name);
            countryTotalCases = itemView.findViewById(R.id.country_cases);
            countryTotalDeaths = itemView.findViewById(R.id.country_deaths);
            countryTotalRecoveries = itemView.findViewById(R.id.country_recoveries);
            countryTodayCases = itemView.findViewById(R.id.today_cases);
            countryTodayDeaths = itemView.findViewById(R.id.today_death);
        }
    }
}
