package com.parser;

import com.model.Ad;
import com.model.AdAuthor;
import com.model.enums.*;

public interface IndividualAd {

    String parseAdId();
    AdAuthor parseAdAuthor();
    AdStatus parseAdStatus();
    int parsePrice();
    String parseLocation();
    String parseComment();

    void parseCarParams();

    String parseMakeYear();
    CarFuelType parseFuelType();
    CarGearBox parseGearBox();
    String parseEnginePower();
    int parseMileage();
    String parseRimSize();
    CarWheelPosition parseWheelPosition();
    CarDrivenWheels parseDriveTrain();
    int parseWeight();
    String parseFirstRefCountry();
    CarDefect parseDefect();
    String parseMot();
    String parseVin();
    String parseMake();
    String parseModel();
    String parseEngineSize();
    CarBodyType parseBodyType();

    Ad getParsedAd();

}
