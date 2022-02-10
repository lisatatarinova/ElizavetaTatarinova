package com.epam.tc.hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;
import org.assertj.core.api.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JdiHomePageTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
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
    public void jdi2UserNameAfterLoginTest(){
        //Perform login
        WebElement loginButton = driver.findElement(By.id("user-icon"));
        loginButton.click();

        FluentWait<WebDriver> webDriverWait = new FluentWait(driver);
        List<WebElement> loginNameField = webDriverWait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("input#name"),0)
        );

        loginNameField.get(0).sendKeys("Roman");
        WebElement loginPasswordField = driver.findElement(By.cssSelector("input#password"));
        loginPasswordField.sendKeys("Jdi1234");
        WebElement pressEnter = driver.findElement(By.id("login-button"));
        pressEnter.click();

        //Assert Username is loggined
        WebElement userNameAfterLogin = webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("user-name"))
        );
        assertThat(userNameAfterLogin.getText()).isEqualTo("ROMAN IOVLEV");
    }


    @Test
    public void jdi3HeaderItemsTest(){
        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItems = driver.findElements(By.xpath("//header/div/nav/ul[contains(@class,'m-l8')]/li"));

        SoftAssertions softAssertionsForHeaderItems = new SoftAssertions();
        softAssertionsForHeaderItems.assertThat(headerItems.get(0).getText()).isEqualTo("HOME");
        softAssertionsForHeaderItems.assertThat(headerItems.get(1).getText()).isEqualTo("CONTACT FORM");
        softAssertionsForHeaderItems.assertThat(headerItems.get(2).getText()).isEqualTo("SERVICE");
        softAssertionsForHeaderItems.assertThat(headerItems.get(3).getText()).isEqualTo("METALS & COLORS");

        softAssertionsForHeaderItems.assertAll();
    }

    @Test
    public void jdi4ImagesInTheIndexPageTest(){
        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imgElements = driver.findElements(By.cssSelector("span[class*='icons-benefit']"));
        assertThat(imgElements.size()).isEqualTo(4);
    }

    @Test
    public void jdi5TextsInTheIndexPageTest(){
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> imgElements = driver.findElements(By.className("benefit-txt"));
        assertThat(imgElements.size()).isEqualTo(4);

        SoftAssertions softAssertionsForTextsInTheIndexPage = new SoftAssertions();
        softAssertionsForTextsInTheIndexPage.assertThat(imgElements.get(0).getText()).isEqualTo("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        softAssertionsForTextsInTheIndexPage.assertThat(imgElements.get(1).getText()).isEqualTo("To be flexible and\n" +
                "customizable");
        softAssertionsForTextsInTheIndexPage.assertThat(imgElements.get(2).getText()).isEqualTo("To be multiplatform");
        softAssertionsForTextsInTheIndexPage.assertThat(imgElements.get(3).getText()).isEqualTo("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        softAssertionsForTextsInTheIndexPage.assertAll();
    }

    @Test
    public void jdi6IframeWithFrameButtonExistsTest(){
        //Assert that there is the iframe with “Frame Button” exist
        List <WebElement> framewithFrameButton = driver.findElements(By.id("frame"));

        assertThat(framewithFrameButton.size()).isGreaterThan(0);
    }

    @Test
    public void jdi7frameButtonInIframeTest(){
        //Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");

        List <WebElement> frameButton = driver.findElements(By.cssSelector("input[value='Frame Button']"));

        assertThat(frameButton.size()).isGreaterThan(0);
        //Switch to original window back
        driver.switchTo().defaultContent();
    }

    @Test
    public void jdi8ItemOnTheLeftSectionTest(){
        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List <WebElement> sidebarMenu = driver.findElements(By.cssSelector("ul[class*='sidebar-menu'] > li"));

        assertThat(sidebarMenu.size()).isEqualTo(5);

        SoftAssertions softAssertionsForSidebarMenu = new SoftAssertions();

        softAssertionsForSidebarMenu.assertThat(sidebarMenu.get(0).getText()).isEqualTo("Home");
        softAssertionsForSidebarMenu.assertThat(sidebarMenu.get(1).getText()).isEqualTo("Contact form");
        softAssertionsForSidebarMenu.assertThat(sidebarMenu.get(2).getText()).isEqualTo("Service");
        softAssertionsForSidebarMenu.assertThat(sidebarMenu.get(3).getText()).isEqualTo("Metals & Colors");
        softAssertionsForSidebarMenu.assertThat(sidebarMenu.get(4).getText()).isEqualTo("Elements packs");
    }

    @AfterClass
    public void tearDown() {
        //Close Browser
        driver.quit();
    }
}
