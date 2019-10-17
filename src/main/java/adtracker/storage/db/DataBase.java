package adtracker.storage.db;

import adtracker.model.Ad;

import java.util.List;

public interface DataBase {
    // HashMap<String, Ad> loadData();
    Ad addNew(Ad ad);

    Ad update(Ad ad);

    Ad getById(String id);

    Ad delete(Ad ad);

    List<Ad> getAll();

    void saveAll(List<Ad> adList);


    // int merge(List<Ad> allAds);
}
