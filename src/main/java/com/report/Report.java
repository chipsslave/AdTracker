package com.report;

import com.model.enums.CarBodyType;
import com.model.enums.CarFuelType;

public class Report {
    private String make;
    private String model;
    private CarFuelType fuelType;
    private CarBodyType bodyType;

    private int adsListed = 0;
    private int adsSold = 0;
    private double avgSaleTime;

    public Report(String make, String model, CarFuelType fuelType, CarBodyType bodyType, int adsListed, int adsSold) {
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
        this.adsListed = adsListed;
        this.adsSold = adsSold;
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

    public CarFuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(CarFuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(CarBodyType bodyType) {
        this.bodyType = bodyType;
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
        return "Report{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", fuelType=" + fuelType +
                ", bodyType=" + bodyType +
                ", adsListed=" + adsListed +
                ", adsSold=" + adsSold +
                '}';
    }

    public void increaseAdsListed() {
        setAdsListed(getAdsListed() + 1);
    }

    public void inreaseAdsSold() {
        setAdsSold(getAdsSold() + 1);
    }
}
