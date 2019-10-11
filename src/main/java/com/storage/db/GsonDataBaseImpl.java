package com.storage.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.Ad;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GsonDataBaseImpl implements DataBase {
    private final Gson GSON = new Gson();
    private String fileName = "data.json";
    private Map<String, Ad> dataLocalStorage;

    GsonDataBaseImpl() {
        this.dataLocalStorage = translateListToMap(getAll());
    }

    GsonDataBaseImpl(String fileName) {
        this.fileName = fileName;
        this.dataLocalStorage = translateListToMap(getAll());
    }

    @Override
    public Ad addNew(Ad ad) {
        dataLocalStorage.put(ad.getAdId(), ad);
        return ad;
    }

    @Override
    public Ad update(Ad ad) {
        return dataLocalStorage.replace(ad.getAdId(), ad);
    }

    @Override
    public Ad getById(String id) {
        return dataLocalStorage.get(id);
    }

    @Override
    public Ad delete(Ad ad) {
        return dataLocalStorage.remove(ad.getAdId());
    }

    @Override
    public List<Ad> getAll() {
        List<Ad> tempList = new ArrayList<>();
        try {
            Reader reader = new FileReader(getFile());
            Type listType = new TypeToken<List<Ad>>() {
            }.getType();
            tempList = GSON.fromJson(reader, listType);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempList;
    }

    @Override
    public void saveAll(List<Ad> adList) {
        Map<String, Ad> adMap = translateListToMap(adList);
        dataLocalStorage.putAll(adMap);
    }

    public void commit() {
        try {
            Writer writer = new FileWriter(getFile(), false);
            GSON.toJson(dataLocalStorage.values(), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private Map<String, Ad> translateListToMap(List<Ad> all) {
        return all.stream().collect(Collectors.toMap(Ad::getAdId, item -> item));
    }
}
