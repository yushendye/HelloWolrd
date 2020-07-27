package com.development.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateTimeDemo extends AppCompatActivity {
    DatePicker datePicker;
    TextView date;
    DatePickerDialog dialog;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_demo);

        datePicker = findViewById(R.id.date_picker);
        date = findViewById(R.id.date);
        timePicker = findViewById(R.id.time);

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.setText(getDate());
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(DateTimeDemo.this, "Selected : " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
            }
        });
    }

    String getDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((datePicker.getMonth() + 1)+"/");//month is 0 based
        builder.append(datePicker.getDayOfMonth()+"/");
        builder.append(datePicker.getYear());
        return builder.toString();
    }

    public void show_dial(View view){
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        dialog = new DatePickerDialog(DateTimeDemo.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }, year, month, day);
        dialog.show();
    }
}