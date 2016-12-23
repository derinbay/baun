package com.n11.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Taylan on 23/12/2016.
 */
public abstract class Page {

    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public void clickTo(WebElement element) {
        waitObject(element);
        element.click();
    }

    public void clickTo(By by) {
        waitObject(by);
        driver.findElement(by).click();
    }

    public String getText(By by) {
        waitObject(by);
        return driver.findElement(by).getText();
    }

    public String getText(WebElement element) {
        waitObject(element);
        return element.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public int getSizeOfWindows() {
        return driver.getWindowHandles().size();
    }

    public void switchToFrame(String frameId) {
        driver.switchTo().frame(frameId);
    }

    public void switchWindow() {
        Set<String> handlers = driver.getWindowHandles();
        String mainWindow = "";

        if (handlers.size() > 1) {
            mainWindow = driver.getWindowHandle();
        }

        for (String handler : handlers) {
            if (!handler.equals(mainWindow)) {
                driver.switchTo().window(handler);
            }
        }
    }

    public void waitObject(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitObject(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void typeTo(WebElement element, String keyword) {
        waitObject(element);
        element.sendKeys(keyword);
    }

    public boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
