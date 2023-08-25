package fiori.steps.common;

import eu.ibagroup.junase.model.util.Assert;
import eu.ibagroup.junase.web.util.Wait;
import fiori.screens.common.Footer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class FooterSteps {

    private final Footer footer = new Footer();

    @Then("^I click button (Save) on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void clickButtonByName(String buttonName, String tabName, String screen, String app) {
        footer.clickButtonByNameOnFooter(buttonName);
        Wait.presenceOfElementLocated(By.id(footer.savedTransactionMessage));
    }

    @Then("^I assert button (Details) is presented on screen (Service Order Quotations) in application (Fiori)$")
    public void assertIconIsPresent(String buttonName, String screen, String app) {
        Assert.assertTrue(footer::isSuccessButtonDisplayed);
    }

    @When("^I click button (Details) on footer on screen (Service Order Quotations) in application (Fiori)$")
    public void clickIconWithCheckbox(String buttonName, String screen, String app) {
        footer.clickSuccessButton();
    }
}
