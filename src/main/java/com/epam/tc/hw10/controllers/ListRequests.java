package com.epam.tc.hw10.controllers;

import static com.epam.tc.hw10.services.TrelloUri.LIST_URI;
import static java.text.MessageFormat.format;

import com.epam.tc.hw10.dto.ListDto;
import io.restassured.response.Response;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class ListRequests extends MainRequests {
    public ListDto create(String listName, String boardId) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", listName);
        requestBody.put("idBoard", boardId);
        ListDto response = super.create(requestBody, LIST_URI).as(ListDto.class);
        return response;
    }

    public ListDto updateListData(String field, String newValue, ListDto list) {
        super.updateData(field, newValue, MessageFormat.format("{0}{1}", LIST_URI, list.getId()))
                .as(ListDto.class);
        list.setName(newValue);
        return list;
    }

    public Response getList(String listId) {
        Response response = super.getData(MessageFormat.format("{0}{1}", LIST_URI, listId));
        return response;
    }
}
