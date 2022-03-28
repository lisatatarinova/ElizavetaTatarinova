package com.epam.tc.hw9;

import com.epam.tc.hw9.SpecialRequests.BoardRequests;
import com.epam.tc.hw9.SpecialRequests.CardRequests;
import com.epam.tc.hw9.SpecialRequests.ListRequests;
import com.epam.tc.hw9.SpecialRequests.UserRequests;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.epam.tc.hw9.RequestsData.*;

public class RestTest {
    BoardRequests boardRequest = new BoardRequests();
    ListRequests listRequests = new ListRequests();
    CardRequests cardRequests = new CardRequests();
    UserRequests userRequests = new UserRequests();

    @Test(priority = 0)
    public void createBoardStatusCodeTest() {
        boardRequest.createBoard(boardName).then()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void getBoardNameTest() {
        boardRequest.getBoardNameTest()
                .path("name");
        Assertions.assertThat(boardName).isEqualTo(boardName);
    }

    @Test(priority = 2)
    public void updateBoardHeaderDateTest() {
        String stringDate = boardRequest.updateBoardData("name", "999")
                .getHeader("Date");
        Assertions.assertThat(stringDate).contains("28 Mar");
    }

    @Test(priority = 3)
    public void createListStatusCodeTest() {
        listRequests.createList("newList2").then()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void updateListNameTest() {
        String name = listRequests.updateListData("name", "qwerty")
                .path("name");
        Assertions.assertThat(name.toCharArray().length).isEqualTo("qwerty".length());
    }

    @Test(priority = 5)
    public void createCardStatusCodeTest() {
        cardRequests.createCard("some new card").then()
                .statusCode(200);
    }

    @Test(priority = 6)
    public void updateCardTest() {
        Map<String, Object> value = new HashMap<>();
        value.put("idAttachment", null);
        value.put("color", "yellow");
        value.put("idUploadedBackground", null);
        value.put("size", "normal");
        value.put("brightness", "light");
        value.put("idPlugin", null);
        String cover = cardRequests.updateCardData("cover", value)
                .asPrettyString();
        Assertions.assertThat(cover).contains("yellow");
    }

    @Test(priority = 7)
    public void deleteCardTest() {
        cardRequests.deleteCard().then()
                .statusCode(200);
    }

    @Test(priority = 8)
    public void deleteBoardTest() {
        boardRequest.deleteBoard().then()
                .statusCode(200);
    }

    @Test(priority = 9)
    public void userNameTest() {
        String fullName = userRequests.getUserName()
                .path("fullName");
        Assertions.assertThat(fullName).isEqualTo("Elizaveta Tatarinova");
    }
}
