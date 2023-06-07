package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.PriceOffersScreen;

public class PriceOffersSteps {
    private final PriceOffersScreen priceOffersScreen = new PriceOffersScreen();
    private static String priceByNumber;

    //FIXME: All the annotations should have @When or @Then, not @And, we use and only in feature file//+
    //make priceByNumber private static //+

    @When("I click on expanding window on screen (.*) in application (.*)$")
    public void clickExpandingWindow(String screen, String app) {
        priceOffersScreen.clickExpandingWindow();
    }

    @Then("^I store price of item (.*) on screen (.*) in application (.*)$")
    public void gatherPriceByNumber(int itemOrder, String screen, String app) {
        priceByNumber = priceOffersScreen.gatherPriceByNumber(itemOrder);
    }

    //FIXME: buttonName//+
    @When("^I click button (.*) for item (.*) on screen (.*) in application (.*)$")
    //FIXME: clickInBasketByItemOrder (buttonName, itemOrder..)//+
    public void clickInBasketByItemOrder(String buttonName, int itemOrder, String screen, String app) {
        //FIXME: clickInBasketByItemOrder(itemOrder)//+
        priceOffersScreen.clickInBasketByItemOrder(itemOrder);
    }

    @Then("^I assert (.*) is presented on screen (.*) in application (.*)$")
    public void assertMessageTextOnScreen(String messageText, String screen, String app) {
        //FIXME: getMessageText//+
        Assert.assertEquals(messageText, priceOffersScreen::getMessageText);
    }

    @Then("^I assert item price on screen (.*) in application (.*)$")
    public void assertPriceOnScreen(String screen, String app) {
        priceByNumber = priceByNumber.substring(0, priceByNumber.indexOf(" "));
        //FIXME: getPrice//+
        Assert.assertEquals(priceByNumber, priceOffersScreen::getPrice);
    }

    @When("^I click button ((?!.*for)(?!.*item ).*) on screen (.*) in application (.*)$")
    public void clickButtonOnBasket(String button, String screen, String app) {
        //FIXME: clickButtonOnBasket , navigateToBasketButton -> the methods naming should be consistent//+
        priceOffersScreen.clickButtonOnBasket();
    }
}
