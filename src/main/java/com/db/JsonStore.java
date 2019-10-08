package com.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.Ad;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class JsonStore {
    private final static String FILE_PATH = "src/main/resources/data.json";
    private final static Gson gson = new Gson();

    public static HashMap<String, Ad> dataStore;

    private JsonStore() throws IOException {
    }

    public static void loadData(){
        Reader reader;
        try {
            reader = new FileReader(FILE_PATH);
            Type listType = new TypeToken<HashMap<String, Ad>>(){}.getType();

            dataStore = gson.fromJson(reader, listType);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (dataStore == null){
            dataStore = new HashMap<String, Ad>();
        }
    }

    public static void saveData(){
        Writer writer;
        try {
            writer = new FileWriter(FILE_PATH, false);
            gson.toJson(dataStore, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
