package com.report.comparator;

import com.report.Report;

import java.util.Comparator;

public class ReportAdsListedComparator implements Comparator<Report> {
    @Override
    public int compare(Report report, Report t1) {
        if (report.getAdsListed() > t1.getAdsListed()) {
            return 1;
        }
        if (report.getAdsListed() < t1.getAdsListed()) {
            return -1;
        }
        return 0;
    }
}
