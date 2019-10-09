package com.parser.AutoPlius;

import com.html.UrlContentReader;
import com.model.Ad;
import com.model.AdAuthor;
import com.model.enums.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.util.HashMap;

public class IndividualAdImpl implements IndividualAd {

    private HashMap<String, String> adCarParams;
    private Document htmlContent;

    public IndividualAdImpl(String target) {
        this.htmlContent = UrlContentReader.readContentInJsoupDocument(target);
        this.adCarParams = parseCarParams();
    }

    public HashMap<String, String> getAdCarParams() {
        return adCarParams;
    }

    public Document getHtmlContent() {
        return htmlContent;
    }

    @Override
    public AdAuthor parseAdAuthor() {
        String name = htmlContent.select("div[class=seller-contact-name]").text().trim();
        String location = htmlContent.select("div[class=seller-contact-location]").text().trim();
        String phone = htmlContent.select("a[class=seller-phone-number]").text().trim();

        return new AdAuthor(name, location, phone);
    }

    @Override
    public AdStatus parseAdStatus() {
        // TODO status
        return null;
    }

    @Override
    public HashMap<String, String> parseCarParams() {
        adCarParams = new HashMap<String, String>();

        Elements paramRows = htmlContent.select("div[class=parameter-row]");
        for (Element paramRow : paramRows){
            String paramLabel = paramRow.select("div[class=parameter-label]").text().trim();
            String paramValue = paramRow.select("div[class=parameter-value]").text().trim();
            adCarParams.put(paramLabel, paramValue);
        }
        return adCarParams;
    }

    @Override
    public int parsePrice() {
        String priceInString = htmlContent.select("div[class=price]").text();
        priceInString = priceInString.replaceAll("[^\\d.]", "").trim();
        return Integer.parseInt(priceInString);
    }

    @Override
    public String parseLocation() {
        return htmlContent.select("div[class=seller-contact-location]").text().trim();
    }

    @Override
    public String[] parseImg() {
        Elements gallery = htmlContent.select("div[class=thumbnail]");
        String[] images = new String[gallery.size()];
        int i = 0;
        for (Element imageElement : gallery){
            String imageUrl = imageElement.attr("style");
            imageUrl = imageUrl.replace("/ann_4_", "/ann_25_");
            imageUrl = imageUrl.replace("background-image: url('", "");
            imageUrl = imageUrl.replace("')", "");
            images[i] = imageUrl;
            i++;
        }
        return images;
    }

    @Override
    public String parseComment() {
        return htmlContent.select("div[class=announcement-description]").text().trim();
    }

    @Override
    public String parseMakeYear() {
        if (getAdCarParams().get("Date of manufacture") == null){
            return "";
        }
        return getAdCarParams().get("Date of manufacture");
    }

    @Override
    public CarFuelType parseFuelType() {
        String fuelType = getAdCarParams().get("Fuel type");
        if (fuelType == null){
            return CarFuelType.Other;
        }
        if (fuelType.equals("Petrol / LPG")){
            return CarFuelType.PetrolLpg;
        }
        if (fuelType.equals("Petrol / electricity")){
            return CarFuelType.PetrolElectricity;
        }
        if (fuelType.equals("Diesel / electricity")){
            return CarFuelType.DieselElectricity;
        }
        if (fuelType.equals("Bioethanol (E85)")){
            return CarFuelType.E85;
        }

        return CarFuelType.valueOf(fuelType);
    }

    @Override
    public CarGearBox parseGearBox() {
        String gearBox = getAdCarParams().get("Gearbox");
        if (gearBox == null){
            return CarGearBox.Unknown;
        }
        return CarGearBox.valueOf(gearBox);
    }

    @Override
    public String parseEnginePower() {
        if (getAdCarParams().get("Engine") == null){
            return "";
        }
        return getAdCarParams().get("Engine");
    }

    @Override
    public int parseMileage() {
        String miles = getAdCarParams().get("Mileage");
        if (miles == null){
            return 0;
        }
        miles = miles.replaceAll("[^\\d.]", "").trim();
        return Integer.parseInt(miles);
    }

    @Override
    public String parseRimSize() {
        String rimSize = getAdCarParams().get("Wheel size");
        if (rimSize == null) {
            return "";
        }
        return rimSize;
    }

    @Override
    public CarWheelPosition parseWheelPosition() {
        String wheelPosition = getAdCarParams().get("Steering wheel");
        if (wheelPosition == null){
            return CarWheelPosition.Unknown;
        }
        if (wheelPosition.startsWith("Left")){
            return CarWheelPosition.Left;
        } else if (wheelPosition.startsWith("Right")){
            return CarWheelPosition.Right;
        }
        return null;
    }

    @Override
    public CarDrivenWheels parseDriveTrain() {
        String wheelPosition = getAdCarParams().get("Driven wheels");
        if (wheelPosition == null){
            return CarDrivenWheels.Unknown;
        }

        if (wheelPosition.startsWith("Front")){
            return CarDrivenWheels.FrontDrive;
        } else if (wheelPosition.startsWith("Rear")){
            return CarDrivenWheels.RearDrive;
        } else if (wheelPosition.startsWith("All")){
            return CarDrivenWheels.AllWheelDrive;
        }
        return null;
    }

    @Override
    public int parseWeight() {
        String carWeight = getAdCarParams().get("Kerb weight, kg");
        if (carWeight == null){
            return 0;
        }
        return Integer.parseInt(carWeight);
    }

    @Override
    public String parseFirstRefCountry() {
        if (getAdCarParams().get("First registration country") == null){
            return "";
        }
        return getAdCarParams().get("First registration country");
    }

    @Override
    public CarDefect parseDefect() {
        String damage = getAdCarParams().get("Damage");
        if (damage == null) {
            return CarDefect.NoDamage;
        }
        if (damage.equals("Crashed")) {
            return CarDefect.Crashed;
        }
        if (damage.equals("Fire / burn")) {
            return CarDefect.Fire;
        }
        if (damage.equals("Gearbox damage")) {
            return CarDefect.GearboxDamage;
        }
        if (damage.equals("Damaged by hail")) {
            return CarDefect.HailDamage;
        }
        if (damage.equals("Water / flood")) {
            return CarDefect.WaterDamage;
        }
        if (damage.equals("Engine damage")) {
            return CarDefect.EngineDamage;
        }
        if (damage.equals("Other major damages")) {
            return CarDefect.OtherDamage;
        }
        return null;
    }

    @Override
    public String parseMot() {
        // TODO
        return null;
    }

    @Override
    public String parseVin() {
        if (getAdCarParams().get("VIN number") == null){
            return "";
        }
        return getAdCarParams().get("VIN number");
    }

    @Override
    public String parseMake() {
        // TODO
        return null;
    }

    @Override
    public String parseModel() {
        // TODO
        return null;
    }

    @Override
    public String parseEngineSize() {
        // TODO
        return null;
    }

    @Override
    public CarBodyType parseBodyType() {
        // TODO
        return null;
    }

    public void parseAdFields(Ad ad){

        ad.setAuthor(parseAdAuthor());
        ad.setPrice(parsePrice());
        ad.setLocation(parseLocation());
        ad.setImages(parseImg());
        ad.setComment(parseComment());
        ad.getCar().setMakeYear(parseMakeYear());
        ad.getCar().setFuelType(parseFuelType());
        ad.getCar().setGearbox(parseGearBox());
        ad.getCar().setEnginePower(parseEnginePower());
        ad.getCar().setMileage(parseMileage());
        ad.getCar().setWheelPosition(parseWheelPosition());
        ad.getCar().setDriveTrain(parseDriveTrain());
        ad.getCar().setWeight(parseWeight());
        ad.getCar().setFirstRegCountry(parseFirstRefCountry());

        ad.getCar().setDefect(parseDefect());
        ad.getCar().setVin(parseVin());

        ad.setUpdated(LocalDateTime.now());
    }
}
