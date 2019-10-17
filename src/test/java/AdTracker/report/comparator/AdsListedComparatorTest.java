package AdTracker.report.comparator;

import AdTracker.report.ReportItem;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdsListedComparatorTest {
    private List<ReportItem> testDataSuccess = Arrays.asList(
            new ReportItem(5, 2, 0.0),
            new ReportItem(8, 2, 0.0),
            new ReportItem(34, 2, 0.0),
            new ReportItem(0, 2, 0.0),
            new ReportItem(-3, 2, 0.0)
    );

    private List<ReportItem> sortedAscendingReportItems = Arrays.asList(
            new ReportItem(-3, 2, 0.0),
            new ReportItem(0, 2, 0.0),
            new ReportItem(5, 2, 0.0),
            new ReportItem(8, 2, 0.0),
            new ReportItem(34, 2, 0.0)
    );

    private List<ReportItem> sortedDescendingReportItems = Arrays.asList(
            new ReportItem(34, 2, 0.0),
            new ReportItem(8, 2, 0.0),
            new ReportItem(5, 2, 0.0),
            new ReportItem(0, 2, 0.0),
            new ReportItem(-3, 2, 0.0)
    );

    @Test
    public void compareAscending() {
        testDataSuccess.sort(new AdsListedComparator(true));
        assertEquals(testDataSuccess.get(0), sortedAscendingReportItems.get(0));
        assertEquals(testDataSuccess.get(1), sortedAscendingReportItems.get(1));
        assertEquals(testDataSuccess.get(2), sortedAscendingReportItems.get(2));
        assertEquals(testDataSuccess.get(3), sortedAscendingReportItems.get(3));
        assertEquals(testDataSuccess.get(4), sortedAscendingReportItems.get(4));
        assertEquals(testDataSuccess.size(), sortedAscendingReportItems.size());
    }

    @Test
    public void compareDescending() {
        testDataSuccess.sort(new AdsListedComparator(false));
        assertEquals(testDataSuccess.get(0), sortedDescendingReportItems.get(0));
        assertEquals(testDataSuccess.get(1), sortedDescendingReportItems.get(1));
        assertEquals(testDataSuccess.get(2), sortedDescendingReportItems.get(2));
        assertEquals(testDataSuccess.get(3), sortedDescendingReportItems.get(3));
        assertEquals(testDataSuccess.get(4), sortedDescendingReportItems.get(4));
        assertEquals(testDataSuccess.size(), sortedDescendingReportItems.size());
    }
}