package com;

import com.model.Ad;
import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;


public class Main {

    // https://en.autoplius.lt/ads/volkswagen-touareg-4-1-l-suv-off-road-2010-diesel-9605847.html

    public static void main(String[] args){
        GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

        for (Ad ad : localJsonStorage.getAll()) {
            System.out.println(ad.getAdId());
        }

//        Front front = new Front(1, 2, store);
//        IndAd indAd = new IndAd(2, store);
//        Manager manager = new Manager(15, store);
//
//        Saver saver = new Saver(localJsonStorage);
//
//        front.start();
//        indAd.start();
//        manager.start();
//        saver.start();

    }
}
