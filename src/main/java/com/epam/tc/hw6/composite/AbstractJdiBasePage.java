package com.epam.tc.hw6.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public abstract class AbstractJdiBasePage {

    protected WebDriver driver;
    protected FluentWait wait;

    protected AbstractJdiBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
}
