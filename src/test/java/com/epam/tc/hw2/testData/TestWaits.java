package com.epam.tc.hw2.testData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;

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
        List<WebElement> loginNameField = webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(locators.PASSWORD_INPUT, 0)
        );
        return loginNameField.get(0);
    }

    public WebElement waitUntilUserIsLoggined(){
        WebElement userNameAfterLogin = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(locators.USER_NAME)
        );
        return userNameAfterLogin;
    }

    public WebElement waitUntilServiceDropDownAppears(){
        List<WebElement> serviceDropDown = webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(locators.DIFFERENT_ELEMENTS_ELEMENT, 0)
        );
        return serviceDropDown.get(0);
    }

    public void waitUntilDifferentElementsPageOpens(){
        webDriverWait.until(ExpectedConditions.urlToBe(testData.differentElementsPage_URL));
    }

    public WebElement waitUntilColourDropDownAppers(){
        List<WebElement> colourDropdown = webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(locators.COLOUR_DROPDOWN, 0)
        );
        return colourDropdown.get(0);
    }
}
