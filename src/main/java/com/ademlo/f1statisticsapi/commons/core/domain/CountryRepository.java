package com.ademlo.f1statisticsapi.commons.core.domain;

import com.ademlo.f1statisticsapi.commons.core.domain.models.Country;

import java.util.List;

public interface CountryRepository {

    List<Country> list();
}
