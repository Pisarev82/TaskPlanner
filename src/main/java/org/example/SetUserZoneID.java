package org.example;

import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SetUserZoneID {
    /*
     * Работа учебная, до этого не использовал статику, по этому решил попробовать.
     * Почему-то все что касается времени написанно статическими методами и переменными.
     * Продолжил традицию и написал все полностью статичным.
     * Проблеммы с статичной переменной начнуться когда 2 пользователя из разных часовых поясов захотят поменять переменную zone
     * в данной реализации это можно сделать методом setZone(String zoneName).
     */
    private static ZoneId zone = ZonedDateTime.now().getZone();

    public static @NotNull String getTime(long timeStamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(timeStamp), SetUserZoneID.zone).format(formatter);
    }

    public static void setZone(String zoneName) {
        SetUserZoneID.zone = ZoneId.of(zoneName);
    }

    public static ZoneId getZone() {
        return zone;
    }
}
