package com.parser.AutoPlius;

import org.jsoup.nodes.Element;

public interface FrontPage {
    int countOfAdsFound();

    String parseAdId(Element adHtml);

    String parseAdUrl(Element adHtml);
}
