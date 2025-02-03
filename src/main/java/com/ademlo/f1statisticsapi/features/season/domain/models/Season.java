package com.ademlo.f1statisticsapi.features.season.domain.models;

public class Season {
    private final Integer code;
    private final Integer year;

    public Season(Integer code, Integer year) {
        this.code = code;
        this.year = year;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getYear() {
        return year;
    }
}
