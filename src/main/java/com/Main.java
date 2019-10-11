package com;

import com.model.Ad;
import com.parser.jsoup.AutoPlius.page.inside.AutoPliusIndividualAdPageImpl;
import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;
import com.util.UrlContentReader;
import org.jsoup.nodes.Document;


public class Main {

    // https://en.autoplius.lt/ads/volkswagen-touareg-4-1-l-suv-off-road-2010-diesel-9605847.html

    public static void main(String[] args){
        Main main = new Main();
        GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

        while (localJsonStorage.getAdToUpdate() != null) {
            Ad ad = localJsonStorage.getAdToUpdate();
            System.out.println(ad.getAdUrl());
            Document pageInHtml = UrlContentReader.readContentInJsoupDocument(ad.getAdUrl());
            AutoPliusIndividualAdPageImpl<GsonDataBaseImpl> autoPliusIndividualAdPage = new AutoPliusIndividualAdPageImpl<>(pageInHtml, localJsonStorage, ad);
            autoPliusIndividualAdPage.checkAdInWebsite();
        }

        localJsonStorage.commit();


    }
}
