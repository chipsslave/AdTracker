package AdTracker.report;

import AdTracker.model.Ad;
import AdTracker.report.reports.r01.R01;
import AdTracker.report.reports.r01.R01ReportItem;

import java.util.List;

public class ReportGeneratorImpl {

    public static List<R01ReportItem> genReport01(List<Ad> data) {
        return (new R01()).generateListOfReportItems(data);
    }

}
