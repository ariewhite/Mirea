package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowDialog(View view){
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea M.C");
    }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Yes\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"No\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Pause\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onClickTimePickerDialog(View view){
        MyTimePickerDialog dialog = new MyTimePickerDialog();
        dialog.show(getSupportFragmentManager(), "time picker dialog fragment");
    }
    public void onClickDatePickerDialog(View view){
        MyDatePickerDialog dialog = new MyDatePickerDialog();
        dialog.show(getSupportFragmentManager(), "date picker dialog fragment");
    }
    public void onClickProgressDialog(View view) {
        MyProgressDialog myProgressDialogFragment = new MyProgressDialog();
        myProgressDialogFragment.show(getSupportFragmentManager(),"Progress");
    }
}