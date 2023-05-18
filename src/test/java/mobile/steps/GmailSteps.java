package mobile.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.screens.ComposePageScreen;
import mobile.screens.WelcomeScreen;
import mobile.screens.MainPageScreen;
import eu.ibagroup.junase.model.util.Assert;

public class GmailSteps {

    private final WelcomeScreen welcomeScreen = new WelcomeScreen();

    private final MainPageScreen mainPageScreen = new MainPageScreen();

    private final ComposePageScreen composePageScreen = new ComposePageScreen();

    @Given("^I navigate to (Gmail) on screen (Welcome) in application (Gmail)$")
    public void headerLabelIsDisplayed(String icon, String screen, String app) {
        Assert.assertTrue(welcomeScreen::isHeaderLabelDisplayed);
    }

    @When("^I click button (Got) on screen (Welcome) in application (Gmail)")
    public void clickGotIt(String button, String screen, String app) {
        welcomeScreen.clickGotItButton();
    }

    @Then("^I assert user \"(.*)\" is displayed on screen (Welcome) in application (Gmail)$")
    public void assertUserIsPresented(String value, String screen, String app) {
        Assert.assertEquals(value, welcomeScreen::getUserName);
    }

    @Then("^I assert email \"(.*)\" is displayed on screen (Welcome) in application (Gmail)$")
    public void assertEmailIsPresentedOnScreenWelcome(String value, String screen, String app) {
        Assert.assertEquals(value, welcomeScreen::getUserAddress);
    }

    @When("^I click button (Take Me To Gmail) on screen (Welcome) in application (Gmail)$")
    public void clickTakeMeToGmailButton(String button, String screen, String app) {
        welcomeScreen.clickTakeMeToGmailButton();
    }

    @Then("^I assert (User) is displayed on screen (Main) in application (Gmail)$")
    public void assertUserIconIsPresented(String label, String screen, String app) {
        Assert.assertTrue(mainPageScreen::isUserIconDisplayed);
    }

    @Then("^I assert button (New Email) is displayed on screen (Main) in application (Gmail)$")
    public void assertNewEmailButtonIsPresented(String button, String screen, String app) {
        Assert.assertTrue(mainPageScreen::isNewEmailButtonDisplayed);
    }

    @When("^I click button (New Email) on screen (Main) in application (Gmail)")
    public void clickNewEmailButton(String button, String screen, String app) {
        mainPageScreen.clickNewEmailButton();
    }

    @When("^I click button (Ok) on alert message on screen (Main) in application (Gmail)")
    public void acceptAlert(String button, String screen, String app) {
        mainPageScreen.acceptAlert();
    }

    @Then("^I assert email \"(.*)\" is displayed on screen (Compose) in application (Gmail)$")
    public void assertEmailIsPresentedOnScreenCompose(String value, String screen, String app) {
        Assert.assertEquals(value, composePageScreen::getUserFromName);
    }

    @When("^I set email \"(.*)\" on screen (Compose) in application (Gmail)$")
    public void setEmailTo(String email, String screen, String app) {
        composePageScreen.setUserTo(email);
    }

    @When("^I set subject \"(.*)\" on screen (Compose) in application (Gmail)$")
    public void setSubject(String text, String screen, String app) {
        composePageScreen.setSubject(text);
    }

    @When("^I click button (Send) on screen (Compose) in application (Gmail)")
    public void clickSendButton(String button, String screen, String app) {
        composePageScreen.clickSendButton();
    }

    @Then("^I assert (Subject) is displayed on screen (Main) in application (Gmail)$")
    public void assertSubjectIsPresented(String text, String screen, String app) {
        Assert.assertTrue(mainPageScreen::isSubjectMessageDisplayed);
    }
}