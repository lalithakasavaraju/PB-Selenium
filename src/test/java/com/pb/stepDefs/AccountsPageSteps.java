package com.pb.stepDefs;


import com.pb.Pages.AccountsPage;
import com.pb.Pages.BasePage;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AccountsPageSteps extends BaseSteps{

    private AccountsPage accountsPage;
    private BasePage basePage;

    public AccountsPageSteps(AccountsPage accountsPage, BasePage basePage) {
        this.accountsPage = accountsPage;
        this.basePage = basePage;
    }


    @When("^I click on my \"([^\"]*)\"$")
    public void iClickOnMy(String links) throws Throwable {
        Assert.assertTrue("URL of the page is wrong", basePage.doesUrlContain("https://app.perkbox.com/welcome/login"));
        accountsPage.clickOnAccountsLink(links);
        accountsPage.clickSubmit();
    }
}
