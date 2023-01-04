package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TasksStorage {
    private final String FILE_NAME;
    ReadJson readJson;
    ArrayList<Task> taskArrayList;

    public TasksStorage(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
        this.readJson =  new ReadJson(FILE_NAME);
        this.taskArrayList = readJson.readJson();
    }

    public void  addTask(String author, int prioritiLevel) {
        taskArrayList.add(new Task(author, prioritiLevel));
    }
    public void  addTask(int deadLine, String author, int prioritiLevel) {
        taskArrayList.add(new Task(deadLine, author, prioritiLevel));
    }

    public void saveToFile() {
        WriteJson writeJson = new WriteJson(FILE_NAME);
        writeJson.writeJson(taskArrayList);
    }

    public void sortByPrioriti() {
        Collections.sort(taskArrayList, Comparator.comparingInt(Task::getPRIORITI_LEVEL));
    }

    public void sortByDeadLine() {
        Collections.sort(taskArrayList, (a,b) -> a.getDeadLine()-b.getDeadLine() < 0 ? -1 : a.getDeadLine()-b.getDeadLine() == 0? 0 : 1);
    }

    public void sortByAddedMoment() {
        Collections.sort(taskArrayList, (a,b) -> a.getAddedMoment()-b.getAddedMoment() < 0 ? -1 : a.getAddedMoment()-b.getAddedMoment() == 0? 0 : 1);
    }

    public void deleteTaskById (int id) {
        int index = -1;
        for (int i = 0; i < taskArrayList.size(); i++ ) {
            if (taskArrayList.get(i).getId() == id) {
                index = i;
            }
        }
        if (index > -1) {
            taskArrayList.remove(index);
        } else {
            System.out.println("Задачи с индексом " + id + " не найдено.");
        }
    }

    public void printTasks() {
        for (Task task: taskArrayList) {
            System.out.println(task);
        }
    }
}
