package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import fiori.screens.Navigation;
import io.cucumber.java.en.When;

public class NavigationSteps {

    private final Navigation navigation = new Navigation();

    @Then("^I assert I am on screen (.*) in application (Fiori)$")
    public void assertScreenInApplication(String screen, String app) {
        Assert.assertTrue(() -> navigation.getScreenTitle().equals(screen));
    }

    @When("^I set search \"(.*)\" on screen (.*) in application (Fiori)$")
    public void setValueByPlaceholder(String value, String screen, String app) {
        navigation.clickSearchButton();
        navigation.setValueByPlaceholder(value);
    }

    @Then("^I click autocomplete (.*) on screen (Search) in application (Fiori)$")
    public void clickContainerByName(String autocompleteName, String screen, String app) {
        navigation.waitAutocompleteIsDisplayed();
        navigation.clickAutocompleteByName(autocompleteName);
    }
}
