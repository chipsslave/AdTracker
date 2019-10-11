package com.parser.jsoup.AutoPlius.page.front;

import com.storage.db.DataBase;
import org.jsoup.nodes.Document;


public class AutoPliusFrontPageImpl<T extends DataBase> extends AutoPliusFrontPageParser {

    private T dataBase;

    public AutoPliusFrontPageImpl(Document pageContentInHtml, T database) {
        super(pageContentInHtml);
        this.dataBase = database;
    }

    public void collectNewAds() {
        parseAds().forEach(ad -> {
            if (dataBase.getById(ad.getAdId()) == null) {
                dataBase.addNew(ad);
                System.out.println("new ad found: " + ad.getAdUrl());
            }
        });
    }
}
