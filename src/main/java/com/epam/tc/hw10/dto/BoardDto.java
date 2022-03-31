package com.epam.tc.hw10.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardDto {
    String id;
    String name;
    Boolean pinned;
    String url;

    BoardDto(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("pinned") Boolean pinned) {
        this.id = id;
        this.name = name;
        this.pinned = pinned;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
