package web.screens;

import org.openqa.selenium.By;
import web.component.Button;

public class ProductsScreen {
    private final String COMPARE_BUTTON_XPATH = "//a[@title='Сравнение предложений на %s']";

    public void clickCompareOrderForProduct(String productName) {
        new Button(By.xpath(String.format(COMPARE_BUTTON_XPATH, productName))).click();
    }
}
