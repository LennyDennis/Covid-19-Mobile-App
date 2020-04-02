package com.example.covid_19.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covid_19.R;
import com.example.covid_19.models.newsAPI.Article;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        Glide.with(context).asBitmap().load(newsHeadlines.get(position).getUrlToImage()).into(holder.newsImage);
        holder.newsTitle.setText(newsHeadlines.get(position).getTitle());
        holder.newsDescription.setText(newsHeadlines.get(position).getDescription());
        String newsSource = String.valueOf(newsHeadlines.get(position).getSource().getName());
        holder.newsSource.setText(newsSource + " - ");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:SS'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        String publishDate = newsHeadlines.get(position).getPublishedAt();
        LocalDate date = LocalDate.parse(publishDate, inputFormatter);
        String formattedDate = outputFormatter.format(date);
        holder.newsTime.setText(formattedDate);


    }

    @Override
    public int getItemCount() {
        return newsHeadlines.size();
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
