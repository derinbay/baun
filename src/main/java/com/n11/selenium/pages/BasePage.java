package com.n11.selenium.pages;

import com.n11.selenium.objects.Buyer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class BasePage extends Page {

    @FindBy(className = "btnSignIn")
    private WebElement signInButton;

    @FindBy(id = "searchData")
    private WebElement searchBar;

    @FindBy(className = "searchBtn")
    private WebElement searchButton;

    @FindBy(className = "username")
    private WebElement username;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage callLoginPage() {
        clickTo(signInButton);
        return new LoginPage(driver);
    }

    public SearchResultPage search(String keyword) {
        typeTo(searchBar, keyword);
        clickTo(searchButton);
        return new SearchResultPage(driver);
    }

    public boolean isLoggedIn(Buyer buyer) {
        String userNameOnPage = getText(username);
        return userNameOnPage.equals(buyer.getName());
    }
}
