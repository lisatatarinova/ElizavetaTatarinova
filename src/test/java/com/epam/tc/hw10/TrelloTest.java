package com.epam.tc.hw10;

import com.epam.tc.hw10.dto.BoardDto;
import com.epam.tc.hw10.dto.CardDto;
import com.epam.tc.hw10.dto.ListDto;
import com.epam.tc.hw10.services.RestTrelloService;
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
    RestTrelloService restTrelloService = new RestTrelloService();

    //создать борду -> получить борду -> проверить, что создалась правильно
    @Test
    public void createBoardTest(){
        board = restTrelloService.create(boardName);
        trelloAssertions.verifyName(board, boardName);
    }

    //создать борду -> удалить борду -> проверить, что удалилась
    @Test
    public void createDeleteBoardTest() {
        board = restTrelloService.create(boardName);
        String boardId = board.getId();
        restTrelloService.delete(board);
        trelloAssertions.verifyIsDeleted(boardId);
    }

    //создать борду -> создать лист -> удалить борду -> проверить статус
    @Test
    public void createBoardListDeleteBoardTest() {
        board = restTrelloService.create(boardName);
        restTrelloService.create(listName, restTrelloService.getValue(board, "id"));
        trelloAssertions.verifyStatus(restTrelloService.delete(board));
    }

    //создать борду -> создать лист -> проапдейтить лист -> проверить результат
    @Test
    public void createBoardListUpdateListTest() {
        board = restTrelloService.create(boardName);
        list = restTrelloService.create(listName, board.getId());
        String listName2 = RandomStringUtils.randomAlphabetic(10);
        restTrelloService.updateListName("name", listName2, list);
        trelloAssertions.verifyName(list, listName2);
    }

    //создать борду -> создать лист -> создать карточку -> удалить карточку -> проверить результат
    @Test
    public void createBoardListCardTest() {
        board = restTrelloService.create(boardName);
        list = restTrelloService.create(listName, board.getId());
        card = restTrelloService.create(cardName, board.getId(), list.getId());
        String cardId = card.getId();
        restTrelloService.delete(card);
        trelloAssertions.verifyIsDeleted(cardId, list.getId());
    }

    @AfterTest
    public void deleteTestData() {
        restTrelloService.delete(card);
        restTrelloService.delete(board);
    }
}
