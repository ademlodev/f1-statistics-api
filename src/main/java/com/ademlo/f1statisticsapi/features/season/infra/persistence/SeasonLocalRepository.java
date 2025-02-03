package com.ademlo.f1statisticsapi.features.season.infra.persistence;

import com.ademlo.f1statisticsapi.features.season.domain.Season;
import com.ademlo.f1statisticsapi.features.season.domain.SeasonRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SeasonLocalRepository implements SeasonRepository {

    private final SeasonDBMapper seasonDBMapper;

    public SeasonLocalRepository(SeasonDBMapper seasonDBMapper) {
        this.seasonDBMapper = seasonDBMapper;
    }

    @Override
    public List<Season> list() {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("seasons.json");
        try {
            List<SeasonEntity> seasons = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<SeasonEntity>>() {});
            return seasonDBMapper.toDomain(seasons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
