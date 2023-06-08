package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.PriceOffersScreen;

public class PriceOffersSteps {
    private final PriceOffersScreen priceOffersScreen = new PriceOffersScreen();
    private static String priceByNumber;

    @When("^I answer (.*) on expanding window about Location (.*) on screen (.*) in application (.*)$")
    public void clickExpandingWindow(String answer,String location, String screen, String app) {
        priceOffersScreen.clickExpandingWindow(answer);
    }

    @Then("^I store price of item (.*) on screen (.*) in application (.*)$")
    public void gatherPriceByNumber(int itemOrder, String screen, String app) {
        priceByNumber = priceOffersScreen.gatherPriceByNumber(itemOrder);
    }

    @When("^I click button (.*) for item (.*) on screen (.*) in application (.*)$")
    public void clickInBasketByItemOrder(String buttonName, int itemOrder, String screen, String app) {
        priceOffersScreen.clickInBasketByItemOrder(itemOrder);
    }

    @Then("^I assert ((?!.*label ).*) is present on screen (.*) in application (.*)$")
    public void assertMessageTextOnScreen(String messageText, String screen, String app) {
        Assert.assertEquals(messageText, priceOffersScreen::getMessageText);
    }

    @Then("^I assert item price on screen (.*) in application (.*)$")
    public void assertPriceOnScreen(String screen, String app) {
        priceByNumber = priceByNumber.substring(0, priceByNumber.indexOf(" "));
        Assert.assertEquals(priceByNumber, priceOffersScreen::getPrice);
    }

    @When("^I click button ((?!.*for)(?!.*item ).*) on screen (.*) in application (.*)$")
    public void clickButtonOnBasket(String button, String screen, String app) {
        priceOffersScreen.clickButtonOnBasket();
    }
}
