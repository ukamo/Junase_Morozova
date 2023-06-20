package web.steps;

import eu.ibagroup.junase.model.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.screens.ProductScreen;

public class ProductSteps {

    private final ProductScreen productScreen = new ProductScreen();

    private static String priceByNumber;

    @When("^I click button (?!.*(for|popover)) on screen (.*) in application (Onliner)$")
    public void clickButtonByName(String buttonName, String screen, String app) {
        productScreen.clickButtonByName(buttonName);
    }

    @When("^I click button (.*) on popover (.*) on screen (.*) in application (Onliner)$")
    public void clickButtonByNameOnPopover(String buttonName, String popoverTitle, String screen, String app) {
        productScreen.clickButtonByNameOnPopover(buttonName, popoverTitle);
    }

    @When("^I click button (В корзину) for item ([0-9]+) on screen (.*) in application (Onliner)$")
    public void clickInBasketForItemOrder(String buttonName, int itemOrder, String screen, String app) {
        productScreen.clickInBasketForItemOrder(itemOrder);
    }

    @Then("^I assert popover (.*) is displayed on screen (.*) in application (Onliner)$")
    public void assertPopoverIsDisplayed(String popoverTitle, String screen, String app) {
        Assert.assertTrue(() -> productScreen.isPopoverDisplayed(popoverTitle));
    }

    @Then("^I assert sidebar is opened on screen (.*) in application (Onliner)$")
    public void assertSidebarIsDisplayed(String screen, String app) {
        Assert.assertTrue(productScreen::isSidebarDisplayed);
    }

    @Then("I assert header (.*) is present on sidebar on screen (.*) in application (Onliner)$")
    public void assertHeaderIsPresent(String header, String screen, String app) {
        Assert.assertListContains(productScreen::getListOfHeaders, header);
    }

    @Then("^I assert item price on screen (.*) in application (Onliner)$")
    public void assertItemPrice(String screen, String app) {
        Assert.assertEquals(priceByNumber, productScreen::getItemPrice);
    }

    @When("^I store price of item ([0-9]+) on screen (.*) in application (Onliner)$")
    public void storePriceByItemOrder(int itemOrder, String screen, String app) {
        priceByNumber = productScreen.getPriceByItemOrder(itemOrder);
    }
}