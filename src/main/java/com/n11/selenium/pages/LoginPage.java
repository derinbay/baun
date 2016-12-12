package com.n11.selenium.pages;

import com.n11.selenium.objects.Buyer;
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

    public HomePage login(Buyer buyer) {
        initElements(driver, this);
        typeTo(emailTextBox, buyer.getEmail());
        typeTo(passwordTextBox, buyer.getPassword());
        clickTo(loginButton);

        return new HomePage(driver);
    }
}

