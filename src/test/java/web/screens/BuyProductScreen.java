package web.screens;

import eu.ibagroup.junase.web.test.WebDriverManager;
import org.openqa.selenium.By;
import web.component.Button;
import web.component.Input;

public class BuyProductScreen {
    private static final Button buttonOffers = new Button(By.xpath("//div[contains(@class,'schema-product__offers')]"));
    private static final Button buttonPriceByCount = new Button(By.xpath("//div[contains(@class,'offers-list__item')]//div[contains(@class,'offers-list__part_action')]"));
    private static final Input inputPriceByCount = new Input(By.xpath("//div[contains(@class,'offers-list__item')]//div[contains(@class,'offers-list__description_alter-other')]"));
    private static final Input inputMessageText = new Input(By.xpath("//div[contains(@class,'product-recommended__sidebar-overflow')]"));

    public void clickByProductName(String nameOfButton, String productName) {
        buttonOffers.findOffersByName(nameOfButton, productName);
    }

    public String gatherPriceByNumber(int numberOfButton) {
        return inputPriceByCount.gatherPriceByNumber(numberOfButton);
    }

    public void clickPriceByNumber(int numberOfButton) {
        buttonPriceByCount.findPriceByNumber(numberOfButton);
    }

    public boolean assertMessageText(String messageText) {
        return WebDriverManager.currentSession().getWebDriver().findElements(By.cssSelector(".product-recommended__subheader")).get(0).getText().equals(messageText);
    };


}
