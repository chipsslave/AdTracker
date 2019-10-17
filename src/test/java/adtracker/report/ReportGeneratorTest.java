package adtracker.report;

import adtracker.model.Ad;
import adtracker.report.comparator.AdsListedComparator;
import adtracker.report.reports.r01.R01ReportItem;
import adtracker.storage.db.DataBaseFactory;
import adtracker.storage.db.GsonDataBaseImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReportGeneratorTest {

    private final GsonDataBaseImpl adsDataBase = DataBaseFactory.getDataBaseInstance("src/test/java/resource/TESTS_DATA.json");

    private List<R01ReportItem> r01ReportItemsAscending = ReportGenerator.genReport01(adsDataBase.getAll(), new AdsListedComparator(true));
    private List<R01ReportItem> r01ReportItemsDescending = ReportGenerator.genReport01(adsDataBase.getAll(), new AdsListedComparator(false));

    private List<R01ReportItem> r01ReportItemsDescendingSuccess = Arrays.asList(
            new R01ReportItem("Ford", 3, 0, 0.0),
            new R01ReportItem("Volvo", 2, 0, 0.0),
            new R01ReportItem("Subaru", 1, 0, 0.0),
            new R01ReportItem("Nissan", 1, 0, 0.0)
    );

    private List<R01ReportItem> r01ReportItemsAscendingSuccess = Arrays.asList(
            new R01ReportItem("Nissan", 1, 0, 0.0),
            new R01ReportItem("Subaru", 1, 0, 0.0),
            new R01ReportItem("Volvo", 2, 0, 0.0),
            new R01ReportItem("Ford", 3, 0, 0.0)
    );

    @Test
    public void checkIfReportIsAsExpected() {
        assertEquals(r01ReportItemsDescending.get(0), r01ReportItemsDescendingSuccess.get(0));
        assertEquals(r01ReportItemsDescending.get(1), r01ReportItemsDescendingSuccess.get(1));
        assertEquals(r01ReportItemsDescending.get(2), r01ReportItemsDescendingSuccess.get(2));
        assertEquals(r01ReportItemsDescending.get(3), r01ReportItemsDescendingSuccess.get(3));

        assertEquals(r01ReportItemsAscending.get(0), r01ReportItemsAscendingSuccess.get(0));
        assertEquals(r01ReportItemsAscending.get(1), r01ReportItemsAscendingSuccess.get(1));
        assertEquals(r01ReportItemsAscending.get(2), r01ReportItemsAscendingSuccess.get(2));
        assertEquals(r01ReportItemsAscending.get(3), r01ReportItemsAscendingSuccess.get(3));
    }

    @Test
    public void checkReportSize() {
        assertEquals(r01ReportItemsAscendingSuccess.size(), r01ReportItemsAscending.size());
        assertEquals(r01ReportItemsDescendingSuccess.size(), r01ReportItemsDescending.size());
    }

    @Test(expected = NullPointerException.class)
    public void checkIfNullValueThrowsExceptionAscending() {
        List<Ad> r01ReportItemsFail = adsDataBase.getAll();
        r01ReportItemsFail.add(null);
        ReportGenerator.genReport01(r01ReportItemsFail, new AdsListedComparator(true));
    }

    @Test(expected = NullPointerException.class)
    public void checkIfNullValueThrowsExceptionDescending() {
        List<Ad> r01ReportItemsFail = adsDataBase.getAll();
        r01ReportItemsFail.add(null);
        ReportGenerator.genReport01(r01ReportItemsFail, new AdsListedComparator(false));
    }
}