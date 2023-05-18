package desktop.steps;

import desktop.screens.NotePad;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import eu.ibagroup.junase.model.util.Assert;

public class AppSteps {

    private final NotePad notePad = new NotePad();

    @When("^I open application (.*)")
    public void openNotepad(String app) {
    }

    @When("^I set \"(.*)\" in new file in application (Notepad)$")
    public void setText(String text, String app) {
        notePad.setText(text);
    }

    @When("^I clear file in new file in application (Notepad)$")
    public void clearText(String app) {
        notePad.clearText();
    }

    @Then("^I assert file is empty in application (Notepad)$")
    public void isFileEmpty(String app) {
        Assert.assertTrue(notePad::isFileEmpty);
    }
}