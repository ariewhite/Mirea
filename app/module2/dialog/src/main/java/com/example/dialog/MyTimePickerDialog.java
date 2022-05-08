package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.text.BreakIterator;
import java.util.Calendar;

public class MyTimePickerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    @NonNull
    Calendar calendar = Calendar.getInstance();
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }
    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        Toast.makeText(getActivity(), "selected - " + hour + " " + minute, Toast.LENGTH_LONG).show();
    }
}
