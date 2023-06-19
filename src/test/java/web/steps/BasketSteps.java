package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import web.screens.BasketScreen;

public class BasketSteps {

    private final BasketScreen basketScreen = new BasketScreen();

    @Then("^I assert (.*) is present on screen (Корзина заказов) in application (Onliner)$")
    public void assertLabelInBasket(String label, String screen, String app) {
        Assert.assertEquals(label, basketScreen::getLabel);
    }
}

