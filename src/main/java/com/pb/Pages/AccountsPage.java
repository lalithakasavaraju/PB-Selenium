package com.pb.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {

    WebDriver driver;
    private By submitButton = By.xpath("//button[@id='login__global-login__tenant-select__btn-submit']");

public AccountsPage() {

    this.driver = BasePage.driver;

    }

    public void clickOnAccountsLink(String link) {
        By accountLinks = By.xpath("//div[@class='globalLogin_wrapper']//span[contains(text(),\"" + link + "\")]");
        click(accountLinks);
    }

    public void clickSubmit() {
        scrollToElement(submitButton);
        click(submitButton);
    }
}
