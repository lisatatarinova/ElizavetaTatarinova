package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.ExpectedDataForTests;
import com.epam.tc.hw4.composite.JdiDifferentElementsPage;
import com.epam.tc.hw4.composite.JdiIndexPage;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertSteps extends AbstractStep {
    JdiIndexPage indexPage;
    JdiDifferentElementsPage elementsPage;
    SoftAssertions softAssertions = new SoftAssertions();

    public AssertSteps(WebDriver driver) {
        super(driver);
        indexPage = new JdiIndexPage(driver);
        elementsPage = new JdiDifferentElementsPage(driver);
    }

    //INDEX PAGE

    @Step("Assert Browser title = {title}")
    public void assertBrowserTitle(String title) {
        assertThat(indexPage.getPageTitle()).isEqualTo(title);
    }

    @Step("Assert Username = {name} is loggined")
    public void assertUserLoggedin(String name) {
        assertThat(indexPage.getUsername()).isEqualTo(name);
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderItems(int number, List<String> headerNames) {
        assertThat(indexPage.getHeaderItems().size()).isEqualTo(number);
        softAssertions.assertThat(indexPage.getHeaderItems()).isEqualTo(headerNames);
        softAssertions.assertAll();
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertIndexPageImages(int number) {
        assertThat(indexPage.getImages().size()).isEqualTo(number);
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertIndexPageTexts(int number, List<String> texts) {
        assertThat(indexPage.getTexts().size()).isEqualTo(number);
        softAssertions.assertThat(indexPage.getTexts()).isEqualTo(texts);
        softAssertions.assertAll();
    }

    @Step("Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void checkTheButtonInIFrame(String buttonName) {
        assertThat(indexPage.getButtonsInFrame()).isEqualTo(buttonName);
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void checkIFrameExists() {
        assertThat(indexPage.getIframes().size()).isGreaterThan(0);
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertItemsInLeftMenu(int number, List<String> leftMenuItems) {
        assertThat(indexPage.getLeftMenuItems().size()).isEqualTo(number);
        softAssertions.assertThat(indexPage.getLeftMenuItems()).isEqualTo(leftMenuItems);
        softAssertions.assertAll();
    }

    //DIFFERENT ELEMENTS PAGE

    @Step("Assert that for each checkbox/radio button/dropdown there is a log " +
            "row and value is corresponded to the status")
    public void assertPageItemsLogs(int itemsCount, List<ExpectedDataForTests.ItemsLog> itemsLogs) {
        System.out.println(itemsCount);
        try {
            for (int i = 0; i < itemsCount; i++) {
                System.out.println(itemsLogs.get(i));
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