package com.thoughtworks.recyclerviewpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.recycler_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createListActivity();
            }
        });
    }

    public void createListActivity() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}