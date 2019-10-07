package com.service;

import com.db.DataStore;
import com.model.Ad;
import com.model.AdStatus;

public class Manager extends Thread{
    private final int secondInMiliseconds = 1000;

    private int checkFrequencySeconds;
    private DataStore adStore;

    public Manager(int checkFrequencySeconds, DataStore adStore) {
        this.checkFrequencySeconds = checkFrequencySeconds * secondInMiliseconds;
        this.adStore = adStore;
    }

    public DataStore getAdStore() {
        return adStore;
    }

    public void report(){
        if (getAdStore().getAdStore().size() != 0){
            int newAds = 0;
            int updatedAds = 0;
            for (Ad ad : getAdStore().getAdStore().values()){
                if (ad.getStatus() == AdStatus.INTRODUCED){
                    newAds++;
                } else if (ad.getStatus() == AdStatus.NEW){
                    updatedAds++;
                }
            }
            System.out.println("Curently list holds in total of: " + getAdStore().getAdStore().size() + " records");
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
