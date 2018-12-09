package com.pb.stepDefs;

import com.pb.Pages.AccountLoginPage;
import com.pb.Pages.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class AccountLoginPageSteps extends BaseSteps {

    private AccountLoginPage accountLoginPage;
    private BasePage basePage;

    public AccountLoginPageSteps(AccountLoginPage accountLoginPage, BasePage basepage) {
        this.accountLoginPage = accountLoginPage;
        this.basePage = basepage;
    }

    @Then("^I should land on account login page with \"([^\"]*)\"$")
    public void i_should_land_on_account_login_page_with(String url) throws Throwable {
        Assert.assertTrue("URL of the page is wrong", basePage.doesUrlContain(url));
    }



    @And("^my \"([^\"]*)\" should be populated in the email input field$")
    public void myShouldBePopulatedInTheEmailInputField(String email) throws Throwable {
        Assert.assertFalse("Email present is wrong", accountLoginPage.getTextFromEmailField().equals(email));
    }
}
