package com.n11.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        clickTo(signInButton);
        return new LoginPage(driver);
    }

    public void clickTo(WebElement element) {
        waitObject(element);
        element.click();
    }

    private void waitObject(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private void waitObject(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
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

    public FavoritesPage goToFavorites() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@title='Hesabım']"))).perform();
        driver.findElement(By.xpath("//*[@title='Favorilerim']")).click();
        return new FavoritesPage(driver);
    }
}
