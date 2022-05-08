package com.example.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyDatePickerDialog  extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    Calendar calendar = Calendar.getInstance();

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Toast.makeText(getActivity(),"selected -"
                        + year + ";"
                        + month + ";"
                        + day,
                        Toast.LENGTH_SHORT).show();
    }
}
