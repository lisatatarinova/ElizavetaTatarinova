package com.epam.tc.hw10.services;

import com.epam.tc.hw10.controllers.BoardRequests;
import com.epam.tc.hw10.controllers.CardRequests;
import com.epam.tc.hw10.controllers.ListRequests;
import com.epam.tc.hw10.dto.BoardDto;
import com.epam.tc.hw10.dto.CardDto;
import com.epam.tc.hw10.dto.ListDto;
import io.restassured.response.Response;

public class RestTrelloService {
    BoardRequests boardRequests = new BoardRequests();
    ListRequests listRequests = new ListRequests();
    CardRequests cardRequests = new CardRequests();

    public BoardDto create(String boardName) {
        BoardDto boardDto = boardRequests.createBoard(boardName);
        return boardDto;
    }

    public ListDto create(String listName, String boardId) {
        ListDto listDto = listRequests.createList(listName, boardId);
        return listDto;
    }

    public CardDto create(String cardName, String boardId, String listId) {
        CardDto cardDto = cardRequests.createCard(cardName, boardId, listId).as(CardDto.class);
        return cardDto;
    }

    public Response delete(BoardDto boardDto) {
        return boardRequests.deleteBoard(boardDto.getId());
    }

    public Response delete(CardDto cardDto) {
        return cardRequests.deleteCard(cardDto.getId());
    }

    public String getValue(BoardDto boardDto, String field) {
        String value = boardRequests.getDataTest(boardDto.getId(), field);
        return value;
    }

    public ListDto updateListName(String field, String newValue, ListDto list) {
        listRequests.updateListData(field, newValue, list.getId());
        list.setName(newValue);
        return listRequests.getList(list.getId()).as(ListDto.class);
    }
}
