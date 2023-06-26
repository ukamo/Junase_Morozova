package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.ServiceOrderQuotationScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceOrderQuotationSteps {

    ServiceOrderQuotationScreen serviceOrderQuotationScreen = new ServiceOrderQuotationScreen();

    @Then("^I assert (dialog) (.*) is opened on screen (.*) in application (Fiori)$")
    public void assertDialogIsOpened(String type, String dialogName, String screen, String app) {
        serviceOrderQuotationScreen.switchIFrameCommon();
        Assert.assertTrue(() -> serviceOrderQuotationScreen.isDialogOpened(type));
    }

    @Then("I assert table is displayed on dialog (.*) on screen (.*) in application (Fiori)$")
    public void assertTableIsDisplayedOnDialog(String dialogName, String screen, String app) {
        serviceOrderQuotationScreen.switchIFrameTransactionType();
        Assert.assertTrue(serviceOrderQuotationScreen::isTableDisplayed);
    }

    @Then("^I assert table has ([0-9]+) rows on dialog (.*) on screen (.*) in application (Fiori)$")
    public void assertTableHasRows(int numberRows, String dialogName, String screen, String app) {
        Assert.assertEquals(numberRows, serviceOrderQuotationScreen::getRowsNumber);
    }

    @When("I click Transaction Type (.*) in table on dialog (.*) on screen(.*) in application (Fiori)$")
    public void clickTransactionTypeOnDialog(String type, String modalName, String screen, String app) {
        serviceOrderQuotationScreen.clickTransactionType(type);
    }
}
