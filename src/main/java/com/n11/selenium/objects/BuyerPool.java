package com.n11.selenium.objects;

import org.openqa.selenium.WebDriver;

import static com.n11.selenium.objects.Config.*;

/**
 * Created by Taylan on 09/12/2016.
 */
public class BuyerPool {

    private BuyerPool() {
    }

    public static Buyer buyerForLoginTest(WebDriver driver) {
        return new Buyer("seleniummallfront90@mailcatch.com", getDefaultPassword(), getDefaultUsername(), driver);
    }

    public static Buyer buyerForFavoritesTest(WebDriver driver) {
        return new Buyer("seleniummallfront91@mailcatch.com", getDefaultPassword(), getDefaultUsername(), driver);
    }

    public static Buyer buyerForInvalidLoginTest(WebDriver driver) {
        return new Buyer("seleniummallfront93@mailcatch.com", getInvalidPassword(), getDefaultUsername(), driver);
    }
}
