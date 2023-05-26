package web.steps;

import io.cucumber.java.en.When;
import web.screens.BuyProductScreen;

public class BuyProductSteps {
    BuyProductScreen buyProductScreen = new BuyProductScreen();
    @When("^I click button (.*) for (.*) on screen (.*) in application (.*)$")
    public void clickCompareOrdersByProductName(String nameOfButton, String productName, String screen, String app) {
        buyProductScreen.clickCompareOrdersByProductName(nameOfButton, productName);

    }
}
