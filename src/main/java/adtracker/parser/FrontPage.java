package adtracker.parser;

import adtracker.model.Ad;
import adtracker.model.enums.AdStatus;
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
