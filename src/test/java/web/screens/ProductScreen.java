package web.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.component.Button;
import web.component.Label;
import web.component.PopOver;
import web.component.Sidebar;

import java.util.List;
import java.util.stream.Collectors;

public class ProductScreen {

    private static final String POPOVER_TITLE_XPATH = "//div[@class='offers-form']/div[contains(text(),'%s')]/span[contains(text(),'%s')]";

    private static final String PRICE_BY_ITEM_ORDER_XPATH = "(//div[contains(@class,'offers-list__description_alter-other')])[%s]";

    private static final String IN_BUSKET_BY_ITEM_ORDER_XPATH = "(//a[contains(text(),'В корзину')])[position() mod 2= 0][%s]";

    private static final String BUTTON_BY_NAME = "//a[contains(text(),'%s')]";

    private final Label sidebarAside = new Label(By.className("product-recommended__sidebar-aside"));

    private final Label labelPrice = new Label(By.cssSelector(".product-recommended__price > div"));

    private PopOver getPopoverByTitle(String popoverTitle) {
        String nameOfPopover = popoverTitle.split(("(—\\s)"))[0] + "—";
        String city = popoverTitle.split(("(—\\s)"))[1];
        return new PopOver(By.xpath(String.format(POPOVER_TITLE_XPATH, nameOfPopover, city)));
    }

    public void isPopoverIsDisplayed(String popoverTitle) {
        getPopoverByTitle(popoverTitle).isDisplayed();
    }

    public void clickButtonByNameOnPopover(String buttonName, String popoverTitle) {
        getPopoverByTitle(popoverTitle).getButtonByName(buttonName).click();
    }

    public String getPriceByItemOrder(int itemOrder) {
        return new Label(By.xpath(String.format(PRICE_BY_ITEM_ORDER_XPATH, itemOrder))).getText();
    }

    public void clickInBasketForItemOrder(int itemOrder) {
        new Button(By.xpath(String.format(IN_BUSKET_BY_ITEM_ORDER_XPATH, itemOrder))).click();
    }

    public boolean isSidebarIsOpened() {
        return sidebarAside.isDisplayed();
    }

    public List<String> getHeaderPresent() {
        return new Sidebar(By.className("product-recommended__sidebar-overflow")).getSubHeaders()
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getItemPrice() {
        return labelPrice.getText();
    }

    public void clickButtonByName(String buttonName) {
        new Button(By.xpath(String.format(BUTTON_BY_NAME, buttonName))).click();
    }
}
