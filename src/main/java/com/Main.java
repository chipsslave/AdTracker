package com;

import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;
import com.util.UrlContentReader;
import org.jsoup.nodes.Document;


public class Main {

    String url = "https://en.autoplius.lt/ads/volkswagen-touareg-4-1-l-suv-off-road-2010-diesel-9605847.html";


    public static void main(String[] args){
        Main main = new Main();
        GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

        String url = "https://en.autoplius.lt/ads/volkswagen-touareg-4-1-l-suv-off-road-2010-diesel-9605847.html";
        //url = "https://www.journaldev.com/7148/java-httpurlconnection-example-java-http-request-get-post";

        Document str = UrlContentReader.readContentInJsoupDocument(url);
        System.out.println(str);

//        while (localJsonStorage.getAdToUpdate() != null) {
//            Ad ad = localJsonStorage.getAdToUpdate();
//            System.out.println(ad.getAdUrl());
//            Document pageInHtml = UrlContentReader.readContentInJsoupDocument(ad.getAdUrl());
//            AutoPliusIndividualAdPageImpl<GsonDataBaseImpl> autoPliusIndividualAdPage = new AutoPliusIndividualAdPageImpl<>(pageInHtml, localJsonStorage, ad);
//            autoPliusIndividualAdPage.checkAdInWebsite();
//        }
//
//        localJsonStorage.commit();


    }
}
