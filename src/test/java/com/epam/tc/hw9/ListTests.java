package com.epam.tc.hw9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ListTests {
    String key = "994b0113b0f455ed984634d551a7beb8";
    String token = "9e7c6b01008523b53d416ca8007ff3fbcbd00bb45a4799b2ed20ea2db73c2a8a";
    String baseUri = "https://api.trello.com/1";
    String authorization = "OAuth oauth_consumer_key=\""+key+"\", oauth_token=\""+token+"\"";

    @Test
    public void createListStatusCodeTest() {
    RestAssured
            .given()
            .contentType("application/json")
            .baseUri(baseUri)
            .header("Authorization", authorization)
            .queryParam("name", "listName")
            .queryParam("idBoard", "614dcadf89267b87ecfbab03")
            .when()
            .post("/lists/")
            .then()
            .statusCode(200);
    }

    @Test
    public void updateListNameTest() {
        String name = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri)
                .header("Authorization", authorization)
                .queryParam("name", "qwerty")
                .when()
                .put("/lists/61517e567c6d3b4c58d9c276")
                .then()
                .extract()
                .response()
                .path("name");
        Assertions.assertThat(name.toCharArray().length).isEqualTo("qwerty".length());
    }


}
