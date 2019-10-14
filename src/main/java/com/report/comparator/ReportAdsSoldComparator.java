package com.report.comparator;

import com.report.Report;

import java.util.Comparator;

public class ReportAdsSoldComparator implements Comparator<Report> {
    @Override
    public int compare(Report report, Report t1) {
        if (report.getAdsSold() > t1.getAdsSold()) {
            return 1;
        }
        if (report.getAdsSold() < t1.getAdsSold()) {
            return -1;
        }
        return 0;
    }
}
