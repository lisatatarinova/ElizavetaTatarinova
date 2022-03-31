package com.epam.tc.hw10.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDto {
    String id;
    String name;
    String idBoard;
    String idList;

    CardDto(@JsonProperty("id") String id, @JsonProperty("name") String name,
            @JsonProperty("idBoard") String idBoard, @JsonProperty("idList") String idList) {
        this.id = id;
        this.name = name;
        this.idBoard = idBoard;
        this.idList = idList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }
}
