package com.ademlo.f1statisticsapi.features.season.infra.http;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@DisplayName("Season Feature")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SeasonControllerIT {
    @LocalServerPort
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }


    @Test
    @DisplayName("Given list season return all seasons")
    void givenUserGetSeasonListThenReturnAll(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/season")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", greaterThan(0))
                .body("[0].year", not(emptyString()))
                .body("[0].year", greaterThan(1949));
    }

    @Test
    @DisplayName("Given list season file return empty list when error on file")
    void givenListSeasonFileGetSeasonListThenReturnEmptyList(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/season")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", equalTo(0));
    }
}