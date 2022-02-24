package com.epam.tc.hw4;

import java.util.List;

public class ExpectedDataForTests {
    public final static List<String> HEADER_ITEMS = List.of("HOME","CONTACT FORM","SERVICE","METALS & COLORS");
    public final static List<String> TEXTS = List.of("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project", "To be flexible and\n" +
            "customizable", "To be multiplatform", "Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");
    public final static List<String> LEFT_MENU_ITEMS = List.of("Home", "Contact form", "Service", "Metals & Colors"
            , "Elements packs");
    public final static List<String> ITEMS_TO_BE_SELECTED = List.of("Water", "Wind", "Selen");
    public final static List<ItemsLog> ITEMS_LOGS = List.of(
            new ItemsLog("Colors", "Yellow"),
            new ItemsLog("metal", "Selen"),
            new ItemsLog("Wind", "true"),
            new ItemsLog("Water", "true")
    );

    public static class ItemsLog {
        public String itemNameLog;
        public String itemStatusLog;

        public ItemsLog(String name, String status){
            this.itemNameLog = name;
            this.itemStatusLog = status;
        }
    }
}
