package com.n11.selenium;

import com.n11.selenium.objects.Buyer;
import com.n11.selenium.objects.BuyerPool;
import com.n11.selenium.pages.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class SmokeTests extends BaseTest {

    @Test
    public void shouldLogin() {
        Buyer buyer = BuyerPool.buyerForLoginTest(driver);
        HomePage homePage = new HomePage(driver)
                .callLoginPage()
                .login(buyer);
        assertTrue(homePage.isLoggedIn(buyer));
    }

    @Test
    public void shouldAddToFavorites() {
        Buyer buyer = BuyerPool.buyerForFavoritesTest(driver);
        new HomePage(driver)
                .callLoginPage()
                .login(buyer);

        FavoritesPage favoritesPage = buyer.clearMyFavorites();
        SearchResultPage resultPage = favoritesPage.search("kalem");

        String productName = resultPage.addToFavorites(1);

        favoritesPage = buyer.goToFavorites();
        assertTrue(productName.equals(favoritesPage.getProductName()));
    }

    @Test
    public void shouldSeeWarningsOnPaymentPage() {
        Buyer buyer = BuyerPool.buyerForLoginTest(driver);
        SearchResultPage searchResultPage = new HomePage(driver)
                .callLoginPage()
                .login(buyer)
                .search("Casio MTP-1374D-7AVDF");

        ProductPage productPage = searchResultPage.clickProduct(1);
        PaymentConfirmationPage paymentConfirmationPage = productPage.instantPay();
        paymentConfirmationPage.acceptAgreement();
        paymentConfirmationPage.purchase();

        assertTrue("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("cardNumber"));
        assertTrue("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("holderName"));
        assertTrue("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("expireMonth"));
        assertTrue("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("securityCode"));
    }
}
