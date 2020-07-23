package com.thoughtworks.recyclerviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final List<Data> data;
    private final Context context;

    public MyAdapter(List<Data> data, Context context) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        Data dataItem = data.get(position);
        if (dataItem != null) {
            return dataItem.type;
        }
        return -1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Data.TYPE_ITEM:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item, parent, false);
                return new MyViewHolder.ListItemViewHolder(view);
            case Data.TYPE_TITLE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_header, parent, false);
                return new MyViewHolder.ListHeaderViewHolder(view);
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data dataItem = data.get(position);
        if (dataItem != null) {
            holder.setData(dataItem, context);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
