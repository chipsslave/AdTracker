package com.report.reportsOld;

import com.model.Ad;

public interface Report<T extends Report> {

    T reportBuilder(T report, Ad ad);
}
