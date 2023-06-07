package web.screens;

import org.openqa.selenium.By;
import web.component.Button;

public class ProductsScreen {
    //FIXME: the objects of elements should be private final //+
    //FIXME: the locator have to locate only one unique web element on the web page
    private final String COMPARE_BUTTON_XPATH = "//a[@title='Сравнение предложений на %s']";

    public void clickCompareOrderForProduct(String productName) {
        new Button(By.xpath(String.format(COMPARE_BUTTON_XPATH, productName))).click();
    }
}
