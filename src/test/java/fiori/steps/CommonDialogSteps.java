package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.CommonDialog;
import fiori.screens.common.Navigation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonDialogSteps {

    private final CommonDialog commonDialog = new CommonDialog();

    private final Navigation navigation = new Navigation();

    @Then("^I assert dialog (.*) is opened on screen (Service Order Quotations) in application (Fiori)$")
    public void assertDialogWithTitleIsOpened(String dialogTitle, String screen, String app) {
        navigation.switchPopUpIframe();
        Assert.assertTrue(() -> commonDialog.isDialogWithTitleOpened(dialogTitle));
    }

    @Then("^I assert dialog (.*) is closed on screen (Service Order Quotations) in application (Fiori)$")
    public void assertDialogWithTitleIsClosed(String dialogTitle, String screen, String app) {
        Assert.assertFalse(() -> commonDialog.isDialogWithTitleOpened(dialogTitle));
    }

    @Then("I assert table is displayed on dialog (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertSelectTableIsDisplayedOnDialog(String dialogTitle, String screen, String app) {
        Assert.assertTrue(() -> commonDialog.isTableDisplayedOnDialog(dialogTitle));
    }

    @Then("^I assert table has ([0-9]+) rows? on dialog (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void assertRowsNumberInTable(int rowsNumber, String dialogTitle, String screen, String app) {
        Assert.assertEquals(rowsNumber, () -> commonDialog.getRowsNumberFromTable(dialogTitle));
    }

    @When("^I click hyperlink (.*) \"(.*)\" in the table on dialog (.*) on screen (Service Order Quotations) in application (Fiori)$")
    public void clickHyperlinkByNameInTableColumn(String columnName, String hyperlinkValue, String dialogTitle, String screen, String app) {
        commonDialog.clickHyperlinkByNameInTableColumn(dialogTitle, hyperlinkValue, columnName);
    }
}
