package com;

import com.model.Ad;
import com.parser.jsoup.AutoPlius.page.front.AutoPliusFrontPageService;
import com.parser.jsoup.AutoPlius.page.inside.AutoPliusIndividualPageService;
import com.report.Report;
import com.report.ReportGenerator;
import com.report.comparator.ReportAdsSoldComparator;
import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;

import java.util.Collections;


public class Main {

    public static void main(String[] args){
        Main main = new Main();
        main.parseFront(50);
        main.parseIndividualAds(0, 6);
        main.report();
        //main.checkDb();
    }

    private void parseFront(int numOfPages) {
        AutoPliusFrontPageService frontPageService = new AutoPliusFrontPageService();
        frontPageService.parseXManyPages(numOfPages);
    }

    private void parseIndividualAds(int howOldDays, int howOldHours) {
        AutoPliusIndividualPageService autoPliusIndividualPageService = new AutoPliusIndividualPageService();
        autoPliusIndividualPageService.updateAdsInDatabase(howOldDays, howOldHours);
    }

    public void report() {
        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateDataSet();
        Collections.sort(reportGenerator.getReportList(), new ReportAdsSoldComparator());
        for (Report report : reportGenerator.getReportList()) {
            System.out.println(report);
        }
    }

    public void checkDb() {
        GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();

//        for (Ad ad : localJsonStorage.getAll()){
//            if (ad.getCar().getMake() == null){
//                localJsonStorage.delete(ad);
//            }
//        }

        localJsonStorage.commit();

        for (Ad ad : localJsonStorage.getAll()) {
            if (ad.getCar().getMake() == null) {
                System.out.println(ad);
            }
        }
    }
}
