package com.ademlo.f1statisticsapi.commons.core.persistence.mapper;

import com.ademlo.f1statisticsapi.commons.core.domain.models.Country;
import com.ademlo.f1statisticsapi.commons.core.persistence.CountryEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryDBMapper {

    public List<Country> toDomain(List<CountryEntity> countries){
        return countries.stream().map(this::toDomain).collect(Collectors.toList());
    }
    public Country toDomain(CountryEntity entity){
            return new Country(
                    entity.getCode(),
                    entity.getName()
            );

    }
}
