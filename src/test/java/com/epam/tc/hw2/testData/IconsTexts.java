package com.epam.tc.hw2.testData;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class IconsTexts {
    private final List<String> iconsTexts = new ArrayList<>();

    IconsTexts(){
        iconsTexts.add("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        iconsTexts.add("To be flexible and\n" +
                "customizable");
        iconsTexts.add("To be multiplatform");
        iconsTexts.add("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    public List<String> getIconsTexts(){
        return iconsTexts;
    }
}
