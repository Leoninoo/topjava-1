package ru.javawebinar.topjava.util;

import java.time.*;

public class TimeUtil {
    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) < 0;
    }

    public static LocalDateTime dateTimeFromString(String dt) {
        Instant instant = Instant.parse(dt + "Z");

        return LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
    }
}
