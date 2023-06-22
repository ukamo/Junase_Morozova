package web.steps.Onliner;

import io.cucumber.java.en.When;
import web.screens.Onliner.ForumScreen;

public class ForumSteps {

    ForumScreen forumScreen = new ForumScreen();

    @When("^I click on hyperlink (.*) on screen (.*) in application (Onliner)$")
    public void clickHyperlink(String hyperlinkName, String screen, String app) {
        forumScreen.clickHyperlink(hyperlinkName);
    }
}
