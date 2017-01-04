package com.n11.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.logging.Logger;

import static com.n11.selenium.objects.Config.*;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Taylan on 23/12/2016.
 */
public abstract class Page {

    private final Logger logger = Logger.getAnonymousLogger();
    final WebDriver driver;

    Page(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    private void waitForAjax() {
        ExpectedCondition<Boolean> pageLoadCondition = webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState"));
        WebDriverWait wait = new WebDriverWait(driver, WAITTIME_TIMEOUT);
        wait.until(pageLoadCondition);
    }

    void clickTo(WebElement element) {
        waitObject(element);
        element.click();
        waitForAjax();
    }

    void clickTo(By by) {
        clickTo(driver.findElement(by));
    }

    String getText(WebElement element) {
        waitObject(element);
        return element.getText();
    }

    String getText(By by) {
        return getText(driver.findElement(by));
    }

    String getCurrentUrl() {
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

    private void waitObject(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitObject(By by, int timeOutInSeconds) {
        waitObject(driver.findElement(by), timeOutInSeconds);
    }

    private void waitObject(WebElement element) {
        waitObject(element, WAITTIME_ELEMENTOCCURENCE);
    }

    public void waitObject(By by) {
        waitObject(driver.findElement(by));
    }

    private boolean waitObjectSafely (WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException ex) {
            logger.info("WebElement is not found");
            return false;
        }
    }

    public boolean waitObjectSafely (By by, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException ex) {
            logger.info("WebElement is not found");
            return false;
        }
    }

    void typeTo(WebElement element, String keyword) {
        waitObject(element);
        element.sendKeys(keyword);
        waitForAjax();
    }

    public void typeTo(By by, String keyword) {
        typeTo(driver.findElement(by), keyword);
    }

    boolean isElementPresent(WebElement element) {
        return waitObjectSafely(element, WAITTIME_SMALL);
    }

    boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }

    void moveTo(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        waitForAjax();
    }

    public void moveTo(By by) {
        moveTo(driver.findElement(by));
    }
}
