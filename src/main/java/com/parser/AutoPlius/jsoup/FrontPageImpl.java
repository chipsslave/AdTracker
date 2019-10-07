package com.parser.AutoPlius.jsoup;

import com.html.UrlContentReader;
import com.parser.AutoPlius.FrontPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FrontPageImpl implements FrontPage {

    private Elements adsInHtml;

    public FrontPageImpl(String target) {
        Document urlJsoupContent = UrlContentReader.readContentInJsoupDocument(target);
        this.adsInHtml = urlJsoupContent.select("a[class^=announcement-item]");
    }

    public Elements getAdsInHtml() {
        return adsInHtml;
    }

    @Override
    public int countOfAdsFound(){
        return adsInHtml.size();
    }

    @Override
    public String parseAdId(Element adHtml){
        Element element = adHtml.selectFirst("div[class^=announcement-comment]");
        return element.attr("data-id");
    }

    @Override
    public String parseAdUrl(Element adHtml){
        Element element = adHtml.selectFirst("a[class^=announcement-item]");
        return element.attr("href");
    }
}
