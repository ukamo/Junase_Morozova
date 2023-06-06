package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.BuyProductScreen;

public class BuyProductSteps {

    //FIXME: private final
    BuyProductScreen buyProductScreen = new BuyProductScreen();
    String priceByNumber;

    //FIXME: buttonName
    @When("^I click on button (.*) for (.*) on screen (.*) in application (.*)$")
    public void clickCompareOrdersByProductName(String nameOfButton, String productName, String screen, String app) {
        //FIXME: clickCompareOrderForProduct -> cause this method can be used only for clicking compare orders
        //if the methos can be used only in one place (for comparing order) in the application - there is no need to parametrise it with the name of the button.
        // Thus you can just write clickCompareOrderForProduct(productName)
        buyProductScreen.clickByProductName(nameOfButton, productName);
    }

    @When("I click on expanding window on screen (.*) in application (.*)$")
    public void clickExpandingWindow(String screen, String app) {
        buyProductScreen.clickExpandingWindow();
    }

    //FIXME: All the annotations should have @When or @Then, not @And, we use and only in feature file
    //make priceByNumber private static
    @And("^I gather price of item (.*) on screen (.*) in application (.*)$")
    public void gatherPriceByNumber(int numberOfButton, String screen, String app) {
        priceByNumber = buyProductScreen.gatherPriceByNumber(numberOfButton);
    }

    @And("^I click on button with name (.*) by item number (.*) on screen (.*) in application (.*)$")
    //FIXME: clickInBasketByItemOrder (buttonName, itemOrder..)
    public void clickInBasketByPriceNumber(String button, int numberOfButton, String screen, String app) {
        //FIXME: clickInBasketByItemOrder(itemOrder)
        buyProductScreen.clickPriceByNumber(numberOfButton);
    }

    @Then("^I assert (.*) is presented on screen (.*) in application (.*)$")
    public void assertMessageTextOnScreen(String messageText, String screen, String app) {
        //FIXME: getMessageText
        Assert.assertEquals(messageText, buyProductScreen::assertMessageText);
    }

    @And("^I assert item price on screen (.*) in application (.*)$")
    public void assertPriceOnScreen(String screen, String app) {
        priceByNumber = priceByNumber.substring(0, priceByNumber.indexOf(" "));
        //FIXME: getPrice
        Assert.assertEquals(priceByNumber, buyProductScreen::assertPrice);
    }

    @When("^I click button (.*) on screen (.*) in application (.*)$")
    public void clickButtonOnBasket(String button, String screen, String app) {
        //FIXME: clickButtonOnBasket , navigateToBasketButton -> the methods naming should be consistent
        buyProductScreen.navigateToBasketButton();
    }

    @And("I assert label (.*) is present on screen (.*) in application (.*)$")
    public void assertLabelInBasket(String label, String screen, String app) {
        //FIXME: getLabel
        Assert.assertEquals(label, buyProductScreen::assertLabelInBasket);
    }


}
