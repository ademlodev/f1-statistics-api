package com.ademlo.f1statisticsapi.commons.core.application;

import com.ademlo.f1statisticsapi.commons.core.domain.CountryRepository;
import com.ademlo.f1statisticsapi.commons.core.domain.models.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrieveCountryUseCase {

    private final CountryRepository countryRepository;

    public RetrieveCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> list(){
        return countryRepository.list();
    }
}
