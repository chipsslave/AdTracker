package adtracker;

import adtracker.model.Ad;
import adtracker.parser.jsoup.autoplius.front.AutoPliusFrontPageService;
import adtracker.parser.jsoup.autoplius.inside.AutoPliusIndividualPageService;
import adtracker.report.ReportGenerator;
import adtracker.report.comparator.AdsListedComparator;
import adtracker.report.reports.r01.R01ReportItem;
import adtracker.storage.db.DataBaseFactory;
import adtracker.storage.db.GsonDataBaseImpl;

import java.util.List;


public class Main {

    private final GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

    public static void main(String[] args){
        Main main = new Main();
//        main.parseFront(50);
//        main.parseIndividualAds(0, 6);
//        main.checkDb();
        main.genReport();
    }

    private void parseFront(int numOfPages) {
        AutoPliusFrontPageService frontPageService = new AutoPliusFrontPageService();
        frontPageService.parseXManyPages(numOfPages);
    }

    private void parseIndividualAds(int howOldDays, int howOldHours) {
        AutoPliusIndividualPageService autoPliusIndividualPageService = new AutoPliusIndividualPageService();
        autoPliusIndividualPageService.updateAdsInDatabase(howOldDays, howOldHours);
    }

    private void checkDb() {
        GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

//        for (Ad ad : localJsonStorage.getAll()) {
//            if (ad.getCar().getMake() == null) {
//                localJsonStorage.delete(ad);
//            }
//        }
//
//        localJsonStorage.commit();

        for (Ad ad : localJsonStorage.getAll()) {
            if (ad.getCar().getMake() == null) {
                System.out.println(ad);
            }
        }
    }

    private void genReport() {
        List<R01ReportItem> r01ReportItems = ReportGenerator.getReport(localJsonStorage.getAll(), new AdsListedComparator(true));
        r01ReportItems.forEach(System.out::println);
    }
}
