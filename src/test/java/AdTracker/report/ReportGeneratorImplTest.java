package AdTracker.report;

import AdTracker.model.Ad;
import AdTracker.report.reports.r01.R01ReportItem;
import AdTracker.storage.db.DataBaseFactory;
import AdTracker.storage.db.GsonDataBaseImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReportGeneratorImplTest {

    private final GsonDataBaseImpl adsDataBase = DataBaseFactory.getDataBaseInstance("TESTS_DATA.json");

    private List<R01ReportItem> r01ReportItems = ReportGeneratorImpl.genReport01(adsDataBase.getAll());

    private List<R01ReportItem> r01ReportSuccess = Arrays.asList(
            new R01ReportItem("Volvo", 2, 0, 0.0),
            new R01ReportItem("Nissan", 1, 0, 0.0),
            new R01ReportItem("Ford", 3, 0, 0.0),
            new R01ReportItem("Subaru", 1, 0, 0.0)
    );

    @Test
    public void checkIfReportIsAsExpected() {
        assertEquals(r01ReportItems.get(0), r01ReportSuccess.get(0));
        assertEquals(r01ReportItems.get(1), r01ReportSuccess.get(1));
        assertEquals(r01ReportItems.get(2), r01ReportSuccess.get(2));
        assertEquals(r01ReportItems.get(3), r01ReportSuccess.get(3));
    }

    @Test
    public void checkReportSize() {
        assertEquals(r01ReportSuccess.size(), r01ReportItems.size());
    }

    @Test(expected = NullPointerException.class)
    public void checkIfNullValueThrowsException() {
        List<Ad> r01ReportItemsFail = adsDataBase.getAll();
        r01ReportItemsFail.add(null);
        ReportGeneratorImpl.genReport01(r01ReportItemsFail);
    }
}