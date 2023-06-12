package web.screens;

import org.openqa.selenium.By;
import web.component.Button;
import web.component.Label;
import web.component.PopOver;

//FIXME:ProductScreen
public class PriceOffersScreen {

    //FIXME: all constants should be declared first in the class, them the other fields go
    //FIXME: write popover xpath in which you can insert popoverTitle using %s in method getPopoverByTitle
    private final PopOver popover = new PopOver(By.cssSelector(".offers-form__description_condensed"));

    //FIXME: PRICE_BY_ITEM_ORDER_XPATH
    private static final String PRICE_BYCOUNT_XPATH = "(//div[contains(@class,'offers-list__description_alter-other')])[%s]";

    //FIXME: IN_BUSKET_BY_ITEM_ORDER_XPATH
    private static final String BUTTON_BYCOUNT_XPATH = "(//a[contains(text(),'В корзину')])[position() mod 2= 0][%s]";

    //FIXME: if you want to locate only first label, the following cssSelector is incorrent, it locates two elements;
    // moreover instead of writing By.cssSelector(".product-recommended__subheader") you can write By.className("product-recommended__subheader");
    //TODO: additional task: please implement the class SideBar that extends Component that will have method getSubHeaders and return the list of two subheaders
    //+ in the Steps class corresponding to that Screen use the method Assert.assertListContains that will check that the subheader "Товар добавлен в корзину"
    // is contained in the list of subheaders that you will retrieve using method getSubHeaders
    //the corresponding step in the step class should be as follows:
    //Then I assert header Товар добавлен в корзину is present on side bar on screen in app...
    private final Label labelMessageText = new Label(By.cssSelector(".product-recommended__subheader"));

    private final Label labelPrice = new Label(By.cssSelector(".product-recommended__price > div"));

    //FIXME: BUTTON_BY_NAME
    private static final String BUTTON_IN_BASKET = "//a[contains(text(),'%s')]";

    //FIXME: add private method getPopoverByTitle(String popoverTitle)

    public void clickExpandingWindow(String answer) {
        popover.isDisplayed();
        //FIXME: getPopoverByTitle(popoverTitle).getButtonByName(buttonName).click();
        popover.getButtonByName(answer).click();
    }

    //FIXME: getPriceByItemOrder
    public String storePriceByNumber(int itemOrder) {
        return new Label(By.xpath(String.format(PRICE_BYCOUNT_XPATH, itemOrder))).getText();
    }

    public void clickInBasketByItemOrder(int itemOrder) {
        new Button(By.xpath(String.format(BUTTON_BYCOUNT_XPATH, itemOrder))).click();
    }

    public String getMessageText() {
        return labelMessageText.getText();
    }

    public String getPrice() {
        return labelPrice.getText();
    }

    //FIXME: clickInBasket
    public void clickButtonOnBasket(String button) {
        new Button(By.xpath(String.format(BUTTON_IN_BASKET, button))).click();
    }
}
