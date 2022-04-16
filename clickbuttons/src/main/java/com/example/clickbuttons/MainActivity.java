package com.example.clickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button bthOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tvOut);
        bthOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Ok");
            }
        };
        bthOk.setOnClickListener(oclBtnOk);

        View.OnClickListener oclBtnCancel = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv.setText("Cancel");
            }
        };
        btnCancel.setOnClickListener(oclBtnCancel);
    }
}