package gracehill.steps;

import eu.ibagroup.junase.model.util.Assert;
import gracehill.screens.Navigation;
import io.cucumber.java.en.Then;

public class NavigationSteps {

    private final Navigation navigation = new Navigation();

    @Then("^I assert I am on screen (.*) in application (Gracehill)$")
    public void assertScreen(String screen, String app) {
        Assert.assertEquals(screen, navigation::getScreenTitle);
    }

}
