package com.service;

import com.db.JsonStore;

public class Saver extends Thread{

    private JsonStore jsonStore;

    public Saver(JsonStore jsonStore){
        this.jsonStore = jsonStore;
    }

    public void save(){
        jsonStore.saveData();
    }

    @Override
    public synchronized void run() {
        while (true){
            save();
            System.err.println("SAVED");
            try {
                Thread.sleep(1000 * 10 * 6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
