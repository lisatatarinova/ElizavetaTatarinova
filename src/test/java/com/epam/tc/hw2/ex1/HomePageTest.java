package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.testData.TestData;
import com.epam.tc.hw2.testData.TestLocators;
import com.epam.tc.hw2.testData.TestWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.assertj.core.api.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomePageTest {
    WebDriver driver;
    SoftAssertions softAssertions = new SoftAssertions();
    TestWaits testWait = new TestWaits();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testWait.setTestWaits(driver);
    }

    @Test
    public void homePageTest() {
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
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        for(int i = 0; i<expected.HEADER_ITEMS.size(); i++)
        {
            softAssertions.assertThat(driver.findElements(locator.HEADER_ITEMS).get(i)
                    .getText()).isEqualTo(expected.HEADER_ITEMS.get(i));
        }
        softAssertions.assertAll();
        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertThat(driver.findElements(locator.IMAGES_ON_INDEX_PAGE).size()).isEqualTo(4);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertThat(driver.findElements(locator.TEXTS_ON_INDEX_PAGE).size()).isEqualTo(4);
        for(int i = 0; i<expected.ICONS_TEXTS.size(); i++)
        {
            softAssertions.assertThat(driver.findElements(locator.TEXTS_ON_INDEX_PAGE)
                    .get(i).getText()).isEqualTo(expected.ICONS_TEXTS.get(i));
        }
        softAssertions.assertAll();
        //8. Assert that there is the iframe with “Frame Button” exist
        assertThat(driver.findElements(locator.EXISTING_IFRAMES).size()).isGreaterThan(0);
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        assertThat(driver.findElements(locator.IFRAME_WITH_FRAME_BUTTON).size()).isGreaterThan(0);
        //10. Switch to original window back
        driver.switchTo().defaultContent();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertThat(driver.findElements(locator.LEFT_SECTION_ITEMS).size()).isEqualTo(5);
        for(int i = 0; i<expected.MENU_ITEMS.size(); i++) {
            softAssertions.assertThat(driver.findElements(locator.LEFT_SECTION_ITEMS)
                    .get(i).getText()).isEqualTo(expected.MENU_ITEMS.get(i));
        }
        softAssertions.assertAll();
    }

    @AfterClass
    public void tearDown() {
        //Close Browser
        driver.quit();
    }
}
