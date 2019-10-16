package com.report.reportsOld;

import com.model.Ad;

public class R01 implements Report<R01> {
    private String make;

    private int adsListed = 0;
    private int adsSold = 0;
    private double avgSaleTime;

    public R01(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    @Override
    public R01 reportBuilder(R01 report, Ad ad) {
        return null;
    }
}
