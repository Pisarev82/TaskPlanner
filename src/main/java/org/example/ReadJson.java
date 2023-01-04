package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReadJson {
    private ArrayList<Task> data;
    private final String FILE_NAME;
    private final Type REVIEW_TYPE;

    public ReadJson(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
        this.REVIEW_TYPE = new TypeToken<List<Task>>() {
        }.getType();
    }


    public ArrayList<Task> readJson () {
        Gson gson1 = new Gson();
        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(FILE_NAME));
        } catch (
                FileNotFoundException e) {
            System.out.println(FILE_NAME + " Не найден, создан новый список дел.");
            return data = new ArrayList<>();
        }
        data = gson1.fromJson(reader, REVIEW_TYPE);
        if (data == null) {
            System.out.println(FILE_NAME + " Не содержит данных, создан новый список дел.");
            return data = new ArrayList<>();
        }
        Collections.sort(data, Comparator.comparingInt(Task::getId));
        Task.setNextId(data.get(data.size()-1).getId());
        return data;
    }

}
