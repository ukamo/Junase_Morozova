package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Label - a model.component for labels.
 */
public class Label extends WebComponent {

    public Label(By locator) {
        super(locator);
    }

    public Label(WebElement element) {
        super(element);
    }

    public String gatherPriceByNumber(int numberOfButton) {
        List<WebElement> listOfElements = getElement().findElements(By.xpath("//div[contains(@class,'offers-list__description_alter-other')]"));
        return listOfElements.get(numberOfButton - 1).getText();
    }
}