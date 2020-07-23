package com.thoughtworks.recyclerviewpractice;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public abstract class MyViewHolder extends RecyclerView.ViewHolder {
    public MyViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(Data data, Context context);

    public static class ListItemViewHolder extends MyViewHolder {

        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final TextView numberTextView;
        private final ImageView imageView;


        public ListItemViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            descriptionTextView = itemView.findViewById(R.id.description);
            numberTextView = itemView.findViewById(R.id.number);
            imageView = itemView.findViewById(R.id.item_image);
        }

        @Override
        public void setData(Data data, Context context) {
            titleTextView.setText(data.title);
            descriptionTextView.setText(data.description);
            numberTextView.setText(String.valueOf(data.number));
            Glide.with((Activity) context)
                    .load(data.imageUrl)
                    .into(imageView);
        }
    }

    public static class ListHeaderViewHolder extends MyViewHolder {
        private final TextView titleTextView;
        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
        }

        @Override
        public void setData(Data data, Context context) {
            titleTextView.setText(data.title);
        }
    }
}
