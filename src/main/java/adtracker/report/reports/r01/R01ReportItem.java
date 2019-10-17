package adtracker.report.reports.r01;

import adtracker.report.ReportItem;

public class R01ReportItem extends ReportItem {
    private String make;

    public R01ReportItem(String make, int adsListed, int adsSold, double avgSaleTime) {
        super(adsListed, adsSold, avgSaleTime);
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "R01ReportItem [make=" + make + ", adsListed=" + getAdsListed() + ", adsSold=" + getAdsSold() + ", avgSaleTime="
                + getAvgSaleTime() + "]";
    }
}
