package fiori.steps.common;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import fiori.screens.common.Navigation;
import io.cucumber.java.en.When;

public class NavigationSteps {

    private final Navigation navigation = new Navigation();

    @Then("^I assert I am on screen (.*) in application (Fiori)$")
    public void assertScreen(String screen, String app) {
        Assert.assertEquals(screen, navigation::getScreenTitle);
    }

    @When("^I set search \"(.*)\" on screen (.*) in application (Fiori)$")
    public void setValueInSearch(String value, String screen, String app) {
        navigation.clickSearch();
        navigation.setSearch(value);
        navigation.clickAutocompleteByName(value);
    }
}
