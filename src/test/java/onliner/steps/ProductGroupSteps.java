package onliner.steps;

import io.cucumber.java.en.When;
import onliner.screens.ProductGroupScreen;

public class ProductGroupSteps {

    private final ProductGroupScreen productGroupScreen = new ProductGroupScreen();

    @When("^I click button (Сравнение предложений) for (.*) on screen (.*) in application (Onliner)$")
    public void clickCompareOrderForProduct(String buttonName, String productName, String screen, String app) {
        productGroupScreen.clickCompareOrderForProduct(productName);
    }
}