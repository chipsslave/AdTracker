package com.service;

import com.db.DataStore;
import com.model.Ad;
import com.model.AdStatus;
import com.parser.AutoPlius.IndividualAdImpl;

public class IndAd extends Thread{
    private final int secondInMiliseconds = 1000;

    private int checkFrequencySeconds;
    private DataStore adStore;

    public IndAd(int checkFrequencySeconds, DataStore adStore) {
        this.checkFrequencySeconds = checkFrequencySeconds * secondInMiliseconds;
        this.adStore = adStore;
    }

    public void scraping(){
        Ad ad = adStore.getIntroducedAd();

        if (ad != null){
            System.out.println("Parsing details for ad: " + ad.getAdUrl());
            IndividualAdImpl individualAd = new IndividualAdImpl(ad.getAdUrl());
            individualAd.parseAdFields(ad);
            ad.setStatus(AdStatus.NEW);
        }
    }

    @Override
    public void run(){
        while (true){
            scraping();
            try {
                System.out.println("Sleeping for: " + checkFrequencySeconds / 1000 + " seconds.");
                Thread.sleep(checkFrequencySeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
