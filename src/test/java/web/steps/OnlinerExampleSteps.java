package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.screenProjectMorozova.OnlinerExampleScreen;

public class OnlinerExampleSteps {

    private final OnlinerExampleScreen exampleScreen = new OnlinerExampleScreen();

    String price;

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
        exampleScreen.clicksOnCatalog(str);
    }
    @Then("the user asserts Catalog section")
    public void assertsCatalogSection(){
        Assert.assertTrue(exampleScreen::getsCatalogTitle);
    }

    @When("the user clicks on Catalog Classifier {string}")
    public void clicksOnCatalogClassifier(String item) {
        exampleScreen.clickCatalogClassifier(item);
    }

    @Then("the user asserts Catalog Classifier {string}")
    public void theUserAssertsCatalogClassifier(String item) {
        Assert.assertTrue(() -> {
            return exampleScreen.getCatalogClassifier(item);
        });
    }


    @When ("the user clicks on Section Item Catalog {string}")
    public void clicksOnSectionItemCatalog(String str){
        exampleScreen.clickTextSectionItemCatalog(str);
    }


    @Then("the user asserts on Section Item Catalog")
    public void assertOnSectionItemCatalog() {
        exampleScreen.getSectionItemCatalog();
    }

    @When("the user clicks on Product Link {string}")
    public void clickOnProductLink(String product) {
        exampleScreen.clickOnProductLink(product);
    }

    @Then("the user asserts on Product Link {string}")
    public void assertOnProductLink(String product) {
        Assert.assertTrue(() -> {
            return exampleScreen.getProductLink(product);
        });
    }

    @When("the user clicks on Price Item Offer {string}")
    public void clickOnPriceItemOffer(String item) {
        exampleScreen.clickOnItemOffers(item);
    }

    @Then("the user asserts on Price Item Offer {string}")
    public void assertOnPriceItemOffer(String item) {
        Assert.assertTrue(()-> exampleScreen.getProductItemOffers(item));
    }



    @When("the user clicks on Add in Basket by First {int} Price")
    public void clickOnnPriceByCount(int number) {
        price = exampleScreen.clickOnPriceByCount(number);
    }
    @Then("the user asserts on Price")
    public void assertPrice() {
        Assert.assertEquals(price, exampleScreen::getPriceByCount);
    }


    @When("the user clicks on Basket button")
    public void theUserClicksOnBasketButton() {
        exampleScreen.navigateToBasketButton();
    }

    @Then("the user asserts on Basket page")
    public void assertBasketPage() {
        Assert.assertTrue(exampleScreen::assertsBasketPage);
    }

    @When("the user asserts that the product is in Basket {string}")
    public void assertsProductInBasket(String product) {
        Assert.assertEquals(product, exampleScreen::verifyProductTitleIsDisplayedInBasket);
    }
}
