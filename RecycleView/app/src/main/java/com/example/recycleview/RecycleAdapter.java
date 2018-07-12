package com.example.recycleview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkmmte.pkrss.Article;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Article> list;

    public RecycleAdapter(List<Article> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Article article = list.get(position);

        holder.title.setText(article.getTitle());
        holder.description.setText(article.getAuthor());
        new DownloadImageTask(holder.featureImage).execute(article.getEnclosure().getUrl());

        holder.btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, article.getSource());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
