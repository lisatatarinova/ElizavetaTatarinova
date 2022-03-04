package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.SeleniumBaseTest;
import com.epam.tc.hw4.utils.ListenerTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.tc.hw4.ExpectedDataForTests.*;

@Listeners(ListenerTest.class)
public class JdiDifferentElementsPageTest extends SeleniumBaseTest {
    @Feature("JDI Site Web Elements")
    @Story("As a User, I want to load Different Elements Page so that I can login and interact with Page Elements")
    @Test(description = "Different Elements Page: login and interaction with Page Elements")
    public void jdiDifferentElementsPageTest() {
        actionStep.openSite("https://jdi-testing.github.io/jdi-light/index.html");
        assertStep.assertBrowserTitle("Home Page");
        actionStep.perfomLogin(user.getUsername(), user.getPassword());
        assertStep.assertUserLoggedin(user.getName());
        actionStep.openHeaderSubmenu("SERVICE", "DIFFERENT ELEMENTS");
        actionStep.selectItem("Water");
        actionStep.selectItem("Wind");
        actionStep.selectItem("Selen");
        actionStep.selectDropDownItem("Yellow");
        assertStep.assertPageItemsLogs(4, ITEMS_LOGS);
    }
}
