package com.epam.tc.hw3;

import java.util.List;
import java.util.stream.Stream;

public class ExpectedDataForTests {
    public Stream<String> headerItems = Stream.of("HOME","CONTACT FORM","SERVICE","METALS & COLORS");
    public Stream<String> texts = Stream.of("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project", "To be flexible and\n" +
            "customizable", "To be multiplatform", "Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");
    public Stream<String> leftMenuItems = Stream.of("Home", "Contact form", "Service", "Metals & Colors"
            , "Elements packs");
    public Stream<String> itemsToBeSelected = Stream.of("Water", "Wind", "Selen");
    public List<ItemsLog> itemsLogs = List.of(
            new ItemsLog("Colors", "Yellow"),
            new ItemsLog("metal", "Selen"),
            new ItemsLog("Wind", "true"),
            new ItemsLog("Water", "true")
    );

    public class ItemsLog {
        public String itemNameLog;
        public String itemStatusLog;

        public ItemsLog(String name, String status){
            this.itemNameLog = name;
            this.itemStatusLog = status;
        }
    }
}
