package AdTracker.report;

public class ReportItem {
    private int adsListed = 0;
    private int adsSold = 0;
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
}
