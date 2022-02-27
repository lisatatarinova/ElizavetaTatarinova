package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.ActionStepsEx1;
import com.epam.tc.hw4.SeleniumBaseTest;
import com.epam.tc.hw4.utils.ListenerTest;
import com.epam.tc.hw4.utils.PropertyLoader;
import com.epam.tc.hw4.utils.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.tc.hw3.ExpectedDataForTests.HEADER_ITEMS;
import static com.epam.tc.hw3.ExpectedDataForTests.LEFT_MENU_ITEMS;
import static com.epam.tc.hw3.ExpectedDataForTests.TEXTS;

@Listeners(ListenerTest.class)
public class JdiIndexPageTest extends SeleniumBaseTest {
    @Feature("JDI Site Web Elements")
    @Story("As a User, I want to load Index Page so that I can login and navigate to the Header menu")
    @Test(description = "Index Page: Login and navigation to the Header menu")
    public void indexPageTest() {
        ActionStepsEx1 actionSteps = new ActionStepsEx1(indexPage, driver);
        User user = new PropertyLoader().getUserPreperties();
        actionSteps.openSite("https://jdi-testing.github.io/jdi-light/index.html");
        actionSteps.assertBrowserTitle("Home Page");
        actionSteps.perfomLogin(user.getUsername(), user.getPassword());
        actionSteps.assertUserLoggedin(user.getName());
        actionSteps.assertHeaderItems(4, HEADER_ITEMS);
        actionSteps.assertIndexPageImages(4);
        actionSteps.assertIndexPageTexts(4, TEXTS);
        actionSteps.checkIFrameExists();
        actionSteps.checkTheButtonInIFrame("Frame Button");
        actionSteps.assertItemsInLeftMenu(5, LEFT_MENU_ITEMS);
    }
}
