package com.report.reportsOld;

public abstract class ReportBase implements Report {

    private int adsListed = 0;
    private int adsSold = 0;
    private double avgSaleTime;

    public int getAdsListed() {
        return adsListed;
    }

    public int getAdsSold() {
        return adsSold;
    }

    public double getAvgSaleTime() {
        return avgSaleTime;
    }

    public void increaseAdsListed() {
        adsListed++;
    }

    public void increaseAdsSold() {
        adsSold++;
    }
}
