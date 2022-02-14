package com.epam.tc.hw2.testData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class TestWaits {
    FluentWait<WebDriver> webDriverWait;
    WebDriver driver;
    TestLocators locators = new TestLocators();
    TestData testData = new TestData();

    public TestWaits(){
    }

    public void setTestWaits(WebDriver driver){
        webDriverWait = new FluentWait(driver);
        this.driver = driver;
    }

    public WebElement waitUntilLoginMenuAppears(){
        return webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(locators.NAME_INPUT, 0)
        ).get(0);
    }

    public WebElement waitUntilUserIsLoggined(){
        return webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(locators.USER_NAME, 0)
        ).get(0);
    }

    public WebElement waitUntilServiceDropDownAppears(){
        return webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(locators.DIFFERENT_ELEMENTS_ELEMENT, 0)
        ).get(0);
    }

    public void waitUntilDifferentElementsPageOpens(){
        webDriverWait.until(ExpectedConditions.urlToBe(testData.DIFF_PAGE_URL));
    }

    public WebElement waitUntilColourDropDownAppers(){
        return webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(locators.COLOUR_DROPDOWN, 0)
        ).get(0);
    }
}
