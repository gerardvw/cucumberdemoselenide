package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class WalletSteps {
    private int totalDollars;

    @Given("^I have (\\d+) dollar in my wallet$")
    public void I_have_dollar_in_my_wallet(int dollars) {
        totalDollars = dollars;
    }

    @When("^I take out (\\d+) dollar$")
    public void iTakeOut(int dollarsOut) {
        totalDollars = totalDollars - dollarsOut;
    }

    @Then("^my wallet should have (\\d+) dollar$")
    public void myWalletShouldHaveDollar(int dollarsExpected) {
        Assert.assertEquals(dollarsExpected, totalDollars);
    }
}
