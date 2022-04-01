package com.epam.tc.hw10;

import com.epam.tc.hw10.controllers.BoardRequests;
import com.epam.tc.hw10.controllers.CardRequests;
import com.epam.tc.hw10.controllers.ListRequests;
import com.epam.tc.hw10.dto.BoardDto;
import com.epam.tc.hw10.dto.CardDto;
import com.epam.tc.hw10.dto.ListDto;
import com.epam.tc.hw10.services.TrelloAssertions;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TrelloTest {
    String boardName = RandomStringUtils.randomAlphabetic(10);
    String listName = RandomStringUtils.randomAlphabetic(10);
    String cardName = RandomStringUtils.randomAlphabetic(10);
    BoardDto board;
    ListDto list;
    CardDto card;
    TrelloAssertions trelloAssertions = new TrelloAssertions();
    BoardRequests boardRequests = new BoardRequests();
    ListRequests listRequests = new ListRequests();
    CardRequests cardRequests = new CardRequests();

    //создать борду -> получить борду -> проверить, что создалась правильно
    @Test
    public void createBoardTest(){
        board = boardRequests.create(boardName);
        trelloAssertions.verifyName(board, boardName);
    }

    //создать борду -> удалить борду -> проверить, что удалилась
    @Test
    public void createDeleteBoardTest() {
        board = boardRequests.create(boardName);
        String boardId = board.getId();
        boardRequests.delete(board.getId());
        trelloAssertions.verifyIsDeleted(boardId);
    }

    //создать борду -> создать лист -> удалить борду -> проверить статус
    @Test
    public void createBoardListDeleteBoardTest() {
        board = boardRequests.create(boardName);
        listRequests.create(listName, boardRequests.getValue(board.getId(), "id"));
        trelloAssertions.verifyStatus(boardRequests.delete(board.getId()));
    }

    //создать борду -> создать лист -> проапдейтить лист -> проверить результат
    @Test
    public void createBoardListUpdateListTest() {
        board = boardRequests.create(boardName);
        list = listRequests.create(listName, board.getId());
        String listName2 = RandomStringUtils.randomAlphabetic(10);
        listRequests.updateListData(listName2, list);
        trelloAssertions.verifyName(list, listName2);
    }

    //создать борду -> создать лист -> создать карточку -> удалить карточку -> проверить результат
    @Test
    public void createBoardListCardTest() {
        board = boardRequests.create(boardName);
        list = listRequests.create(listName, board.getId());
        card = cardRequests.create(cardName, board.getId(), list.getId());
        String cardId = card.getId();
        cardRequests.delete(card.getId());
        trelloAssertions.verifyIsDeleted(cardId, list.getId());
    }

    @AfterTest
    public void deleteTestData() {
        if (card!=null) {
            cardRequests.delete(card.getId());
        }

        if (board!=null) {
            boardRequests.delete(board.getId());
        }
    }
}
