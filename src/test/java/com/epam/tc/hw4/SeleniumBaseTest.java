package com.epam.tc.hw4;

import com.epam.tc.hw4.composite.JdiDifferentElementsPage;
import com.epam.tc.hw4.composite.JdiIndexPage;
import com.epam.tc.hw4.ex1.JdiIndexPageTest;
import com.epam.tc.hw4.utils.ListenerTest;
import com.epam.tc.hw4.utils.PropertyLoader;
import com.epam.tc.hw4.utils.ScreenshotMaker;
import com.epam.tc.hw4.utils.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class SeleniumBaseTest {
    protected WebDriver driver;
    protected SoftAssertions softAssertions = new SoftAssertions();
    protected User user = new PropertyLoader().getUserPreperties();
    protected JdiIndexPage indexPage;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.indexPage = new JdiIndexPage(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
