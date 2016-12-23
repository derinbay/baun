package com.n11.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Taylan on 02/12/2016.
 */
public class FavoritesPage extends BasePage {

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(By.xpath("//*[@id='watchList']//tbody/tr/td[@class='productTitle']//a"));
    }
}
