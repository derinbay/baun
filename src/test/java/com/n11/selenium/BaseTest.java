package com.n11.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class BaseTest {

    WebDriver driver;

    @Before
    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "E:\\Users\\taylan.derinbay\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.n11.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
