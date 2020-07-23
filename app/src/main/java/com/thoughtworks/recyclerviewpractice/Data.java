package com.thoughtworks.recyclerviewpractice;

import java.util.ArrayList;
import java.util.List;

class Data {
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_TITLE = 1;
    public String title;
    public String description;
    public int number;
    public int type;
    public String imageUrl;

    public Data(String title, String description, int number, int type, String imageUrl) {
        this.title = title;
        this.description = description;
        this.number = number;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public static List<Data> createMockData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data("This is header", null, 0, TYPE_TITLE, null));
        String baseUrl = "https://loremflickr.com/180/180?lock=";
        String title = "title";
        String desc = "desc";
        for (int i = 1; i < 101; i++) {
            data.add(new Data(title + i, desc + i, i, TYPE_ITEM, baseUrl + i));
        }
        return data;
    }
}
