package com.parser.jsoup.AutoPlius.page.front;

import com.model.Ad;
import com.model.ModelFactory;
import com.model.enums.AdStatus;
import com.parser.FrontPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AutoPliusFrontPageParser implements FrontPage {

    private Document pageContentInHtml;

    AutoPliusFrontPageParser(Document pageContentInHtml) {
        this.pageContentInHtml = pageContentInHtml;
    }

    @Override
    public int countOfAdsFound() {
        return pageContentInHtml.select("a[class^=announcement-item]").size();
    }

    @Override
    public String parseAdId(Element adInHtml) {
        Element element = adInHtml.selectFirst("div[class^=announcement-comment]");
        return element.attr("data-id");
    }

    @Override
    public String parseAdUrl(Element adInHtml) {
        Element element = adInHtml.selectFirst("a[class^=announcement-item]");
        return element.attr("href");
    }

    @Override
    public Elements getAdsInHtml() {
        return pageContentInHtml.select("a[class^=announcement-item]");
    }

    @Override
    public List<Ad> parseAds() {
        List<Ad> adList = new ArrayList<>();
        getAdsInHtml().forEach(adInHtml -> {
            adList.add(ModelFactory.getNewAdInstance(parseAdId(adInHtml), parseAdUrl(adInHtml), AdStatus.INTRODUCED, LocalDateTime.now()));
        });
        return adList;
    }
}
