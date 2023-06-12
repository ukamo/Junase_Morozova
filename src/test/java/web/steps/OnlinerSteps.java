package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.OnlinerScreen;

public class OnlinerSteps {

    OnlinerScreen onlinerScreen = new OnlinerScreen();

    @When("^I click (.*) search on screen (.*) in application (Onliner)$")
    public void clickOnSearch(String nameOfSearch, String screen, String app) {
        onlinerScreen.clickOnSearch();
    }

    @Then("^I assert I am on (.*) search on screen (.*) in application (Onliner)$")
    public void assertCursorSearch(String nameOfSearch, String screen, String app) {
        Assert.assertTrue(() -> onlinerScreen.getCursorSeacrh().contains(nameOfSearch));
    }

    @When("^I set (.*) in search (.*) on screen (.*) in application (Onliner)$")
    public void typeInSearch(String textTyped, String nameOfSearch, String screen, String app) {
        onlinerScreen.typeInSearch(textTyped);
    }

    @Then("^I assert I am on tab (в каталоге) on screen (.*) in application (Onliner)$")
    public void assertSearchTab(String tab, String screen, String app) {
        onlinerScreen.swithOnIFrameFieldSearching();
        Assert.assertEquals(tab, onlinerScreen::getTextInSearchTab);
    }
}
