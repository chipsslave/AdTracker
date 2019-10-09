package com.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.Ad;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class JsonStore {
    private final String FILE_NAME = "data.json";
    private final Gson GSON = new Gson();

    private HashMap<String, Ad> dataLocalStorage;

    public JsonStore() {
    }

    public HashMap<String, Ad> loadData(){
        try {
            Reader reader = new FileReader(FILE_NAME);
            Type listType = new TypeToken<HashMap<String, Ad>>(){}.getType();
            dataLocalStorage = GSON.fromJson(reader, listType);
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return dataLocalStorage;
    }

    public void saveData(){
        try {
            Writer writer = new FileWriter(FILE_NAME, false);
            GSON.toJson(dataLocalStorage, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
