package AdTracker.report.comparator;

import AdTracker.report.ReportItem;

import java.util.Comparator;

public class AdsListedComparator implements Comparator<ReportItem> {

    private boolean ascending;

    public AdsListedComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(ReportItem reportItem, ReportItem t1) {
        if (ascending) {
            if (reportItem.getAdsListed() > t1.getAdsListed()) {
                return 1;
            }
            if (reportItem.getAdsListed() < t1.getAdsListed()) {
                return -1;
            }
        } else {
            if (reportItem.getAdsListed() > t1.getAdsListed()) {
                return -1;
            }
            if (reportItem.getAdsListed() < t1.getAdsListed()) {
                return 1;
            }
        }
        return 0;
    }
}
