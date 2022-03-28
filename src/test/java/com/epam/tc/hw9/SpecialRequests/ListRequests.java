package com.epam.tc.hw9.SpecialRequests;

import com.epam.tc.hw9.Authentification;
import com.epam.tc.hw9.MainRequests;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.epam.tc.hw9.RequestsData.*;

public class ListRequests extends MainRequests {

    public Response createList(String listName) {
        Map <String, String> requestBody = new HashMap<>();
        requestBody.put("name", listName);
        requestBody.put("idBoard", boardId);
        Response response = super.create(requestBody, "/lists/");
        listId = response.then().extract().response().path("id");
        return response;
    }

    public Response updateListData(String field, String value) {
        Response response = super.updateData(field, value, "/lists/"+listId);
        return response;
    }
}
