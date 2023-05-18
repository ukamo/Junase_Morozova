package web.steps.stepsProjectMorozova;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.screenProjectMorozova.OnlinerExampleScreen;

public class OnlinerExampleSteps {

    private final OnlinerExampleScreen exampleScreen = new OnlinerExampleScreen();

    @Then("^the user opens Onliner website$")
    public void assertScreen() {
        Assert.assertTrue(exampleScreen::getScreenTitle);
    }

    @When("^the user clicks on (Catalog) section$")
    public void clickOnCatalog() {
        exampleScreen.clickOnCatalog();
    }
}
