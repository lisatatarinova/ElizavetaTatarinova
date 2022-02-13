package com.epam.tc.hw2.testData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLocators {
    public By USER_ICON;
    public By USER_NAME;
    public By PASSWORD_INPUT;
    public By LOGIN_BUTTON;
    public By HEADER_ITEMS;
    public By IMAGES_ON_INDEX_PAGE;
    public By TEXTS_ON_INDEX_PAGE;
    public By EXISTING_IFRAMES;
    public By IFRAME_WITH_FRAME_BUTTON;
    public By LEFT_SECTION_ITEMS;
    public By DIFFERENT_ELEMENTS_ELEMENT;
    public By COLOUR_DROPDOWN;
    public By SERVICE_DROPDOWN;
    public Map<String, By> CHECK_BOX;
    public By RADIO_BUTTON;
    public By COLOUR_DROPDOWNITEM_RED;
    public Map<String, By> LOGS_CHECKBOXES_RADIOBUTTON;
    public By LOGS_DROPDOWN;

    public TestLocators(){
        this.USER_ICON = By.id("user-icon");
        this.USER_NAME = By.id("user-name");
        this.PASSWORD_INPUT = By.cssSelector("input#password");
        this.LOGIN_BUTTON = By.id("login-button");
        this.HEADER_ITEMS = By.xpath("//header/div/nav/ul[contains(@class,'m-l8')]/li");
        this.IMAGES_ON_INDEX_PAGE = By.cssSelector("span[class*='icons-benefit']");
        this.TEXTS_ON_INDEX_PAGE = By.className("benefit-txt");
        this.EXISTING_IFRAMES = By.id("frame");
        this.IFRAME_WITH_FRAME_BUTTON = By.cssSelector("input[value='Frame Button']");
        this.LEFT_SECTION_ITEMS = By.cssSelector("ul[class*='sidebar-menu'] > li");
        this.DIFFERENT_ELEMENTS_ELEMENT = By.xpath("//a[text()='Different elements']");
        this.COLOUR_DROPDOWN = By.xpath("//option[text()='Yellow']");
        this.SERVICE_DROPDOWN = By.xpath("//header/descendant::a[contains(.,'Service')]");
        this.CHECK_BOX = new HashMap<>();
        this.CHECK_BOX.put("water", By.xpath("//label[contains(.,'Water')]/input"));
        this.CHECK_BOX.put("wind", By.xpath("//label[contains(.,'Wind')]/input"));
        this.RADIO_BUTTON = By.xpath("//label[contains(.,'Selen')]/input");
        this.COLOUR_DROPDOWNITEM_RED = By.xpath("//option[text()='Red']");
        this.LOGS_CHECKBOXES_RADIOBUTTON = new HashMap<>();
        this.LOGS_CHECKBOXES_RADIOBUTTON.put("water",
                By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'Water')]"));
        this.LOGS_CHECKBOXES_RADIOBUTTON.put("wind",
                By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'Wind')]"));
        this.LOGS_CHECKBOXES_RADIOBUTTON.put("metal",
                By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'metal')]"));
        this.LOGS_DROPDOWN = By.xpath("//ul[@class='panel-body-list logs']/child::li[contains(.,'Colors')]");
    }
}
