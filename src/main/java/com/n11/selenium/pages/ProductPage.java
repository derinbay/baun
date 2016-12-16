package com.n11.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        PageFactory.initElements(driver, this);
        waitObject(instantPayButton);
        instantPayButton.click();
        return new PaymentConfirmationPage(driver);
    }
}
