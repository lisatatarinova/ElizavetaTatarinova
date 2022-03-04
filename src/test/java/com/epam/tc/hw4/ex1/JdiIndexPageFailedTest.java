package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.SeleniumBaseTest;
import com.epam.tc.hw4.steps.ActionSteps;
import com.epam.tc.hw4.utils.ListenerTest;
import com.epam.tc.hw4.utils.PropertyLoader;
import com.epam.tc.hw4.utils.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.tc.hw3.ExpectedDataForTests.*;

@Listeners(ListenerTest.class)
public class JdiIndexPageFailedTest extends SeleniumBaseTest {
    @Feature("JDI Site Web Elements")
    @Story("As a User, I want to load Index Page so that I can login and navigate to the Header menu")
    @Test(description = "Index Page: Login and navigation to the Header menu")
    public void indexPageTest() {
        User user = new PropertyLoader().getUserPreperties();
        actionStep.openSite("https://jdi-testing.github.io/jdi-light/index.html");
        assertStep.assertBrowserTitle("Home Page1");
        actionStep.perfomLogin(user.getUsername(), user.getPassword());
        assertStep.assertUserLoggedin(user.getName());
        assertStep.assertHeaderItems(4, HEADER_ITEMS);
        assertStep.assertIndexPageImages(4);
        assertStep.assertIndexPageTexts(4, TEXTS);
        assertStep.checkIFrameExists();
        assertStep.checkTheButtonInIFrame("Frame Button");
        assertStep.assertItemsInLeftMenu(5, LEFT_MENU_ITEMS);
    }
}
