package adtracker.report.comparator;

import adtracker.report.ReportItem;

import java.util.Comparator;

public class AdsAverageSaleTimeComparator implements Comparator<ReportItem> {

    private boolean ascending;

    AdsAverageSaleTimeComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(ReportItem reportItem, ReportItem t1) {

        if (ascending) {
            return Double.compare(reportItem.getAvgSaleTimeInDays(), t1.getAvgSaleTimeInDays());
        } else {
            return Double.compare(t1.getAvgSaleTimeInDays(), reportItem.getAvgSaleTimeInDays());
        }
    }
}
