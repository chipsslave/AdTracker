package adtracker.parser.jsoup.AutoPlius.page.front;

import adtracker.model.Ad;
import adtracker.model.ModelFactory;
import adtracker.model.enums.AdStatus;
import adtracker.parser.FrontPage;
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
            adList.add(ModelFactory.getNewAdInstance(parseAdId(adInHtml), parseAdUrl(adInHtml), parseAdStatus(adInHtml), LocalDateTime.now()));
        });
        return adList;
    }

    @Override
    public AdStatus parseAdStatus(Element adInHtml) {
        String adStatus = adInHtml.select("div[class^=announcement-badge]").text().trim();
        if (adStatus.equals("Sold!")) {
            return AdStatus.SOLD;
        }
        return AdStatus.INTRODUCED;
    }
}
