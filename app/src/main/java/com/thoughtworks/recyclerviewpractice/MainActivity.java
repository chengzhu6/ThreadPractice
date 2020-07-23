package com.thoughtworks.recyclerviewpractice;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;

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
        button = findViewById(R.id.thread_practice);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonClickTask buttonClickTask = new ButtonClickTask();
                buttonClickTask.execute();
            }
        });

    }

    public void createListActivity() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    class ButtonClickTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            button.setClickable(false);
            for (Integer i = 0; i < 10; i++) {
                publishProgress(i);
                SystemClock.sleep(1000);
            }
            button.setClickable(true);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            button.setText(values[0].toString());
        }
    }
}