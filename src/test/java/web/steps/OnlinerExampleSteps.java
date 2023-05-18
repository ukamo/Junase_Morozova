package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.screenProjectMorozova.OnlinerExampleScreen;

public class OnlinerExampleSteps {

    private final OnlinerExampleScreen exampleScreen = new OnlinerExampleScreen();

    @Given("^the user opens Onliner website$")
    public void assertScreens() {
        exampleScreen.navigateToOnlinerPage();

    }

    @Then("the user asserts Oniner website")
    public void theUserAssertsOninerWebsite() {
        Assert.assertTrue(exampleScreen::getsScreenTitle);
    }


    @When("the user clicks on Catalog section {string}")
    public void theUserClicksOnCatalogSection(String str) {
        exampleScreen.clicksOnCatalog("Каталог");
    }
}
