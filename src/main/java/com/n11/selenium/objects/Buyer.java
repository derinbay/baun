package com.n11.selenium.objects;

import com.n11.selenium.pages.FavoritesPage;
import com.n11.selenium.pages.HomePage;
import com.n11.selenium.pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Taylan on 09/12/2016.
 */
public class Buyer {

    private String email;
    private String password;
    private String name;
    private WebDriver driver;

    public Buyer(String email, String password, String name, WebDriver driver) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.driver = driver;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FavoritesPage goToFavorites() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@title='Hesabım']"))).perform();
        driver.findElement(By.xpath("//*[@title='Favorilerim']")).click();
        return new FavoritesPage(driver);
    }

    public FavoritesPage clearMyFavorites() {
        FavoritesPage favoritesPage = goToFavorites();

        if (!favoritesPage.isElementPresent(By.className("emptyWatchList"))) {
            driver.findElement(By.id("allItemsSelected")).click();
            driver.findElement(By.id("removeSelectedProducts")).click();
        }
        return favoritesPage;
    }

    public String addToFavoritesFromSearchResults(String keyword, int productRow) {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.search(keyword);
        return searchResultPage.addToFavorites(productRow);
    }
}





















