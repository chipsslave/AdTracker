package adtracker.parser.jsoup.AutoPlius.page.front;

import adtracker.model.Ad;
import adtracker.model.enums.AdStatus;
import adtracker.storage.db.DataBase;
import org.jsoup.nodes.Document;

import java.time.LocalDateTime;
import java.util.List;


class AutoPliusFrontPageImpl<T extends DataBase> extends AutoPliusFrontPageParser {

    private T dataBase;

    AutoPliusFrontPageImpl(Document pageContentInHtml, T dataBase) {
        super(pageContentInHtml);
        this.dataBase = dataBase;
    }

    void collectAds() {
        List<Ad> parsedAds = parseAds();
        for (Ad ad : parsedAds) {
            Ad adInDatabase = dataBase.getById(ad.getAdId());

            if (ad.getStatus().equals(AdStatus.INTRODUCED)) {
                if (!adExistsInStorage(ad)) {
                    dataBase.addNew(ad);
                }
            }

            if (ad.getStatus().equals(AdStatus.SOLD)) {
                if (adExistsInStorage(ad) && !adInDatabase.getStatus().equals(AdStatus.SOLD)) {
                    adInDatabase.setStatus(AdStatus.SOLD);
                    adInDatabase.setSold(LocalDateTime.now());
                }
            }
        }
    }

    private boolean adExistsInStorage(Ad ad) {
        return dataBase.getById(ad.getAdId()) != null;
    }
}
