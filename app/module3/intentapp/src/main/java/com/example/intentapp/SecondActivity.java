package com.example.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    protected TextView textView;  public static final String EXTRA_TIME = "TIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String string = intent.getStringExtra(EXTRA_TIME);
        textView.setText(string);
    }
}
