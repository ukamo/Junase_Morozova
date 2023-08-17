package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import eu.ibagroup.junase.model.util.TextUtil;
import eu.ibagroup.junase.web.util.Wait;
import fiori.screens.ServiceOrderQuotationScreen;
import fiori.screens.common.Navigation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static fiori.screens.common.Navigation.driver;

public class ServiceOrderQuotationSteps {

    private final ServiceOrderQuotationScreen serviceOrderQuotationScreen = new ServiceOrderQuotationScreen();

    private final Navigation navigation = new Navigation();

    private static String transactionNumber;

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
    public void isTableDisplayed(String tabName, String screen, String app) {
        Assert.assertTrue(serviceOrderQuotationScreen::isItemsTableDisplayed);
    }

    @When("^I switch to tab (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void switchToTab(String tabName, String screen, String app) {
        serviceOrderQuotationScreen.switchToTab(tabName);
    }

    @When("^I check checkbox in column (Select) in table on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void checkCheckboxesInColumn(String columnHeader, String tabName, String screen, String app) {
        serviceOrderQuotationScreen.checkCheckboxesInColumn(columnHeader);
    }

    @When("^I assert message with pattern \"(.*)\" is displayed on screen (Service Order Quotations) in application (Fiori)$")
    public void assertMessageWithPatternIsDisplayed(String messageText, String screen, String app) {
        Assert.assertEqualsPattern(Pattern.compile(messageText), () -> serviceOrderQuotationScreen.getTransactionText());
    }

    @When("^I store Transaction number on screen (Service Order Quotations) in application (Fiori)$")
    public void storeTransactionNumber(String screen, String app) {
        String transactionText = serviceOrderQuotationScreen.getTransactionText();
        transactionNumber = transactionText.replaceAll("[^0-9]", "");
    }

    @When("^I set Transaction number on (Service Order Quotation ID) on screen (Service Order Quotations) in application (Fiori)$")
    public void setTransactionNumber(String valueName, String screen, String ap) {
        navigation.switchApplicationIframe();
        serviceOrderQuotationScreen.setInput(valueName, transactionNumber);
    }

    @When("^I click button (Search) on screen (Service Order Quotations) in application (Fiori)$")
    public void clickSearchButton(String buttonName, String screen, String app) {
        serviceOrderQuotationScreen.clickSearchButton();
    }

    @When("^I click button (Edit|Accept) on tab (Quotation Details|Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void clickButtonOnSubHeader(String buttonName, String tabName, String screen, String app) {
        if (buttonName.equals("Edit")) {
            navigation.switchApplicationIframe();
            serviceOrderQuotationScreen.clickButtonByNameOnSubHeader(buttonName);
        } else if (buttonName.equals("Accept")){
            serviceOrderQuotationScreen.clickButtonByNameOnSubHeader(buttonName);
            Wait.waitForLoad();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @When("^I click button (Release All Items) on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void clickReleaseAllButton(String buttonName, String tabName, String screen, String app) {
        serviceOrderQuotationScreen.clickButtonByName(buttonName);
    }

    @Then("^I assert record with (.*) \"(.*)\" has (Status) \"(.*)\" in table on tab (Items) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertStatus(String columnHeader, String value, String columnStatusHeader, String status, String tabName, String screen, String app) {
        //Assert.assertEquals(status, () -> serviceOrderQuotationScreen.getValueInTable(columnHeader, value, columnStatusHeader));
        if (status.equals("Released")) {
            Assert.assertEquals(status, () -> serviceOrderQuotationScreen.getReleasedStatusFromTable(columnHeader, value, columnStatusHeader));
        } else if (status.equals("Completed")){
            Assert.assertEquals(status, () -> serviceOrderQuotationScreen.getCompletedStatusFromTable(columnHeader, value, columnStatusHeader));
        }
    }
}
