package com.epam.tc.hw6.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

@UtilityClass
public class ScreenshotMaker {

    public File makeScreenshot(Object driver) {
        TakesScreenshot sc = (TakesScreenshot) driver;
        File screensFile = sc.getScreenshotAs(OutputType.FILE);
        return screensFile;
    }
}
