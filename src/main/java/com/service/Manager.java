package com.service;

import com.model.Ad;
import com.model.AdStatus;

import java.util.HashMap;

public class Manager extends Thread{
    private final int secondInMiliseconds = 1000;

    private int checkFrequencySeconds;
    private HashMap<String, Ad> adStore;

    public Manager(int checkFrequencySeconds, HashMap<String, Ad> adStore) {
        this.checkFrequencySeconds = checkFrequencySeconds * secondInMiliseconds;
        this.adStore = adStore;
    }

    public void report(){
        if (adStore.size() != 0){
            int newAds = 0;
            int updatedAds = 0;
            for (Ad ad : adStore.values()){
                if (ad.getStatus() == AdStatus.INTRODUCED){
                    newAds++;
                } else if (ad.getStatus() == AdStatus.NEW){
                    updatedAds++;
                }
            }
            System.out.println("Curently list holds in total of: " + adStore.size() + " records");
            System.out.println("Brand new ads: " + newAds);
            System.out.println("Updated ads: " + updatedAds);
        }
    }

    @Override
    public void run(){
        while (true){
            report();
            try {
                Thread.sleep(checkFrequencySeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
