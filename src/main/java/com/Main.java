package com;

import com.model.Ad;
import com.parser.jsoup.AutoPlius.page.front.AutoPliusFrontPageService;
import com.parser.jsoup.AutoPlius.page.inside.AutoPliusIndividualPageService;
import com.report.model.ReportGeneratorImpl;
import com.report.reports.R01;
import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;


public class Main {

    private final GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

    public static void main(String[] args){
        Main main = new Main();
        //main.parseFront(50);
        //main.parseIndividualAds(0, 6);
        //main.checkDb();
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
        ReportGeneratorImpl<R01, GsonDataBaseImpl> reportGenerator = new ReportGeneratorImpl<>(localJsonStorage);
        reportGenerator.generateReport();
        reportGenerator.printToConsole();
    }
}
