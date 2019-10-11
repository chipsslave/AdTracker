package com.parser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public interface FrontPage {

    int countOfAdsFound(Elements elements);

    String parseAdId(Element adHtml);

    String parseAdUrl(Element adHtml);
}
