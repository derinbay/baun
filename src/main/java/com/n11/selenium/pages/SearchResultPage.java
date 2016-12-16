package com.n11.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by taylan.derinbay on 25.11.2016.
 */
public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String addToFavorites(int productRow) {
        driver.findElement(By.xpath("//*[@id='view']//li[" + productRow + "]//*[@title='Favorilere ekle']")).click();
        String productName = driver.findElement(By.xpath("//*[@id='view']//li[" + productRow + "]//h3[contains(@class, 'productName')]")).getText();

        return productName;
    }

    public ProductPage clickProduct(int productRow) {
        List<WebElement> productList = driver.findElements(By.xpath("//*[@id='view']//li[@itemprop='itemListElement']"));
        productList.get(productRow - 1).findElement(By.xpath(".//a")).click();

        return new ProductPage(driver);
    }
}
