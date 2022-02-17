package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.SeleniumBaseTest;
import com.epam.tc.hw3.page.objects.composite.JdiIndexPage;
import org.testng.annotations.Test;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JdiIndexPageTest extends SeleniumBaseTest {

    @Test
    public void indexPageTest(){
        JdiIndexPage indexPage = new JdiIndexPage(driver);
        //1. Open test site by URL
        indexPage.openSite("https://jdi-testing.github.io/jdi-light/index.html");
        //2. Assert Browser title
        assertThat(indexPage.getPageTitle()).isEqualTo("Home Page");
        //3. Perform login
        indexPage.login("Roman", "Jdi1234");
        //4. Assert Username is loggined
        assertThat(indexPage.getUsername()).isEqualTo("ROMAN IOVLEV");
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertThat(indexPage.getHeaderItems().count()).isEqualTo(4);
        softAssertions.assertThat(indexPage.getHeaderItems()
                .collect(Collectors.toList())).isEqualTo(expectedDataForTests.headerItems
                .collect(Collectors.toList()));
        softAssertions.assertAll();
        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertThat(indexPage.getImages().count()).isEqualTo(4);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertThat(indexPage.getTexts().count()).isEqualTo(4);
        softAssertions.assertThat(indexPage.getTexts()
                        .collect(Collectors.toList()))
                .isEqualTo(expectedDataForTests.texts
                        .collect(Collectors.toList()));
        softAssertions.assertAll();
        //8. Assert that there is the iframe with “Frame Button” exist
        assertThat(indexPage.getIframes().count()).isGreaterThan(0);
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertThat(indexPage.checkButtonsInFrame()).isEqualTo("Frame Button");
        //10. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertThat(indexPage.getLeftMenuItems().count()).isEqualTo(5);
        softAssertions.assertThat(indexPage.getLeftMenuItems()
                        .collect(Collectors.toList()))
                .isEqualTo(expectedDataForTests.leftMenuItems
                        .collect(Collectors.toList()));
        softAssertions.assertAll();
    }
}
