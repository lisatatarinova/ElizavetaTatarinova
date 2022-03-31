package com.epam.tc.hw10.controllers;

import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.tc.hw10.services.CrudMethods.CARD;
import static com.epam.tc.hw10.services.CrudMethods.LIST;

public class CardRequests extends MainRequests {

    public Response createCard(String cardName, String boardId, String listId) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", cardName);
        requestBody.put("idBoard", boardId);
        requestBody.put("idList", listId);
        Response response = super.create(requestBody, CARD);
        return response;
    }

    public Response updateCardData(String field, String value, String cardId) {
        Response response = super.updateData(field, value, CARD + cardId);
        return response;
    }

    public Response deleteCard(String cardId) {
        Response response = super.delete(CARD + cardId);
        return response;
    }

    public List<String> getAllCardsOnList(String listId) {
        List<String> response = super.getData(LIST + listId + CARD).then().extract().path("id");
        return response;
    }
}
