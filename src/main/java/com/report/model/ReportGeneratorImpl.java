package com.report.model;

import com.model.Ad;
import com.report.reports.Report;
import com.storage.db.DataBase;

import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorImpl<T extends Report, D extends DataBase> implements ReportGenerator {
    private final D localJsonStorage;
    private List<T> reportFieldList = new ArrayList<>();

    public ReportGeneratorImpl(D localJsonStorage) {
        this.localJsonStorage = localJsonStorage;
    }

    public List<T> getReportFieldList() {
        return reportFieldList;
    }

    @Override
    public void printToConsole() {
        for (T rep : reportFieldList) {
            System.out.println(rep);
        }
    }

    @Override
    public void generateReport() {
        Report<T> r = new Report<T>() {
            @Override
            public List<T> genRep(List<Ad> adsList) {
                return null;
            }
        };

        reportFieldList = r.genRep(localJsonStorage.getAll());

    }

}
