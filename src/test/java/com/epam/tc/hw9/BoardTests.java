package com.epam.tc.hw9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class BoardTests {
    String key = "";
    String token = "";
    String baseUri = "https://api.trello.com/1";
    String authorization = "OAuth oauth_consumer_key=\""+key+"\", oauth_token=\""+token+"\"";

    @Test
    public void createBoardStatusCodeTest() {
    RestAssured
            .given()
            .contentType("application/json")
            .baseUri(baseUri)
            .header("Authorization", authorization)
            .queryParam("name", "boardName")
            .when()
            .post("/boards/")
            .then()
            .statusCode(200);
    }

   @Test
    public void getBoardNameTest() {
       String boardName = RestAssured
                               .given()
                               .contentType("application/json")
                               .baseUri(baseUri)
                               .header("Authorization", authorization)
                               .when()
                               .get("/boards/614dcadf89267b87ecfbab03")
                               .then()
                               .extract()
                               .response()
                               .path("name");
        Assertions.assertThat(boardName).isEqualTo("boardname");
    }

    @Test
    public void updateBoardHeaderDateTest() {
        String date = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri)
                .header("Authorization", authorization)
                .queryParam("name", "999")
                .when()
                .put("/boards/614dcadf89267b87ecfbab03")
                .then()
                .extract()
                .response()
                .getHeader("Date");
        Assertions.assertThat(date).contains("29 Mar");
    }

    @Test
    public void deleteBoardTest() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri)
                .header("Authorization", authorization)
                .when()
                .delete("/boards/6242fe18aaee56491672123e")
                .then()
                .statusCode(200);
    }

    @Test
    public void userNameTest() {
        String fullName = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri)
                .header("Authorization", authorization)
                .when()
                .get("/members/me")
                .then()
                .extract()
                .response()
                .path("fullName");
        Assertions.assertThat(fullName).isEqualTo("Elizaveta Tatarinova");
    }
}
