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
import com.example.covid_19.models.newsAPI.Article;

import java.util.List;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder> {

    private List<Article> newsHeadlines;
    private Context context;

    public NewsRecyclerViewAdapter(List<Article> newsHeadlines, Context context) {
        this.newsHeadlines = newsHeadlines;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_view, parent, false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        Glide.with(context).asBitmap().load(newsHeadlines.get(position).getUrl()).into(holder.newsImage);
        holder.newsTitle.setText(newsHeadlines.get(position).getTitle());
        holder.newsDescription.setText(newsHeadlines.get(position).getDescription());
        String newsSource = String.valueOf(newsHeadlines.get(position).getSource());
        holder.newsSource.setText(newsSource);
        holder.newsTime.setText(newsHeadlines.get(position).getPublishedAt());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        ImageView newsImage;
        TextView newsTitle;
        TextView newsDescription;
        TextView newsSource;
        TextView newsTime;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            newsImage = itemView.findViewById(R.id.news_image);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDescription = itemView.findViewById(R.id.news_description);
            newsSource = itemView.findViewById(R.id.news_source);
            newsTime = itemView.findViewById(R.id.news_time);
        }

    }
}
