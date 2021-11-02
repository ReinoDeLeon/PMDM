package com.example.intents.activity.mapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText _addressEditText = findViewById(R.id.address);

        _addressEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {

                    String _address = _addressEditText.getText().toString();

                    String _urlEncoded = Uri.encode(_address);
                    String _uriString = String.format("geo:0,0?q=%s", _urlEncoded);
                    Uri _uri = Uri.parse(_uriString);
                    Intent intent = new Intent(Intent.ACTION_VIEW, _uri);
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}