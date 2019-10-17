package adtracker.report;

import adtracker.model.Ad;
import adtracker.report.comparator.AdsListedComparator;
import adtracker.report.reports.r01.R01ReportItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@Ignore
public class ReportGeneratorTest {

    private List<Ad> adList = new ArrayList<>();

    private ReportGenerator reportGenerator = new ReportGenerator();

    private List<?> r01ReportItemsAscending = null;
    private List<?> r01ReportItemsDescending = null;

    private List<R01ReportItem> r01ReportItemsDescendingSuccess = null;

    private List<R01ReportItem> r01ReportItemsAscendingSuccess = null;

    @Before
    public void loadData() {
        Gson GSON = new Gson();
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("TESTS_DATA.json")).getFile());


        try {
            Reader reader = new FileReader(file);
            Type listType = new TypeToken<List<Ad>>() {
            }.getType();
            adList = GSON.fromJson(reader, listType);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        r01ReportItemsAscending = reportGenerator.getReport(ReportList.R01, adList, new AdsListedComparator(true));
        r01ReportItemsDescending = reportGenerator.getReport(ReportList.R01, adList, new AdsListedComparator(false));

        r01ReportItemsDescendingSuccess = Arrays.asList(
                new R01ReportItem("Ford", 3, 0, 0.0),
                new R01ReportItem("Volvo", 2, 0, 0.0),
                new R01ReportItem("Subaru", 1, 0, 0.0),
                new R01ReportItem("Nissan", 1, 0, 0.0)
        );

        r01ReportItemsAscendingSuccess = Arrays.asList(
                new R01ReportItem("Nissan", 1, 0, 0.0),
                new R01ReportItem("Subaru", 1, 0, 0.0),
                new R01ReportItem("Volvo", 2, 0, 0.0),
                new R01ReportItem("Ford", 3, 0, 0.0)
        );
    }

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
        List<Ad> r01ReportItemsFail = adList;
        r01ReportItemsFail.add(null);
        reportGenerator.getReport(ReportList.R01, r01ReportItemsFail, new AdsListedComparator(true));
    }

    @Test(expected = NullPointerException.class)
    public void checkIfNullValueThrowsExceptionDescending() {
        List<Ad> r01ReportItemsFail = adList;
        r01ReportItemsFail.add(null);
        reportGenerator.getReport(ReportList.R01, r01ReportItemsFail, new AdsListedComparator(false));
    }
}