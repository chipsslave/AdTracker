package com.service;

import com.db.DataStore;
import com.model.Ad;
import com.model.AdStatus;
import com.parser.AutoPlius.jsoup.FrontPageImpl;
import org.jsoup.nodes.Element;

public class Front extends Thread{
    private final String autoPliusUrl = "https://en.autoplius.lt/ads/used-cars?page_nr=1";
    private final int MINUTE_IN_MILISECONDS = 60000;
    private final int SECOND_IN_MILISECONDS = 1000;

    private int maxPageToCheck = 5;
    private int checkFrequencyMinutes;
    private DataStore adStore;

    public Front(int maxPageToCheck, int checkFrequencyMinutes, DataStore adStore) {
        this.maxPageToCheck = maxPageToCheck;
        this.checkFrequencyMinutes = checkFrequencyMinutes * MINUTE_IN_MILISECONDS;
        this.adStore = adStore;
    }

    public DataStore getAdStore() {
        return adStore;
    }

    public void scraping(){
        System.out.println("Checking front page of AutoPlius");
        FrontPageImpl frontPage = new FrontPageImpl(autoPliusUrl);
        for (Element ad : frontPage.getAdsInHtml()){
            String id = frontPage.parseAdId(ad);
            String url = frontPage.parseAdUrl(ad);
            if (!getAdStore().getAdStore().containsKey(id)){
                System.out.println("Found new Ad " + url);
                getAdStore().getAdStore().put(id, new Ad(id, url, AdStatus.INTRODUCED));
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
