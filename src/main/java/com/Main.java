package com;

import com.db.DataStore;
import com.service.Front;
import com.service.IndAd;
import com.service.Manager;

public class Main {
    public static void main(String[] args){
        DataStore store = new DataStore();

        Front front = new Front(1, 1, store);
        IndAd indAd = new IndAd(15, store);
        Manager manager = new Manager(5, store);

        front.start();
        indAd.start();
        manager.start();

    }
}
