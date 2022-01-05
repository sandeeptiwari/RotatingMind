package com.rotatingmind.java16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;

public class DateTimeFormatting {

    public static void main(String[] args) {
        var dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendDayPeriodText(TextStyle.FULL)
                .toFormatter();
        String output = dateTimeFormatter.format(LocalDateTime.of(2021, 6, 2, 12, 21));
        System.out.println("Result " + output);
    }
}
