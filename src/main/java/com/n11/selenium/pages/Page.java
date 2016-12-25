package com.n11.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static com.n11.selenium.objects.Config.WAITTIME_ELEMENTOCCURENCE;
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

    public void waitObject(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAITTIME_ELEMENTOCCURENCE);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitObject(By by) {
        waitObject(driver.findElement(by));
    }

    public boolean waitObjectSafely (WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception ex) {
            System.out.println("Element was not visible on page!");
            return false;
        }
    }

    public void typeTo(WebElement element, String keyword) {
        waitObject(element);
        element.sendKeys(keyword);
    }

    public void typeTo(By by, String keyword) {
        typeTo(driver.findElement(by), keyword);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            System.out.println("WebElement is not displaying!");
            return false;
        }
    }

    public boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }

    public void moveTo(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void moveTo(By by) {
        moveTo(driver.findElement(by));
    }
}
