package com.example.mephi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsPaperAdapter extends RecyclerView.Adapter<NewsPaperAdapter.ViewHolder> {
    Context context;
    ArrayList<Article> newsArrayList;

    public NewsPaperAdapter(Context context, ArrayList<Article> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.article, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = newsArrayList.get(position);
        holder.heading.setText(article.heading);
        holder.imageArticle.setImageResource(article.imageID);
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView heading;
        ImageView imageArticle;

        public ViewHolder(View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            imageArticle = itemView.findViewById(R.id.imageArticle);
        }
    }
}
