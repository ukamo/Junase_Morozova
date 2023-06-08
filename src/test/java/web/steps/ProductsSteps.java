package web.steps;

import io.cucumber.java.en.When;
import web.screens.ProductsScreen;

public class ProductsSteps {
    private final ProductsScreen productsScreen = new ProductsScreen();

    @When("^I click button ((Сравнение предложений)) for (.*) on screen (.*) in application (.*)$")
    public void clickCompareOrderForProduct(String buttonName, String productName, String screen, String app) {
        productsScreen.clickCompareOrderForProduct(productName);
    }
}
