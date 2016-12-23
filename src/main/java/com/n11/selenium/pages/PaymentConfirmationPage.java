package com.n11.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taylan on 16/12/2016.
 */
public class PaymentConfirmationPage extends BasePage {

    @FindBy(id = "acceptAgreement")
    private WebElement acceptAgreement;

    @FindBy(id = "purchaseButton")
    private WebElement purchaseButton;

    public PaymentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void acceptAgreement() {
        clickTo(acceptAgreement);
    }

    public void purchase() {
        clickTo(purchaseButton);
    }

    public boolean isWarningDisplayedFor(String field) {
        return isElementPresent(By.xpath("//*[@data-errormessagefor='" + field + "']"));
    }
}
