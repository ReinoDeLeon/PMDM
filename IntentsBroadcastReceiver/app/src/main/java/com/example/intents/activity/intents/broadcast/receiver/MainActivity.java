package com.example.intents.activity.intents.broadcast.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver tickReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView hourTextView = (TextView) findViewById(R.id.hour);
        TextView minuteTextView = (TextView) findViewById(R.id.minute);

        hourTextView.setText(String.format("%d", Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
        minuteTextView.setText(String.format("%d", Calendar.getInstance().get(Calendar.MINUTE)));

        tickReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction() == Intent.ACTION_TIME_TICK && Calendar.getInstance().get(Calendar.MINUTE) > 9) {
                    hourTextView.setText(String.format("%d", Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
                    minuteTextView.setText(String.format("%d", Calendar.getInstance().get(Calendar.MINUTE)));

                } else if (intent.getAction() == Intent.ACTION_TIME_TICK && Calendar.getInstance().get(Calendar.MINUTE) < 10) {
                    hourTextView.setText(String.format("%d", Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
                    minuteTextView.setText(String.format("0%d", Calendar.getInstance().get(Calendar.MINUTE)));
                }
            }
        };
        registerReceiver(tickReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(tickReceiver);
    }
}