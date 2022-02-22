package com.epam.tc.hw3.pageObjects.composite.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBaseComponent {

    protected WebDriver driver;
    protected FluentWait wait;

    protected AbstractBaseComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait(driver);
        PageFactory.initElements(this.driver, this);
    }
}
