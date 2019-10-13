package com;

import com.parser.jsoup.AutoPlius.page.front.AutoPliusFrontPageService;


public class Main {

    String url = "https://en.autoplius.lt/ads/volkswagen-touareg-4-1-l-suv-off-road-2010-diesel-9605847.html";


    public static void main(String[] args){



//        while (localJsonStorage.getAdToUpdate() != null) {
//            Ad ad = localJsonStorage.getAdToUpdate();
//            System.out.println(ad.getAdUrl());
//            Document pageInHtml = UrlContentReader.readContentInJsoupDocument(ad.getAdUrl());
//            AutoPliusIndividualAdPageImpl<GsonDataBaseImpl> autoPliusIndividualAdPage = new AutoPliusIndividualAdPageImpl<>(pageInHtml, localJsonStorage, ad);
//            autoPliusIndividualAdPage.checkAdInWebsite();
//        }


    }

    public void parseFront(int numOfPages) {
        AutoPliusFrontPageService frontPageService = new AutoPliusFrontPageService();
        frontPageService.parseXManyPages(numOfPages);
    }
}
