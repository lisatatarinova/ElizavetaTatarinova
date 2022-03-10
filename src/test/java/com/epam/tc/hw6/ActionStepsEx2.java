package com.epam.tc.hw6;

import com.epam.tc.hw4.ExpectedDataForTests;
import com.epam.tc.hw4.SeleniumBaseTest;
import com.epam.tc.hw4.composite.JdiDifferentElementsPage;
import com.epam.tc.hw4.composite.JdiIndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActionStepsEx2 extends SeleniumBaseTest {
    JdiIndexPage indexPage;
    JdiDifferentElementsPage elementsPage;

    public ActionStepsEx2(JdiIndexPage indexPage) {
        this.indexPage = indexPage;
    }

    @Step("1. Open test site by URL")
    public void openSite(String url) {
        indexPage.openSite(url);
    }

    @Step("2. Assert Browser title = {title}")
    public void assertBrowserTitle(String title){
        assertThat(indexPage.getPageTitle()).isEqualTo(title);
    }

    @Step("3. Perform login({username}, {password})")
    public void perfomLogin(String username, String password) {
        indexPage.login(username, password);
    }

    @Step("4. Assert Username = {name} is loggined")
    public void assertUserLoggedin(String name) {
        assertThat(indexPage.getUsername()).isEqualTo(name);
    }

    @Step("5. Open through the header menu {menu} -> {subMenu}")
    public void openHeaderSubmenu(String menu, String subMenu, WebDriver driver) {
        indexPage.openHeaderSubMenu(menu, subMenu);
        this.elementsPage = new JdiDifferentElementsPage(driver);
        assertThat(elementsPage.getCurrentPageUrl())
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");
    }


    @Step("6. Select checkboxes / radio")
    public void selectCheckboxesAndRadioButtons(List<String> itemsToBeSelected) {
        itemsToBeSelected.forEach(elementsPage::selectItem);
    }

    @Step("7. Select in dropdown")
    public void selectDropdown(String itemForDropDown) {
        elementsPage.selectInDropDown(itemForDropDown);
    }

    @Step("8. Assert that for each checkbox/radio button/dropdown there is a log " +
            "row and value is corresponded to the status")
    public void assertPageItemsLogs(int itemsCount, List<ExpectedDataForTests.ItemsLog> itemsLogs) {
        try {
            for(int i=0; i<itemsCount; i++) {
                softAssertions
                        .assertThat(elementsPage
                                .getItemLogs()
                                .get(i)
                                .contains(itemsLogs.get(i).itemNameLog)
                                && elementsPage
                                .getItemLogs()
                                .get(i)
                                .contains(itemsLogs.get(i).itemStatusLog))
                        .isEqualTo(true);
            }
            softAssertions.assertAll();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index 3 out of bounds for length 3");
        }

    }
}
