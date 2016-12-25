package com.n11.selenium;

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
public class SmokeTests extends BaseTest {

    @Test
    public void shouldLogin() {
        Buyer buyer = buyerForLoginTest(driver);
        HomePage homePage = new HomePage(driver)
                .callLoginPage()
                .login(buyer);

        assertThat("Buyer is not logged in!", homePage.isLoggedIn(buyer));
    }

    @Test
    public void shouldNotLogin() {
        Buyer buyer = buyerForInvalidLoginTest(driver);
        HomePage homePage = new HomePage(driver)
                .callLoginPage()
                .login(buyer);

        assertThat("Buyer is logged in!", !homePage.isLoggedIn(buyer));
    }

    @Test
    public void shouldAddToFavorites() {
        Buyer buyer = buyerForFavoritesTest(driver);
        new HomePage(driver)
                .callLoginPage()
                .login(buyer);

        buyer.clearMyFavorites();
        String productName = buyer.search("kalem")
                .addToFavorites(1);

        FavoritesPage favoritesPage = buyer.goToFavorites();
        assertThat(productName, equalTo(favoritesPage.getProductName(1)));
    }

    @Test
    public void shouldSeeWarningsOnPaymentPage() {
        Buyer buyer = buyerForLoginTest(driver);
        new HomePage(driver)
                .callLoginPage()
                .login(buyer)
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
