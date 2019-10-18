package adtracker.report.reports.r01;

import adtracker.model.Ad;
import adtracker.model.enums.AdStatus;
import adtracker.report.Report;
import adtracker.report.ReportItem;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class R01 implements Report<R01ReportItem> {

    @Override
    public List<R01ReportItem> generateListOfReportItems(List<Ad> adsList, Comparator<ReportItem> comparator) {
        List<R01ReportItem> items = new ArrayList<>();
        for (Ad ad : adsList) {
            boolean found = false;
            for (R01ReportItem item : items) {
                if (item != null) {
                    if (item.getMake().equals(ad.getCar().getMake())) {
                        if (ad.getStatus().equals(AdStatus.SOLD)) {
                            item.setAdsSold(item.getAdsSold() + 1);
                            Duration duration = Duration.between(ad.getSold(), ad.getFound());
                            long soldInDays = Math.abs(duration.toDays());
                            item.pushSaleInDays(soldInDays);
                        }
                        found = true;
                        item.setAdsListed(item.getAdsListed() + 1);
                    }
                }
            }
            if (!found) {
                if (ad.getStatus().equals(AdStatus.SOLD)) {
                    items.add(new R01ReportItem(ad.getCar().getMake(), 1, 1, 0.0));
                } else {
                    items.add(new R01ReportItem(ad.getCar().getMake(), 1, 0, 0.0));
                }

            }

        }
        items.sort(comparator);
        return items;
    }
}
