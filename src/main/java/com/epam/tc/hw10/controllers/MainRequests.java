package com.epam.tc.hw10.controllers;

import com.epam.tc.hw10.services.Auth;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class MainRequests {
    Auth authentication = new Auth();

    public Response create(Map<String, String> requestBody, String methodPath) {
        Response response = RestAssured
                .given(authentication.requestSpecification())
                .body(requestBody)
                .when()
                .post(methodPath);
        return response;
    }

    public Response getData(String methodPath) {
        Response response = RestAssured
                .given(authentication.requestSpecification())
                .when()
                .get(methodPath)
                .then()
                .extract()
                .response();
        return response;
    }

    public Response updateData(String field, String value, String methodPath) {
        Map<String, String> putBody = new HashMap<>();
        putBody.put(field, value);
        Response response = RestAssured
                .given(authentication.requestSpecification())
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
                .given(authentication.requestSpecification())
                .when()
                .delete(methodPath);
        return response;
    }
}
