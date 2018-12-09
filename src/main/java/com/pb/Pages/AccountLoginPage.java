package com.pb.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountLoginPage extends BasePage {

    WebDriver driver;
    private By emailInputField = By.xpath("//input[@name='email']");

    public AccountLoginPage() {
        this.driver = BasePage.driver;
    }

    public String getTextFromEmailField() {
        String email = getText(emailInputField);
        return email;
    }
}
