package com.service;

import com.model.Ad;

import java.util.HashMap;

public class AutoPliusFront {
    private final String autoPliusUrl = "https://en.autoplius.lt/ads/used-cars?page_nr=1";

    private int checkFrequencyMinutes;
    private HashMap<String, Ad> adStore;

//    public AutoPliusFront(String target, HashMap<String, Ad> adStore) {
//        super(target);
//        this.adStore = adStore;
//    }
//
//    public void scraping(){
//        System.out.println("Checking front page of AutoPlius");
//        AutoPliusFrontPageImpl frontPage = new AutoPliusFrontPageImpl(autoPliusUrl);
//        for (Element ad : frontPage.getAdsInHtml()){
//            String id = frontPage.parseAdId(ad);
//            String url = frontPage.parseAdUrl(ad);
//            if (!adStore.containsKey(id)){
//                System.out.println("Found new Ad " + url);
//                LocalDateTime time = LocalDateTime.now();
//                adStore.put(id, ModelFactory.getAd(id, url, AdStatus.INTRODUCED, time));
//            }
//        }
//    }

}
