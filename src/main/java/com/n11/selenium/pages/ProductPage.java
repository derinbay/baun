package com.n11.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taylan on 16/12/2016.
 */
public class ProductPage extends BasePage {

    @FindBy(id = "instantPay")
    private WebElement instantPayButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public PaymentConfirmationPage instantPay() {
        clickTo(instantPayButton);
        return new PaymentConfirmationPage(driver);
    }
}
