package adtracker.report;


import adtracker.model.Ad;

import java.util.Comparator;
import java.util.List;

public interface Report<T extends ReportItem> {

    List<T> generateListOfReportItems(List<Ad> adsList, Comparator<ReportItem> comparator);
}
