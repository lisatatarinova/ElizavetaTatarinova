package com.epam.tc.hw6;

import com.epam.tc.hw4.SeleniumBaseTest;
import com.epam.tc.hw4.composite.JdiIndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActionStepsEx1 extends SeleniumBaseTest {
    JdiIndexPage indexPage;

    public ActionStepsEx1(JdiIndexPage indexPage, WebDriver driver) {
        this.indexPage = indexPage;
        this.driver = driver;
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

    @Step("5. Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderItems(int number, List<String> headerNames) {
        assertThat(indexPage.getHeaderItems().size()).isEqualTo(number);
        softAssertions.assertThat(indexPage.getHeaderItems()).isEqualTo(headerNames);
        softAssertions.assertAll();
    }

    @Step("6. Assert that there are 4 images on the Index Page and they are displayed")
    public void assertIndexPageImages(int number) {
        assertThat(indexPage.getImages().size()).isEqualTo(number);
    }

    @Step("7. Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertIndexPageTexts(int number, List<String> texts) {
        assertThat(indexPage.getTexts().size()).isEqualTo(number);
        softAssertions.assertThat(indexPage.getTexts()).isEqualTo(texts);
        softAssertions.assertAll();
    }

    @Step("8. Assert that there is the iframe with “Frame Button” exist")
    public void checkIFrameExists() {
        assertThat(indexPage.getIframes().size()).isGreaterThan(0);
    }

    @Step("9. Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void checkTheButtonInIFrame(String buttonName) {
        assertThat(indexPage.getButtonsInFrame()).isEqualTo(buttonName);
    }

    @Step("10. Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertItemsInLeftMenu(int number, List<String> leftMenuItems) {
        assertThat(indexPage.getLeftMenuItems().size()).isEqualTo(number);
        softAssertions.assertThat(indexPage.getLeftMenuItems()).isEqualTo(leftMenuItems);
        softAssertions.assertAll();
    }

}
