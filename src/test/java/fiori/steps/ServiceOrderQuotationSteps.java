package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.ServiceOrderQuotationScreen;
import fiori.util.TextUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceOrderQuotationSteps {

    private final ServiceOrderQuotationScreen serviceOrderQuotationScreen = new ServiceOrderQuotationScreen();

    @When("^I set (Description) as random string on tab (Quotation Details) on screen (Service Order Quotations) in application (Fiori)$")
    public void setInputByLabelAsRandomValue(String labelName, String tab, String screen, String app) {
        String randomValue = TextUtil.generateAlphanumericString(11);
        serviceOrderQuotationScreen.setInputByLabel(labelName, randomValue);
    }

    @When("^I set (.*) \"([0-9]+)\" on tab (Quotation Details) on screen (Service Order Quotations) in application (Fiori)$")
    public void setInputByLabelOnTab(String labelName, String value, String tab, String screen, String app) {
        if (labelName.equals("Employee")){
            serviceOrderQuotationScreen.setInputByLabelAndClickEnter(labelName, value);
        }
        else {
            serviceOrderQuotationScreen.setInputByLabel(labelName, value);
        }
    }

    @When("^I set (.*) \"(.*)\" in row \"([0-9]+)\" in the table on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void setInputInRow(String columnHeader,String value, int rowIndex, String tabName, String screen, String app) {
        serviceOrderQuotationScreen.setInputInRowItemsTable(columnHeader,value,rowIndex-1);
    }

    @Then("^I assert I am on tab (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertTabIsActive(String tabName, String screen, String app) {
        serviceOrderQuotationScreen.switchApplicationIframe();
        Assert.assertEquals(tabName, serviceOrderQuotationScreen::getActiveTab);
    }
    @Then("^I assert table is displayed on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void  assertItemsTableIsDisplayed(String tabName,String screen, String app) {
        Assert.assertTrue(serviceOrderQuotationScreen::isItemsTableDisplayed);
    }

    @When("^I switch to tab (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void switchToTab(String tabName,String screen, String app) {
        serviceOrderQuotationScreen.switchToTab(tabName);
    }

    @And("I check (Select) unchecked checkboxes in the table on tab (Items) on screen (Service Order Quotations) in application (Fiori)")
    public void assertCheckboxIsUnchecked(String columnHeader, String tabName, String screen, String app) {
        serviceOrderQuotationScreen.switchToTab(tabName);
    }
}
