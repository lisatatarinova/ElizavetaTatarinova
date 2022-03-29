package com.epam.tc.hw9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CardTests {
    String key = "994b0113b0f455ed984634d551a7beb8";
    String token = "9e7c6b01008523b53d416ca8007ff3fbcbd00bb45a4799b2ed20ea2db73c2a8a";
    String baseUri = "https://api.trello.com/1";
    String authorization = "OAuth oauth_consumer_key=\""+key+"\", oauth_token=\""+token+"\"";

    @Test
    public void createCardStatusCodeTest() {
        RestAssured
                .given()
                .contentType("application/json")
                .baseUri(baseUri)
                .header("Authorization", authorization)
                .queryParam("name", "cardName")
                .queryParam("idList", "61517e567c6d3b4c58d9c276")
                .when()
                .post("/cards/")
                .then()
                .statusCode(200);
    }

    @Test
    public void updateCardTest() {
        Map<String, Object> value = new HashMap<>();
        value.put("idAttachment", null);
        value.put("color", "yellow");
        value.put("idUploadedBackground", null);
        value.put("size", "normal");
        value.put("brightness", "light");
        value.put("idPlugin", null);
        Map<String, Map<String, Object>> putBody = new HashMap<>();
        putBody.put("cover", value);
        String cover = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri)
                .header("Authorization", authorization)
                .body(putBody)
                .when()
                .put("/cards/624308303ffb737dcfa9274c")
                .then()
                .extract()
                .response()
                .asPrettyString();
        Assertions.assertThat(cover).contains("yellow");
    }


    @Test
    public void deleteCardTest() {
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(baseUri)
                .header("Authorization", authorization)
                .when()
                .delete("/cards/62420843edf89c555570e603")
                .then()
                .statusCode(200);
    }


}
