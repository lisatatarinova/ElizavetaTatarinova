package com.epam.tc.hw10.controllers;

import static com.epam.tc.hw10.services.TrelloUri.CARD_URI;
import static com.epam.tc.hw10.services.TrelloUri.LIST_URI;

import com.epam.tc.hw10.dto.CardDto;
import io.restassured.response.Response;
import java.text.MessageFormat;
import java.util.List;

public class CardRequests extends MainRequests {

    public CardDto create(String cardName, String boardId, String listId) {
        CardDto requestBody = new CardDto();
        requestBody.setName(cardName);
        requestBody.setIdBoard(boardId);
        requestBody.setIdList(listId);
        CardDto response = super.create(requestBody, CARD_URI).as(CardDto.class);
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
