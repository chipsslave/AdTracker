package com.service;

import com.model.Ad;
import com.model.enums.AdStatus;
import com.parser.jsoup.AutoPlius.page.inside.AutoPliusIndividualAdImpl;

import java.time.LocalDateTime;
import java.util.HashMap;

public class IndAd {
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
            AutoPliusIndividualAdImpl individualAd = new AutoPliusIndividualAdImpl(ad.getAdUrl());
            individualAd.parseAdFields(ad);
            if (ad.getStatus() == AdStatus.INTRODUCED){
                ad.setStatus(AdStatus.NEW);
            } else {
                ad.setStatus(AdStatus.UPDATED);
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
