package web.screens.screenProjectMorozova;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.Hyperlink;
import web.component.Label;

public class OnlinerBasketPage {
    private final Label priceByCount = new Label(By.xpath("//div[contains(@class,'product-recommended__sidebar-aside')]//div[contains(@class,'product-recommended__price')]//div[contains(@class,'product-recommended__link')]"));
    private final Button navigateToBasketButton = new Button(By.xpath("//a[contains(@class,'button-style_another button-style_base-alter product-recommended__button')]"));
    private final Label onlinerCartLogo = new Label(By.xpath("//a[contains(@class,'cart-form__image cart-form__image_logo')]"));
    private final Label productInBasket = new Label(By.xpath("//div[contains(@class,'cart-form__offers-part_data')]//a[contains(@class,'cart-form__link')]"));

    public String clickOnPriceByCount(int number) {
        String xpathForSaving = "//div[contains(@class,'offers-list__item')][" + number + "]//div[contains(@class,'offers-list__description_alter-other')]";
        Hyperlink hyperLink = new Hyperlink(By.xpath(xpathForSaving));
        String text = hyperLink.getText();
        String xpath = "//div[contains(@class,'offers-list__item')][" + number + "]//div[contains(@class,'offers-list__part_action')]//a[contains(@class,'offers-list__button_cart button-style_expletive')]";
        Button button = new Button(By.xpath(xpath));
        button.click();
        return text;
    }

    public String getPriceByCount() {
        return priceByCount.getText();
    }

    public void navigateToBasketButton() {
        navigateToBasketButton.click();
    }

    public boolean assertsBasketPage() {
        return onlinerCartLogo.isDisplayed();
    }

    public String verifyProductTitleIsDisplayedInBasket() {
        return productInBasket.getText();
    }


}
