package com.parser.AutoPlius;

import com.model.*;

import java.util.HashMap;

public interface IndividualAd {

    AdAuthor parseAdAuthor();
    AdStatus parseAdStatus();
    int parsePrice();
    String parseLocation();
    String[] parseImg();
    String parseComment();

    HashMap<String, String> parseCarParams();

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
    CarDoors parseDoors();
    String parseMot();
    String parseVin();
    String parseMake();
    String parseModel();
    String parseEngineSize();
    CarBodyType parseBodyType();

}
