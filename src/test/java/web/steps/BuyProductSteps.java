package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.BuyProductScreen;

public class BuyProductSteps {
    BuyProductScreen buyProductScreen = new BuyProductScreen();

    String priceByNumber;

    @When("^I click button (.*) for (.*) on screen (.*) in application (.*)$")
    public void clickCompareOrdersByProductName(String nameOfButton, String productName, String screen, String app) {
        // buyProductScreen.clickCompareOrdersByProductName(nameOfButton, productName);
        buyProductScreen.clickByProductName(nameOfButton, productName);
    }

    @When("^I gather price of item (.*) on screen (.*) in application (.*)$")

    public void gatherPriceByNumber(int numberOfButton, String screen, String app) {
        priceByNumber = buyProductScreen.gatherPriceByNumber(numberOfButton);
    }

    @And("I click button (.*) by item (.*) on screen (.*) in application (.*)$")
    public void clickInBasketByPriceNumber(String button, int numberOfButton, String screen, String app) {
        buyProductScreen.clickPriceByNumber(numberOfButton);
    }

    @Then("I assert (.*) is presented on screen (.*) in application (.*)$")
    public void assertMessageTextOnScreen(String messageText, String screen, String app) {
        Assert.assertTrue(() -> buyProductScreen.assertMessageText(messageText));
    }


}
