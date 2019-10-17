package adtracker.report.reports.r02;

import adtracker.model.Ad;
import adtracker.model.enums.AdStatus;
import adtracker.report.Report;
import adtracker.report.ReportItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class R02 implements Report<R02ReportItem> {
    @Override
    public List<R02ReportItem> generateListOfReportItems(List<Ad> adsList, Comparator<ReportItem> comparator) {
        List<R02ReportItem> items = new ArrayList<>();
        for (Ad ad : adsList) {
            boolean found = false;
            for (R02ReportItem item : items) {
                if (item != null) {
                    if (item.getMake().equals(ad.getCar().getMake()) && item.getModel().equals(ad.getCar().getModel())) {
                        if (ad.getStatus().equals(AdStatus.SOLD)) {
                            item.setAdsSold(item.getAdsSold() + 1);
                        }
                        found = true;
                        item.setAdsListed(item.getAdsListed() + 1);
                    }
                }
            }
            if (!found) {
                if (ad.getStatus().equals(AdStatus.SOLD)) {
                    items.add(new R02ReportItem(ad.getCar().getMake(), ad.getCar().getModel(), 1, 1, 0.0));
                } else {
                    items.add(new R02ReportItem(ad.getCar().getMake(), ad.getCar().getModel(), 1, 0, 0.0));
                }

            }

        }
        items.sort(comparator);
        return items;
    }
}
