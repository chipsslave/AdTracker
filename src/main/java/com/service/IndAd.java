package com.service;

import com.model.Ad;
import com.model.enums.AdStatus;
import com.parser.AutoPlius.IndividualAdImpl;

import java.time.LocalDateTime;
import java.util.HashMap;

public class IndAd extends Thread{
    private final int secondInMiliseconds = 1000;

    private int checkFrequencySeconds;
    private HashMap<String, Ad> adStore;

    public IndAd(int checkFrequencySeconds, HashMap<String, Ad> adStore) {
        this.checkFrequencySeconds = checkFrequencySeconds * secondInMiliseconds;
        this.adStore = adStore;
    }

    public void scraping(){
        Ad ad = getAdToUpdate();

        if (ad != null){
            System.out.println("Parsing details for ad: " + ad.getAdUrl());
            IndividualAdImpl individualAd = new IndividualAdImpl(ad.getAdUrl());
            individualAd.parseAdFields(ad);
            if (ad.getStatus() == AdStatus.INTRODUCED){
                ad.setStatus(AdStatus.NEW);
            } else {
                ad.setStatus(AdStatus.UPDATED);
            }

        }
    }

    @Override
    public void run(){
        while (true){
            if (adStore != null){
                scraping();
            }
            try {
                //System.out.println("Sleeping for: " + checkFrequencySeconds / 1000 + " seconds.");
                Thread.sleep(checkFrequencySeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Ad getAdToUpdate(){
        if (adStore.values() != null){
            for (Ad ad : adStore.values()){
                if (ad.getStatus() == AdStatus.INTRODUCED || ad.getUpdated().isBefore(LocalDateTime.now().minusDays(1))){
                    return ad;
                }
            }
        }

        return null;
    }

}
