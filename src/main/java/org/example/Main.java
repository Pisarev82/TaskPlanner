package org.example;

import java.time.Instant;


public class Main {

    public static void main(String[] args) {
        // Следующая строка кода рабочая, но с ней не интересно. Она нужна когда системное время отличается, от требуемого пользователем.
        // SetUserZoneID.setZone("America/Los_Angeles");

        System.out.println("Ваш часовой пояс: " + SetUserZoneID.getZone() +" сейчас: " + SetUserZoneID.getTime(Instant.now().getEpochSecond()));


        TasksStorage tasksStorage = new TasksStorage("test.json");
        /*
        Реализация функционала по дабовлению задач не входило в ТЗ.
        Да и не интересно писать очередной консольный ввод.
         */
        tasksStorage.addTask("Николай", 2);
        tasksStorage.addTask(8,"Николай", 1);
        /*
        Проверка основного функционала
         */
        tasksStorage.printTasks();
        tasksStorage.saveToFile();
        System.out.println("-----------------");
        tasksStorage.sortByPrioriti();
        tasksStorage.printTasks();
        System.out.println("-----------------");
        tasksStorage.sortByDeadLine();
        tasksStorage.printTasks();
        System.out.println("-----------------");
        tasksStorage.deleteTaskById(15);
        tasksStorage.printTasks();

        System.out.println("Ваш часовой пояс: " + SetUserZoneID.getZone() +" сейчас: " + SetUserZoneID.getTime(Instant.now().getEpochSecond()));

    }
}

