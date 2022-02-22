package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.SeleniumBaseTest;
import com.epam.tc.hw3.pageObjects.composite.JdiDifferentElementsPage;
import com.epam.tc.hw3.pageObjects.composite.JdiIndexPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.epam.tc.hw3.ExpectedDataForTests.*;

public class JdiDifferentElementsPageTest extends SeleniumBaseTest {

    @Test
    public void jdiDifferentElementsPageTest() {
        JdiIndexPage indexPage = new JdiIndexPage(driver);
        //1. Open test site by URL
        indexPage.openSite("https://jdi-testing.github.io/jdi-light/index.html");
        //2. Assert Browser title
        assertThat(indexPage.getPageTitle()).isEqualTo("Home Page");
        //3. Perform login
        indexPage.login(user.getUsername(), user.getPassword());
        //4. Assert Username is loggined
        assertThat(indexPage.getUsername()).isEqualTo(user.getName());
        //5. Open through the header menu Service -> Different Elements Page
        indexPage.openPageThroughMenu("SERVICE", "DIFFERENT ELEMENTS");
        JdiDifferentElementsPage elementsPage = new JdiDifferentElementsPage(driver);
        assertThat(elementsPage.getCurrentPageUrl())
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");
        //6. Select checkboxes / radio
        ITEMS_TO_BE_SELECTED.forEach(elementsPage::selectItem);
        //8. Select in dropdown
        elementsPage.selectInDropDown("Yellow");
        //9. Assert that for each checkbox/radio button/dropdown there is a log row and value is corresponded to the status
        for(int i=0; i<4; i++) {
            softAssertions
                    .assertThat(elementsPage
                            .getItemLogs()
                            .get(i)
                            .contains(ITEMS_LOGS.get(i).itemNameLog)
                    && elementsPage
                            .getItemLogs()
                            .get(i)
                            .contains(ITEMS_LOGS.get(i).itemStatusLog))
                    .isEqualTo(true);
        }
        softAssertions.assertAll();
    }
}
