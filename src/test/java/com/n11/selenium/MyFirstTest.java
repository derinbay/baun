package com.n11.selenium;

import com.n11.selenium.pages.HomePage;
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
}
