package com.ademlo.f1statisticsapi.features.season.infra.http;

import com.ademlo.f1statisticsapi.features.season.domain.SeasonRepository;
import com.ademlo.f1statisticsapi.features.season.domain.models.Season;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@DisplayName("Season Feature")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SeasonControllerIT {
    @LocalServerPort
    int port;

    @MockBean
    private SeasonRepository seasonRepositoryMock;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }


    @Test
    @DisplayName("Given list season return all seasons")
    void givenUserGetSeasonListThenReturnAll(){
        List<Season> seasons = Arrays.asList(
                new Season(1, 1950),
                new Season(2, 2024)
        );

        when(seasonRepositoryMock.list()).thenReturn(seasons);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/season")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", greaterThan(0))
                .body("[0].year", not(emptyString()))
                .body("[0].year", equalTo(1950));
    }

    @Test
    @DisplayName("Given list season file return empty list when error on file")
    void givenListSeasonFileGetSeasonListThenReturnEmptyList(){
        when(seasonRepositoryMock.list()).thenReturn(Collections.emptyList());

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/season")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", empty());
    }
}