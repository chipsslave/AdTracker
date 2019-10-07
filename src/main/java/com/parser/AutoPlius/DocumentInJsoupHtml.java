package com.parser.AutoPlius;

import org.jsoup.nodes.Document;

public class DocumentInJsoupHtml {
    private final Document pageInJsoupHtml;

    public DocumentInJsoupHtml(Document pageInJsoupHtml) {
        this.pageInJsoupHtml = pageInJsoupHtml;
    }

    protected Document getPageInJsoupHtml() {
        return pageInJsoupHtml;
    }
}
