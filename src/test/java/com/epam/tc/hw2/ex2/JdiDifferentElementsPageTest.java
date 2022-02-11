package com.epam.tc.hw2.ex2;

import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JdiDifferentElementsPageTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        String driverPath = "/Users/Elizaveta_Tatarinova/Downloads/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void jdi1BrowserNameTest() {
        //Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        //Assert Browser title
        assertThat(driver.getTitle()).isEqualTo("Home Page");
    }

    @Test
    public void jdi2UserNameAfterLoginTest() {
        //Perform login
        driver.findElement(By.id("user-icon")).click();

        FluentWait<WebDriver> webDriverWait = new FluentWait(driver);
        List<WebElement> loginNameField = webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("input#name"), 0)
        );

        loginNameField.get(0).sendKeys("Roman");
        driver.findElement(By.cssSelector("input#password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        //Assert Username is loggined
        WebElement userNameAfterLogin = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("user-name"))
        );
        assertThat(userNameAfterLogin.getText()).isEqualTo("ROMAN IOVLEV");
    }

    @Test
    public void jdi3DifferentElementsPageTest() {
        //Open through the header menu Service -> Different Elements Page
        WebElement serviceInHeaderButton =
                driver.findElement(By.xpath("//header/descendant::a[contains(.,'Service')]"));
        serviceInHeaderButton.click();

        FluentWait<WebDriver> webDriverWait = new FluentWait(driver);
        List<WebElement> serviceDropDown = webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[text()='Different elements']"), 0)
        );
        serviceDropDown.get(0).click();

        //WebDriverWait webDriverWait1 = new WebDriverWait(driver, Duration.ofSeconds(100));
        webDriverWait.until(ExpectedConditions.urlToBe("https://jdi-testing.github.io/jdi-light/different-elements.html"));

        //Select checkboxes
        driver.findElement(By.xpath("//label[contains(.,\"Water\")]/input")).click();
        driver.findElement(By.xpath("//label[contains(.,\"Wind\")]/input")).click();

        //Select radio
        driver.findElement(By.xpath("//label[contains(.,\"Selen\")]/input")).click();

        //Select in dropdown
        driver.findElement(By.xpath("//option[text()='Red']")).click();

        List<WebElement> colourDropdown = webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//option[text()='Yellow']"), 0)
        );
        colourDropdown.get(0).click();

        //Assert that
        //•	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertThat(driver.findElement(By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'Water')]"))
                .getText()).contains("true");
        assertThat(driver.findElement(By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'Wind')]"))
                .getText()).contains("true");
        //Assert that
        //•	for radio button there is a log row and value is corresponded to the status of radio button
        assertThat(driver.findElement(By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'metal')]"))
                .getText()).contains("Selen");
        //Assert that
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertThat(driver.findElement(By.xpath("//ul[@class='panel-body-list logs']/child::li[contains(.,'Colors')]"))
                .getText()).contains("Yellow");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
