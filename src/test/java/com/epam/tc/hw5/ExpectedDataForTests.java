package com.epam.tc.hw5;

import java.util.List;

public class ExpectedDataForTests {
    public final static List<String> CHECKBOXES_TO_BE_SELECTED = List.of("Water", "Wind");
    public final static String RADIOBUTTON_TO_BE_SELECTED = "Selen";
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
