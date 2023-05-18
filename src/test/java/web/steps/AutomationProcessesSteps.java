package web.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import eu.ibagroup.junase.model.util.Assert;
import web.screens.AutomationProcessesScreen;

public class AutomationProcessesSteps {

    private final AutomationProcessesScreen automationProcessesScreen = new AutomationProcessesScreen();

    @When("^I click button (CREATE NEW) on screen (Automation Processes)$")
    public void clickCreateNew(String buttonName, String screen) {
        automationProcessesScreen.clickCreateNew();
    }

    @When("^I set Filter by text \"(.*)\" on screen (.*)$")
    public void setFilterByText(String value, String screenName) {
        automationProcessesScreen.setFilterByText(value);
    }

    @When("^I check checkbox in header in table on screen (Automation Processes)$")
    public void checkCheckboxInHeader(String screen) {
        automationProcessesScreen.checkCheckBoxInHeader();
    }

    @Then("^I assert table has ([0-9]+) rows? on screen (Automation Processes)$")
    public void assertTableHasRows(int rowsNumber, String screen) {
        Assert.assertEquals(rowsNumber, automationProcessesScreen::getRowsNumber);
    }

    @Then("^I assert table is empty on screen (Automation Processes)$")
    public void assertTableIsEmpty(String screen) {
        Assert.assertTrue(automationProcessesScreen::isTableEmpty);
    }

    @When("^I click button (Delete) on screen (Automation Processes)$")
    public void clickDelete(String buttonName, String screen) {
        automationProcessesScreen.clickDelete();
    }
}