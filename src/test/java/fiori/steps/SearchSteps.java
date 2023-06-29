package fiori.steps;

import eu.ibagroup.junase.model.util.Assert;
import fiori.screens.SearchScreen;
import io.cucumber.java.en.Then;

public class SearchSteps {

    SearchScreen searchScreen = new SearchScreen();

    @Then("^I assert container (.*) is displayed on screen (Search) in application (Fiori)$")
    public void assertContainerIsDisplayed(String containerName, String screen, String app) {
        Assert.assertTrue(() -> searchScreen.isContainerByNameDisplayed(containerName));
    }
}
