package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.ServiceOrderQuotationScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceOrderQuotationSteps {

    ServiceOrderQuotationScreen serviceOrderQuotationScreen = new ServiceOrderQuotationScreen();

    @Then("^I assert dialog (Select Transaction Type) is opened on screen (Service Order Quotations) in application (Fiori)$")
    //@Then("^I assert dialog (Select Organizational Data) is opened on screen (Service Order Quotations) in application (Fiori)$")
    //@Then("^I assert dialog (Partner Selection Document header) is opened on screen (Service Order Quotations) in application (Fiori)$")
    public void assertDialogIsOpened(String dialogName, String screen, String app) {
        serviceOrderQuotationScreen.switchApplicationIframe();
        serviceOrderQuotationScreen.switchPopUpIframe();
        Assert.assertTrue(() -> serviceOrderQuotationScreen.isDialogNameOpened(dialogName));
    }

    @Then("I assert table is displayed on dialog (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertTableIsDisplayedOnDialog(String dialogName, String screen, String app) {
        Assert.assertTrue(serviceOrderQuotationScreen::isTableDisplayed);
    }

    @Then("^I assert table has ([0-9]+) rows on dialog (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertTableHasRows(int rowsNumber, String dialogName, String screen, String app) {
        Assert.assertEquals(rowsNumber, serviceOrderQuotationScreen::getRowsNumber);
    }

    @When("^I click Transaction Type \"(.*)\" in table on dialog (Select Transaction Type) on screen (Service Order Quotations) in application (Fiori)$")
    //@When("^I click \"Service – (Dom. Service Org DE)\" in table on dialog (Select Organizational Data) on screen (Service Order Quotations) in application (Fiori)$")
    public void clickTransactionTypeOnDialog(String typeName, String modalName, String screen, String app) {
        serviceOrderQuotationScreen.clickTransactionType(typeName);
    }

    @Then("^I assert I am on table (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertTableIsDisplayed(String tableName, String screen, String app) {
        serviceOrderQuotationScreen.switchServiceQuotationCreateIframe();
        Assert.assertEquals(tableName, serviceOrderQuotationScreen::getTextFromTable);
    }

    @Then("^I set value in (description) field on tab (Solution Quotation: New) on screen (Service Order Quotations) in application (Fiori)$")
    public void setValueInDescriptionField(String field, String tab, String screen, String app) {
        serviceOrderQuotationScreen.setValueInDescriptionField(field);
    }

    @Then("^I set \"([0-9]+)\" value in (soldto) party field on tab (Solution Quotation: New) on screen (Service Order Quotations) in application (Fiori)$")
    public void setValueSoldToPartyField(String value, String field, String tab, String screen, String app) {
        serviceOrderQuotationScreen.setValueInputField(value, field);
    }
}
