package com.parser.AutoPlius;

import com.parser.FrontPage;
import com.util.UrlContentReader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AutoPliusFrontPageImpl implements FrontPage {

    private Elements adsInHtml;

    public AutoPliusFrontPageImpl(String target) {
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
