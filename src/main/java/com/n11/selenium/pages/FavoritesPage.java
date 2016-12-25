package com.n11.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taylan on 02/12/2016.
 */
public class FavoritesPage extends BasePage {

    @FindBy(className = "emptyWatchList")
    private WebElement emptyWatchList;

    @FindBy(id = "allItemsSelected")
    private WebElement selectAllCheckBox;

    @FindBy(id = "removeSelectedProducts")
    private WebElement removeSelected;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName(int row) {
        return getText(By.xpath("//*[@id='watchList']//tbody/tr/td[@class='productTitle']//a[" + row + "]"));
    }

    public FavoritesPage clearMyFavorites() {
        if (!isElementPresent(emptyWatchList)) {
            clickTo(selectAllCheckBox);
            clickTo(removeSelected);
        }
        return this;
    }
}
