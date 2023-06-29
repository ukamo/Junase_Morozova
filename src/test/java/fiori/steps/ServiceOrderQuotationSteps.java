package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.ServiceOrderQuotationScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceOrderQuotationSteps {

    ServiceOrderQuotationScreen serviceOrderQuotationScreen = new ServiceOrderQuotationScreen();

    @Then("^I assert dialog (.*) is opened on screen (.*) in application (Fiori)$")
    public void assertDialogIsOpened(String dialogName, String screen, String app) {
        serviceOrderQuotationScreen.switchApplicationIframe();
        serviceOrderQuotationScreen.switchTransactionTypeIframe();
        Assert.assertTrue(() -> serviceOrderQuotationScreen.isDialogWithNameOpened(dialogName));
    }

    @Then("I assert table is displayed on dialog (.*) on screen (.*) in application (Fiori)$")
    public void assertTableIsDisplayedOnDialog(String dialogName, String screen, String app) {
        Assert.assertTrue(serviceOrderQuotationScreen::isTableDisplayed);
    }

    @Then("^I assert table has ([0-9]+) rows on dialog (.*) on screen (.*) in application (Fiori)$")
    public void assertTableHasRows(int rowsNumber, String dialogName, String screen, String app) {
        Assert.assertEquals(rowsNumber, serviceOrderQuotationScreen::getRowsNumber);
    }

    @When("I click Transaction Type \"(.*)\" in table on dialog (.*) on screen(.*) in application (Fiori)$")
    public void clickTransactionTypeOnDialog(String typeName, String modalName, String screen, String app) {
        serviceOrderQuotationScreen.clickTransactionType(typeName);
    }
}
