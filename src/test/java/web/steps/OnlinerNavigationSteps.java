package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.screenProjectMorozova.OnlinerNavigation;

public class OnlinerNavigationSteps {
    private final OnlinerNavigation navigation = new OnlinerNavigation();

    @Given("^the user opens Onliner website$")
    public void assertScreens() {
        navigation.navigateToOnlinerPage();

    }

    @Then("the user asserts Oniner website")
    public void theUserAssertsOninerWebsite() {
        Assert.assertTrue(navigation::getsScreenTitle);
    }

    @When("the user clicks on Catalog section {string}")
    public void theUserClicksOnCatalogSection(String str) {
        navigation.clicksOnCatalog(str);
    }

    @Then("the user asserts Catalog section")
    public void assertsCatalogSection() {
        Assert.assertTrue(navigation::getsCatalogTitle);
    }

    @When("the user clicks on Catalog Classifier {string}")
    public void clicksOnCatalogClassifier(String item) {
        navigation.clickCatalogClassifier(item);
    }

    @Then("the user asserts Catalog Classifier {string}")
    public void theUserAssertsCatalogClassifier(String item) {
        Assert.assertTrue(() -> navigation.getCatalogClassifier(item));
    }

    @When("the user clicks on Section Item Catalog {string}")
    public void clicksOnSectionItemCatalog(String str) {
        navigation.clickTextSectionItemCatalog(str);
    }


    @Then("the user asserts on Section Item Catalog")
    public void assertOnSectionItemCatalog() {
        navigation.getSectionItemCatalog();
    }

    @When("the user clicks on Product Link {string}")
    public void clickOnProductLink(String product) {
        navigation.clickOnProductLink(product);
    }

    @Then("the user asserts on Product Link {string}")
    public void assertOnProductLink(String product) {
        Assert.assertTrue(() -> {
            return navigation.getProductLink(product);
        });
    }

    @When("the user clicks on Price Item Offer {string}")
    public void clickOnPriceItemOffer(String item) {
        navigation.clickOnItemOffers(item);
    }

    @Then("the user asserts on Price Item Offer {string}")
    public void assertOnPriceItemOffer(String item) {
        Assert.assertTrue(() -> navigation.getProductItemOffers(item));
    }

}
