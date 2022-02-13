package com.epam.tc.hw2.testData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HeaderSectionItems {
    private final List<String> headerSectionItems = new ArrayList<>();

    HeaderSectionItems(){
        headerSectionItems.add("HOME");
        headerSectionItems.add("CONTACT FORM");
        headerSectionItems.add("SERVICE");
        headerSectionItems.add("METALS & COLORS");
    }

    public List<String> getHeaderSectionItems() {
        return headerSectionItems;
    }
}
