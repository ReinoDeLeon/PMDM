package com.example.Ivan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addBtn = findViewById(R.id.adderButton);
        Button subtractBtn = findViewById(R.id.subtractButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumberEditText = findViewById(R.id.firstNumber);
                EditText secondNumberEditText = findViewById(R.id.secondNumber);
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                TextView result = findViewById(R.id.resultBox);
                result.setText(String.format("%d", (firstNumber+secondNumber)));
            };
        });
        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumberEditText = findViewById(R.id.firstNumber);
                EditText secondNumberEditText = findViewById(R.id.secondNumber);
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                TextView result = findViewById(R.id.resultBox);
                result.setText(String.format("%d", (firstNumber-secondNumber)));
            };
        });
    }

}