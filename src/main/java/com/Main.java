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
        JsonStore jsonStore = new JsonStore();
        HashMap<String, Ad> store = jsonStore.loadData();


        Front front = new Front(1, 2, store);
        IndAd indAd = new IndAd(2, store);
        Manager manager = new Manager(15, store);

        Saver saver = new Saver(jsonStore);

        front.start();
        indAd.start();
        manager.start();
        saver.start();

    }
}
