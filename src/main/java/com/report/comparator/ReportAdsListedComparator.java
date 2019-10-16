package com.report.comparator;

import com.report.CarReport;

import java.util.Comparator;

public class ReportAdsListedComparator implements Comparator<CarReport> {
    @Override
    public int compare(CarReport carReport, CarReport t1) {
//        if (carReport.getAdsListed() > t1.getAdsListed()) {
//            return 1;
//        }
//        if (carReport.getAdsListed() < t1.getAdsListed()) {
//            return -1;
//        }
        return 0;
    }
}
