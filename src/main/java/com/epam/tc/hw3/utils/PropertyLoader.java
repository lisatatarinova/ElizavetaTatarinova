package com.epam.tc.hw3.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("user");
    protected static String username = resourceBundle.getString("user.username");
    protected static String password = resourceBundle.getString("user.password");
    protected static String name = resourceBundle.getString("user.name");
}
