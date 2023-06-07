package web.steps;

import io.cucumber.java.en.When;
import web.screens.ProductsScreen;

public class ProductsSteps {
    private final ProductsScreen productsScreen = new ProductsScreen();

    @When("^I click button ((Сравнение предложений)) for (.*) on screen (.*) in application (.*)$")
    public void clickCompareOrderForProduct(String buttonName, String productName, String screen, String app) {
        //FIXME: clickCompareOrderForProduct -> cause this method can be used only for clicking compare orders//+
        //if the methos can be used only in one place (for comparing order) in the application - there is no need to parametrise it with the name of the button.//+
        // Thus you can just write clickCompareOrderForProduct(productName) +
        productsScreen.clickCompareOrderForProduct(productName);
    }
}
