package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.testData.TestData;
import com.epam.tc.hw2.testData.TestLocators;
import com.epam.tc.hw2.testData.TestWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DifferentElementsPageTest {
    WebDriver driver;
    TestWaits testWait = new TestWaits();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testWait.setTestWaits(driver);
    }

    @Test
    public void differentElementsPageTest() {
        TestData expected = new TestData();
        TestLocators locator = new TestLocators(); //locator's finder
        //1. Open test site by URL
        driver.get(expected.URL);
        //2. Assert Browser title
        assertThat(driver.getTitle()).isEqualTo(expected.BROWSER_TITLE);
        //3. Perform login
        driver.findElement(locator.USER_ICON).click();
        testWait.waitUntilLoginMenuAppears().sendKeys(expected.USER_NAME);
        driver.findElement(locator.PASSWORD_INPUT).sendKeys(expected.USER_PASSWORD);
        driver.findElement(locator.LOGIN_BUTTON).click();
        //4. Assert Username is loggined
        assertThat(testWait.waitUntilUserIsLoggined().getText()).isEqualTo(expected.USER_LOGIN_NAME);
        //5. Open through the header menu Service -> Different Elements Page
        driver.findElement(locator.SERVICE_DROPDOWN).click();
        testWait.waitUntilServiceDropDownAppears().click();
        testWait.waitUntilDifferentElementsPageOpens();
        //6. Select checkboxes
       for(int i = 0; i < 2; i++) {
           driver.findElements(locator.CHECK_BOX)
                   .stream()
                   .filter(checkbox -> checkbox.getText().contains("Water") || checkbox.getText().contains("Wind"))
                   .collect(Collectors.toList()).get(i)
                   .click();
       }
        //7. Select radio
        driver.findElement(locator.RADIO_BUTTON).click();
        //8. Select in dropdown
        driver.findElement(locator.COLOUR_DROPDOWNITEM_RED).click();
        testWait.waitUntilColourDropDownAppers().click();
        //9. Assert that for each checkbox/radiobutton/dropdown there is an individual log row and corresponded value
        for(int i = 0; i < 4; i++) {
            assertThat(driver.findElements(locator.LOGS_CHECKBOXES_RADIOBUTTON)
                    .stream()
                    .filter(item -> item.getText().contains("Water")
                            || item.getText().contains("Wind")
                            || item.getText().contains("metal")
                            || item.getText().contains("Yellow"))
                    .collect(Collectors.toList()).size()).isEqualTo(4);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
