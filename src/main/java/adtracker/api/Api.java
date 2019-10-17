package adtracker.api;

import adtracker.model.Ad;
import adtracker.storage.db.DataBase;
import org.jsoup.nodes.Document;

public interface Api<T extends DataBase> {

    T getDataBaseInstance();

    void checkFrontPageForNewAds(Document pageContentInHtml, T dataBase);

    Ad getAdToUpdate();

    void updateAd(Document pageContentInHtml, T dataBase, Ad ad);
}
