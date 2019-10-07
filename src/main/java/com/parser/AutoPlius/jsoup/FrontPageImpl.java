package com.parser.AutoPlius.jsoup;

import com.parser.AutoPlius.DocumentInJsoupHtml;
import com.parser.AutoPlius.FrontPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FrontPageImpl extends DocumentInJsoupHtml implements FrontPage {

    private Elements adsInHtml;

    public FrontPageImpl(Document pageInHtml) {
        super(pageInHtml);
        this.adsInHtml = getPageInJsoupHtml().select("a[class^=announcement-item]");
    }

    public Elements getAdsInHtml() {
        return adsInHtml;
    }

    @Override
    public int countOfAdsFound(){
        Elements elements = getPageInJsoupHtml().select("a[class^=announcement-item]");

        return elements.size();
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
