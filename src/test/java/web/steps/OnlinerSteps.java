package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.OnlinerScreen;

public class OnlinerSteps {

    OnlinerScreen onlinerScreen = new OnlinerScreen();

    @When("^I navigate to search (Поиск) on screen (.*) in application (Onliner)$")
    public void navigateToSearch(String tabName, String screen, String app) {
        onlinerScreen.navigateToSearch();
    }

    @Then("^I assert I am on search (Поиск) on screen (.*) in application (Onliner)$")
    public void assertSearchTab(String tabName, String screen, String app) {
        Assert.assertTrue(() -> onlinerScreen.getSearchTab().contains(tabName));
    }

    @When("^I set (.*) in search (.*) on screen (.*) in application (Onliner)$")
    public void setTextInSearch(String text, String nameOfSearch, String screen, String app) {
        onlinerScreen.setTextInSearch(text);
    }

    @Then("^I assert I am on tab (в каталоге) on screen (.*) in application (Onliner)$")
    public void assertTab(String tab, String screen, String app) {
        onlinerScreen.swithOnIFrameField();
        Assert.assertEquals(tab, onlinerScreen::getTextFromTab);
    }
}
