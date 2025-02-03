package com.ademlo.f1statisticsapi.features.season.domain;

import com.ademlo.f1statisticsapi.features.season.domain.models.Season;

import java.util.List;

public interface SeasonRepository {
    List<Season> list();
}
