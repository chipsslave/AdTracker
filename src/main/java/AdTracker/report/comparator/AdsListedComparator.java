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
            return Integer.compare(reportItem.getAdsListed(), t1.getAdsListed());
        } else {
            return Integer.compare(t1.getAdsListed(), reportItem.getAdsListed());
        }
    }
}
