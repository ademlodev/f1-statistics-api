package com.ademlo.f1statisticsapi.commons.core.persistence;

import com.ademlo.f1statisticsapi.commons.core.domain.CountryRepository;
import com.ademlo.f1statisticsapi.commons.core.domain.models.Country;
import com.ademlo.f1statisticsapi.commons.core.persistence.mapper.CountryDBMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
@AllArgsConstructor
public class CountryLocalRepository implements CountryRepository {

    private final CountryDBMapper countryDBMapper;
    @Override
    public List<Country> list() {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("countries.json");
        try {
            List<CountryEntity> countries = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<CountryEntity>>() {});
            return countryDBMapper.toDomain(countries);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
