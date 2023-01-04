package org.example;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {

    private static AtomicInteger nextId = new AtomicInteger();
    private final int id;
    private final long addedMoment;
    private long deadLine;
    private final int PRIORITI_LEVEL;
    private final String author;


    public Task(String author, int PRIORITI_LEVEL) {
        this.id = nextId.incrementAndGet();
        this.addedMoment = creationTimeStamp();
        this.author = author;
        this.PRIORITI_LEVEL = PRIORITI_LEVEL;
    }

    public Task(int deadlineInHour, String author, int PRIORITI_LEVEL) {
        this(author, PRIORITI_LEVEL);
        this.deadLine = (long)deadlineInHour*3600 + addedMoment;
    }


    private long creationTimeStamp() {
        return Instant.now().getEpochSecond();
    }

    public long getAddedMoment() {
        return addedMoment;
    }

    public long getDeadLine() {
        return deadLine;
    }

    public int getPRIORITI_LEVEL() {
        return PRIORITI_LEVEL;
    }

    public int getId() {
        return id;
    }

    public static void setNextId(int delta) {
        Task.nextId.getAndSet(delta);
    }

    private String deadlineToString() {
        if (deadLine == 0) {
            return  "Не задан";
        } else {
            return  SetUserZoneID.getTime(deadLine);
        }
    }

    private String priorityLevelToString() {
        return switch (PRIORITI_LEVEL) {
            case (1) -> ", приоритет низкий";
            case (2) -> ", приоритет средний";
            case (3) -> ", немедленное выполнение";
            default -> "Такого приоретета нет( ";
        };
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID = " + id +
                ", addedMoment = " + SetUserZoneID.getTime(addedMoment) +
                ", deadLine = " + deadlineToString() +
                ", author = '" + author + '\'' +
                priorityLevelToString() +
                '}';
    }
}
