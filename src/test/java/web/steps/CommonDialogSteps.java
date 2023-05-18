package web.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import eu.ibagroup.junase.model.util.Assert;
import web.screens.CommonDialog;

public class CommonDialogSteps {

    private final CommonDialog dialog = new CommonDialog();

    @Then("^I assert dialog is opened on screen (.*)$")
    public void assertDialogOpened(String screen) {
        Assert.assertTrue(dialog::isDialogOpened);
    }

    @Then("^I assert message \"(.*)\" is displayed on dialog on screen (.*)$")
    public void assertMessageOnDialog(String text, String screen) {
        Assert.assertEquals(text, dialog::getMessageText);
    }

    @When("^I click button (.*) on dialog on screen (.*)$")
    public void clickUpload(String buttonName, String screen) {
        dialog.clickButton(buttonName);
    }
}