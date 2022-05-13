package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private SharedPreferences preferences;
    private EditText fileName;
    private EditText text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = findViewById(R.id.fileOfName);
        text = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        preferences = getPreferences(MODE_PRIVATE);

        try {
            fileName.setText(preferences.getString("file_name", "murzabaev"));
            text.setText(getTextFromFile());
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
        }
    }

    private String getTextFromFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(fileName.getText().toString());
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            String text = new String(bytes);
            Log.d(TAG, text);
            Toast.makeText(this, "load complete", Toast.LENGTH_SHORT).show();
            return text;
        } catch (IOException ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }

    public void onClick(View view){
        FileOutputStream outputStream;
        String textName = text.getText().toString();
        String name = fileName.getText().toString();
        try {
            outputStream = openFileOutput(name, Context.MODE_PRIVATE);
            outputStream.write(textName.getBytes());
            outputStream.close();
            Toast.makeText(this, "save complete", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("file_name", name);
        editor.apply();
    }
}