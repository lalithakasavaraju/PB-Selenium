package com.pb.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private static final int DEFAULT_WEBDRIVER_WAIT_SECONDS = 25;

    protected static WebDriver driver;

    public void setWebDriver(WebDriver driver){

        this.driver=driver;
    }


    public void click(By button) {
        driver.findElement(button).click();
    }

    public String enterText(By field, String text) {
        driver.findElement(field).click();
        driver.findElement(field).sendKeys(text);
        return text;
    }

    public void scrollToElement(By element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeAsyncScript("arguments[0].scrollIntoView(true); setTimeout(arguments[arguments.length-1])", driver.findElement(element));
        sleep(1);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    public boolean isElementPresent(By elementBy) {
        List<WebElement> elements = driver.findElements(elementBy);
        if (elements.isEmpty()) {
            return false;
        }
        return driver.findElement(elementBy).isDisplayed();
    }

    public boolean doesUrlContain(String url) {
        return waitUntil(ExpectedConditions.urlContains(url));
    }

    public <T> T waitUntil(ExpectedCondition<T> condition) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WEBDRIVER_WAIT_SECONDS);
        return wait.until(condition);
    }


    public String getText(By element) {
        return driver.findElement(element).getText();
    }

}
