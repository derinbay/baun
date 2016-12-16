package com.n11.selenium.objects;

/**
 * Created by Taylan on 09/12/2016.
 */
public class BuyerPool {

    private BuyerPool() {
    }

    public static String defaultPassword = "N11passw0rd";

    public static Buyer buyerForLoginTest() {
        return new Buyer("seleniummallfront90@mailcatch.com", defaultPassword, "UAT BUYER DONTUSETHISBUYER");
    }

    public static Buyer buyerForFavoritesTest() {
        return new Buyer("seleniummallfront91@mailcatch.com", defaultPassword, "UAT BUYER DONTUSETHISBUYER");
    }

    public static Buyer buyerForAnotherTest() {
        return new Buyer("seleniummallfront92@mailcatch.com", defaultPassword, "UAT BUYER DONTUSETHISBUYER");
    }

    public static Buyer buyerForBlablaTest() {
        return new Buyer("seleniummallfront93@mailcatch.com", defaultPassword, "UAT BUYER DONTUSETHISBUYER");
    }
}
