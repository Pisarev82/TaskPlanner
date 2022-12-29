package org.example;

import java.time.Instant;

public class Task {
    private static int id;
    private final long addedMoment;
    private long deadline;
    private final String author;

    public Task(int id, String author) {
        this.id = id;
        this.addedMoment = creationTimeStamp();
        this.author = author;
    }

    public Task(int id, int deadlineInHour, String author) {
        this(id, author);
        this.deadline = setDeadline(deadlineInHour);

    }

    private long creationTimeStamp() {
        long now = Instant.now().getEpochSecond();
        return now;
    }

    private long setDeadline(int deadlineInHour) {
        return (long)deadlineInHour*3600;
    }

    @Override
    public String toString() {
        return "Task{" +
                "addedMoment=" + addedMoment +
                ", deadline=" + deadline +
                ", author='" + author + '\'' +
                '}';
    }
}
