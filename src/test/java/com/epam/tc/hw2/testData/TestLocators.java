package com.epam.tc.hw2.testData;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

public class TestLocators {
    public By USER_ICON = By.id("user-icon");
    public By USER_NAME = By.id("user-name");
    public By PASSWORD_INPUT = By.cssSelector("input#password");
    public By NAME_INPUT = By.cssSelector("input#name");
    public By LOGIN_BUTTON = By.id("login-button");
    public By HEADER_ITEMS = By.xpath("//header/div/nav/ul[contains(@class,'m-l8')]/li");
    public By IMAGES_ON_INDEX_PAGE = By.cssSelector("span[class*='icons-benefit']");
    public By TEXTS_ON_INDEX_PAGE = By.className("benefit-txt");
    public By EXISTING_IFRAMES = By.id("frame");
    public By IFRAME_WITH_FRAME_BUTTON = By.cssSelector("input[value='Frame Button']");
    public By LEFT_SECTION_ITEMS = By.cssSelector("ul[class*='sidebar-menu'] > li");
    public By DIFFERENT_ELEMENTS_ELEMENT = By.xpath("//a[text()='Different elements']");
    public By COLOUR_DROPDOWN = By.xpath("//option[text()='Yellow']");
    public By SERVICE_DROPDOWN = By.xpath("//header/descendant::a[contains(.,'Service')]");
    public Map<String, By> CHECK_BOX = new HashMap<>();
    {
        this.CHECK_BOX.put("water", By.xpath("//label[contains(.,'Water')]/input"));
        this.CHECK_BOX.put("wind", By.xpath("//label[contains(.,'Wind')]/input"));
    }
    public By RADIO_BUTTON = By.xpath("//label[contains(.,'Selen')]/input");
    public By COLOUR_DROPDOWNITEM_RED = By.xpath("//option[text()='Red']");
    public Map<String, By> LOGS_CHECKBOXES_RADIOBUTTON = new HashMap<>();
    {
        LOGS_CHECKBOXES_RADIOBUTTON.put("water",
                By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'Water')]"));
        LOGS_CHECKBOXES_RADIOBUTTON.put("wind",
                By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'Wind')]"));
        LOGS_CHECKBOXES_RADIOBUTTON.put("metal",
                By.xpath("//ul[contains(@class,logs)]/child::li[contains(.,'metal')]"));
    }
    public By LOGS_DROPDOWN = By.xpath("//ul[@class='panel-body-list logs']/child::li[contains(.,'Colors')]");
}
