package com;

import com.db.JsonStore;
import com.model.Ad;
import com.service.Front;
import com.service.IndAd;
import com.service.Manager;
import com.service.Saver;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        JsonStore.loadData();
        HashMap<String, Ad> store = JsonStore.dataStore;

        Front front = new Front(1, 2, store);
        IndAd indAd = new IndAd(2, store);
        Manager manager = new Manager(15, store);

        Saver saver = new Saver();

        front.start();
        indAd.start();
        manager.start();
        saver.start();

    }
}
