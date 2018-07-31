package com.example.choi.sampledatetimepicker;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class DateTimePicker extends LinearLayout {

    DatePicker datePicker;
    TimePicker timePicker;
    onDateChangedListener listener;
    CheckBox checkTimePicker;

    public DateTimePicker(Context context) {
        super(context);
        init(context);
    }

    public DateTimePicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.picker, this, true);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        checkTimePicker = (CheckBox) findViewById(R.id.checkTimePicker);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        final int curYear = calendar.get(Calendar.YEAR);
        final int curMonth = calendar.get(Calendar.MONTH);
        final int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        final int curHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int curMinute = calendar.get(Calendar.MINUTE);

        datePicker.init(curYear, curMonth, curDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth, int hour, int minute) {
                if(listener != null){
                    listener.onDateTimeChanged(DateTimePicker.this, year, monthOfYear, dayOfMonth, timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                }
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                listener.onDateTimeChanged(DateTimePicker.this, datePicker.getYear(), datePicker.getDayOfMonth(), datePicker.getDayOfMonth(), hourOfDay, minute);
            }
        });

        timePicker.setCurrentHour(curHour);
        timePicker.setCurrentMinute(curMinute);

        checkTimePicker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                timePicker.setEnabled(isChecked);
                timePicker.setVisibility(checkTimePicker.isChecked() ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    public void setOnDateTimeChangedListener(DatePicker.OnDateChangedListener dateTimeListener){
        this.listener = listener;
    }

    public void updateDateTime(int year, int monthOfYear, int dayOfMonth, int hour, int minute){
        datePicker.updateDate(year, monthOfYear, dayOfMonth);
        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(minute);
    }
}
