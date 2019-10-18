package adtracker.report;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReportItem {
    private int adsListed;
    private int adsSold;
    private double avgSaleTimeInDays;
    private List<Long> saleInDays = new ArrayList<>();

    public ReportItem(int adsListed, int adsSold, double avgSaleTimeInDays) {
        this.adsListed = adsListed;
        this.adsSold = adsSold;
        this.avgSaleTimeInDays = avgSaleTimeInDays;
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

    protected double getAvgSaleTimeInDays() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(this.saleInDays.stream().mapToLong(val -> val).average().orElse(0.0)));
    }

    public void pushSaleInDays(Long saleInDays) {
        this.saleInDays.add(saleInDays);
    }

    @Override
    public String toString() {
        return "ReportItem{" +
                "adsListed=" + adsListed +
                ", adsSold=" + adsSold +
                ", avgSaleTimeInDays=" + avgSaleTimeInDays +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportItem that = (ReportItem) o;
        return adsListed == that.adsListed &&
                adsSold == that.adsSold &&
                Double.compare(that.avgSaleTimeInDays, avgSaleTimeInDays) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adsListed, adsSold, avgSaleTimeInDays);
    }
}
