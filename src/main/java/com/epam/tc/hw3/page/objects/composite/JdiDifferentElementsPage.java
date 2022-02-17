package com.epam.tc.hw3.page.objects.composite;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JdiDifferentElementsPage extends AbstractJdiBasePage {

    @FindAll({
        @FindBy(className = "label-checkbox"),
        @FindBy(className = "label-radio")
    })
    private List<WebElement> items;

    @FindBy(css = "div[class='colors']")
    private WebElement dropdownMenu;

    @FindBy(css = "[class = 'uui-form-element'] > option")
    private List<WebElement> dropdownItems;

    @FindBy(css = "ul[class='panel-body-list logs'] > li")
    private List<WebElement> logs;

    public JdiDifferentElementsPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlToBe("https://jdi-testing.github.io/jdi-light/different-elements.html"));
    }

    @Override
    public String getCurrentPageUrl() {
        return super.getCurrentPageUrl();
    }

    public void selectItem(String itemName) {
        items.stream()
                .filter(item ->
                        item.getText().contains(itemName))
                .toList().get(0).click();
    }

    public void selectInDropDown(String dropdownItemName) {
        dropdownMenu.click();
        wait.until(ExpectedConditions
                .visibilityOf(dropdownItems
                        .stream()
                        .filter(item -> item.getText().contains(dropdownItemName))
                        .toList().get(0)));
        dropdownItems.stream()
                .filter(item -> item.getText().contains(dropdownItemName))
                .toList().get(0).click();
    }

    public List<String> getItemLogs() {
        return logs.stream().map(WebElement::getText).toList();
    }
}
