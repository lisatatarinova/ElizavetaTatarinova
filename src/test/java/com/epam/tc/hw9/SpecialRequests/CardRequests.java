package com.epam.tc.hw9.SpecialRequests;

import com.epam.tc.hw9.Authentification;
import com.epam.tc.hw9.MainRequests;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.epam.tc.hw9.RequestsData.boardId;
import static com.epam.tc.hw9.RequestsData.listId;
import static com.epam.tc.hw9.RequestsData.cardId;

public class CardRequests extends MainRequests {

    public Response createCard(String cardName) {
        Map <String, String> requestBody = new HashMap<>();
        requestBody.put("name", cardName);
        requestBody.put("idBoard", boardId);
        requestBody.put("idList", listId);
        Response response = super.create(requestBody, "/cards/");
        cardId = response.then().extract().response().path("id");
        return response;
    }

    public Response updateCardData(String field, Map<String, Object> value) {
        Response response = super.updateData(field, value, "/cards/"+cardId);
        return response;
    }

    public Response deleteCard() {
        Response response = super.delete("/cards/"+cardId);
        return response;
    }
}
