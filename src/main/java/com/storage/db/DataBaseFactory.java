package com.storage.db;

public class DataBaseFactory {

    private static GsonDataBaseImpl localJsonStorage;

    public static GsonDataBaseImpl getDataBaseInstance() {
        localJsonStorage = new GsonDataBaseImpl();
        return localJsonStorage;
    }

    public static GsonDataBaseImpl getDataBaseInstance(String FILE_NAME) {
        localJsonStorage = new GsonDataBaseImpl(FILE_NAME);
        return localJsonStorage;
    }

}
