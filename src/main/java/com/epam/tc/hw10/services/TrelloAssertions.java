package com.epam.tc.hw10.services;

import com.epam.tc.hw10.controllers.BoardRequests;
import com.epam.tc.hw10.controllers.CardRequests;
import com.epam.tc.hw10.dto.BoardDto;
import com.epam.tc.hw10.dto.ListDto;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class TrelloAssertions {

    public TrelloAssertions verifyName(BoardDto boardDto, String boardName) {
        Assertions.assertThat(boardDto.getName()).isEqualTo(boardName);
        return this;
    }

    public TrelloAssertions verifyName(ListDto listDto, String listName) {
        Assertions.assertThat(listDto.getName()).isEqualTo(listName);
        return this;
    }

    public TrelloAssertions verifyIsDeleted(String id) {
        Assertions.assertThat(id).isNotIn(new BoardRequests().getAllBoardsIds());
        return this;
    }

    public TrelloAssertions verifyIsDeleted(String id, String listdId) {
        Assertions.assertThat(id).isNotIn(new CardRequests().getAllCardsOnList(listdId));
        return this;
    }

    public TrelloAssertions verifyStatus(Response response) {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
        return this;
    }
}
