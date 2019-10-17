package AdTracker.report;

import java.util.Objects;

public class ReportItem {
    private int adsListed;
    private int adsSold;
    private double avgSaleTime;

    public ReportItem(int adsListed, int adsSold, double avgSaleTime) {
        this.adsListed = adsListed;
        this.adsSold = adsSold;
        this.avgSaleTime = avgSaleTime;
    }

    public int getAdsListed() {
        return adsListed;
    }

    public void setAdsListed(int adsListed) {
        this.adsListed = adsListed;
    }

    public int getAdsSold() {
        return adsSold;
    }

    public void setAdsSold(int adsSold) {
        this.adsSold = adsSold;
    }

    public double getAvgSaleTime() {
        return avgSaleTime;
    }

    public void setAvgSaleTime(double avgSaleTime) {
        this.avgSaleTime = avgSaleTime;
    }

    @Override
    public String toString() {
        return "ReportItem{" +
                "adsListed=" + adsListed +
                ", adsSold=" + adsSold +
                ", avgSaleTime=" + avgSaleTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportItem that = (ReportItem) o;
        return adsListed == that.adsListed &&
                adsSold == that.adsSold &&
                Double.compare(that.avgSaleTime, avgSaleTime) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adsListed, adsSold, avgSaleTime);
    }
}
