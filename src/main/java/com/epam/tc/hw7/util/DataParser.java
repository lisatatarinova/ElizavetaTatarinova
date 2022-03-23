package com.epam.tc.hw7.util;

import com.epam.tc.hw7.entities.MetalAndColors;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DataParser {

    @DataProvider(name = "metalsAndColorsData")
    public static Object[][] jsonParser() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, MetalAndColors> metalAndColorsMap = objectMapper
            .readValue(new File(("src/test/resources/JDI_ex8_metalsColorsDataSet.json")),
                new TypeReference<>() {
                });

        int i = 0;
        Object[][] object = new Object[metalAndColorsMap.size()][1];
        for (Map.Entry<String, MetalAndColors> entry : metalAndColorsMap.entrySet()
        ) {
            object[i][0] = entry.getValue();
            i++;
        }
        return object;
    }
}
