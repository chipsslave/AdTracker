package adtracker;

import adtracker.parser.jsoup.autoplius.front.AutoPliusFrontPageService;
import adtracker.parser.jsoup.autoplius.inside.AutoPliusIndividualPageService;
import adtracker.report.ReportGenerator;
import adtracker.report.ReportList;
import adtracker.report.comparator.AdsListedComparator;
import adtracker.storage.db.DataBaseFactory;
import adtracker.storage.db.GsonDataBaseImpl;


public class Main {

    private final GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

    public static void main(String[] args){
        Main main = new Main();
        //main.parseFront(50);
        main.parseIndividualAds(0, 6);
        main.genReport(ReportList.R01);
    }

    private void parseFront(int numOfPages) {
        AutoPliusFrontPageService frontPageService = new AutoPliusFrontPageService();
        frontPageService.parseXManyPages(numOfPages);
    }

    private void parseIndividualAds(int howOldDays, int howOldHours) {
        AutoPliusIndividualPageService autoPliusIndividualPageService = new AutoPliusIndividualPageService();
        autoPliusIndividualPageService.updateAdsInDatabase(howOldDays, howOldHours);
    }

    private void genReport(ReportList reportName) {
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.getReport(reportName, localJsonStorage.getAll(), new AdsListedComparator(true)).forEach(System.out::println);
    }
}
