package com.n11.selenium.objects;

/**
 * Created by Taylan on 25/12/2016.
 */
public class Config {

    public static final String MAIN_URL = "http://www.n11.com/";
    public static final int WAITTIME_TIMEOUT = 60;
    public static final int WAITTIME_ELEMENTOCCURENCE = 15;
    public static final int WAITTIME_SMALL = 5;
    private static final String DEFAULT_USERNAME = "UAT BUYER DONTUSETHISBUYER";
    private static final String DEFAULT_PASSWORD = "N11passw0rd";
    private static final String INVALID_PASSWORD = "invalid";

    public static String getDefaultPassword() {
        return DEFAULT_PASSWORD;
    }

    public static String getInvalidPassword() {
        return INVALID_PASSWORD;
    }

    public static String getDefaultUsername() {
        return DEFAULT_USERNAME;
    }
}
