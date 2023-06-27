package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import fiori.screens.NavigationScreen;

public class NavigationSteps {

    private final NavigationScreen navigation = new NavigationScreen();

    @Then("^I assert I am on screen (.*) in application (Fiori)$")
    public void assertScreenInApplication(String screen, String app) {
        Assert.assertTrue(() -> navigation.getScreenTitle().contains(screen));
    }
}
