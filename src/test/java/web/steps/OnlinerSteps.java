package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.OnlinerScreen;

public class OnlinerSteps {

    private final OnlinerScreen onlinerScreen = new OnlinerScreen();

    @When("^I set (.*) \"(.*)\" on screen (Onlíner) in application (Onliner)$")
    public void setInputByPlaceholder(String placeholder, String value, String screen, String app) {
        onlinerScreen.setInputByPlaceholder(placeholder, value);
    }

    @Then("I assert dialog (Search) is opened on screen (Onlíner) in application (Onliner)$")
    public void assertSearchDialogIsOpened(String dialog, String screen, String app) {
        Assert.assertTrue(onlinerScreen::isSearchDialogDisplayed);
    }

    @Then("^I assert I am on tab (.*) on dialog (Search) on screen (Onlíner) in application (Onliner)$")
    public void assertTabOnDialog(String tabName, String dialog, String screen, String app) {
        Assert.assertEquals(tabName, onlinerScreen::getActiveTabName);
    }

    @When("^I switch to tab (.*) on dialog (Search) on screen (Onlíner) in application (Onliner)$")
    public void switchToTabOnDialog(String tabName, String dialog, String screen, String app) {
        onlinerScreen.switchToTab(tabName);
    }

    @When("^I click hyperlink (.*) on dialog (Search) on screen (Onlíner) in application (Onliner)$")
    public void clickHyperlinkByNameOnDialog(String hyperlinkName, String dialog, String screen, String app) {
        onlinerScreen.clickHyperlinkByName(hyperlinkName);
    }
}
