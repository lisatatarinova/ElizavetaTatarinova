package com.epam.tc.hw6.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("user");

    public User getUserPreperties() {
        return new User(resourceBundle.getString("user.username"),
                resourceBundle.getString("user.password"),
                resourceBundle.getString("user.name"));
    }
}
