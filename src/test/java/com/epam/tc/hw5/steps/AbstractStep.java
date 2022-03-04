package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.composite.JdiDifferentElementsPage;
import com.epam.tc.hw5.composite.JdiIndexPage;
import com.epam.tc.hw5.composite.JdiUserTablePage;
import com.epam.tc.hw5.context.TestContext;
import org.openqa.selenium.WebDriver;

public class AbstractStep {

    protected JdiIndexPage indexPage;
    protected JdiDifferentElementsPage elementsPage;
    protected JdiUserTablePage userTablePage;

    protected AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        indexPage = new JdiIndexPage(driver);
        elementsPage = new JdiDifferentElementsPage(driver);
        userTablePage = new JdiUserTablePage(driver);
    }
}
