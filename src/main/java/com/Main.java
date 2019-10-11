package com;

import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;
import com.util.UrlContentReader;
import org.jsoup.nodes.Document;


public class Main {

    // https://en.autoplius.lt/ads/volkswagen-touareg-4-1-l-suv-off-road-2010-diesel-9605847.html

    public static void main(String[] args){
        GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

        Document pageHtml = UrlContentReader.readContentInJsoupDocument("https://autoplius.lt/skelbimai/toyota-corolla-1-6-l-hecbekas-2003-benzinas-9652197.html");

//        AutoPliusFrontPageImpl<GsonDataBaseImpl> autoPliusFrontPage = new AutoPliusFrontPageImpl<>(pageHtml, localJsonStorage);
//
//        System.out.println(autoPliusFrontPage.countOfAdsFound());
//        autoPliusFrontPage.collectNewAds();
//        localJsonStorage.commit();

//        AutoPliusIndividualAdPageImpl<GsonDataBaseImpl> autoPliusIndividualAdPage = new AutoPliusIndividualAdPageImpl<>(pageHtml, localJsonStorage);
//        System.out.println(autoPliusIndividualAdPage.parseAdId());


//        IndAd indAd = new IndAd(2, store);
//        Manager manager = new Manager(15, store);
//
//        Saver saver = new Saver(localJsonStorage);
//
//        front.start();
//        indAd.start();
//        manager.start();
//        saver.start();

    }
}
