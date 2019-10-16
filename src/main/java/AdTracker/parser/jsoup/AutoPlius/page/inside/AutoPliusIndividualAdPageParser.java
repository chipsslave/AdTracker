package AdTracker.parser.jsoup.AutoPlius.page.inside;

import AdTracker.model.Ad;
import AdTracker.model.AdAuthor;
import AdTracker.model.ModelFactory;
import AdTracker.model.enums.*;
import AdTracker.parser.IndividualAd;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDateTime;
import java.util.HashMap;

public class AutoPliusIndividualAdPageParser implements IndividualAd {

    private Document pageContentInHtml;
    private HashMap<String, String> adCarParams = new HashMap<>();

    AutoPliusIndividualAdPageParser(Document pageContentInHtml) {
        this.pageContentInHtml = pageContentInHtml;
        parseCarParams();
    }

    @Override
    public String parseAdId() {
        String adId = pageContentInHtml.select("li[class=announcement-id]").text().trim();
        adId = adId.replaceAll("[^\\d.]", "").trim();
        return adId;
    }

    @Override
    public AdAuthor parseAdAuthor() {
        String name = pageContentInHtml.select("div[class=seller-contact-name]").text().trim();
        String location = pageContentInHtml.select("div[class=seller-contact-location]").text().trim();
        String phone = pageContentInHtml.select("a[class=seller-phone-number]").text().trim();

        return ModelFactory.getNewAdAuthorInstance(name, location, phone);
    }

    @Override
    public AdStatus parseAdStatus() {
        Element status = pageContentInHtml.selectFirst("div[class=error-msg]");
        if (status != null) {
            String message = status.select("div[class=msg-subject]").text().trim();
            if (message.startsWith("Advertisement does not exist")) {
                return AdStatus.SOLD;
            }
        }
        return AdStatus.UPDATED;
    }

    @Override
    public int parsePrice() {
        String priceInString = pageContentInHtml.select("div[class=price]").text();
        priceInString = priceInString.replaceAll("[^\\d.]", "").trim();

        return (priceInString.equals("")) ? 0 : Integer.parseInt(priceInString);
    }

    @Override
    public String parseLocation() {
        return pageContentInHtml.select("div[class=seller-contact-location]").text().trim();
    }

    @Override
    public String parseComment() {
        return pageContentInHtml.select("div[class=announcement-description]").text().trim();
    }

    @Override
    public void parseCarParams() {
        Elements paramRows = pageContentInHtml.select("div[class=parameter-row]");
        for (Element paramRow : paramRows) {
            String paramLabel = paramRow.select("div[class=parameter-label]").text().trim();
            String paramValue = paramRow.select("div[class=parameter-value]").text().trim();
            adCarParams.put(paramLabel, paramValue);
        }
    }

    @Override
    public String parseMakeYear() {
        String makeYear = adCarParams.get("Date of manufacture");
        if (makeYear == null) {
            return "";
        }
        return makeYear;
    }

    @Override
    public CarFuelType parseFuelType() {
        String fuelType = adCarParams.get("Fuel type");
        if (fuelType == null) {
            return CarFuelType.Other;
        }
        if (fuelType.equals("Petrol / LPG")) {
            return CarFuelType.PetrolLpg;
        }
        if (fuelType.equals("Petrol / electricity")) {
            return CarFuelType.PetrolElectricity;
        }
        if (fuelType.equals("Diesel / electricity")) {
            return CarFuelType.DieselElectricity;
        }
        if (fuelType.equals("Bioethanol (E85)")) {
            return CarFuelType.E85;
        }

        return CarFuelType.valueOf(fuelType);
    }

    @Override
    public CarGearBox parseGearBox() {
        String gearBox = adCarParams.get("Gearbox");
        if (gearBox == null) {
            return CarGearBox.Unknown;
        }
        return CarGearBox.valueOf(gearBox);
    }

    @Override
    public String parseEnginePower() {
        String enginePower = adCarParams.get("Engine");
        if (enginePower == null) {
            return "";
        }
        return enginePower;
    }

    @Override
    public int parseMileage() {
        String miles = adCarParams.get("Mileage");
        if (miles == null) {
            return 0;
        }
        miles = miles.replaceAll("[^\\d.]", "").trim();
        return Integer.parseInt(miles);
    }

    @Override
    public String parseRimSize() {
        String rimSize = adCarParams.get("Wheel size");
        if (rimSize == null) {
            return "";
        }
        return rimSize;
    }

    @Override
    public CarWheelPosition parseWheelPosition() {
        String wheelPosition = adCarParams.get("Steering wheel");
        if (wheelPosition == null) {
            return CarWheelPosition.Unknown;
        }
        if (wheelPosition.startsWith("Left")) {
            return CarWheelPosition.Left;
        } else if (wheelPosition.startsWith("Right")) {
            return CarWheelPosition.Right;
        }
        return null;
    }

    @Override
    public CarDrivenWheels parseDriveTrain() {
        String wheelPosition = adCarParams.get("Driven wheels");
        if (wheelPosition == null) {
            return CarDrivenWheels.Unknown;
        }

        if (wheelPosition.startsWith("Front")) {
            return CarDrivenWheels.FrontDrive;
        } else if (wheelPosition.startsWith("Rear")) {
            return CarDrivenWheels.RearDrive;
        } else if (wheelPosition.startsWith("All")) {
            return CarDrivenWheels.AllWheelDrive;
        }
        return null;
    }

    @Override
    public int parseWeight() {
        String carWeight = adCarParams.get("Kerb weight, kg");
        if (carWeight == null) {
            return 0;
        }
        return Integer.parseInt(carWeight);
    }

    @Override
    public String parseFirstRefCountry() {
        String firstRefCountry = adCarParams.get("First registration country");
        if (firstRefCountry == null) {
            return "";
        }
        return firstRefCountry;
    }

    @Override
    public CarDefect parseDefect() {
        String damage = adCarParams.get("Damage");
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
        String vin = adCarParams.get("VIN number");
        if (vin == null) {
            return "";
        }
        return vin;
    }

    @Override
    public String parseMake() {
        Elements elements = pageContentInHtml.select("li[class=crumb]");
        return (elements.size() > 1) ? elements.get(2).text() : "";
    }

    @Override
    public String parseModel() {
        Elements elements = pageContentInHtml.select("li[class=crumb]");
        return (elements.size() > 1) ? elements.get(3).text() : "";
    }

    @Override
    public String parseEngineSize() {
        // TODO
        //Element element = pageContentInHtml.selectFirst("div[class=col-8 page-title");
        return null;
    }

    @Override
    public CarBodyType parseBodyType() {
        String element = pageContentInHtml.selectFirst("div.col-8.page-title").text();
        String[] strings = element.split(", ");
        String body = (strings.length == 3) ? strings[2] : "";
        if (body.equals("coupe")) {
            return CarBodyType.Coupe;
        }
        if (body.equals("suv / off-road")) {
            return CarBodyType.SUV;
        }
        if (body.equals("saloon / sedan")) {
            return CarBodyType.Saloon;
        }
        if (body.equals("hetchback")) {
            return CarBodyType.Hatchback;
        }
        if (body.equals("wagon")) {
            return CarBodyType.Wagon;
        }
        if (body.equals("mpv / minivan")) {
            return CarBodyType.Minivan;
        }
        if (body.equals("commercial")) {
            return CarBodyType.Commercial;
        }
        if (body.equals("convertible")) {
            return CarBodyType.Convertible;
        }
        if (body.equals("limousine")) {
            return CarBodyType.Limousine;
        }
        if (body.equals("pick-up")) {
            return CarBodyType.PickUp;
        }
        if (body.equals("passenger vans")) {
            return CarBodyType.PassengerVan;
        }
        if (body.equals("other")) {
            return CarBodyType.Other;
        }
        return CarBodyType.Unknown;
    }

    @Override
    public Ad getParsedAd() {
        Ad ad = ModelFactory.getNewBlankAdInstance();

        ad.setAdId(parseAdId());
        ad.setAuthor(parseAdAuthor());
        ad.setPrice(parsePrice());
        ad.setLocation(parseLocation());
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
        ad.getCar().setMake(parseMake());
        ad.getCar().setModel(parseModel());
        ad.getCar().setBodyType(parseBodyType());

        ad.setUpdated(LocalDateTime.now());

        return ad;
    }
}
