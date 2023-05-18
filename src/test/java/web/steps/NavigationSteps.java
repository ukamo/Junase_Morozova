package web.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import eu.ibagroup.junase.model.util.Assert;
import web.screens.Navigation;

public class NavigationSteps {

    private final Navigation navigation = new Navigation();

    @When("^I navigate to screen (.*)$")
    public void navigateTo(String moduleName) {
        navigation.navigateToModule(moduleName);
    }

    @Then("^I assert I am on screen (.*)$")
    public void assertScreen(String screenName) {
        Assert.assertEquals(screenName, navigation::getScreenTitle);
    }
}