package com.n11.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class BasePage {

    @FindBy(className = "btnSignIn")
    private WebElement signInButton;

    @FindBy(id = "searchData")
    private WebElement searchBar;

    @FindBy(className = "searchBtn")
    private WebElement searchButton;

    @FindBy(className = "username")
    private WebElement username;

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage callLoginPage() {
        PageFactory.initElements(driver, this);
        signInButton.click();
        return new LoginPage(driver);
    }

    public SearchResultPage search(String keyword) {
        PageFactory.initElements(driver, this);
        searchBar.sendKeys(keyword);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public boolean isLoggedIn() {
        PageFactory.initElements(driver, this);
        String userName = username.getText();
        return userName.equals("UAT BUYER DONTUSETHISBUYER");
    }
}
