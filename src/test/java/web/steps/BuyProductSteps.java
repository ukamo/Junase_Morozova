package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.BuyProductScreen;

public class BuyProductSteps {
    BuyProductScreen buyProductScreen = new BuyProductScreen();
    String priceByNumber;

    @When("^I click on button (.*) for (.*) on screen (.*) in application (.*)$")
    public void clickCompareOrdersByProductName(String nameOfButton, String productName, String screen, String app) {
      buyProductScreen.clickByProductName(nameOfButton, productName);
    }

    @When("^I gather price of item (.*) on screen (.*) in application (.*)$")
    public void gatherPriceByNumber(int numberOfButton, String screen, String app) {
        priceByNumber = buyProductScreen.gatherPriceByNumber(numberOfButton);
    }

    @And("^I click on button with name (.*) by item number (.*) on screen (.*) in application (.*)$")
    public void clickInBasketByPriceNumber(String button, int numberOfButton, String screen, String app) {
        buyProductScreen.clickPriceByNumber(numberOfButton);
    }

    @Then("^I assert (.*) is presented on screen (.*) in application (.*)$")
    public void assertMessageTextOnScreen(String messageText, String screen, String app) {
        Assert.assertEquals(messageText, buyProductScreen::assertMessageText);
    }

    @And("^I assert item price on screen (.*) in application (.*)$")
    public void assertPriceOnScreen(String screen, String app) {
        priceByNumber = priceByNumber.substring(0, priceByNumber.indexOf(" "));
        Assert.assertEquals(priceByNumber, buyProductScreen::assertPrice);
    }

    @When("^I click button (.*) on screen (.*) in application (.*)$")
    public void clickButtonOnBasket(String button, String screen, String app) {
        buyProductScreen.navigateToBasketButton();
    }

    @And("I assert label (.*) is present on screen (.*) in application (.*)$")
    public void assertLabel(String label, String screen, String app) {
        Assert.assertEquals(label, buyProductScreen::assertLabel);
    }
}
