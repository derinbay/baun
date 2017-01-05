package com.n11.selenium;

import com.n11.selenium.helpers.BaseTest;
import com.n11.selenium.objects.Buyer;
import com.n11.selenium.pages.FavoritesPage;
import com.n11.selenium.pages.HomePage;
import com.n11.selenium.pages.PaymentConfirmationPage;
import org.junit.Test;

import static com.n11.selenium.objects.BuyerPool.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class SmokeTest extends BaseTest {

    @Test
    public void shouldLogin() {
        Buyer buyer = buyerForLoginTest(driver)
                .login();

        assertThat("Buyer is logged in!", new HomePage(driver).isLoggedIn(buyer));
    }

    @Test
    public void shouldNotLogin() {
        Buyer buyer = buyerForInvalidLoginTest(driver)
                .login();

        assertThat("Buyer is not logged in!", !new HomePage(driver).isLoggedIn(buyer));
    }

    @Test
    public void shouldAddToFavorites() {
        FavoritesPage favoritesPage = buyerForFavoritesTest(driver)
                .login()
                .clearMyFavorites();

        String productName = favoritesPage.search("kalem")
                .addToFavorites(1);
        favoritesPage.goToFavorites();

        assertThat(productName, equalTo(favoritesPage.getProductName(1)));
    }

    @Test
    public void shouldSeeWarningsOnPaymentPage() {
        buyerForLoginTest(driver)
                .login()
                .search("Casio MTP-1374D-7AVDF")
                .clickProduct(1)
                .instantPay()
                .acceptAgreement()
                .purchase();

        PaymentConfirmationPage paymentConfirmationPage = new PaymentConfirmationPage(driver);
        assertThat("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("cardNumber"));
        assertThat("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("holderName"));
        assertThat("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("expireMonth"));
        assertThat("Warning is not displaying!", paymentConfirmationPage.isWarningDisplayedFor("securityCode"));
    }
}
