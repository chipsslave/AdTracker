package com.report;

import com.model.Ad;
import com.model.enums.AdStatus;
import com.storage.db.DataBaseFactory;
import com.storage.db.GsonDataBaseImpl;

import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {
    private final GsonDataBaseImpl localJsonStorage = DataBaseFactory.getDataBaseInstance();
    private final List<Report> reportList = new ArrayList<>();

    public ReportGenerator() {
    }

    public void generateDataSet() {
        for (Ad ad : localJsonStorage.getAll()) {
            boolean found = false;
            for (Report report : reportList) {
                if (report != null) {
                    if (report.getMake().equals(ad.getCar().getMake()) &&
                            report.getModel().equals(ad.getCar().getModel()) &&
                            report.getBodyType().equals(ad.getCar().getBodyType()) &&
                            report.getFuelType().equals(ad.getCar().getFuelType())) {
                        if (ad.getStatus().equals(AdStatus.SOLD)) {
                            report.increaseAdsListed();
                            report.inreaseAdsSold();
                            found = true;
                        } else {
                            report.increaseAdsListed();
                            found = true;
                        }
                    }
                }
            }
            if (!found) {
                if (ad.getStatus().equals(AdStatus.SOLD)) {
                    reportList.add(new Report(ad.getCar().getMake(), ad.getCar().getModel(), ad.getCar().getFuelType(), ad.getCar().getBodyType(), 1, 1));
                } else {
                    reportList.add(new Report(ad.getCar().getMake(), ad.getCar().getModel(), ad.getCar().getFuelType(), ad.getCar().getBodyType(), 1, 0));
                }

            }

        }
    }

    public List<Report> getReportList() {
        return reportList;
    }
}
