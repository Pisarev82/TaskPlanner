package org.example;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        long now = getTimeStamp();

        System.out.println("Hello world!  \n" + now +"\n" );
        Instant instant = Instant.ofEpochSecond(now);
        System.out.println(instant);
        Instant instant1 = Instant.EPOCH.plus(getTimeStamp(), ChronoUnit.SECONDS);
        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");
        ZoneId zone = ZoneId.of("Europe/Moscow");
        ZonedDateTime time = ZonedDateTime.ofInstant(instant, zone);
        ZonedDateTime time1 = ZonedDateTime.ofInstant(instant1, zone);
        System.out.println(time);
        System.out.println(time1);
        Task task = new Task(1, "Николай");
        Task task1 = new Task(2, 24, "Николай");
        System.out.println(task + " " + task);
    }

    static long getTimeStamp() {
        long now = Instant.now().getEpochSecond();
        return now;
    }
}

