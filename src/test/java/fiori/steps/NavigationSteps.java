package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import fiori.screens.NavigationScreen;

public class NavigationSteps {

    private final NavigationScreen navigation = new NavigationScreen();

    @Then("^I assert I am on screen (.*) in application (Fiori)$")
    public void assertScreenInApplication(String screen, String app) {
        Assert.assertTrue(() -> navigation.getScreenTitle().contains(screen));
    }

    @When("^I set (Search) (.*) on screen (.*) in application (Fiori)$")
    public void setValueInField(String iconName, String value, String screen, String app) {
        navigation.clickIconByName(iconName);
        navigation.setValue(value, iconName);
    }

    @Then("^I assert container (.*) is displayed on screen (.*) in application (Fiori)$")
    public void assertContainerIsDisplayed(String value, String screen, String app) {
        Assert.assertTrue(() -> navigation.isContainerByNameDisplayed(value));
    }

    @When("^I click container (.*) on screen (.*) in application (Fiori)$")
    public void clickByContainer(String containerName, String screen, String app) {
        navigation.clickContainerByName(containerName);
    }

    @Then("^I assert (dialog) (.*) is opened on screen (.*) in application (Fiori)$")
    public void assertDialogIsOpened(String type, String dialogName, String screen, String app) {
        // navigation.switсhIFrameSelectTransactionType();
        navigation.switсhIFrameCommon();
        Assert.assertTrue(() -> navigation.isDialogOpened(type));
    }

    /*@Then("^I assert modal window (.*) is opened on screen (.*) in application (Sap)$")
    public void assertModalWindowIsDisplayed(String modalName, String screen, String app) {

        Assert.assertEquals(modalName, navigation::getModalWindowText);
    }*/
    @Then("I assert table is displayed on dialog (.*) on screen (.*) in application (Fiori)$")
    public void assertTableIsDisplayedOnDialog(String dialogName, String screen, String app) {
        //navigation.switсhIFrameSelectTransactionType();
        navigation.switсhIFrameTransactionType();
        Assert.assertTrue(navigation::isTableDisplayed);
    }

    @Then("^I assert table has ([0-9]+) rows on dialog (.*) on screen (.*) in application (Fiori)$")
    public void assertTableHasRows(int numberRows, String dialogName, String screen, String app) {
        Assert.assertEquals(numberRows, navigation::getRowsNumber);
    }

    @When("I click Transaction Type (.*) in table on dialog (.*) on screen(.*) in application (Fiori)$")
    public void clickTransactionTypeOnDialog(String type, String modalName, String screen, String app) {
        navigation.clickTransactionType(type);
    }
}
