package com.thoughtworks.recyclerviewpractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_list);
        List<Data> data = Data.createMockData();
        MyAdapter myAdapter = new MyAdapter(data);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

}

class Data {
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_TITLE = 1;
    public String title;
    public String description;
    public int number;
    public int type;

    public Data(String title, String description, int number, int type) {
        this.title = title;
        this.description = description;
        this.number = number;
        this.type = type;
    }

    public static List<Data> createMockData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data("This is header", null, 0, TYPE_TITLE));
        for (int i = 0; i < 15; i++) {
            data.add(new Data("title" + i, "desc" + i, i, TYPE_ITEM));
        }
        return data;
    }
}
