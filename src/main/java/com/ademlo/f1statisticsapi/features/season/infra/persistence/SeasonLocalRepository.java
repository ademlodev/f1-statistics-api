package com.ademlo.f1statisticsapi.features.season.infra.persistence;

import com.ademlo.f1statisticsapi.features.season.domain.models.Season;
import com.ademlo.f1statisticsapi.features.season.domain.SeasonRepository;
import com.ademlo.f1statisticsapi.features.season.infra.persistence.mapper.SeasonDBMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class SeasonLocalRepository implements SeasonRepository {

    private final Logger LOG = LogManager.getLogger(SeasonLocalRepository.class);
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
            LOG.error("Season file read error");
            return Collections.emptyList();
        }
    }
}
