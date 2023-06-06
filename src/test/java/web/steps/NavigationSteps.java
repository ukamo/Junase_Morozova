package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.NavigationScreen;

public class NavigationSteps {

    //FIXME: the filed should have private final identificatior
    //FIXME: rename NavigationScreen to Navigation (it is not the web page entity)
    NavigationScreen navigationScreen = new NavigationScreen();

    private static final String DELIMITER = " -> ";

    @Given("^I am on screen (.*) in application (.*)$")
    @Then("I assert I am on screen (.*) in application (.*)$")
    public void assertScreenInApplication(String screen, String app) {
        Assert.assertTrue(() -> navigationScreen.getScreenTitle().contains(screen));
    }

    //FIXME: remove unused exception
    //FIXME: the arguments should be consistent in this method and in the same method at th NavigationScreen class, i.e. sectionName
    @When("I navigate to (.*) section on screen (.*) in application (.*)$")
    public void navigateSection(String section, String screen, String app) throws InterruptedException {
        navigationScreen.navigateToSection(section);
    }


    @When("I navigate 3 sections (.*) on screen (.*) in application (.*)$")
    public void navigateTabs(String tabs, String screen, String app) {
        String[] menuItems = tabs.split(DELIMITER);
        navigationScreen.navigateToFirstLevel(menuItems[0]);
        navigationScreen.navigateToSecondLevel(menuItems[1]);
        navigationScreen.navigateToThirdLevel(menuItems[2]);

    }

//FIXME: remove blank rows everywhere in the project
}
