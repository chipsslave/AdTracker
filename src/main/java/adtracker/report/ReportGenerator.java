package adtracker.report;

import adtracker.model.Ad;
import adtracker.report.reports.r01.R01;
import adtracker.report.reports.r01.R01ReportItem;

import java.util.Comparator;
import java.util.List;

public class ReportGenerator {

    public static List<R01ReportItem> genReport01(List<Ad> data, Comparator<ReportItem> comparator) {
        return new R01().generateListOfReportItems(data, comparator);
    }

}
