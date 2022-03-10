package com.epam.tc.hw6.composite;

import com.epam.tc.hw6.composite.component.LoginWindowComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class JdiIndexPage extends AbstractJdiBasePage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//header/div/nav/ul[contains(@class,'m-l8')]/li/a")
    private List<WebElement> headerItems;

    @FindBy(xpath = "//ul[@class='dropdown-menu' and @role='menu']/li/a")
    private List<WebElement> headerSubMenu;

    @FindBy(css = "span[class*='icons-benefit']")
    private List<WebElement> images;

    @FindBy(className = "benefit-txt")
    private List<WebElement> texts;

    @FindBy(id = "frame")
    private List<WebElement> iframes;

    @FindBy(id = "frame-button")
    private WebElement iframeButtons;

    @FindBy(css = "[class='sidebar-menu left'] > li > a > span")
    private List<WebElement> leftMenuItems;

    public JdiIndexPage(WebDriver driver) {
        super(driver);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void login(String login, String password) {
        userIcon.click();
        new LoginWindowComponent(driver, login, password).openLoginWindow();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("user-name"), 0));
    }

    public String getUsername() {
        return userName.getText();
    }

    public List<String> getHeaderItems() {
        return headerItems.stream().map(WebElement::getText).toList();
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<String> getTexts() {
        return texts.stream().map(WebElement::getText).toList();
    }

    public List<WebElement> getIframes() {
        return iframes;
    }

    public String getButtonsInFrame() {
        driver.switchTo().frame("frame");
        String frameButtonValue = iframeButtons.getAttribute("value");
        driver.switchTo().defaultContent();
        return frameButtonValue;
    }

    public List<String> getLeftMenuItems() {
        return leftMenuItems.stream().map(WebElement::getText).toList();
    }

    public void openHeaderSubMenu(String menuItem, String subMenuItem) {
        headerItems.stream()
                .filter(item -> item.getText().contains(menuItem))
                .toList()
                .get(0).click();
        wait.until(ExpectedConditions.visibilityOf(headerSubMenu.get(0)));
        headerSubMenu.stream().filter(item -> item.getText().contains(subMenuItem)).toList().get(0).click();
    }
}
