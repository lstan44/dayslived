package com.example.dayslived;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class datePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
    }

    public void getDays(View view) {
        DatePicker p = (DatePicker) findViewById(R.id.datePicker);
        int day = p.getDayOfMonth();
        int month = p.getMonth();
        int year = p.getYear();

        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        int currentDay = c.get(Calendar.DAY_OF_MONTH);

        int monthDays[] = {31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31};

        TextView tv = findViewById(R.id.tv_daysllived);


        int n1 = currentYear * 365 + currentDay;

//         Add days for months in given date
        for (int i = 0; i < currentMonth - 2; i++)
        {
            n1 += monthDays[i];
        }


        // Since every leap year is of 366 days,
        // Add a day for every leap year
        n1 += countLeapYears(currentYear,currentMonth);


        // SIMILARLY, COUNT TOTAL NUMBER OF DAYS BEFORE 'dt2'
        int n2 = year * 365 + day;
        for (int i = 0; i < month - 1; i++)
        {
            n2 += monthDays[i];
        }
        n2 += countLeapYears(year, month);

        // return difference between two counts
        int diff = (n1 - n2);
        String text = "You have lived "+diff+ " days.";
        tv.setText(text);
    }

    public  int countLeapYears(int y, int m)
    {
        int years = y;

        // Check if the current year needs to be considered
        // for the count of leap years or not
        if (m <= 2)
        {
            years--;
        }

        // An year is a leap year if it is a multiple of 4,
        // multiple of 400 and not a multiple of 100.
        return years / 4 - years / 100 + years / 400;
    }


}
