package com.epam.tc.hw2.testData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LeftMenuSectionItems {
    private final List<String> leftMenuItems = new ArrayList<>();

    LeftMenuSectionItems(){
        leftMenuItems.add("Home");
        leftMenuItems.add("Contact form");
        leftMenuItems.add("Service");
        leftMenuItems.add("Metals & Colors");
        leftMenuItems.add("Elements packs");
    }

    public List<String> getLeftMenuItems(){
        return leftMenuItems;
    }
}
