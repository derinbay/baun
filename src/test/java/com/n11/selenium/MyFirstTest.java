package com.n11.selenium;

import com.n11.selenium.pages.FavoritesPage;
import com.n11.selenium.pages.HomePage;
import com.n11.selenium.pages.SearchResultPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class MyFirstTest extends BaseTest {

    @Test
    public void shouldLogin() {
        HomePage homePage = new HomePage(driver)
                .callLoginPage()
                .login("seleniummallfront90@mailcatch.com", "N11passw0rd");
        assertTrue(homePage.isLoggedIn());

        homePage.search("samsung");
    }

    @Test
    public void shouldAddToFavorites() {
        SearchResultPage resultPage = new HomePage(driver)
                .callLoginPage()
                .login("seleniummallfront90@mailcatch.com", "N11passw0rd")
                .search("kalem");

        String productName = resultPage.addToFavorites(1);
        resultPage.goToFavorites();

        FavoritesPage favoritesPage = new FavoritesPage(driver);
        assertTrue(productName.equals(favoritesPage.getProductName()));
    }
}
