package web.screens;

import org.openqa.selenium.By;
import web.component.Button;

public class BuyProductScreen {

    private static final String COMPARE_ORDERS_BUTTON_XPATH = "(//a[contains(@title,'%s')])[1]";

    public void clickCompareOrdersByProductName(String nameOfButton, String productName){
        new Button(By.xpath(String.format(COMPARE_ORDERS_BUTTON_XPATH,productName))).click();
    }
}
