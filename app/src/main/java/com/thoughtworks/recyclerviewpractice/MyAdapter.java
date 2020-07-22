package com.thoughtworks.recyclerviewpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private final List<Data> data;

    public MyAdapter(List<Data> data) {
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
                return new ListItemViewHolder(view);
            case Data.TYPE_TITLE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_header, parent, false);
                return new ListHeaderViewHolder(view);
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data dataItem = this.data.get(position);
        if (dataItem != null) {
            holder.setData(dataItem);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ListItemViewHolder extends MyViewHolder {

        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final TextView numberTextView;


        public ListItemViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            descriptionTextView = itemView.findViewById(R.id.description);
            numberTextView = itemView.findViewById(R.id.number);
        }

        @Override
        public void setData(Data data) {
            titleTextView.setText(data.title);
            descriptionTextView.setText(data.description);
            numberTextView.setText(String.valueOf(data.number));
        }
    }

    public static class ListHeaderViewHolder extends MyViewHolder {
        private final TextView titleTextView;
        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
        }

        @Override
        public void setData(Data data) {
            titleTextView.setText(data.title);
        }
    }
}
