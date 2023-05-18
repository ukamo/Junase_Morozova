package web.steps;

import io.cucumber.java.en.Then;
import eu.ibagroup.junase.model.util.Assert;
import web.screens.Message;

public class CommonMessagesSteps {

    private final Message message = new Message();

    @Then("^I assert message \"(.*)\" is displayed on screen (.*)$")
    public void assertMessage(String text, String screen) {
        Assert.assertEquals(text, message::getMessage);
        message.waitForMessageContainerToHide(text);
    }
}