package com.n11.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static com.n11.selenium.objects.Config.*;
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

    public void waitForAjax() {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> "complete".equals(((JavascriptExecutor) driver).executeScript("return document.readyState"));
        WebDriverWait wait = new WebDriverWait(driver, WAITTIME_TIMEOUT);
        wait.until(pageLoadCondition);
    }

    public void clickTo(WebElement element) {
        waitObject(element);
        element.click();
        waitForAjax();
    }

    public void clickTo(By by) {
        clickTo(driver.findElement(by));
    }

    public String getText(WebElement element) {
        waitObject(element);
        return element.getText();
    }

    public String getText(By by) {
        return getText(driver.findElement(by));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
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

    public void waitObject(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitObject(By by, int timeOutInSeconds) {
        waitObject(driver.findElement(by), timeOutInSeconds);
    }

    public void waitObject(WebElement element) {
        waitObject(element, WAITTIME_ELEMENTOCCURENCE);
    }

    public void waitObject(By by) {
        waitObject(driver.findElement(by));
    }

    public boolean waitObjectSafely (WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception ex) {
            System.out.println("Element was not visible on page!");
            return false;
        }
    }

    public boolean waitObjectSafely (By by, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception ex) {
            System.out.println("Element was not visible on page!");
            return false;
        }
    }

    public void typeTo(WebElement element, String keyword) {
        waitObject(element);
        element.sendKeys(keyword);
        waitForAjax();
    }

    public void typeTo(By by, String keyword) {
        typeTo(driver.findElement(by), keyword);
    }

    public boolean isElementPresent(WebElement element) {
        return waitObjectSafely(element, WAITTIME_SMALL);
    }

    public boolean isElementPresent(By by) {
        return waitObjectSafely(by, WAITTIME_SMALL);
    }

    public void moveTo(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        waitForAjax();
    }

    public void moveTo(By by) {
        moveTo(driver.findElement(by));
    }
}
