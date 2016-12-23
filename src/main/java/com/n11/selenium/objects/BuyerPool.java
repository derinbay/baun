package com.n11.selenium.objects;

import org.openqa.selenium.WebDriver;

/**
 * Created by Taylan on 09/12/2016.
 */
public class BuyerPool {

    private BuyerPool() {
    }

    public static String defaultPassword = "N11passw0rd";

    public static Buyer buyerForLoginTest(WebDriver driver) {
        return new Buyer("seleniummallfront90@mailcatch.com", defaultPassword, "UAT BUYER DONTUSETHISBUYER", driver);
    }

    public static Buyer buyerForFavoritesTest(WebDriver driver) {
        return new Buyer("seleniummallfront91@mailcatch.com", defaultPassword, "UAT BUYER DONTUSETHISBUYER", driver);
    }

    public static Buyer buyerForAnotherTest(WebDriver driver) {
        return new Buyer("seleniummallfront92@mailcatch.com", defaultPassword, "UAT BUYER DONTUSETHISBUYER", driver);
    }

    public static Buyer buyerForBlablaTest(WebDriver driver) {
        return new Buyer("seleniummallfront93@mailcatch.com", defaultPassword, "UAT BUYER DONTUSETHISBUYER", driver);
    }
}
