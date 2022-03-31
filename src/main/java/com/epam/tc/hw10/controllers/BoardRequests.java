package com.epam.tc.hw10.controllers;

import static com.epam.tc.hw10.services.CrudMethods.BOARD;
import static com.epam.tc.hw10.services.CrudMethods.ME;

import com.epam.tc.hw10.dto.BoardDto;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardRequests extends MainRequests {

    public BoardDto createBoard(String boardName) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", boardName);
        BoardDto response = super.create(requestBody, BOARD).as(BoardDto.class);
        return response;
    }

    public String getDataTest(String boardId, String field) {
        String response = super.getData(BOARD + boardId).path(field);
        return response;
    }

    public Response deleteBoard(String boardId) {
        Response response = super.delete(BOARD + boardId);
        return response;
    }

    public List<Integer> getAllBoardsIds() {
        List<Integer> response = super.getData(ME).then().extract().path("idBoards");
        return response;
    }
}
