package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.screenProjectMorozova.OnlinerBasketPage;

public class OnlinerBasketPageSteps {

    OnlinerBasketPage basketPage = new OnlinerBasketPage();
    String price;

    @When("the user clicks on Add in Basket by First {int} Price")
    public void clickOnnPriceByCount(int number) {
        price = basketPage.clickOnPriceByCount(number);
    }

    @Then("the user asserts on Price")
    public void assertPrice() {
        Assert.assertEquals(price, basketPage::getPriceByCount);
    }


    @When("the user clicks on Basket button")
    public void theUserClicksOnBasketButton() {
        basketPage.navigateToBasketButton();
    }

    @Then("the user asserts on Basket page")
    public void assertBasketPage() {
        Assert.assertTrue(basketPage::assertsBasketPage);
    }

    @When("the user asserts that the product is in Basket {string}")
    public void assertsProductInBasket(String product) {
        Assert.assertEquals(product, basketPage::verifyProductTitleIsDisplayedInBasket);
    }
}
