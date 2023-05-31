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
        navigationScreen.navigateToSection(section);
    }


    @When("I navigate 3 sections (.*) on screen (.*) in application (.*)$")
    public void navigateTabs(String tabs, String screen, String app) {
        String[] menuItems = tabs.split(DELIMITER);
        navigationScreen.navigateToFirstLevel(menuItems[0]);
        navigationScreen.navigateToSecondLevel(menuItems[1]);
        navigationScreen.navigateToThirdLevel(menuItems[2]);

    }

    @When("I navigate to (.*) search on screen (.*) in application (.*)$")
    public void navigateToSearch(String nameOfSearch, String screen, String app) {
        navigationScreen.navigateToSearch();
    }


    @Then("I assert I am on (.*) search on screen (.*) in application (.*)$")
    public void assertSeacrhInApp(String nameOfSearch, String screen, String app) {
        Assert.assertEquals(nameOfSearch, navigationScreen::assertSeacrhInApp);
    }

    @When("I type (.*) in search (.*) on screen (.*) in application (.*)$")
    public void typeInSearch(String text, String nameOfSearch, String screen, String app) {
        navigationScreen.typeInSearch(text);

    }
    @When("I switch to iframe on screen (.*) in application (.*)$")
    public void swithToIFrame(String screen, String app) {
        navigationScreen.swithOnIFrameFieldSearching();
    }

    @Then("I assert I typed (.*) on screen (.*) in application (.*)$")
    public void assertTypedText(String text, String screen, String app) {
        Assert.assertEquals(text, navigationScreen::assertTypedText);
    }

    @When("I navigate (.*) section on iframe on screen (.*) in application (.*)$")
    public void navigateOnSectionInSearch(String section, String screen, String app) {
        //navigationScreen.swithOnIFrameFieldSearching();
        navigationScreen.navigateOnSectionInSearch(section);
    }

    @Then("I assert I am on (.*) section on screen (.*) in application (.*)$")
    public void assertCursorIsOnSection(String section, String screen, String app) {
        Assert.assertEquals(section, navigationScreen::assertCursorIsOnSection);
    }


    /*@When("I navigate on (.*) topic on screen (.*) in application (.*)$")
    public void navigateToTopicByNumber(int numberOfTopic, String screen, String app) {
        navigationScreen.navigateToTopicByNumber(numberOfTopic);
    }

     */
}
