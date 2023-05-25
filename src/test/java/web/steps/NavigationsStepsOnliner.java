package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.NavigationOnliner;

import java.util.regex.Pattern;

public class NavigationsStepsOnliner {
    NavigationOnliner navigationOnliner = new NavigationOnliner();
    @Given("^I am on screen (.*) in application (.*)$")
    public void assertScreenInApplication(String screen, String app) {
        navigationOnliner.navigateToOnlinerPage();

    }
    @When("I navigate to (.*) on screen (.*) in application (.*)$")
    public void navigateSection(String section, String screen, String app) {
        navigationOnliner.clickOnSection(section);
    }
    @Then("I assert I am on screen (.*) in application (.*)$")
    public void assertSection(String screen, String app) {
        Assert.assertEqualsPattern(Pattern.compile(screen), navigationOnliner::getContent);
    }


}
