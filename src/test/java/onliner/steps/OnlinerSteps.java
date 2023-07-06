package onliner.steps;


import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.OnlinerScreen;
import onliner.screens.OnlinerScreen;

public class OnlinerSteps {

    OnlinerScreen onlinerScreen = new OnlinerScreen();

    @Then("I assert dialog (.*) on screen (.*) in application (Onliner)$")
    public void assertDialog(String dialog, String screen, String app) {
        onlinerScreen.swithIFrame();
        Assert.assertTrue(() -> onlinerScreen.isDialogSearchDisplayed());
    }

    @Then("^I assert I am on tab (.*) on dialog (.*) on screen (.*) in application (Onliner)$")
    public void assertTab(String tab, String dialog, String screen, String app) {
        Assert.assertEquals(tab, onlinerScreen::getTextFromTab);
    }

    @When("^I set (Поиск в Каталоге) value (.*) on screen (.*) in application (Onliner)$")
    public void SetValue(String tab, String value, String screen, String app) {
        onlinerScreen.setValue(tab, value);
    }

    @When("^I switch to tab (.*) on screen (.*) in application (Onliner)$")
    public void switchToTab(String section, String screen, String app) {
        onlinerScreen.switchToTab(section);
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
