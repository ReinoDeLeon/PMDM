package com.example.intents.activity.explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String FIRST_NUMBER = "firstNumber";
    public static final String SECOND_NUMBER = "secondNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.adderButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText _firstNumberEditText = (EditText) findViewById(R.id.firstNumber);
                EditText _secondNumberEditText = (EditText) findViewById(R.id.secondNumber);
                Integer _firstNumber = Integer.parseInt(_firstNumberEditText.getText().toString());
                Integer _secondNumber = Integer.parseInt(_secondNumberEditText.getText().toString());
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ResultActivity.class);
                intent.putExtra(FIRST_NUMBER, _firstNumber);
                intent.putExtra(SECOND_NUMBER, _secondNumber);
                startActivity(intent);
            }
        });
    }
}