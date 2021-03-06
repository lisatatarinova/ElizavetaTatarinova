package com.epam.tc.hw5.hook;

import com.epam.tc.hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberOptions {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        System.out.println("setUpAll");
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        TestContext.getInstance().setObject("driver", driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getInstance().cleanContext();
    }
}
