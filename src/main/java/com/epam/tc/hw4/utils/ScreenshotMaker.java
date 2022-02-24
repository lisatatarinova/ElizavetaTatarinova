package com.epam.tc.hw4.utils;

import java.io.File;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@UtilityClass
public class ScreenshotMaker {

    public File makeScreenshot(Object driver) {
        TakesScreenshot sc = (TakesScreenshot) driver;
        File screensFile = sc.getScreenshotAs(OutputType.FILE);
        return screensFile;
    }
}
