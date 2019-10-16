package AdTracker.report.comparator;

import AdTracker.report.ReportItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AdsListedComparatorTest {

    @Test
    public void compare() {
        List<ReportItem> reportItems = new ArrayList<>();
        reportItems.add(new ReportItem(5, 2, 0.0));
        reportItems.add(new ReportItem(4, 2, 0.0));
        reportItems.add(new ReportItem(-2, 2, 0.0));
        reportItems.add(new ReportItem(7, 2, 0.0));
        reportItems.add(new ReportItem(0, 2, 0.0));
    }
}