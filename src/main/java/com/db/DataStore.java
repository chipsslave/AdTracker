package com.db;

import com.model.Ad;
import com.model.AdStatus;

import java.util.HashMap;

public class DataStore {
    private HashMap<String, Ad> adStore = new HashMap<String, Ad>();

    public HashMap<String, Ad> getAdStore() {
        return adStore;
    }

    public void addAd(String id, Ad ad){
        getAdStore().put(id, ad);
    }

    public Ad getIntroducedAd(){
        for (Ad ad : getAdStore().values()){
            if (ad.getStatus() == AdStatus.INTRODUCED){
                return ad;
            }
        }
        return null;
    }

}
