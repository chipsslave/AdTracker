package AdTracker.model;

import AdTracker.model.enums.AdStatus;

import java.time.LocalDateTime;

public class ModelFactory {

    public static Ad getNewBlankAdInstance() {
        return new Ad();
    }

    public static Ad getNewAdInstance(String adId, String adUrl, AdStatus status, LocalDateTime found) {
        return new Ad(adId, adUrl, status, found);
    }

    public static AdAuthor getNewAdAuthorInstance(String name, String location, String phone) {
        return new AdAuthor(name, location, phone);
    }
}
