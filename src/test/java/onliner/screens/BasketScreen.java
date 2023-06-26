package onliner.screens;

import onliner.component.Label;
import org.openqa.selenium.By;

public class BasketScreen {

    private final Label labelTextInBasket = new Label(By.cssSelector(".cart-form__offers-part_data a.cart-form__link"));

    public String getLabel() {
        return labelTextInBasket.getText();
    }
}
