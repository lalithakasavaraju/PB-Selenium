package com.pb.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;
    private By pBlogo = By.xpath("//img[@id='header__header-brand__img']");
    private By inputEmail = By.xpath("//input");
    private By submitButton = By.xpath("//button[@id='login__global-login__btn-submit']");
    private By errormessage = By.xpath("//div[contains(text(),'User is not found')]");

public LoginPage() {

    this.driver = BasePage.driver;
    }

    public boolean isPerkBoxLogoVisible() {
        return (isElementPresent(pBlogo));
    }

    public void enterEmail() {
        enterText(inputEmail, "pooja@perkbox.co.uk");
        click(submitButton);
    }

    public void enterUnregisteredEmail() {
        enterText(inputEmail, "pooja123@perkbox.co.uk");
        click(submitButton);
    }

    public String getErrorMessagePresent() {
        return getText(errormessage);
    }

}
