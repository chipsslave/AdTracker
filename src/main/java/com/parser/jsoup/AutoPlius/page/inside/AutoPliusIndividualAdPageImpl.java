package com.parser.jsoup.AutoPlius.page.inside;

import com.model.Ad;
import com.model.enums.AdStatus;
import com.storage.db.DataBase;
import org.jsoup.nodes.Document;

import java.time.LocalDateTime;

class AutoPliusIndividualAdPageImpl<T extends DataBase> extends AutoPliusIndividualAdPageParser {

    private T dataBase;
    private Ad ad;

    AutoPliusIndividualAdPageImpl(Document pageContentInHtml, T dataBase, Ad ad) {
        super(pageContentInHtml);
        this.dataBase = dataBase;
        this.ad = ad;
    }

    void checkAdAgainstWebsite() {

        if (parseAdStatus() == AdStatus.SOLD) {
            ad.setStatus(AdStatus.SOLD);
            ad.setSold(LocalDateTime.now());
        } else if (parseAdStatus() == AdStatus.UPDATED) {
            Ad parsedAd = getParsedAd();
            parsedAd.setFound(ad.getFound());
            parsedAd.setLastChecked(LocalDateTime.now());
            parsedAd.setStatus(AdStatus.UPDATED);
            dataBase.addNew(parsedAd);
        }


    }
}
