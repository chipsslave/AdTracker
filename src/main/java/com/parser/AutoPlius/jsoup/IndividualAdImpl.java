package com.parser.AutoPlius.jsoup;

import com.html.UrlContentReader;
import com.model.*;
import com.parser.AutoPlius.IndividualAd;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        // TODO Fix to match all types
        String fuelType = getAdCarParams().get("Fuel type");
        if (fuelType == null){
            return CarFuelType.Other;
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
        // TODO
        return null;
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
        // TODO
        return null;
    }

    @Override
    public CarDoors parseDoors() {
        // TODO
        return null;
    }

    @Override
    public String parseMot() {
        // TODO
        return null;
    }

    @Override
    public String parseVin() {
        // TODO
        return null;
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

    public Ad parseAdFields(Ad ad){

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

        return ad;
    }
}
