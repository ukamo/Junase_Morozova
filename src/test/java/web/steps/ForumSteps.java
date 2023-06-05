package web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import web.screens.ForumScreen;

public class ForumSteps {
    ForumScreen forumScreen = new ForumScreen();
    String IdOfAuthor;

    @When("^I get Id to the (.*) message of (.*) on screen (.*) theme in application (.*)$")
    public void getIdOfAuthorTheMessage(int numberOfTopic, String nameOfHeader, String screen, String app) {
        IdOfAuthor = forumScreen.getIdByNumber(numberOfTopic);
    }

    @And("^I navigate to the (.*) message of (.*) on screen (.*) theme in application (.*)$")
    public void navigateToMessage(int numberOfTopic, String nameOfHeader, String screen, String app) {
        forumScreen.navigateToMessage(numberOfTopic);
    }
}
