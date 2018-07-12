package com.example.recycleview;

import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView featureImage;
    public TextView title;
    public TextView description;
    public AppCompatButton btnLink;

    public ViewHolder(View itemView) {
        super(itemView);
        this.featureImage = itemView.findViewById(R.id.featuredImage);
        this.title = itemView.findViewById(R.id.title);
        this.description = itemView.findViewById(R.id.subtitle);
        this.btnLink = itemView.findViewById(R.id.btnLink);
    }
}
