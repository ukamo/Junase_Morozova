package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import web.component.Button;
import web.component.Input;

public class BuyProductScreen {
    private static final Button buttonOffers = new Button(By.xpath("//div[contains(@class,'schema-product__offers')]"));
    private static final Button buttonPriceByCount = new Button(By.xpath("//div[contains(@class,'offers-list__item')]//div[contains(@class,'offers-list__part_action')]"));
    private static final Input inputPriceByCount = new Input(By.xpath("//div[contains(@class,'offers-list__group')]"));
    private static final Input inputMessageText = new Input(By.cssSelector(".product-recommended__subheader"));
    private static final Input inputPrice = new Input(By.xpath("//div[contains(@class,'product-recommended__link_primary')]/span"));

    public void clickByProductName(String nameOfButton, String productName) {
        buttonOffers.findOffersByName(nameOfButton, productName);
    }

    public String gatherPriceByNumber(int numberOfButton) {
        String price = inputPriceByCount.gatherPriceByNumber(numberOfButton);
        return price;
    }

    public void clickPriceByNumber(int numberOfButton) {
        buttonPriceByCount.findPriceByNumber(numberOfButton);
    }

    public boolean assertMessageText(String messageText) {
        return inputMessageText.getText().equals(messageText);
    };


    public boolean assertPrice(String priceByNumber) {
        priceByNumber = priceByNumber.substring(0, priceByNumber.indexOf(" "));
        return inputPrice.getText().equals(priceByNumber);
    };





}
