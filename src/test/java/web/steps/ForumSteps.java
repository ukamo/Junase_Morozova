package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import web.screens.ForumScreen;

public class ForumSteps {
    ForumScreen forumScreen = new ForumScreen();
    String idOfAuthor;

    @When("^I get Id to the (.*) message of (.*) on screen (.*) theme in application (.*)$")
    public void getIdOfAuthorTheMessage(int numberOfTopic, String nameOfHeader, String screen, String app) {
        idOfAuthor = forumScreen.getIdByNumber(numberOfTopic);
    }

    @And("^I navigate to the (.*) message of (.*) on screen (.*) theme in application (.*)$")
    public void navigateToMessage(int numberOfTopic, String nameOfHeader, String screen, String app) {
        forumScreen.navigateToMessage(numberOfTopic);
    }

    @And("^I assert ID on screen (.*) in application (.*)$")
    public void assertId(String screen, String app) {
        Assert.assertEquals(idOfAuthor, forumScreen::assertProfile);
    }


    @And("I assert (.*) and (.*) on screen (.*) in application (.*)$")
    public void assertFieldsExist(String field1, String field2, String screen, String app) {
        Assert.assertTrue(() -> forumScreen.assertFieldsExist(field1));
        Assert.assertTrue(() -> forumScreen.assertFieldsExist(field2));
    }
}
