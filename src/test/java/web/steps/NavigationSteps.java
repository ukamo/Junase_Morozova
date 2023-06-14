package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.Navigation;

public class NavigationSteps {

    private final Navigation navigation = new Navigation();

    private static final String DELIMITER = " -> ";

    @Given("^I am on screen (.*) in application (Onliner)$")
    @Then("^I assert I am on screen (.*) in application (Onliner)$")
    public void assertScreenInApplication(String screen, String app) {
        Assert.assertTrue(() -> navigation.getScreenTitle().contains(screen));
    }

    @When("^I navigate ((?!.*Каталог).*) on screen (.*) in application (Onliner)$")
    public void navigateTabs(String tabs, String screen, String app) {
        String[] menuItems = tabs.split(DELIMITER);
        navigation.navigateToFirstLevel(menuItems[0]);
        navigation.navigateToSecondLevel(menuItems[1]);
        navigation.navigateToThirdLevel(menuItems[2]);
    }
}
