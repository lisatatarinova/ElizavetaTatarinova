package com.epam.tc.hw10.services;

import com.epam.tc.hw10.dto.TrelloDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Auth {
    TrelloDto auth = new PropertyLoader().getAuthPreperties();

    public RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .baseUri(auth.baseUri)
                .queryParam("token", auth.token)
                .queryParam("key", auth.key);
    }

    public RequestSpecification postRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON)
                .baseUri(auth.baseUri)
                .queryParam("token", auth.token)
                .queryParam("key", auth.key);
    }
}
