package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.SelectDialog;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectDialogSteps {

    SelectDialog selectDialog = new SelectDialog();

    @Then("^I assert dialog (Select Transaction Type) is opened on screen (Service Order Quotations) in application (Fiori)$")
    @Then("^I assert dialog (Select Organizational Data) is opened on screen (Service Order Quotations) in application (Fiori)$")
    @Then("^I assert dialog (Partner Selection Document header) is opened on screen (Service Order Quotations) in application (Fiori)$")
    public void assertDialogIsOpened(String dialogName, String screen, String app) {
        selectDialog.switchPopUpIframe();
        Assert.assertTrue(() -> selectDialog.isDialogNameOpened(dialogName));
    }

    @Then("I assert table is displayed on dialog (Select Transaction Type) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertSelectTransactionTypeTableIsDisplayedOnDialog(String dialogName, String screen, String app) {
        Assert.assertTrue(selectDialog::isSelectTransactionTypeTableDisplayed);
    }

    @Then("I assert table is displayed on dialog (Select Organizational Data) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertTableIsDisplayedOnDialog(String dialogName, String screen, String app) {
        Assert.assertTrue(selectDialog::isSelectOrganizationalDataTableDisplayed);
    }

    @Then("^I assert table has ([0-9]+) rows on dialog (Select Transaction Type) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertSelectTransactionTypeTableHasRows(int rowsNumber, String dialogName, String screen, String app) {
        Assert.assertEquals(rowsNumber, selectDialog::getRowsNumberSelectTransactionTypeTable);
    }

    @Then("^I assert table has ([0-9]+) rows on dialog (Select Organizational Data) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertSelectOrganizationalDataTableHasRows(int rowsNumber, String dialogName, String screen, String app) {
        Assert.assertEquals(rowsNumber, selectDialog::getRowsNumberSelectOrganizationalDataTable);
    }

    @When("^I click Transaction Type \"(.*)\" in table on dialog (Select Transaction Type) on screen (Service Order Quotations) in application (Fiori)$")
    @When("^I click \"Service – (Dom. Service Org DE)\" in table on dialog (Select Organizational Data) on screen (Service Order Quotations) in application (Fiori)$")
    public void clickTitleByNameOnDialog(String titleName, String modalName, String screen, String app) {
        selectDialog.clickTitleByNameOnDialog(titleName);
    }
}
