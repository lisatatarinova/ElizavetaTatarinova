package com.epam.tc.hw10.controllers;

import com.epam.tc.hw10.dto.CardDto;
import io.restassured.response.Response;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.epam.tc.hw10.services.TrelloUri.CARD_URI;
import static com.epam.tc.hw10.services.TrelloUri.LIST_URI;
import static java.text.MessageFormat.format;

public class CardRequests extends MainRequests {

    public CardDto create(String cardName, String boardId, String listId) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", cardName);
        requestBody.put("idBoard", boardId);
        requestBody.put("idList", listId);
        CardDto response = super.create(requestBody, CARD_URI).as(CardDto.class);
        return response;
    }

    public Response updateCardData(String field, String value, String cardId) {
        Response response = super.updateData(field, value, MessageFormat.format("{0}{1}", CARD_URI, cardId));
        return response;
    }

    public Response delete(String cardId) {
        Response response = super.delete(MessageFormat.format("{0}{1}", CARD_URI, cardId));
        return response;
    }

    public List<String> getAllCardsOnList(String listId) {
        List<String> response = super.getData(MessageFormat.format("{0}{1}{2}", LIST_URI, listId, CARD_URI)).then().extract().path("id");
        return response;
    }
}
