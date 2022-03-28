package com.epam.tc.hw9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.epam.tc.hw9.RequestsData.*;
import static com.epam.tc.hw9.RequestsData.key;

public class Authentification {
    public RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON).baseUri(baseUri).queryParam("token", token).queryParam("key",key);
    }

    public RequestSpecification postRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON)
                .baseUri(baseUri).queryParam("token", token).queryParam("key",key);
    }
}
