package web.screens;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.Dialog;
import web.component.Label;

public class PriceOffersScreen {
    private final Dialog expandingWindow = new Dialog(By.xpath("//div[contains(@class,'popover-style__content')]//div[contains(@class,'offers-form__description')]/span"));
    private final Label labelPriceByCount = new Label(By.xpath("//div[contains(@class,'offers-list__group')]"));
    private final String BUTTON_BYCOUNT_XPATH = "//div[contains(@class,'offers-list__group')]/div[%s]//div[contains(@class,'offers-list__part_action')]//a[contains(@class,' button-style_expletive')]";
    private final Label labelMessageText = new Label(By.cssSelector(".product-recommended__subheader"));
    private final Label labelPrice = new Label(By.xpath("//div[contains(@class,'product-recommended__link_primary')]/span"));
    private final Button navigateToBasketButton = new Button(By.xpath("//a[contains(@class,'button-style_another button-style_base-alter product-recommended__button')]"));

    //FIXME: you don't need else in this method + I can't understand what is the purpose of this method //#This method closes window about navigation, it the window exists
    public void clickExpandingWindow() {
        if (expandingWindow.isDisplayed()) {
            expandingWindow.clickButtonById();
        } else {
            return;
        }
    }

    public String gatherPriceByNumber(int itemOrder) {
        return labelPriceByCount.gatherPriceByNumber(itemOrder);
    }

    public void clickInBasketByItemOrder(int itemOrder) {
        //FIXME: remove method from the Button class //+
        new Button(By.xpath(String.format(BUTTON_BYCOUNT_XPATH, itemOrder))).click();
    }

    public String getMessageText() {
        return labelMessageText.getText();
    }

    public String getPrice() {
        return labelPrice.getText();
    }

    public void clickButtonOnBasket() {
        navigateToBasketButton.click();
    }
}
