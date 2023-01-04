package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteJson {
    private final String FILENAME;

    public WriteJson(String filename) {
        FILENAME = filename;
    }

    public void writeJson (ArrayList<Task> taskArrayListToWrite) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String test = gson.toJson(taskArrayListToWrite);

        try (FileWriter writer = new FileWriter(FILENAME, false)) {
            writer.write(test);
            writer.flush();
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
