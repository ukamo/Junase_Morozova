package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.OnlinerScreen;

public class OnlinerSteps {

    private final OnlinerScreen onlinerScreen = new OnlinerScreen();

    @Then("I assert dialog (Search) is opened on screen (Onliner) in application (Onliner)$")
    public void assertSearchDialogIsOpened(String dialog, String screen, String app) {
        onlinerScreen.switchToIFrame();
        Assert.assertTrue(() -> onlinerScreen.isSearchDialogDisplayed());
    }

    @Then("^I assert I am on tab (.*) on dialog (.*) on screen (Onliner) in application (Onliner)$")
    public void assertTab(String tabName, String dialog, String screen, String app) {
        Assert.assertEquals(tabName, onlinerScreen::getActiveTabName);
    }

    @When("^I set (.*) \"(.*)\" on screen (.*) in application (Onliner)$")
    public void setInputByPlaceholder(String placeholder, String value, String screen, String app) {
        onlinerScreen.setInputByPlaceholder(placeholder, value);
    }

    @When("^I switch to tab (.*) on screen (.*) in application (Onliner)$")
    public void switchToTab(String section, String screen, String app) {
        onlinerScreen.switchToTab(section);
    }

    @When("^I click hyperlink (.*) on screen (.*) in application (Onliner)$")
    public void clickHyperlinkByName(String hyperlinkName, String screen, String app) {
        onlinerScreen.clickHyperlinkByName(hyperlinkName);
    }
}
