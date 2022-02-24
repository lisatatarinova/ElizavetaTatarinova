package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.ActionStepsEx2;
import com.epam.tc.hw4.SeleniumBaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.epam.tc.hw4.ExpectedDataForTests.*;

public class JdiDifferentElementsPageTest extends SeleniumBaseTest {
    @Feature("JDI Site Web Elements")
    @Story("As a User, I want to load Different Elements Page so that I can login and interact with Page Elements")
    @Test(description = "Different Elements Page: login and interaction with Page Elements")
    public void jdiDifferentElementsPageTest() {
        ActionStepsEx2 actionSteps = new ActionStepsEx2(indexPage);
        actionSteps.openSite("https://jdi-testing.github.io/jdi-light/index.html");
        actionSteps.assertBrowserTitle("Home Page");
        actionSteps.perfomLogin(user.getUsername(), user.getPassword());
        actionSteps.assertUserLoggedin(user.getName());
        actionSteps.openHeaderSubmenu("SERVICE", "DIFFERENT ELEMENTS", driver);
        actionSteps.selectCheckboxesAndRadioButtons(ITEMS_TO_BE_SELECTED);
        actionSteps.selectDropdown("Yellow");
        actionSteps.assertPageItemsLogs(4, ITEMS_LOGS);
    }
}
