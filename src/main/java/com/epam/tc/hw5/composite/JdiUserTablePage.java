package com.epam.tc.hw5.composite;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JdiUserTablePage extends AbstractJdiBasePage {

    @FindBy(css = "td > select")
    private List<WebElement> dropDownItems;

    @FindBy(css = "td > a")
    private List<WebElement> usernameItems;

    @FindBy(css = "div[class='user-descr'] > span")
    private List<WebElement> descriptionItems;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxesItems;

    @FindBy(css = "tr td:first-child")
    private List<WebElement> numberItem;

    @FindBy(xpath = "//a[contains(text(),'Roman')]/preceding::option")
    private List<WebElement> dropDownOptions;

    @FindBy(css = "ul[class='panel-body-list logs'] > li")
    private List<WebElement> logs;

    public JdiUserTablePage(WebDriver driver) {
        super(driver);
    }

    public int getTableItemsCounter(String itemType) {
        int count = 0;
        switch (itemType) {
            case "Dropdowns":
                count = dropDownItems.size();
                break;
            case "Usernames":
                count = usernameItems.size();
                break;
            case "Description texts under images":
                count = descriptionItems.size();
                break;
            case "Checkboxes":
                count = checkboxesItems.size();
                break;
            default:
                break;
        }
        return count;
    }

    public List<Map<String, String>> getTableFromUserPage() {
        List<Map<String, String>> table = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Map<String, String> row = new LinkedHashMap<>();
            row.put("Number", numberItem.get(i).getText());
            row.put("User", usernameItems.get(i).getText());
            row.put("Description", descriptionItems.get(i).getText().replaceAll("\n", " "));
            table.add(row);
        }
        return table;
    }

    public List<String> getDropDownValues() {
        dropDownItems.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(dropDownOptions.get(0)));
        System.out.println(dropDownOptions.get(0).getText());
        return dropDownOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void selectCheckBox(String userName) {
        driver.findElement(By.xpath("//a[contains(text(),'"
                + userName + "')]/following::input[@type='checkbox']")).click();
    }

    public List<String> getLogs() {
        if (logs.size() != 0) {
            return logs.stream().map(WebElement::getText)
                    .map(item -> item.substring(9, item.length())).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}
