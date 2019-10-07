/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author mselv
 */
public class Ad {
    private String adId;
    private String adUrl;
    private AdAuthor author;
    
    private AdStatus status;
    
    private LocalDate found;
    private LocalDate updated;
    private LocalDate lastChecked;
    private LocalDate sold;
    
    private int price;
    
    private Car car;
    
    private String location;
    
    private String[] images;
    
    private String comment;

    public Ad() {
        this.car = new Car();
    }

    public Ad(String adId, String adUrl, AdStatus status) {
        this.adId = adId;
        this.adUrl = adUrl;
        this.status = status;
        this.car = new Car();
    }

    public Ad(String adId, String adUrl, AdAuthor author, AdStatus status, LocalDate found, LocalDate updated, LocalDate lastChecked, LocalDate sold, int price, Car car, String location, String[] images, String comment) {
        this.adId = adId;
        this.adUrl = adUrl;
        this.author = author;
        this.status = status;
        this.found = found;
        this.updated = updated;
        this.lastChecked = lastChecked;
        this.sold = sold;
        this.price = price;
        this.car = car;
        this.location = location;
        this.images = images;
        this.comment = comment;
    }

    public Ad(AdAuthor parseAdAuthor, int parsePrice, String parseLocation, String[] parseImg, String parseComment, String parseMakeYear, CarFuelType parseFuelType, CarGearBox parseGearBox, String parseEnginePower, int parseMileage, CarWheelPosition parseWheelPosition, CarDrivenWheels parseDriveTrain, int parseWeight, String parseFirstRefCountry) {

    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public AdAuthor getAuthor() {
        return author;
    }

    public void setAuthor(AdAuthor author) {
        this.author = author;
    }

    public AdStatus getStatus() {
        return status;
    }

    public void setStatus(AdStatus status) {
        this.status = status;
    }

    public LocalDate getFound() {
        return found;
    }

    public void setFound(LocalDate found) {
        this.found = found;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public LocalDate getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDate lastChecked) {
        this.lastChecked = lastChecked;
    }

    public LocalDate getSold() {
        return sold;
    }

    public void setSold(LocalDate sold) {
        this.sold = sold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "adId='" + adId + '\'' +
                ", adUrl='" + adUrl + '\'' +
                ", author=" + author +
                ", status=" + status +
                ", found=" + found +
                ", updated=" + updated +
                ", lastChecked=" + lastChecked +
                ", sold=" + sold +
                ", price=" + price +
                ", car=" + car +
                ", location='" + location + '\'' +
                ", images=" + Arrays.toString(images) +
                ", comment='" + comment + '\'' +
                '}';
    }
}
