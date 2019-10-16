package AdTracker.report;


import AdTracker.model.Ad;

import java.util.List;

public interface Report<T extends ReportItem> {

    List<T> generateListOfReportItems(List<Ad> adsList);
}
