package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.NavigationScreen;

public class NavigationSteps {
    NavigationScreen navigationScreen = new NavigationScreen();

    private static final String DELIMITER = " -> ";

    @Given("^I am on screen (.*) in application (.*)$")
    @Then("I assert I am on screen (.*) in application (.*)$")
    public void assertScreenInApplication(String screen, String app) {
        Assert.assertTrue(() -> navigationScreen.getScreenTitle().contains(screen));
    }

    @When("I navigate to (.*) section on screen (.*) in application (.*)$")
    public void navigateSection(String section, String screen, String app) throws InterruptedException {
     //   Thread.sleep(200);
        navigationScreen.navigateToSection(section);
    }


    @When("I navigate 3 sections (.*) on screen (.*) in application (.*)$")
    public void navigateTabs(String tabs, String screen, String app) {
        //List<String> listOfTabs = List.of(tabs.split(DELIMITER));
        String[] menuItems = tabs.split(DELIMITER);
        navigationScreen.navigateToFirstLevel(menuItems[0]);
        navigationScreen.navigateToSecondLevel(menuItems[1]);
        navigationScreen.navigateToThirdLevel(menuItems[2]);

    }


}
