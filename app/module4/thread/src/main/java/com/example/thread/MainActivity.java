package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        textView.setText("Current thread - " + mainThread.getName());
        mainThread.setName("MireaMainThread");
        textView.append("\n new name of thread - " + mainThread.getName());

    }
    public void onClick(View view){
        Runnable runnable = new Runnable() {
            public void run() {
                int numberThread = counter++;
                Log.i("ThreadProject", "Запущен поток № " + numberThread);
                long endTime = System.currentTimeMillis()
                        + 20 * 1000;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime -
                                    System.currentTimeMillis());
                        } catch (Exception e) {
                        }
                    }
                }
                Log.i("ThreadProject", "Выполнен поток № " + numberThread);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        Runnable runnable1 = new Runnable() {
            public void run() {
                int count = (9 + 20) * 2 / 30;
                TextView textView = findViewById(R.id.textView);
                textView.setText("average number of lessons : " + count);
            }
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();
    }
}