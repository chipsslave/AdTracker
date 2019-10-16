package AdTracker;

import AdTracker.model.Ad;
import AdTracker.parser.jsoup.AutoPlius.page.front.AutoPliusFrontPageService;
import AdTracker.parser.jsoup.AutoPlius.page.inside.AutoPliusIndividualPageService;
import AdTracker.report.ReportGeneratorImpl;
import AdTracker.report.reports.r01.R01ReportItem;
import AdTracker.storage.db.DataBaseFactory;
import AdTracker.storage.db.GsonDataBaseImpl;

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

    public void checkDb() {
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

    public void genReport() {
        List<R01ReportItem> r01ReportItems = ReportGeneratorImpl.genReport01(localJsonStorage.getAll());
        //Collections.sort(r01ReportItems, new AdsListedComparator());
        for (R01ReportItem r : r01ReportItems) {
            System.out.println(r);
        }
    }
}
