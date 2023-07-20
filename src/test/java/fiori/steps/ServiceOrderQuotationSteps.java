package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import eu.ibagroup.junase.model.util.TextUtil;
import fiori.screens.ServiceOrderQuotationScreen;
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
        if (labelName.equals("Employee")) {
            serviceOrderQuotationScreen.setInputByLabelAndClickEnter(labelName, value);
        } else {
            serviceOrderQuotationScreen.setInputByLabel(labelName, value);
        }
    }

    @When("^I set (.*) \"(.*)\" in row ([0-9]+) in table on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void setInputInRow(String columnHeader, String value, int rowIndex, String tabName, String screen, String app) {
        if (columnHeader.equals("Quantity")) {
            serviceOrderQuotationScreen.setInputInRowItemsTableAndClickEnter(columnHeader, value, rowIndex - 1);
        } else {
            serviceOrderQuotationScreen.setInputInRowItemsTable(columnHeader, value, rowIndex - 1);

        }
    }

    @Then("^I assert table is displayed on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertItemsTableIsDisplayed(String tabName, String screen, String app) {
        Assert.assertTrue(serviceOrderQuotationScreen::isItemsTableDisplayed);
    }

    @When("^I switch to tab (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void switchToTab(String tabName, String screen, String app) {
        serviceOrderQuotationScreen.switchToTab(tabName);
    }

    @When("^I check (Select) in all rows in table on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void checkCheckboxesInAllRows(String columnHeader, String tabName, String screen, String app) {
        serviceOrderQuotationScreen.checkCheckboxesInAllRows(columnHeader);
    }

    @Then("^I click button (Save) on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void clickSaveButton(String buttonName, String tabName, String screen, String app) {
        serviceOrderQuotationScreen.clickSaveButton();
    }
}
