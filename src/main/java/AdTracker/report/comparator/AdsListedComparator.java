package AdTracker.report.comparator;

import AdTracker.report.ReportItem;

import java.util.Comparator;

public class AdsListedComparator implements Comparator<ReportItem> {

    @Override
    public int compare(ReportItem reportItem, ReportItem t1) {
        if (reportItem.getAdsListed() > t1.getAdsListed()) {
            return 1;
        }
        if (reportItem.getAdsListed() < t1.getAdsListed()) {
            return -1;
        }
        return 0;
    }
}
