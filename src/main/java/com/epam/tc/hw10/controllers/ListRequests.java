package com.epam.tc.hw10.controllers;

import static com.epam.tc.hw10.services.CrudMethods.LIST;

import com.epam.tc.hw10.dto.ListDto;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class ListRequests extends MainRequests {
    public ListDto createList(String listName, String boardId) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", listName);
        requestBody.put("idBoard", boardId);
        ListDto response = super.create(requestBody, LIST).as(ListDto.class);
        return response;
    }

    public Response updateListData(String field, String value, String listId) {
        Response response = super.updateData(field, value, LIST + listId);
        return response;
    }

    public Response getList(String listId) {
        Response response = super.getData(LIST + listId);
        return response;
    }
}
