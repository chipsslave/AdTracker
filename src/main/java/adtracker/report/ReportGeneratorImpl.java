package adtracker.report;

import adtracker.model.Ad;
import adtracker.report.reports.r01.R01;
import adtracker.report.reports.r01.R01ReportItem;

import java.util.List;

public class ReportGeneratorImpl {

    public static List<R01ReportItem> genReport01(List<Ad> data) {
        return (new R01()).generateListOfReportItems(data);
    }

}
