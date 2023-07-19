package fiori.component;

import eu.ibagroup.junase.web.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Autocomplete - a component for autocomplete.
 */
public class Autocomplete extends Component {

    public Autocomplete(By locator) {
        super(locator);
    }

    /**
     * The method sends the keys to the autocomplete field, and after the list of elements appears,
     * selects the element with the value
     */
    public void selectValue(String value) {
        Wait.visibilityOfElementLocated(getLocator());
        getElement().sendKeys(value);
        Wait.functionPassed(() -> {
            for (WebElement element : getElement().findElements(By.xpath("//tbody[contains(@Class,'sapMListItems')]//span[contains(@Class,'sapMText')]"))) {
                if (element.getText().contains(value)) {
                    element.click();
                    return;
                }
            }
            throw new IllegalStateException("Cannot locate element with text [" + value + "]");
        });
    }
}
