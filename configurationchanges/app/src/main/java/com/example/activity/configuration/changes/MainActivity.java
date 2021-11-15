package com.example.activity.configuration.changes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import android.os.Bundle;
import android.os.PersistableBundle;

public class MainActivity extends AppCompatActivity {
    private static final String TIMESTAMP_KEY = "TIMESTAMP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.getLong(MainActivity.TIMESTAMP_KEY);
        }
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        Long timeStamp = Calendar.getInstance().getTimeInMillis();
        outState.putLong(MainActivity.TIMESTAMP_KEY, timeStamp);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}