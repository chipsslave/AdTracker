package com.parser.jsoup.AutoPlius.page.front;

import com.model.Ad;
import com.model.enums.AdStatus;
import com.storage.db.DataBase;
import org.jsoup.nodes.Document;

import java.time.LocalDateTime;
import java.util.List;


public class AutoPliusFrontPageImpl<T extends DataBase> extends AutoPliusFrontPageParser {

    private T dataBase;

    AutoPliusFrontPageImpl(Document pageContentInHtml, T dataBase) {
        super(pageContentInHtml);
        this.dataBase = dataBase;
    }

    void collectAds() {
        List<Ad> parsedAds = parseAds();
        for (Ad ad : parsedAds) {
            Ad adInDatabase = dataBase.getById(ad.getAdId());

            if (adExistsInStorage(ad)) {
                if (ad.getStatus() == AdStatus.SOLD) {
                    if (adInDatabase.getStatus() != AdStatus.SOLD) {
                        adInDatabase.setStatus(AdStatus.SOLD);
                        adInDatabase.setSold(LocalDateTime.now());
                    }
                }
            } else {
                dataBase.addNew(ad);
            }
        }
    }

    private boolean adExistsInStorage(Ad ad) {
        return dataBase.getById(ad.getAdId()) != null;
    }
}
