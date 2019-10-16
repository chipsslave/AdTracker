package com.report.generator;

import com.report.model.ReportGeneratorImpl;

public abstract class ReportGenerator {

    public abstract ReportGeneratorImpl generateReport();

    public void generateDataSet() {
//        for (Ad ad : localJsonStorage.getAll()) {
//            boolean found = false;
//            for (CarReport carReport : carReportList) {
//                if (carReport != null) {
//                    if (carReport.getMake().equals(ad.getCar().getMake()) &&
//                            carReport.getModel().equals(ad.getCar().getModel()) &&
//                            carReport.getBodyType().equals(ad.getCar().getBodyType()) &&
//                            carReport.getFuelType().equals(ad.getCar().getFuelType())) {
//                        if (ad.getStatus().equals(AdStatus.SOLD)) {
//                            carReport.increaseAdsListed();
//                            carReport.increaseAdsSold();
//                            found = true;
//                        } else {
//                            carReport.increaseAdsListed();
//                            found = true;
//                        }
//                    }
//                }
//            }
//            if (!found) {
//                if (ad.getStatus().equals(AdStatus.SOLD)) {
//                    carReportList.add(new CarReport(ad.getCar().getMake(), ad.getCar().getModel(), ad.getCar().getFuelType(), ad.getCar().getBodyType(), 1, 1));
//                } else {
//                    carReportList.add(new CarReport(ad.getCar().getMake(), ad.getCar().getModel(), ad.getCar().getFuelType(), ad.getCar().getBodyType(), 1, 0));
//                }
//
//            }
//
//        }
    }
}
