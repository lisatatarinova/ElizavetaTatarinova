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
        //6. WebDriverWait webDriverWait1 = new WebDriverWait(driver, Duration.ofSeconds(100));
        testWait.waitUntilDifferentElementsPageOpens();
        //7. Select checkboxes
        driver.findElement(locator.CHECK_BOX.get("water")).click();
        driver.findElement(locator.CHECK_BOX.get("wind")).click();
        //8. Select radio
        driver.findElement(locator.RADIO_BUTTON).click();
        //9. Select in dropdown
        driver.findElement(locator.COLOUR_DROPDOWNITEM_RED).click();
        testWait.waitUntilColourDropDownAppers().click();
        //10. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertThat(driver.findElement(locator.LOGS_CHECKBOXES_RADIOBUTTON.get("water"))
                .getText()).contains("true");
        assertThat(driver.findElement(locator.LOGS_CHECKBOXES_RADIOBUTTON.get("wind"))
                .getText()).contains("true");
        //11. Assert that for radio button there is a log row and value is corresponded to the status of radio button
        assertThat(driver.findElement(locator.LOGS_CHECKBOXES_RADIOBUTTON.get("metal"))
                .getText()).contains("Selen");
        //12. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        assertThat(driver.findElement(locator.LOGS_DROPDOWN)
                .getText()).contains("Yellow");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
