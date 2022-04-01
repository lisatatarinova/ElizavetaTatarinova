package com.epam.tc.hw10.controllers;

import static com.epam.tc.hw10.services.TrelloUri.BOARD_URI;
import static com.epam.tc.hw10.services.TrelloUri.ME_URI;

import com.epam.tc.hw10.dto.BoardDto;
import io.restassured.response.Response;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardRequests extends MainRequests {

    public BoardDto create(String boardName) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", boardName);
        BoardDto response = super.create(requestBody, BOARD_URI).as(BoardDto.class);
        return response;
    }

    public String getValue(String boardId, String field) {
        String response = super.getData(MessageFormat.format("{0}{1}", BOARD_URI, boardId)).path(field);
        return response;
    }

    public Response delete(String boardId) {
        Response response = super.delete(MessageFormat.format("{0}{1}", BOARD_URI, boardId));
        return response;
    }

    public List<Integer> getAllBoardsIds() {
        List<Integer> response = super.getData(ME_URI).then().extract().path("idBoards");
        return response;
    }
}
