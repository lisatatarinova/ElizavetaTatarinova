package com.epam.tc.hw3.utils;

public class User {
    PropertyLoader propertyLoader = new PropertyLoader();

    public String getUsername() {
        return propertyLoader.username;
    }

    public String getPassword() {
        return propertyLoader.password;
    }

    public String getName() {
        return propertyLoader.name;
    }

}
