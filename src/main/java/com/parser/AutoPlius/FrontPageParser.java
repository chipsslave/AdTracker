package com.parser.AutoPlius;

import com.parser.FrontPage;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FrontPageParser implements FrontPage {
    @Override
    public int countOfAdsFound(Elements elements) {
        return elements.size();
    }

    @Override
    public String parseAdId(Element adHtml) {
        return null;
    }

    @Override
    public String parseAdUrl(Element adHtml) {
        return null;
    }
}
