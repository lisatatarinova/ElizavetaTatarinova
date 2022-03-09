package com.epam.tc.hw4.steps;

import org.openqa.selenium.WebDriver;

public class AbstractStep {
    protected WebDriver driver;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
    }
}
