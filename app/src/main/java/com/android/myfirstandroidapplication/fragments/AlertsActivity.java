package com.android.myfirstandroidapplication.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.myfirstandroidapplication.R;

import java.util.Calendar;

public class AlertsActivity extends AppCompatActivity {

    private TextView textViewDate;
    private TextView textViewDateTime;

    private int year, month, day, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_date_time_pickers);
        initView();
    }

    private void initView() {
        textViewDate = findViewById(R.id.textViewDate);
        textViewDateTime = findViewById(R.id.textViewDateTime);
    }

    public void openDatePickerOnClick(View view) {
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textViewDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, year, month, day);
        datePickerDialog.show();
    }


    public void openDateTimePickerOnClick(View view) {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        textViewDateTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    public void openAlertDialogOnClick(View view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.notice));
        builder.setMessage(getString(R.string.alert_title));

// add the buttons
        builder.setPositiveButton(getString(R.string.launch_app),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertsActivity.this,
                                getString(R.string.launch_app) + " " + getString(R.string.click),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNeutralButton(getString(R.string.reminde_me),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertsActivity.this,
                                getString(R.string.reminde_me) + " " + getString(R.string.click),
                                Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton(getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertsActivity.this,
                                getString(R.string.cancel) + " " + getString(R.string.click),
                                Toast.LENGTH_SHORT).show();
                    }
                });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
