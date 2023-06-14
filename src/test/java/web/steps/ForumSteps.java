package web.steps;

import io.cucumber.java.en.When;
import web.screens.ForumScreen;

public class ForumSteps {

    ForumScreen forumScreen = new ForumScreen();

    @When("^I click on hyperlink (.*) on screen (.*) in application (Onliner)$")
    public void clickOnHyperlink(String hyperlinkName, String screen, String app) {
        forumScreen.clickOnHyperlink(hyperlinkName);
    }
}
