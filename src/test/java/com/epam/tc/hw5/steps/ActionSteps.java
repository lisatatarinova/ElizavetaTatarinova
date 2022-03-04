package com.epam.tc.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class ActionSteps extends AbstractStep {
    //INDEX PAGE

    @Given("I open JDI GitHub site {string}")
    public void openSite(String url) {
        indexPage.openSite(url);
    }

    @Given("I login as user with username = {string} and password = {string}")
    public void perfomLogin(String username, String password) {
        indexPage.login(username, password);
    }

    //DIFFERENT ELEMENTS PAGE

    @When("I open through the header menu {string} -> {string}")
    public void openHeaderSubmenu(String menu, String subMenu) {
        indexPage.openHeaderSubMenu(menu, subMenu);
    }

    @When("Select item {string}")
    public void selectItem(String item) {
        elementsPage.selectItem(item);
    }

    @When("Select in dropdown {string}")
    public void selectDropDownItem(String item) {
        elementsPage.selectInDropDown(item);
    }

    @When("I select Vip checkbox for {string}")
    public void selectCheckbox(String userName) {
        userTablePage.selectCheckBox(userName);
    }
}
