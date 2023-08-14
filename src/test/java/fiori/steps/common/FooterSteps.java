package fiori.steps.common;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.common.Footer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.regex.Pattern;

public class FooterSteps {

    private final Footer footer = new Footer();

    @Then("^I assert button (Details) is presented on screen (Service Order Quotations) in application (Fiori)$")
    public void assertIconIsPresent(String buttonName,String screen, String app) {
        Assert.assertTrue(footer::isSuccessButtonDisplayed);
    }
    @When("^I click button (Details) on footer on screen (Service Order Quotations) in application (Fiori)$")
    public void clickIconWithCheckbox(String buttonName, String screen, String app) {
        footer.clickSuccessButton();
    }

}
