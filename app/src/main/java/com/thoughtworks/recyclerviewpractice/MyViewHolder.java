package com.thoughtworks.recyclerviewpractice;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class MyViewHolder extends RecyclerView.ViewHolder {
    public MyViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(Data data);
}
