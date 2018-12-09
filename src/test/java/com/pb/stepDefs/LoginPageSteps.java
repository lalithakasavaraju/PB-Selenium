package com.pb.stepDefs;

import com.pb.Pages.BasePage;
import com.pb.Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginPageSteps extends BaseSteps {

    private LoginPage loginPage;
    private BasePage basePage;

    public LoginPageSteps(LoginPage loginPage, BasePage basePage) {
        this.basePage = basePage;
        this.loginPage = loginPage;
    }

    @Given("^I am on perkbox homepage$")
    public void iAmOnPerkboxHomepage() throws Throwable {
        Assert.assertTrue(basePage.doesUrlContain("https://app.perkbox.com/welcome/login"));
        Assert.assertTrue("PB Logo is not present", loginPage.isPerkBoxLogoVisible());
    }

    @When("^I am a registered user and I login to my account$")
    public void i_am_a_registered_user_and_I_login_to_my_account() throws Throwable {
        loginPage.enterEmail();
    }

    @Given("^I am not a registered user with perkbox and I try to login$")
    public void i_am_not_a_registered_user_with_perkbox_and_I_try_to_login() throws Throwable {
        Assert.assertTrue(basePage.doesUrlContain("https://app.perkbox.com/welcome/login"));
        Assert.assertTrue("PB Logo is not present", loginPage.isPerkBoxLogoVisible());
    }

    @When("^I give my email and select continue$")
    public void i_give_my_email_and_select_continue() throws Throwable {
        loginPage.enterUnregisteredEmail();
    }

    @Then("^I should receive error message \"([^\"]*)\"$")
    public void i_should_receive_error_message(String message) throws Throwable {
        Assert.assertTrue("Error message is no present", loginPage.getErrorMessagePresent().contains(message));
    }

}
