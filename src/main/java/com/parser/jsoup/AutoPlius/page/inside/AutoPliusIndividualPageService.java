package com.parser.jsoup.AutoPlius.page.inside;

import com.model.Ad;
import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;
import com.util.UrlContentReader;
import org.jsoup.nodes.Document;

public class AutoPliusIndividualPageService {
    private final GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

    public void updateAdsInDatabase(int howOldDays, int howOldHours) {

        String tempURL = "";

        while (localJsonStorage.getAdToUpdate(howOldDays, howOldHours) != null) {
            Ad ad = localJsonStorage.getAdToUpdate(howOldDays, howOldHours);


            if (!tempURL.equals(ad.getAdUrl())) {
                System.out.println(ad.getAdUrl());

                Document pageInHtml = UrlContentReader.readContentInJsoupDocument(ad.getAdUrl());

                AutoPliusIndividualAdPageImpl<GsonDataBaseImpl> autoPliusIndividualAdPage = new AutoPliusIndividualAdPageImpl<>(pageInHtml, localJsonStorage, ad);
                autoPliusIndividualAdPage.checkAdAgainstWebsite();

                tempURL = ad.getAdUrl();
                localJsonStorage.commit();
            } else {
                break;
            }
        }
        localJsonStorage.commit();
    }
}
