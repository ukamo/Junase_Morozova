package web.screens;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.Label;
import web.component.PopOver;

public class PriceOffersScreen {
    private final PopOver popover = new PopOver(By.cssSelector(".offers-form__description_condensed"));
    private static final String PRICE_BYCOUNT_XPATH = "(//div[contains(@class,'offers-list__description_alter-other')])[%s]";
    private static final String BUTTON_BYCOUNT_XPATH = "(//a[contains(text(),'В корзину')])[position() mod 2= 0][%s]";
    private final Label labelMessageText = new Label(By.cssSelector(".product-recommended__subheader"));
    private final Label labelPrice = new Label(By.cssSelector(".product-recommended__price > div"));
    private static final String BUTTON_IN_BASKET = "//a[contains(text(),'%s')]";

    public void clickExpandingWindow(String answer) {
        popover.isDisplayed();
        popover.getButtonByName(answer).click();
    }

    public String storePriceByNumber(int itemOrder) {
        return new Label(By.xpath(String.format(PRICE_BYCOUNT_XPATH, itemOrder))).getText();
    }

    public void clickInBasketByItemOrder(int itemOrder) {
        new Button(By.xpath(String.format(BUTTON_BYCOUNT_XPATH, itemOrder))).click();
    }

    public String getMessageText() {
        return labelMessageText.getText();
    }

    public String getPrice() {
        return labelPrice.getText();
    }

    public void clickButtonOnBasket(String button) {
        new Button(By.xpath(String.format(BUTTON_IN_BASKET, button))).click();
    }
}
