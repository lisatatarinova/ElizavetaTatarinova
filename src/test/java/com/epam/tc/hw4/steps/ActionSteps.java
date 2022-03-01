package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.composite.JdiDifferentElementsPage;
import com.epam.tc.hw4.composite.JdiIndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActionSteps extends AbstractStep {
    JdiIndexPage indexPage;
    JdiDifferentElementsPage elementsPage;

    public ActionSteps(WebDriver driver) {
        super(driver);
        indexPage = new JdiIndexPage(driver);
        elementsPage = new JdiDifferentElementsPage(driver);
    }

    //INDEX PAGE

    @Step("Open test site by URL")
    public void openSite(String url) {
        indexPage.openSite(url);
    }

    @Step("Perform login({username}, {password})")
    public void perfomLogin(String username, String password) {
        indexPage.login(username, password);
    }

    //DIFFERENT ELEMENTS PAGE

    @Step("5. Open through the header menu {menu} -> {subMenu}")
    public void openHeaderSubmenu(String menu, String subMenu) {
        indexPage.openHeaderSubMenu(menu, subMenu);
        this.elementsPage = new JdiDifferentElementsPage(driver);
        assertThat(elementsPage.getCurrentPageUrl())
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");
    }

    @Step("Select item {itemName} on the page")
    public void selectItem(String item) {
        elementsPage.selectItem(item);
    }

    @Step("Select item on the page")
    public void selectDropDownItem(String item) {
        elementsPage.selectInDropDown(item);
    }

}