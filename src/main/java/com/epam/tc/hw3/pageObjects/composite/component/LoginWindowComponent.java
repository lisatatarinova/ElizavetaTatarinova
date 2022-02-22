package com.epam.tc.hw3.pageObjects.composite.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginWindowComponent extends AbstractBaseComponent {

    @FindBy(css = "input#password")
    private WebElement passwordInput;

    @FindBy(css = "input#name")
    private WebElement loginInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    String login;
    String password;

    public LoginWindowComponent(WebDriver driver, String login, String password) {
        super(driver);
        this.login = login;
        this.password = password;
    }

    public void openLoginWindow() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("form-horizontal-pad"), 0));
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
