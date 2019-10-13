package com.parser.jsoup.AutoPlius.page.front;

import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;
import com.util.UrlContentReader;
import org.jsoup.nodes.Document;

public class AutoPliusFrontPageService {
    private final String URL_BASE = "https://en.autoplius.lt/ads/used-cars?page_nr=";
    private final int START_PAGE_NUM = 1;
    private final GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

    public void parseXManyPages(int numOfPAgesToParse) {
        for (int i = START_PAGE_NUM; i <= numOfPAgesToParse; i++) {
            Document pageInHtml = UrlContentReader.readContentInJsoupDocument(URL_BASE + i);
            AutoPliusFrontPageImpl<GsonDataBaseImpl> parser = new AutoPliusFrontPageImpl<>(pageInHtml, localJsonStorage);

            parser.collectAds();
        }

        localJsonStorage.commit();
    }
}
