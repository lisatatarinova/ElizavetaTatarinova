package com.epam.tc.hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    static void beforeSuite() {
        PageFactory.initSite(Site.class);
    }

    @AfterSuite(alwaysRun = true)
    static void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
