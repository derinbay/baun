package com.n11.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password) {
        initElements(driver, this);
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}

