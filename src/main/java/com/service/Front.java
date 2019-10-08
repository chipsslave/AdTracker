package com.service;

import com.model.Ad;
import com.model.AdStatus;
import com.parser.AutoPlius.FrontPageImpl;
import org.jsoup.nodes.Element;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Front extends Thread{
    private final String autoPliusUrl = "https://en.autoplius.lt/ads/used-cars?page_nr=1";
    private final int MINUTE_IN_MILISECONDS = 60000;
    private final int SECOND_IN_MILISECONDS = 1000;

    private int maxPageToCheck = 5;
    private int checkFrequencyMinutes;
    private HashMap<String, Ad> adStore;

    public Front(int maxPageToCheck, int checkFrequencyMinutes, HashMap<String, Ad> adStore) {
        this.maxPageToCheck = maxPageToCheck;
        this.checkFrequencyMinutes = checkFrequencyMinutes * MINUTE_IN_MILISECONDS;
        this.adStore = adStore;
    }

    public void scraping(){
        System.out.println("Checking front page of AutoPlius");
        FrontPageImpl frontPage = new FrontPageImpl(autoPliusUrl);
        for (Element ad : frontPage.getAdsInHtml()){
            String id = frontPage.parseAdId(ad);
            String url = frontPage.parseAdUrl(ad);
            if (!adStore.containsKey(id)){
                System.out.println("Found new Ad " + url);
                LocalDateTime time = LocalDateTime.now();
                adStore.put(id, new Ad(id, url, AdStatus.INTRODUCED, time));
            }
        }

        try {
            System.out.println("Sleeping for: " + checkFrequencyMinutes / SECOND_IN_MILISECONDS + " seconds.");
            Thread.sleep(checkFrequencyMinutes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (true) {
            scraping();
        }

    }
}
