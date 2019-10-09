/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.enums.*;

/**
 *
 * @author mselv
 */
public class Car {
    private String makeYear;
    private CarFuelType fuelType;
    private CarGearBox gearbox;
    private String enginePower;
    private int mileage;
    private String rimSize;
    private CarWheelPosition wheelPosition;
    private CarDrivenWheels driveTrain;
    private int weight;
    private String firstRegCountry;
    private CarDefect defect;
    private String mot;
    private String vin;
    
    private String make;
    private String model;
    private String engineSize;
    private CarBodyType bodyType;

    public Car() {
    }

    public String getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(String makeYear) {
        this.makeYear = makeYear;
    }

    public CarFuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(CarFuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarGearBox getGearbox() {
        return gearbox;
    }

    public void setGearbox(CarGearBox gearbox) {
        this.gearbox = gearbox;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getRimSize() {
        return rimSize;
    }

    public void setRimSize(String rimSize) {
        this.rimSize = rimSize;
    }

    public CarWheelPosition getWheelPosition() {
        return wheelPosition;
    }

    public void setWheelPosition(CarWheelPosition wheelPosition) {
        this.wheelPosition = wheelPosition;
    }

    public CarDrivenWheels getDriveTrain() {
        return driveTrain;
    }

    public void setDriveTrain(CarDrivenWheels driveTrain) {
        this.driveTrain = driveTrain;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getFirstRegCountry() {
        return firstRegCountry;
    }

    public void setFirstRegCountry(String firstRegCountry) {
        this.firstRegCountry = firstRegCountry;
    }

    public CarDefect getDefect() {
        return defect;
    }

    public void setDefect(CarDefect defect) {
        this.defect = defect;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public CarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(CarBodyType bodyType) {
        this.bodyType = bodyType;
    }
}
