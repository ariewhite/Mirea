package com.example.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLinkActivity(View view) {
        Uri adress = Uri.parse("https://www.mirea.ru/");
        Intent openLinkActivity = new Intent(Intent.ACTION_VIEW, adress);

        if(openLinkActivity.resolveActivity(getPackageManager()) != null){
            startActivity(openLinkActivity);
        }
        else {
            Log.d("Intent", "Не получилось обработать намерение" );
        }
    }

    public void shareMyDetails(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Мурзабаев Чингиз Динарович");
        startActivity(shareIntent);
    }
}