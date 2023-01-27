package org.example;

public class TaskBuilder {

    private int timeUntillDeadLine;
    private int PRIORITI_LEVEL;
    private String author;

    public TaskBuilder setTimeUntillDeadLine(int timeUntillDeadLine) {
        this.timeUntillDeadLine = timeUntillDeadLine;
        return this;
    }

    public TaskBuilder setPRIORITI_LEVEL(int PRIORITI_LEVEL) {
        this.PRIORITI_LEVEL = PRIORITI_LEVEL;
        return this;
    }

    public TaskBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getTimeUntillDeadLine() {
        return timeUntillDeadLine;
    }

    public int getPRIORITI_LEVEL() {
        return PRIORITI_LEVEL;
    }

    public String getAuthor() {
        return author;
    }

    public Task creatTask () {
        return new Task(this);
    }

}
