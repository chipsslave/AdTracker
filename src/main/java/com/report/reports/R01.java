package com.report.reports;

import com.model.Ad;
import com.model.enums.AdStatus;

import java.util.ArrayList;
import java.util.List;

public class R01 implements Report<R01> {
    private String make;

    private int adsListed = 0;
    private int adsSold = 0;
    private double avgSaleTime;

    public R01(String make) {
        this.make = make;
    }

    public R01(String make, int adsListed, int adsSold) {
        this.make = make;
        this.adsListed = adsListed;
        this.adsSold = adsSold;
    }

    public String getMake() {
        return make;
    }

    public void increaseAdsListed() {
        adsListed++;
    }

    public void increaseAdsSold() {
        adsSold++;
    }

    @Override
    public List<R01> genRep(List<Ad> adsList) {
        List<R01> reportFieldList = new ArrayList<>();
        for (Ad ad : adsList) {
            boolean found = false;
            for (R01 carReport : reportFieldList) {
                if (carReport != null) {
                    if (carReport.getMake().equals(ad.getCar().getMake())) {
                        if (ad.getStatus().equals(AdStatus.SOLD)) {
                            carReport.increaseAdsListed();
                            carReport.increaseAdsSold();
                            found = true;
                        } else {
                            carReport.increaseAdsListed();
                            found = true;
                        }
                    }
                }
            }
            if (!found) {
                if (ad.getStatus().equals(AdStatus.SOLD)) {
                    reportFieldList.add(new R01(ad.getCar().getMake(), 1, 1));
                } else {
                    reportFieldList.add(new R01(ad.getCar().getMake(), 1, 0));
                }

            }

        }
        return reportFieldList;
    }

//    public List<R01> generateReport(List<R01> reportFieldList, List<Ad> adsList) {
//        for (Ad ad : adsList) {
//            boolean found = false;
//            for (R01 carReport : reportFieldList) {
//                if (carReport != null) {
//                    if (carReport.getMake().equals(ad.getCar().getMake())) {
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
//                    reportFieldList.add(new R01(ad.getCar().getMake(), 1, 1));
//                } else {
//                    reportFieldList.add(new R01(ad.getCar().getMake(), 1, 0));
//                }
//
//            }
//
//        }
//        return reportFieldList;
//    }
}
