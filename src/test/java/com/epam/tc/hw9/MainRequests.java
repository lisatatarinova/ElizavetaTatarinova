package com.epam.tc.hw9;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class MainRequests {
    Authentification authentification = new Authentification();

    public Response create(Map <String, String> requestBody, String methodPath) {

        Response response = RestAssured
                .given()
                .spec(authentification.postRequestSpecification())
                .body(requestBody)
                .when()
                .post(methodPath);
        return response;
    }

    public Response getData(String methodPath) {
        Response response = RestAssured
                .given()
                .spec(authentification.getRequestSpecification())
                .when()
                .get(methodPath)
                .then()
                .extract()
                .response();
        return response;
    }

    public Response updateData(String field, Map<String, Object> value, String methodPath) {
        Map<String, Map<String, Object>> putBody = new HashMap<>();
        putBody.put(field, value);
        Response response = RestAssured
                .given()
                .spec(authentification.postRequestSpecification())
                .body(putBody)
                .when()
                .put(methodPath)
                .then()
                .extract()
                .response();;
        return response;
    }

    public Response updateData(String field, String value, String methodPath) {
        Map<String, String> putBody = new HashMap<>();
        putBody.put(field, value);
        Response response = RestAssured
                .given()
                .spec(authentification.postRequestSpecification())
                .body(putBody)
                .when()
                .put(methodPath)
                .then()
                .extract()
                .response();;
        return response;
    }

    public Response delete(String methodPath) {
        Response response = RestAssured
                .given()
                .spec(authentification.getRequestSpecification())
                .when()
                .delete(methodPath);
        return response;
    }
}
