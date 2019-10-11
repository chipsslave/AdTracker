package com.parser.jsoup.AutoPlius.page.front;

import com.model.Ad;
import com.model.enums.AdStatus;
import com.storage.db.DataBase;
import org.jsoup.nodes.Document;


public class AutoPliusFrontPageImpl<T extends DataBase> extends AutoPliusFrontPageParser {

    private T dataBase;

    public AutoPliusFrontPageImpl(Document pageContentInHtml, T dataBase) {
        super(pageContentInHtml);
        this.dataBase = dataBase;
    }

    public void collectNewAds() {
        parseAds().forEach(ad -> {
            if (!adExistsInStorage(ad)) {
                dataBase.addNew(ad);
            }
            if (ad.getStatus() == AdStatus.SOLD) {
                dataBase.getById(ad.getAdId()).setStatus(ad.getStatus());
            }

        });
    }

    public boolean adExistsInStorage(Ad ad) {
        return dataBase.getById(ad.getAdId()) != null;
    }
}
