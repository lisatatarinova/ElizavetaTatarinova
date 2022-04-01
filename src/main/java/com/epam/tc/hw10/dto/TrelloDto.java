package com.epam.tc.hw10.dto;

public class TrelloDto {
    public String baseUri;
    public String token;
    public String key;

    public TrelloDto(String baseUri, String token, String key) {
        this.baseUri = baseUri;
        this.token = token;
        this.key = key;
    }
}
