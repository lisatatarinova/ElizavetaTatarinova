package com.epam.tc.hw4;

import com.epam.tc.hw4.steps.ActionSteps;
import com.epam.tc.hw4.steps.AssertSteps;
import com.epam.tc.hw4.utils.PropertyLoader;
import com.epam.tc.hw4.utils.User;
import com.epam.tc.hw4.ExpectedDataForTests;
import io.cucumber.java.bs.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBaseTest {
    protected WebDriver driver;
    protected User user = new PropertyLoader().getUserPreperties();
    protected ActionSteps actionStep;
    protected AssertSteps assertStep;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        actionStep = new ActionSteps(driver);
        assertStep = new AssertSteps(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
