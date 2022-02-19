package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.SeleniumBaseTest;
import com.epam.tc.hw3.pageObjects.composite.JdiIndexPage;
import com.epam.tc.hw3.utils.PropertyLoader;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.epam.tc.hw3.ExpectedDataForTests.*;

public class JdiIndexPageTest extends SeleniumBaseTest {

    @Test
    public void indexPageTest(){
        JdiIndexPage indexPage = new JdiIndexPage(driver);
        //1. Open test site by URL
        indexPage.openSite("https://jdi-testing.github.io/jdi-light/index.html");
        //2. Assert Browser title
        assertThat(indexPage.getPageTitle()).isEqualTo("Home Page");
        //3. Perform login
        indexPage.login(user.getUsername(), user.getPassword());
        //4. Assert Username is loggined
        assertThat(indexPage.getUsername()).isEqualTo(user.getName());
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertThat(indexPage.getHeaderItems().size()).isEqualTo(4);
        softAssertions.assertThat(indexPage.getHeaderItems()).isEqualTo(HEADER_ITEMS);
        softAssertions.assertAll();
        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertThat(indexPage.getImages().size()).isEqualTo(4);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertThat(indexPage.getTexts().size()).isEqualTo(4);
        softAssertions.assertThat(indexPage.getTexts()).isEqualTo(TEXTS);
        softAssertions.assertAll();
        //8. Assert that there is the iframe with “Frame Button” exist
        assertThat(indexPage.getIframes().size()).isGreaterThan(0);
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertThat(indexPage.checkButtonsInFrame()).isEqualTo("Frame Button");
        //10. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertThat(indexPage.getLeftMenuItems().size()).isEqualTo(5);
        softAssertions.assertThat(indexPage.getLeftMenuItems()).isEqualTo(LEFT_MENU_ITEMS);
        softAssertions.assertAll();
    }
}
