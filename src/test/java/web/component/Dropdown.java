package web.component;

import eu.ibagroup.junase.web.component.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import eu.ibagroup.junase.web.util.Wait;

import java.util.List;

/**
 * Dropdown - a model.component for dropdown lists.
 */
public class Dropdown extends WebComponent {

    public static final String OPTION_XPATH = "//option";

    public Dropdown(By locator) {
        super(locator);
    }

    public Dropdown(WebElement element) {
        super(element);
    }

    /**
     * Opens a dropdown list with options and selects the option with the corresponding value.
     *
     * @param value - the name of the element to select
     */
    public void select(String value) {
        getElement().click();
        Wait.functionPassed(() -> {
            List<WebElement> listOfElements = getElement().findElements(By.xpath(OPTION_XPATH));
            for (WebElement element : listOfElements) {
                if (element.getText().contains(value)) {
                    element.click();
                    return;
                }
            }
            throw new IllegalStateException("Cannot locate dropdown option with text [" + value + "]");
        });
    }

    @Override
    public Dropdown scrollToElement() {
        return (Dropdown) super.scrollToElement();
    }
}