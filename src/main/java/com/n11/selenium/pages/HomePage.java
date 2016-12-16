package com.n11.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FavoritesPage clearMyFavorites() {
        FavoritesPage favoritesPage = goToFavorites();

        if (!isElementPresent(By.className("emptyWatchList"))) {
            driver.findElement(By.id("allItemsSelected")).click();
            driver.findElement(By.id("removeSelectedProducts")).click();
        }
        return favoritesPage;
    }
}
