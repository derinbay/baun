package com.n11.selenium.objects;

/**
 * Created by Taylan on 25/12/2016.
 */
public abstract class Config {

    public static final String MAIN_URL = "http://www.n11.com/";
    public static final int WAITTIME_TIMEOUT = 60;
    public static final int WAITTIME_ELEMENTOCCURENCE = 15;
    public static final int WAITTIME_SMALL = 5;
    public static final String DEFAULT_USERNAME = "UAT BUYER DONTUSETHISBUYER";
    public static final String DEFAULT_PASSWORD = "N11passw0rd";
    public static final String INVALID_PASSWORD = "invalid";

    private Config() {
    }
}
