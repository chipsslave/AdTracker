package AdTracker.api;

import AdTracker.model.Ad;
import AdTracker.storage.db.DataBase;
import org.jsoup.nodes.Document;

public interface Api<T extends DataBase> {

    T getDataBaseInstance();

    void checkFrontPageForNewAds(Document pageContentInHtml, T dataBase);

    Ad getAdToUpdate();

    void updateAd(Document pageContentInHtml, T dataBase, Ad ad);
}
