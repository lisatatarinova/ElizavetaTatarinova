package com.epam.tc.hw10.services;

import com.epam.tc.hw10.dto.TrelloDto;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyLoader {
    private static Locale locale = new Locale("", "");
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("requests", locale);

    public TrelloDto getAuthPreperties() {
        return new TrelloDto(resourceBundle.getString("trello.baseUri"),
                    resourceBundle.getString("trello.token"),
                    resourceBundle.getString("trello.key"));
        }

}
