package com.n11.selenium.helpers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.n11.selenium.objects.Config.MAIN_URL;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class BaseTest {

    protected WebDriver driver;

    @Before
    public void startUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
