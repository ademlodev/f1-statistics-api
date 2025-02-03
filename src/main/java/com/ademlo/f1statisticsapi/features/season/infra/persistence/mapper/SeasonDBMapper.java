package com.ademlo.f1statisticsapi.features.season.infra.persistence.mapper;

import com.ademlo.f1statisticsapi.features.season.domain.models.Season;
import com.ademlo.f1statisticsapi.features.season.infra.persistence.SeasonEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeasonDBMapper {

    public List<Season> toDomain(List<SeasonEntity> entities){
        return entities.stream().map(this::toDomain).collect(Collectors.toList());
    }
    public Season toDomain(SeasonEntity entity){
        return new Season(
                Integer.parseInt(entity.getCode()),
                Integer.parseInt(entity.getName())
        );

    }
}
