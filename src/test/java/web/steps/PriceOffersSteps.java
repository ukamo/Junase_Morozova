package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.PriceOffersScreen;

//FIXME:ProductSteps
public class PriceOffersSteps {

    private final PriceOffersScreen priceOffersScreen = new PriceOffersScreen();

    private static String priceByNumber;

    //FIXME: I click button (.*) on pop over (.*) on screen (.*) in application (Onliner)
    @When("^I answer (.*) on expanding window about Location (.*) on screen (.*) in application (Onliner)$")
    //FIXME: clickButtonByNameOnPopover (buttonName, popoverTitle, ..)
    public void clickExpandingWindow(String answer,String location, String screen, String app) {
        //FIXME:priceOffersScreen.clickButtonByNameOnPopover (buttonName, popoverTitle)
        priceOffersScreen.clickExpandingWindow(answer);
    }

    //FIXME: you should pass digits in item, not any string, i.e. ([0-9]+), check the same for all the numerals across the project
    @Then("^I store price of item (.*) on screen (.*) in application (Onliner)$")
    //FIXME: storePriceByItemOrder
    public void storePriceByNumber(int itemOrder, String screen, String app) {
        //FIXME: priceOffersScreen.getPriceByItemOrder(itemOrder)
        priceByNumber = priceOffersScreen.storePriceByNumber(itemOrder);
    }

    //FIXME: I click button (В корзину) ...
    //FIXME: clickInBasketForItemOrder
    @When("^I click button (.*) for item (.*) on screen (.*) in application (Onliner)$")
    public void clickInBasketByItemOrder(String buttonName, int itemOrder, String screen, String app) {
        priceOffersScreen.clickInBasketByItemOrder(itemOrder);
    }

    @Then("^I assert ((?!.*label ).*) is present on screen (.*) in application (Onliner)$")
    //FIXME: assertLabel
    public void assertMessageTextOnScreen(String messageText, String screen, String app) {
        Assert.assertEquals(messageText, priceOffersScreen::getMessageText);
    }

    @Then("^I assert item price on screen (.*) in application (Onliner)$")
    //TODO: assertItemPrice
    public void assertPriceOnScreen(String screen, String app) {
       // priceByNumber = priceByNumber.substring(0, priceByNumber.indexOf(" "));
        Assert.assertEquals(priceByNumber, priceOffersScreen::getPrice);
    }

    //FIXME: I click button ((?!.*for ).*) on screen (.*) in application (Onliner)
    @When("^I click button ((?!.*for)(?!.*item ).*) on screen (.*) in application (Onliner)$")
    //FIXME: clickButtonByName(String buttonName...
    public void clickButtonOnBasket(String button, String screen, String app) {
        //FIXME: clickButtonByName(buttonName)
        priceOffersScreen.clickButtonOnBasket(button);
    }
}