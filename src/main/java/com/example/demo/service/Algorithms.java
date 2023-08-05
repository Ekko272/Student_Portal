package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Algorithms {
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
                while (!calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, java.util.Locale.US).equalsIgnoreCase(dayOfWeek)) {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }
                schedule.add(sdf.format(calendar.getTime()));

                calendar.add(Calendar.WEEK_OF_YEAR, 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return schedule;
    }
}
