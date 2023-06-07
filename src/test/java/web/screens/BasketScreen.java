package web.screens;

import org.openqa.selenium.By;
import web.component.Label;

public class BasketScreen {
    private final Label labelTextInBasket = new Label(By.xpath("//div[contains(@class,'cart-form__description_font-weight_semibold')]/a[contains(@class,'cart-form__link_primary')]"));

    public String getLabel() {
        return labelTextInBasket.getText();
    }
}
