package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.ServiceOrderQuotationScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceOrderQuotationSteps {

    ServiceOrderQuotationScreen serviceOrderQuotationScreen = new ServiceOrderQuotationScreen();

    @Then("^I assert I am on table (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertTableIsDisplayed(String tableName, String screen, String app) {
        serviceOrderQuotationScreen.switchServiceQuotationCreateIframe();
        Assert.assertEquals(tableName, serviceOrderQuotationScreen::getTextFromTable);
    }

    @When("^I set value in (Description) field on tab (Solution Quotation: New) on screen (Service Order Quotations) in application (Fiori)$")
    public void setValueInDescriptionField(String field, String tab, String screen, String app) {
        serviceOrderQuotationScreen.setValueInDescriptionField(field);
    }

    @Then("^I set \"([0-9]+)\" value in (Sold-To Party) field on tab (Solution Quotation: New) on screen (Service Order Quotations) in application (Fiori)$")
    @Then("^I set \"([0-9]+)\" value in (Contact) field on tab (Solution Quotation: New) on screen (Service Order Quotations) in application (Fiori)$")
    @Then("^I set \"([0-9]+)\" value in (Employee) field on tab (Solution Quotation: New) on screen (Service Order Quotations) in application (Fiori)$")
    public void setValueInField(String value, String field, String tab, String screen, String app) {
        serviceOrderQuotationScreen.setValueInputField(value, field);
    }
}
