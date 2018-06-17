package com.lonelycountry.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author YeFan
 * 2018/4/22.
 */
public class DateUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime parse(String text) {
        return LocalDateTime.parse(text, DATE_TIME_FORMATTER);
    }

    public static String format(LocalDateTime temporal) {
        return DATE_TIME_FORMATTER.format(temporal);
    }
}
