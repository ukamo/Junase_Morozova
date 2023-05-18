package javaApp.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaApp.screens.JavaAppScreen;
import eu.ibagroup.junase.model.util.Assert;

public class JavaAppSteps {

    private final JavaAppScreen javaAppScreen = new JavaAppScreen();

    @Given("^I login to java application$")
    public void loginToApp() {
    }

    @When("^I set user \"(.*)\" in java application$")
    public void setUser(String userName) {
        javaAppScreen.setUserName(userName);
    }

    @When("^I set password \"(.*)\" in java application$")
    public void setPassword(String password) {
        javaAppScreen.setUserPassword(password);
    }

    @When("^I click button (Login) in java application$")
    public void clickLoginButton(String button) {
        javaAppScreen.clickLoginButton();
    }

    @Then("^I assert message (Login Success) is displayed in java application$")
    public void assertMessageIsDisplayed(String value) {
        Assert.assertTrue(javaAppScreen::isTitleDisplayed);
    }
}