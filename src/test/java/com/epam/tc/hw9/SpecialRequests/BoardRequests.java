package com.epam.tc.hw9.SpecialRequests;

import com.epam.tc.hw9.Authentification;
import com.epam.tc.hw9.MainRequests;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.epam.tc.hw9.RequestsData.boardId;

public class BoardRequests extends MainRequests {

    public Response createBoard(String boardName) {
        Map <String, String> requestBody = new HashMap<>();
        requestBody.put("name", boardName);
        Response response = super.create(requestBody, "/boards/");
        boardId = response.then().extract().response().path("id");
        return response;
    }

    public Response getBoardNameTest() {
        Response response = super.getData("/boards/"+boardId);
        return response;
    }

    public Response updateBoardData(String field, String value) {
        Response response = super.updateData(field, value, "/boards/"+boardId);
        return response;
    }

    public Response deleteBoard() {
        Response response = super.delete("/boards/"+boardId);
        return response;
    }
}
