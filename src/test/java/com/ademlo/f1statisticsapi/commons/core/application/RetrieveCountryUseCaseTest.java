package com.ademlo.f1statisticsapi.commons.core.application;

import com.ademlo.f1statisticsapi.commons.core.domain.CountryRepository;
import com.ademlo.f1statisticsapi.commons.core.domain.models.Country;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@DisplayName("Season Feature")
class RetrieveCountryUseCaseTest {

    @InjectMocks
    private RetrieveCountryUseCase sut;

    @Mock
    private CountryRepository countryRepositoryMock;

    @BeforeEach
    void setUp(){
        countryRepositoryMock = mock(CountryRepository.class);
        sut = new RetrieveCountryUseCase(countryRepositoryMock);
    }

    @Test
    @DisplayName("Given list country return all")
    void givenUserGetCountryListThenReturnAll(){
        //Given
        final var countryMock = mock(Country.class);
        final var countriesMock = List.of(countryMock);
        when(countryRepositoryMock.list()).thenReturn(countriesMock);

        //When
        List<Country> actualCountries = sut.list();
        //Then
        assertNotNull(countriesMock);
        assertNotNull(actualCountries);
        verify(countryRepositoryMock, times(1)).list();
        verifyNoMoreInteractions(countryRepositoryMock);
    }

    @Test
    @DisplayName("Given list county return empty list when error on file")
    void givenListSeasonFileGetSeasonListThenReturnEmptyList(){
        //Given
        when(countryRepositoryMock.list()).thenReturn(Collections.emptyList());

        //When
        List<Country> actualCountries = sut.list();
        //Then
        assertNotNull(actualCountries);
        verify(countryRepositoryMock, times(1)).list();
        verifyNoMoreInteractions(countryRepositoryMock);
    }
}