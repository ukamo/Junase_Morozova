package web.screens;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.Dialog;
import web.component.Label;

public class BuyProductScreen {
    private static final Dialog expandingWindow = new Dialog(By.xpath("//div[contains(@class,'popover-style__content')]//div[contains(@class,'offers-form__description')]/span"));
    private static final Button buttonOffers = new Button(By.xpath("//div[contains(@class,'schema-product__offers')]"));
    private static final Button buttonPriceByCount = new Button(By.xpath("//div[contains(@class,'offers-list__item')]//div[contains(@class,'offers-list__part_action')]"));
    private static final Label labelPriceByCount = new Label(By.xpath("//div[contains(@class,'offers-list__group')]"));
    private static final Label labelMessageText = new Label(By.cssSelector(".product-recommended__subheader"));
    private static final Label labelPrice = new Label(By.xpath("//div[contains(@class,'product-recommended__link_primary')]/span"));
    private final Button navigateToBasketButton = new Button(By.xpath("//a[contains(@class,'button-style_another button-style_base-alter product-recommended__button')]"));
    private static final Label labelTextInBasket = new Label(By.xpath("//div[contains(@class,'cart-form__description_font-weight_semibold')]/a[contains(@class,'cart-form__link_primary')]"));

    public void clickExpandingWindow(){
        if (expandingWindow.isDisplayed()){
            expandingWindow.clickButtonById();
        } else {
            return;
        }
    }
    public void clickByProductName(String nameOfButton, String productName) {
        buttonOffers.findOffersByName(nameOfButton, productName);
    }

    public String gatherPriceByNumber(int numberOfButton) {
        return labelPriceByCount.gatherPriceByNumber(numberOfButton);
    }

    public void clickPriceByNumber(int numberOfButton) {
        buttonPriceByCount.findPriceByNumber(numberOfButton);
    }

    public String assertMessageText() {
        return labelMessageText.getText();
    }

    public String assertPrice() {
        return labelPrice.getText();
    }

    public void navigateToBasketButton() {
        navigateToBasketButton.click();
    }

    public String assertLabelInBasket() {
        return labelTextInBasket.getText();
    }
}
