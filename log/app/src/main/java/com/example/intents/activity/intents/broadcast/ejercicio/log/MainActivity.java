package com.example.intents.activity.intents.broadcast.ejercicio.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w(getLocalClassName(), "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.w(getLocalClassName(), "onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(getLocalClassName(), "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(getLocalClassName(), "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.w(getLocalClassName(), "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.w(getLocalClassName(), "onRestart()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.w(getLocalClassName(), "onStop()");
    }
}