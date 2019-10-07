/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

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
    private CarDoors doors;
    private String mot;
    private String vin;
    
    private String make;
    private String model;
    private String engineSize;
    private CarBodyType bodyType;

    public Car() {
    }

    public Car(String makeYear, CarFuelType fuelType, CarGearBox gearbox, String make, String model, CarBodyType bodyType) {
        this.makeYear = makeYear;
        this.fuelType = fuelType;
        this.gearbox = gearbox;
        this.make = make;
        this.model = model;
        this.bodyType = bodyType;
    }

    public Car(String makeYear, CarFuelType fuelType, CarGearBox gearbox, String enginePower, int mileage, String rimSize, CarWheelPosition wheelPosition, CarDrivenWheels driveTrain, int weight, String firstRegCountry, CarDefect defect, CarDoors doors, String mot, String vin, String make, String model, String engineSize, CarBodyType bodyType) {
        this.makeYear = makeYear;
        this.fuelType = fuelType;
        this.gearbox = gearbox;
        this.enginePower = enginePower;
        this.mileage = mileage;
        this.rimSize = rimSize;
        this.wheelPosition = wheelPosition;
        this.driveTrain = driveTrain;
        this.weight = weight;
        this.firstRegCountry = firstRegCountry;
        this.defect = defect;
        this.doors = doors;
        this.mot = mot;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.engineSize = engineSize;
        this.bodyType = bodyType;
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

    public CarDoors getDoors() {
        return doors;
    }

    public void setDoors(CarDoors doors) {
        this.doors = doors;
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
