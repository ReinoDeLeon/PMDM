package com.example.intents.activity.explicit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int firstNumber;
        int secondNumber;

        Intent intent = getIntent();
        firstNumber = intent.getIntExtra(MainActivity.FIRST_NUMBER, 0);
        secondNumber = intent.getIntExtra(MainActivity.SECOND_NUMBER, 0);
        TextView resultTextView = findViewById(R.id.result);
        resultTextView.setText(String.format("El resultado de la operación %d + %d es %d", firstNumber, secondNumber, (firstNumber+secondNumber)));
    }
}