package AdTracker.parser;

import AdTracker.model.Ad;
import AdTracker.model.enums.AdStatus;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public interface FrontPage {

    int countOfAdsFound();

    String parseAdId(Element adInHtml);

    String parseAdUrl(Element adInHtml);

    Elements getAdsInHtml();

    List<Ad> parseAds();

    AdStatus parseAdStatus(Element adInHtml);
}
