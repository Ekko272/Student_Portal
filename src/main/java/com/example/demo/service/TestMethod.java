package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestMethod {
    public static void main(String[] args) {
        String startDateString = "08/02/2023";
        int courseLengthInWeeks = 20;
        String dayOfWeek = "Wednesday"; // "Monday", "Tuesday", ..., "Sunday"

        List<String> schedule = generateDateSchedule(startDateString, courseLengthInWeeks, dayOfWeek);
        for (String date : schedule) {
            System.out.println(date);
        }
    }

    public static List<String> generateDateSchedule(String startDateString, int courseLengthInWeeks, String dayOfWeek) {
        List<String> schedule = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar calendar = Calendar.getInstance();

        try {
            Date startDate = sdf.parse(startDateString);
            calendar.setTime(startDate);

            for (int i = 0; i < courseLengthInWeeks; i++) {
                // Find the next occurrence of the specified day of the week
                while (!calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, java.util.Locale.US).equalsIgnoreCase(dayOfWeek)) {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }

                // Add the date to the schedule
                schedule.add(sdf.format(calendar.getTime()));

                // Move to the next week
                calendar.add(Calendar.WEEK_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return schedule;
    }
}
