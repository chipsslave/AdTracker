package adtracker.report.reports.r02;

import adtracker.report.ReportItem;

public class R02ReportItem extends ReportItem {
    private String make;
    private String model;

    public R02ReportItem(String make, String model, int adsListed, int adsSold, double avgSaleTime) {
        super(adsListed, adsSold, avgSaleTime);
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "R02ReportItem [make=" + make + ", model=" + model + ", adsListed=" + getAdsListed() + ", adsSold=" + getAdsSold() + ", avgSaleTime="
                + getAvgSaleTime() + "]";
    }
}
