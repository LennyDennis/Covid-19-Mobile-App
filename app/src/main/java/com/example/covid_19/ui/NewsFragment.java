package com.example.covid_19.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.R;
import com.example.covid_19.adapters.NewsRecyclerViewAdapter;
import com.example.covid_19.models.newsAPI.Article;
import com.example.covid_19.models.newsAPI.NewsHeadlinesResponse;
import com.example.covid_19.network.newsAPINetwork.NewsAPI;
import com.example.covid_19.network.newsAPINetwork.NewsRetrofitInstance;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private static final String TAG = "NewsFragment";

    @BindView(R.id.news_recyclerview)
    RecyclerView newsRecyclerView;
    RecyclerView.LayoutManager layoutManager;

    private List<Article> newsHeadlines;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);

        NewsAPI newsAPI = NewsRetrofitInstance.getNewsAPIRetrofitInstance();

        Call<NewsHeadlinesResponse> call = newsAPI.getHeadlines();

        call.enqueue(new Callback<NewsHeadlinesResponse>() {
            @Override
            public void onResponse(Call<NewsHeadlinesResponse> call, Response<NewsHeadlinesResponse> response) {
                if (response.isSuccessful()) {
                    newsHeadlines = response.body().getArticles();
                    NewsRecyclerViewAdapter newsAdapter = new NewsRecyclerViewAdapter(newsHeadlines, getContext());
                    newsRecyclerView.setAdapter(newsAdapter);
                    layoutManager = new LinearLayoutManager(getContext());
                    newsRecyclerView.setLayoutManager(layoutManager);
                } else {
                    Log.d(TAG, "onResponse: response not successfull");
                }
            }

            @Override
            public void onFailure(Call<NewsHeadlinesResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: reponse failed");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
