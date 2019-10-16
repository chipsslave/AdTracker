package com.report.reports;


import com.model.Ad;

import java.util.List;

public interface Report<T extends Report> {

    List<T> genRep(List<Ad> adsList);
}
