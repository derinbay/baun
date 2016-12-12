package com.n11.selenium;

import com.n11.selenium.objects.Buyer;
import com.n11.selenium.objects.BuyerPool;
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
        Buyer buyer = BuyerPool.buyerForLoginTest();
        HomePage homePage = new HomePage(driver)
                .callLoginPage()
                .login(buyer);
        assertTrue(homePage.isLoggedIn(buyer));

        homePage.search("samsung");
    }

    @Test
    public void shouldAddToFavorites() {
        Buyer buyer = BuyerPool.buyerForFavoritesTest();
        HomePage homePage = new HomePage(driver)
                .callLoginPage()
                .login(buyer);

        FavoritesPage favoritesPage = homePage.clearMyFavorites();
        SearchResultPage resultPage = favoritesPage.search("kalem");

        String productName = resultPage.addToFavorites(1);

        favoritesPage = resultPage.goToFavorites();
        assertTrue(productName.equals(favoritesPage.getProductName()));
    }
}
