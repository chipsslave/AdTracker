package adtracker.report.comparator;

import adtracker.report.ReportItem;

import java.util.Comparator;

public class ComparatorFactory {

    public static Comparator<ReportItem> getComparator(ComparatorsList comparator, boolean ascending) {
        switch (comparator) {
            case AdsListedComparator:
                return new AdsListedComparator(ascending);
            case AdsAverageSaleTimeComparator:
                return new AdsAverageSaleTimeComparator(ascending);
        }
        return null;
    }
}
