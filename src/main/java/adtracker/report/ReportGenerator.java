package adtracker.report;

import adtracker.model.Ad;
import adtracker.report.reports.r01.R01;
import adtracker.report.reports.r02.R02;

import java.util.Comparator;
import java.util.List;

public class ReportGenerator {

    public List<?> getReport(ReportList reportName, List<Ad> data, Comparator<ReportItem> comparator) {
        switch (reportName) {
            case R01:
                return new R01().generateListOfReportItems(data, comparator);
            case R02:
                return new R02().generateListOfReportItems(data, comparator);
        }

        return null;
    }

}
